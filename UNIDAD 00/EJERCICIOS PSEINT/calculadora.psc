Algoritmo calculadora
	Definir operacion Como Real;
	Repetir 
	Escribir "Elije:";
	Escribir "1. para suma";
	Escribir "2. para resta";
	Escribir "3. para multiplicación";
	Escribir "4. para división";
	Escribir "0. para terminar";
	Leer operacion;
	Si operacion >0 y operacion <5 Entonces
		Definir numero1 Como Real;
		Leer numero1;
		Escribir "Ingrese el segundo número";
		Definir numero2 Como Real;
		Leer numero2;
		Si operacion=1 Entonces
			Escribir "el resultado de la suma es:";
			Escribir numero1+numero2;
			
		FinSi
		
		Si operacion=2 Entonces
			Escribir "el resultado de la resta es:";
			Escribir numero1-numero2;
			
		FinSi
		Si operacion=3 Entonces
			Escribir "el resultado de la multiplicacion es:";
			Escribir numero1*numero2;
			
		FinSi
		Si operacion=4 Entonces
			Escribir "el resultado de la división es:";
			Escribir numero1/numero2;
		FinSi
	SiNo
		Escribir "no es valido";
	FinSi
Hasta Que operacion= 0
FinAlgoritmo
