import React, {Component} from 'react';
import DepartmentComponent from './Department.Component';
import EmployeeComponent from './Employee.Component';


class ParentComponent extends Component{
    state = {
        departments: [
            
          ]
    }

    

    render(){
        console.log("New-Departments",this.props.departments);

        return(
            <React.Fragment>
                <DepartmentComponent departmentAdd={this.departmentAdd}>
                </DepartmentComponent>
                <EmployeeComponent departments={this.state.departments}>
                </EmployeeComponent>

                
            </React.Fragment>   
            //React.createElement("div",null,"Parent")
        )
    }

}

export default ParentComponent;