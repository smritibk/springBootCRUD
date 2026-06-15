package com.nchl.projectcrudoperation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import javax.swing.*;

@SpringBootApplication
public class ProjectCrudOperationApplication  extends SpringBootServletInitializer{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(ProjectCrudOperationApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ProjectCrudOperationApplication.class, args);
    }

}
