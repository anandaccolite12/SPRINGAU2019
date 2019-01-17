import React, { Component } from 'react';
import EmployeeComponent from "./Employee.Component";
import DepartmentComponent from "./Department.Component";

class AddEmployee extends Component{
    data={};
    state = {
        shown : false
    };

    onClick = () => {
        console.log("New Dept",this.props.departments)
        this.setState({shown: true});
    }
    
    onCancel = () => {
        this.setState({shown: false});
    }
    
    handleChange = event => {
        //console.log(event.target.value);
        this.data[event.target.id]=event.target.value;
    }

    add = e =>{
        if(this.data.age<23){
            alert('Error');
        }
        else{
            e.preventDefault();
            console.log("Data",this.data);
            this.props.employeeAdded(this.data);
        }
    }

    render(){
        return (
            <div>
                <button onClick={this.onClick}>Add Employee</button><br/>
                {this.state.shown && (
                <div>
                    <form>
                        <span>Name :</span><br/>
                        <input type="text" id="name" onChange={this.handleChange} required/><br/>
                        <span>LastName :</span><br/>
                        <input type="text" id="lname" onChange={this.handleChange}/><br/>
                        <span>Age :</span><br/>
                        <input type="text" id="age" onChange={this.handleChange}/><br/>
                        <span>Designation :</span><br/>
                        <input type="text" id="designation" onChange={this.handleChange}/><br/><br/>
                        <span>Department :</span><br/>
                        <div className="styled-select slate">
                        <select id="department" onChange={this.handleChange}> 
                        {
                                this.props.departments && this.props.departments.map((department, i) => {
                                    return (
                                        <option key={department.name}> {department.name}</option>
                                    );
                                })}
                        }
                        </select><br/>
                        </div>
                        <span>Location :</span><br/>
                        <input type="text" id="location"  onChange={this.handleChange}/><br/>
                        <button  onClick={this.add}>Add</button><br/>
                        <button onClick={this.onCancel}>Cancel</button><br/>
                    </form>
                </div>
                )}
            </div>

            //React.createElement("div",null,"AddEmplyee")
        );
    }
}

export default AddEmployee;