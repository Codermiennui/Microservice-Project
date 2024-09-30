package com.xuanpac.employeeservice.command.aggregate;


import com.xuanpac.employeeservice.command.command.CreateEmployeeCommand;
import com.xuanpac.employeeservice.command.command.DeleteEmployeeCommand;
import com.xuanpac.employeeservice.command.command.UpdateEmployeeCommand;
import com.xuanpac.employeeservice.command.event.EmployeeCreatedEvent;
import com.xuanpac.employeeservice.command.event.EmployeeDeletedEvent;
import com.xuanpac.employeeservice.command.event.EmployeeUpdatedEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@NoArgsConstructor
@Aggregate
public class EmployeeAggregate {
    @AggregateIdentifier
    private String id;
    private String firstName;
    private String LastName;
    private String Kin;
    private Boolean isDisciplined;

    @CommandHandler
    public EmployeeAggregate(CreateEmployeeCommand command){
        EmployeeCreatedEvent event = new EmployeeCreatedEvent();
        BeanUtils.copyProperties(command,event);
        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public void handle(UpdateEmployeeCommand command){
        EmployeeUpdatedEvent event = new EmployeeUpdatedEvent();
        BeanUtils.copyProperties(command,event);
        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public void handle(DeleteEmployeeCommand command){
        EmployeeDeletedEvent event = new EmployeeDeletedEvent();
        BeanUtils.copyProperties(command,event);
        AggregateLifecycle.apply(event);
    }
    @EventSourcingHandler
    public void on(EmployeeCreatedEvent event){
        this.id = event.getId();
        this.firstName = event.getFirstName();
        this.LastName = event.getLastName();
        this.Kin = event.getKin();
        this.isDisciplined = event.getIsDisciplined();
    }

    @EventSourcingHandler
    public void on(EmployeeUpdatedEvent event){
        this.id = event.getId();
        this.firstName = event.getFirstName();
        this.LastName = event.getLastName();
        this.Kin = event.getKin();
        this.isDisciplined = event.getIsDisciplined();
    }
    @EventSourcingHandler
    public void on(EmployeeDeletedEvent event){
        this.id = event.getId();
    }
}
