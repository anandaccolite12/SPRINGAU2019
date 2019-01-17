import React, {Component} from 'react';


class ListDepartmentComponent extends Component{
    render(){
        //console.log("Departments",this.props.departments);

        return (
            <div>
            <h1>Departments</h1>
                <table>
                <tr>
                    <th>Name</th>
                    <th>Description</th>
                </tr>    
                {
                this.props.departments && this.props.departments.map((department, i) => {
                    return (
                        <tr key={department.name}>
                            <td>{department.name}</td>
                            <td>{department.description}</td>
                        </tr>
                    );
                })}
                </table>
            </div>
           //React.createElement("div",null,"ListDepartment")
        )
    }
}

export default ListDepartmentComponent;