Algoritmo SumaNumerosPositivos
    Definir numeroIntroducido, suma, i Como Entero;
	
    Escribir "Ingrese un número entero positivo: ";
    Leer numeroIntroducido;
	
    Si numeroIntroducido <= 0 Entonces
        Escribir "El número ingresado no es positivo.";
    Sino
        suma <- 0;  // Inicializamos la variable suma a 0
		
        Para i <- 1 Hasta numeroIntroducido Con Paso 1 Hacer
            suma <- suma + i;
        FinPara
		
        Escribir "La suma de los números enteros positivos desde 1 hasta ", numeroIntroducido, " es ", suma;
    FinSi
FinAlgoritmo
