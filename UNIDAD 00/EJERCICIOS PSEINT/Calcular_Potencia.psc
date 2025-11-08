Algoritmo Calcular_Potencia
	Definir base, exponente, contador, potencia como Entero; 
	
	Escribir "Introduzca la base ";
	Leer base;
	Escribir "Introduzca el exponente"; 
	Leer exponente;
	potencia <- base;
		Para contador<-1 hasta exponente-1 con paso 1 hacer
			potencia<-potencia*base;
		FinPara
	Escribir potencia;
FinAlgoritmo
