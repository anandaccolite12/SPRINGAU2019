import React, {Component} from 'react';


class AddDepartmentComponent extends Component{
    data={};
    state = {
        shown : false
    };

    onClick = () => {
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
        e.preventDefault();
        console.log("Data",this.data);
        this.props.departmentAdd(this.data);
    }

    render(){
        return (
            <div>
                <button onClick={this.onClick}>Add Department</button><br/>
                {this.state.shown && (
                <div>
                    <form>
                        <span>Name :</span><br/>
                        <input type="text" id="name" onChange={this.handleChange} required/><br/>
                        <span>Description :</span><br/>
                        <input type="text" id="description" onChange={this.handleChange}/><br/>
                        <button  onClick={this.add}>Add</button><br/>
                        <button onClick={this.onCancel}>Cancel</button><br/>
                    </form>
                </div>
                )}
            </div>
           //React.createElement("div",null,"AddDepartment")
        )
    }
}

export default AddDepartmentComponent;