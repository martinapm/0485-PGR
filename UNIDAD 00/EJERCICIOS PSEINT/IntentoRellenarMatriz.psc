Algoritmo RellenarMatriz
	
    definir filas, columnas, minimo, maximo, i, j como entero;
	Definir matriz como Real;
    
    escribir "Ingrese el número de filas:";
    leer filas;
    
    escribir "Ingrese el número de columnas:";
    leer columnas;
    
    escribir "Ingrese el valor mínimo del rango:";
    leer minimo;
    
    escribir "Ingrese el valor máximo del rango:";
    leer maximo;
	
	dimension matriz[100];
	
    
    para i <- 0 hasta filas - 1 hacer;
        para j <- 0 hasta columnas - 1 hacer;
            matriz[0]<- aleatorio(minimo, maximo);
        finpara;
    finpara;
	
    escribir "La matriz generada es:";
    para i <- 0 hasta filas - 1 hacer;
        para j <- 0 hasta columnas - 1 hacer;
            escribir sin saltar matriz[0];
        finpara;
        escribir "";
    finpara;
	
Fin algoritmo