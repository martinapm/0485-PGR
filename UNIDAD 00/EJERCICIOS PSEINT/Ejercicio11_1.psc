Algoritmo DeterminarPrimo
	//Un numero primo solo es divisible por 1 y por si mismo.
	//Por tanto, si solo encuentros dos divisores (contador = 2) será primo
    Definir numero, i, contador Como Entero;	
	
    Escribir "Ingrese un número: ";
    Leer numero;
	
	//De primeras suponemos que todos los numeros son primos
    esPrimo <- Verdadero;
	
    Para i <- 1 Hasta numero Con Paso 1 Hacer
        Si numero MOD i = 0 Entonces
            contador <- contador + 1 ;
        FinSi
    FinPara
	
	//Si solo he encontrado dos divisores (1 y el mismo), entonces es primo
    Si contador = 2 Entonces
        Escribir numero, " es un número primo.";
    Sino
        Escribir numero, " no es un número primo.";
    FinSi
FinAlgoritmo


