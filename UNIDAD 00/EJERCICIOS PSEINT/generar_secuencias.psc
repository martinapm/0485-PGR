Algoritmo generar_secuencias
	
Definir numero como Entero;
Definir secuencia como Entero;
Definir contador Como Entero;

Escribir "Introduce un numero" Sin Saltar;
Leer numero;

Si numero >= 0 Entonces 

Escribir "Vamos a generar una secuencia de números desde 1 hasta ", numero;

Dimensionar secuencia[numero];
Para contador <- +1 hasta numero-1 hacer
	secuencia[contador] <- contador;
FinPara
	
Para contador <- +1 hasta numero-1 Hacer
	Escribir Sin Saltar secuencia[contador];
	Escribir sin saltar " , ";
FinPara
Fin Si	
FinAlgoritmo
