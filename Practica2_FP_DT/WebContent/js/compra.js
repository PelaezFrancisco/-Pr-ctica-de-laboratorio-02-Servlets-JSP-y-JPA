var c = 0;
var arr = new Array();
function countPro(id){
	c=c+1;
	console.log("Id push="+id);
	arr.push(id);
}
function red(){
	var idemp = document.getElementById("empresaId").value;
	var salida = "/Practica1_DT_FP/CrearPedido?emp="+idemp;
	
	
	for (let index = 0; index < arr.length; index++) {
		if (index==1) {
			salida=salida+"&";
		}
		var proid=arr.findIndex(index);
		var procant=document.getElementById("cant"+proid).value;
		salida=salida+"id"+index+"="+proid+"&cant"+index+"="+procant;
		if (arr.length!=index) {
			salida=salida+"&";
		}
	}

	//Redireccion
	document.location.href=salida;

}