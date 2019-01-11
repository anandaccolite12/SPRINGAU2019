

function storeUserNameAndPassword(){
	//alert('Form Submitted');
	localStorage.setItem((document.getElementById("signupUsername").value),(document.getElementById("signupPassword").value));
	sessionStorage.setItem((document.getElementById("signupUsername").value),(document.getElementById("signupPassword").value));

}


function getUserNameAndPassword(){
	//alert('Form Submitted');
	if(localStorage.getItem((document.getElementById("loginUsername").value)) == null){
		alert("username not exist, please sign in");
	}
	else{
		if((document.getElementById("loginPassword").value)== localStorage.getItem((document.getElementById("loginUsername").value))){
			alert("password is correct");
			window.location.href = 'http://www.guffa.com';
			//document.getElementById('myButton').style.visibility = 'visible';
		}
		else{
			alert("password is wrong");
		}
	}
}