Algoritmo Calcular_Potencia_Comprobar
	Definir base, exponente, contador, potencia, potencia2 como Entero; 
	
	Escribir "Introduzca la base ";
	Leer base;
	Escribir "Introduzca el exponente"; 
	Leer exponente;
	potencia <- base;
	Para contador<-1 hasta exponente-1 con paso 1 hacer
		potencia<-potencia*base;
	FinPara
	Escribir "El resultado es: ";
	Escribir potencia;
	
	potencia2<-base^exponente;
	Si potencia= potencia2 Entonces
		Escribir "El resultado es el mismo que en Pseint";
	SiNo
		Escribir "El resultado es incorrecto" , potencia," Es distinto de ", potencia2;
	FinSi
FinAlgoritmo

