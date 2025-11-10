Algoritmo ClasificacionNumeros
    Definir numero Como Real;
	
    Escribir "Ingrese un número: ";
    Leer numero;
	
    Si numero > 0 Entonces
        Escribir "El número ingresado es positivo.";
    Sino
        Si numero < 0 Entonces
            Escribir "El número ingresado es negativo.";
        Sino
            Escribir "El número ingresado es igual a cero.";
        FinSi
    FinSi
FinAlgoritmo
