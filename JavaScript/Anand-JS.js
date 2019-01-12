//Employee Constructor
function Employee(id, firstName, lastName, address, phno, gender, DOB, designation) {
  this.id = id;
  this.name = {
    firstName,
    lastName
  };
  this.address = address;
  this.phno = phno;
  this.gender = gender;
  this.DOB = DOB;
  this.designation = designation;
 
  this.fillTimesheet = function(){
    console.log("Hi "+this.name.firstName +", Please fill the timesheet");
  }
 
  this.getTaxDetails = function(){
    console.log("Form 16");
  }
  
}

//List
var EmployeesList = [];

//Creation of Object
var manager1 = new Employee("123","Anand","yyy","coimbatore","8526737875","male","04-09-1985","Manager");

//IIFE, adding all the employees to the list
(function() {
  EmployeesList.push(manager1);   
  
  //inheriting employees
  //By using __proto__ getting the property of firstEmployee*********************************************************
  EmployeesList.push(new manager1.__proto__.constructor("321","Raj","wwww","Chennai","8056547875","male","12-09-1991","Manager"));
  EmployeesList.push(new manager1.__proto__.constructor("456","Sri Venu","jmhng","Chennai","4567865445","male","12-09-1991","Developer"));
  EmployeesList.push(new manager1.__proto__.constructor("654","Vinith","nmb","Chennai","4567887658","female","12-09-1991","Developer"));
  EmployeesList.push(new manager1.__proto__.constructor("789","Jaga","hgf","Bangalore","987654321","male","12-09-1991","HR"));
  EmployeesList.push(new manager1.__proto__.constructor("987","Dilip","dfgh","Bangalore","123456789","female","12-09-1991","HR"));
  EmployeesList.push(new manager1.__proto__.constructor("000","Vignesh","dfgh","Bangalore","123456789","male","12-09-1991","Intern"));  
}());

//function expression
var getAllEmployeeDetails = function(){
  console.log("\n\nAll Employees Details");
  for(let index=0; index < EmployeesList.length; index++){
      console.log("ID : "+ EmployeesList[index].id + "\nName : "+ EmployeesList[index].name.firstName +"\nDesignation :"+ EmployeesList[index].designation);
	}
};

//functioncall
getAllEmployeeDetails();

//delete property of getTaxDetails, if the employee is intern
(function () {
  for(let index=0; index < EmployeesList.length; index++){
    if(EmployeesList[index].designation == "Intern"){
      delete EmployeesList[index].getTaxDetails;   //deleting property
    }
  }
})();


//adding new employee using added employee property
var seniorManager = new manager1.__proto__.constructor("8888","qqq","wwww","Delhi","8056547875","male","12-09-1981","SeniorManager");

//adding additional property to Senior manager
seniorManager.__proto__.getAllManagerDetails = function(){
  console.log("\n\nManager Details")
    for(let index=0; index < EmployeesList.length; index++){
      if(EmployeesList[index].designation == "Manager"){
        console.log("ID : "+ EmployeesList[index].id + "\nName : "+ EmployeesList[index].name.firstName +"\nDesignation :"+ EmployeesList[index].designation);
      }
	}
}

// functioncall of the additional property
seniorManager.getAllManagerDetails();


function timeSheetFillAlert(employee){
  console.log(employee.fillTimesheet());
}

//binding the employee and timeSheetFillAlert property
//forEach loop
(function () {
  EmployeesList.forEach(function(employee){
    var temp = timeSheetFillAlert.bind(employee);
    temp(employee);
	});
})();
