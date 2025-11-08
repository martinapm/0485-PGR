Algoritmo numprimos
	
	Definir numero1,contador, restoDivision Como Entero;
	definir divisorEncontrado Como logico;
	
	contador<-0;
	restoDivision<-0;
	divisorEncontrado<-FALSO;
	
	Escribir "Dime el numero para saber si es primo o no: ", Sin Saltar;
	Leer numero1;
	
	
		
		contador <- 2 ;
		Mientras  (contador<=(numero1-1) y divisorEncontrado = FALSO) Hacer			
			restoDivision<-numero1%contador;
			si restoDivision=0 Entonces
				divisorEncontrado<-Verdadero;
			FinSi
			contador <- contador + 1;
		FinMientras		
	
	
	Si divisorEncontrado=Falso Entonces
		Escribir "Tu numero es primo";
	SiNo
		Escribir "Tu numero NO es primo";
	FinSi

FinAlgoritmo