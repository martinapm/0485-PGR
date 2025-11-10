Algoritmo PotenciaDeNumero
    Definir base, exponente, resultado Como Real;
	Definir i como Entero;
	
    Escribir "Ingrese la base: ";
    Leer base;
	
    Escribir "Ingrese el exponente: ";
    Leer exponente;
	
    resultado <- 1;  // Inicializamos el resultado a 1
	
    Para i <- 1 Hasta exponente Con Paso 1 Hacer
        resultado <- resultado * base;
    FinPara
	
    Escribir base, "^", exponente, " = ", resultado;
FinAlgoritmo