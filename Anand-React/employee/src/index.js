import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';
import EmployeeComponent from "./Employee.Component";
import DepartmentComponent from "./Department.Component";

//ReactDOM.render(<EmployeeComponent />, document.getElementById('root2'));

ReactDOM.render(<EmployeeComponent />, document.getElementById('root'));


// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: http://bit.ly/CRA-PWA
serviceWorker.unregister();
