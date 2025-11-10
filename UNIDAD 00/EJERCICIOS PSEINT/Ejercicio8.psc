Algoritmo SumaNumerosPositivos
    Definir n, factorial, i Como Entero;
	
    Escribir "Ingrese un número entero positivo: ";
    Leer n;
	
    Si n <= 0 Entonces
        Escribir "El número ingresado no es positivo.";
    Sino
        factorial <- 1;  // Inicializamos la variable factorial a 1
		
        Para i <- 1 Hasta n Con Paso 1 Hacer
            factorial <- factorial * i;
        FinPara
		
		Escribir "El factorial de ", n, " es ", factorial;
    FinSi
FinAlgoritmo