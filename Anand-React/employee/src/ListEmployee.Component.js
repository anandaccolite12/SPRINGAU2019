import React, { Component } from 'react';

import "./ListEmployeeCSS.css";

class ListEmployee extends Component {
    data = {};


    handleChange = event => {
        console.log(event.target.value);
        this.data[event.target.id] = event.target.value;
        console.log(this.data[event.target.id]);
    }

    render() {
        console.log("Employees", this.props.employees);

        //let newEmployees = this.props.employees.map((employee,i)=>{
        //   return i;
        //});

        return (

            <div>
                <form>
                    <span>Department :</span><br />
                    <div className="styled-select slate">
                        <select id="department" onChange={this.handleChange}>
                            {
                                this.props.departments && this.props.departments.map((department, i) => {
                                    return (
                                        <option key={department.name}> {department.name}</option>
                                    );
                                })}
                            }
                        </select><br />
                    </div>
                </form>

                <h1>Employees</h1>
                <table >
                    <tr>
                        <th>FirstName</th>
                        <th>LastName</th>
                        <th>Age</th>
                        <th>Designation</th>
                        <th>Department</th>
                        <th>Location</th>
                    </tr>
                    {
                        this.props.employees && this.props.employees.map((employee, i) => {
                            if (employee.department != this.data["department"]) {
                                return (
                                    <tr key={employee.name}>
                                        <td>{employee.name}</td>
                                        <td>{employee.lname}</td>
                                        <td>{employee.age}</td>
                                        <td>{employee.designation}</td>
                                        <td>{employee.department}</td>
                                        <td>{employee.location}</td>
                                    </tr>
                                )
                            }
                        })}
                </table>
            </div>
            //React.createElement("div",null,"ListEmplyee")
        );
    }
}

export default ListEmployee;