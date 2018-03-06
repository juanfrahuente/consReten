function test( valor ){

  alert( valor );
}
//=========================================================================================
function enviarFormulario(link){

  document.forms[0].action=link;
  document.forms[0].submit();

}
//=========================================================================================
function imprimir(){
	if (navigator.appName == "Microsoft Internet Explorer"){
        	window.focus();
        	window.print();
	}else{
        	window.print();
	}
    return;
}
//=========================================================================================
//funcion de autocompletacion del Digito verificador para el SAE II
function putDvSAE2(rutf,dvf){
	// ************ Valida que un rut sea numerico, y calcula su digito verificador.
	var glosaDelRut;

	glosaDelRut = rutf.value;
	if (!validarRUT(glosaDelRut)) {
		rutf.value=glosaDelRut;
	  	dvf.value = "";
		rutf.focus();
		dvf.value = "";
		return false;
	}
	if ( glosaDelRut  == "" ){
    		dvf.value = "";
  	}
	else{
    		dvf.value = getDV(glosaDelRut);
  	}
  	return true;
}
//=========================================================================================
function getDV( rut ) {
	// ************ Calcula el digito verificador dado un rut.
  var dvr = '0';

  suma = 0;
  mul = 2;

  for (i= rut.length -1 ; i >= 0; i--) {
    suma = suma + rut.charAt(i) * mul;
    if (mul == 7) {
      mul = 2;
    } else {
      mul++;
    }
  }
  res = suma % 11;
  if (res==1) {
    dvr = 'K';
  } else if (res==0) {
    dvr = '0';
  } else {
    dvi = 11-res;
    dvr = dvi + "";
  }
  return dvr;
}
//=========================================================================================
function validarRUT(rut){
	// ************ Valida que un rut solo contenga números
	return (soloNumeros(rut));
}
//=========================================================================================
function soloNumeros(cadena) {
	// ************ Valida que una cadena contenga solo números
	var numeros = "0123456789";
	var caracter;
	if (cadena == null) {
    return false;
	}
	var len;
	len = cadena.length;
	for (var i =0; i < len; i++) {
		caracter = cadena.substring(i,i+1);
	  if(numeros.indexOf(caracter) < 0) {
      return false;
    }
	}
	return true;
}
//=========================================================================================
function myPrint() {
    if (navigator.appName == "Microsoft Internet Explorer") {
        window.parent.CONTENIDO.focus();
        window.print();
    } else {
        window.parent.CONTENIDO.print();
    }
}
