Algoritmo Calcular_Primo
	Definir contador, num, resto como Entero;
	Definir encontrado como Logico;
	encontrado <- Falso;
		Escribir "Escribe un numero: "; 
		Leer num;
		Para contador<-2 Hasta num-1 Con Paso 1 Hacer
			resto <-num % contador;
			Si resto=0 Entonces
				encontrado <- Verdadero;
			FinSi
		FinPara
		Si encontrado=Verdadero Entonces
			Escribir num, " No es primo";
		SiNo
			Escribir num, " Es primo";
		FinSi
	Escribir encontrado;
FinAlgoritmo