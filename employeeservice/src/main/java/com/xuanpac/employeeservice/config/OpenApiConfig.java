package com.xuanpac.employeeservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
@OpenAPIDefinition(
        info = @Info(
                title = "Employee Api Specification - Xuanpac",
                description = "Api documentation for Employee Service",
                version = "1.0",
                contact = @Contact(
                        name = " Nguyen Huu Bac",
                        email = "huubacnguyen03@gmail.com",
                        url = "https://ictu.edu.vn/"
                ),
                license = @License(
                        name = "MIT License",
                        url = "https://ictu.edu.vn/category/khoa-hoc-cong-nghe/"
                ),
                termsOfService = "https://ictu.edu.vn/"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:9002"
                ),
                @Server(
                        description = "Dev ENV",
                        url = "https://employee-service.dev.com"
                ),
                @Server(
                        description = "Prod ENV",
                        url = "https://employee-service.prod.com"
                ),
        }
)
public class OpenApiConfig {
}