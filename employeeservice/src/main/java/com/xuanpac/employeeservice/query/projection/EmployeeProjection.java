package com.xuanpac.employeeservice.query.projection;

import com.xuanpac.employeeservice.command.data.Employee;
import com.xuanpac.employeeservice.command.data.EmployeeRepository;
import com.xuanpac.employeeservice.query.model.EmployeeResponseModel;
import com.xuanpac.employeeservice.query.queries.GetAllEmployeeQuery;
import com.xuanpac.employeeservice.query.queries.GetDetailEmployeeQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class EmployeeProjection {
    @Autowired
    private EmployeeRepository employeeRepository;
    @QueryHandler
    public List<EmployeeResponseModel> handle(GetAllEmployeeQuery query){
        List<Employee> listEmployee = employeeRepository.findAllByIsDisciplined(query.getIsDisciplined());
        return listEmployee.stream().map(employee -> {
            EmployeeResponseModel model = new EmployeeResponseModel();
            BeanUtils.copyProperties(employee,model);
            return model;
        }).toList();
    }
    @QueryHandler
    public EmployeeResponseModel handle(GetDetailEmployeeQuery query) throws Exception{
        Employee employee = employeeRepository.findById(query.getId()).orElseThrow(() -> new Exception("Employee not found"));
        EmployeeResponseModel model = new EmployeeResponseModel();
        BeanUtils.copyProperties(employee,model);
        return model;
    }
}