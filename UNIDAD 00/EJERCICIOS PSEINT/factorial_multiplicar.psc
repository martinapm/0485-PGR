Algoritmo factorial_multiplicar
	Definir num1 Como Entero;
	Definir contador Como Entero;
	Definir suma Como Entero;
	suma<-1;
	Escribir "Introduzca el factorial, para que sume: ";
	Leer num1;
	Escribir num1;
	
	Para contador <-1 Hasta num1 Con Paso 1 Hacer
		suma<- contador*suma;
	FinPara
	Escribir "El resultado de la factorial_suma es:" ,suma;
	
	
	
	
FinAlgoritmo