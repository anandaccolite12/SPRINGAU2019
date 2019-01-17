import React, {Component} from 'react';

import AddDepartmentComponent from "./AddDept.Component.js"
import ListDepartmentComponent from "./ListDept.Component.js"
import AddEmployee from "./ListEmployee.Component.js"

class DepartmentComponent extends Component{
    state = {
        
    }

    departmentAdded = newDepartmentDetail => {
        console.log("new Data",newDepartmentDetail);
        let departments = [...this.state.departments];
        departments.push(newDepartmentDetail);
        this.setState({departments:departments});
        this.props.departmentAdd(this.state.departments);
    };


    render(){
        return (
            <React.Fragment>
                <AddDepartmentComponent departmentAdded={this.departmentAdded}>
                </AddDepartmentComponent>
                <ListDepartmentComponent departments={this.state.departments}>
                </ListDepartmentComponent>
            </React.Fragment>   
        )
    }
}

export default DepartmentComponent;
