import React, { Component } from 'react';

import AddEmployee  from "./AddEmployee.Component";

import ListEmployee from "./ListEmployee.Component";

import AddDepartmentComponent from "./AddDept.Component"

import ListDepartmentComponent from "./ListDept.Component"

class EmployeeComponent extends Component{
    state = {
        employees: [
            {
              name: "raviteja",
              lname: "V",
              age: 21,
              designation: "intern",
              department: "IT",
              location: "Mangalore, Karnataka,India, Asia, World, Earth"
            },
            {
              name: "Devraj",
              lname: "M",
              age: 21,
              designation: "intern",
              department: "HR",
              location: "Bangalore,Karnataka,India, Asia, World, Earth"
            },
            {
              name: "kumar",
              lname: "santanu",
              age: 26,
              designation: "intern",
              department: "HR",
              location: "Patna, Bihar,India, Asia, World, Earth"
            }
          ],
          departments: [
            {
              name: "Leadership",
              description: "Leadership members"
            },
            {
              name: "IT",
              description: "Technical issues solver"
            },
            {
              name: "HR",
              description: "Campus Hiring"
            }
          ]
    }

    employeeAdded = newEmployeeDetail => {
        console.log("new Data",newEmployeeDetail);
        let employees = [...this.state.employees];
        employees.push(newEmployeeDetail);
        this.setState({employees:employees});
    };

    departmentAdd = newDepartmentDetail => {
        console.log("Parent Department Data",newDepartmentDetail);
        let departments = [...this.state.departments];
        departments.push(newDepartmentDetail);
        this.setState({departments:departments});
    };

    render(){
        return (
            <React.Fragment>
                <AddEmployee employeeAdded={this.employeeAdded} departments={this.state.departments}>
                </AddEmployee>
                <ListEmployee employees={this.state.employees} departments={this.state.departments}>
                </ListEmployee>
                <AddDepartmentComponent departmentAdd={this.departmentAdd}>
                </AddDepartmentComponent>
                <ListDepartmentComponent departments={this.state.departments}>
                </ListDepartmentComponent>
            </React.Fragment>
            
        )
    }
}

export default EmployeeComponent;