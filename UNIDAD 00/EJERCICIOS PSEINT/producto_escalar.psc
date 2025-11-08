Proceso producto_escalar
	Definir tamano Como Entero;
	Definir array Como Entero;
	Definir indice Como Entero;
	Definir multiplicador Como Entero;
	Definir resultado Como Entero;
	
	Escribir "Por favor introduzca el tamaño de la array" Sin Saltar;
	Leer tamano;
	Dimensionar array[tamano];
	
	Para indice<- 0 Hasta tamano-1 Hacer	
		Escribir "Introduce el numero de la posicion", indice;
		Leer array[indice];
	Fin Para 
	
	Escribir "Introduce el factor multiplicador";
	Leer multiplicador;
	
	Para indice<-0 Hasta tamano-1 Hacer
		resultado<-multplicador*array[indice];
		Escribir resultado;
	FinPara
	
FinProceso
