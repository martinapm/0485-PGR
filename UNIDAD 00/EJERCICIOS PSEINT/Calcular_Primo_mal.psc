Algoritmo Calcular_Primo_mal
	Definir num, num2 como Entero;
	Definir Primo Como Entero;
	Escribir "Ingresa el numero";
	Leer num;
	Leer Primo;
	Primo <-Verdadero
	Si num <= 1 Entonces
		Escribir Primo = Falso;
	SiNo
		Para num2<-2 Hasta num-1 Con Paso 1 Hacer
			Si num%num2=0 Entonces
				Escribir Primo = Falso;
			SiNo
				Escribir "Intentelo de nuevo";
			FinSi
		FinPara
	FinSi
	
	Si Primo Entonces
		Escribir "Este número es Primo";
	SiNo
		Escribir "Este número no es Primo";
	FinSi
	
	
FinAlgoritmo
