package com.xuanpac.employeeservice.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteEmployeeCommand {
    @TargetAggregateIdentifier
    private String id;
}