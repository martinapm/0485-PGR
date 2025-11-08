Algoritmo DeterminarPrimo
	//Un numero primo solo es divisible por 1 y por si mismo.
	//Por tanto si encuentro un divisor sin tener en cuenta el 1 y él mismo, entonces no será primo.
    Definir numero, i Como Entero;
	Definir esPrimo como Logico;
	
    Escribir "Ingrese un número: ";
    Leer numero;
	
	//De primeras suponemos que todos los numeros son primos
    esPrimo <- Verdadero;
	
    Para i <- 2 Hasta numero-1 Con Paso 1 Hacer
        Si numero MOD i = 0 Entonces
            esPrimo <- falso;  //Si se encuentra un divisor entonces ya no es primo, por tanto establecemos la variable esPrimo a falso
        FinSi
    FinPara
	
    Si esPrimo  Entonces
        Escribir numero, " es un número primo.";
    Sino
        Escribir numero, " no es un número primo.";
    FinSi
FinAlgoritmo


