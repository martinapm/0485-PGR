Algoritmo factorial_suma2
	Definir num1 Como Entero;
	Definir contador Como Entero;
	Definir suma Como Entero;
	suma<-0;
	Escribir "Introduzca el factorial, para que sume: ";
	Leer num1;
	Escribir num1;
	
	Para contador <-0 Hasta num1 Con Paso 1 Hacer
		suma<- contador+suma;
	FinPara
	Escribir "El resultado de la factorial_suma es:" ,suma;
	
	
	
	
FinAlgoritmo