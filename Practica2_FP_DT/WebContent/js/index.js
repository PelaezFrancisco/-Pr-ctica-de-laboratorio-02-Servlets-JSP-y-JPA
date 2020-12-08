function redirect(){
   document.location.href = '/Practica2_FP_DT/IndexController?id=1';
};

function sendpage(){
	console.log("Entro a js");
	var e = document.getElementById("items").value;
	console.log("Var e= "+e);
	document.location.href = '/Practica2_FP_DT/IndexController?id='+e;
	
}

function redirectSignIn(){
	console.log("Entro a redirreccion");
	document.location.href = '/public/IniciarSesion.html';
	
}