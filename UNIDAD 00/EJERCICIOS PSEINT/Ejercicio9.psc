Algoritmo DivisoresDeNumero
    Definir i, n Como Entero;
	
    Escribir "Ingrese un número entero: ";
    Leer n;
	
    Escribir "Los divisores de ", n, " son: ";
	
    Para i <- 1 Hasta n Con Paso 1 Hacer
        Si n MOD i = 0 Entonces
            Escribir i;
        FinSi
    FinPara
	
FinAlgoritmo
