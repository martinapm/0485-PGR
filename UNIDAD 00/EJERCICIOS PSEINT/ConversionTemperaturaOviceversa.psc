Algoritmo ConversionTemperatura
	Definir opcion Como Entero;
	Definir celsius, fahrenheit Como Entero ;
	Escribir "Seleccione una opción";
	Escribir "1. Convertir de Celsius a Fahrenheit";
	Escribir "2. Convertir Fahrenheit a Celsius";
	Leer opcion;
	Si opcion=1 Entonces 
		Escribir "Introduzca los grados de Cº para convertir:";
		definir grados Como Entero;
		Leer grados;
		
		Escribir "El resultado es:";
		Escribir (grados * 9/5 +32);
	
	FinSi
	
	Si opcion=2 Entonces
		Escribir "Introduzca los grados Fº para convertir;";
		definir grados Como Entero;
		
		Leer grados;
		Escribir "El resultado es:";
		Escribir ((grados -32)*(5/9));
	FinSi
	
	
FinAlgoritmo
