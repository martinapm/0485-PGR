Algoritmo manipularCadenaArrays
	Definir frase, array como Caracter;
	Definir longitudfrase como Entero;
	Definir letra Como Caracter;
	Definir contador como Entero;

	
	Escribir "Ingrese frase";
	Leer frase;
	
	longitudfrase <- Longitud(frase);
	
	Escribir Longitud(frase);
	
	Escribir Mayusculas(frase);
	Escribir Minusculas(frase);
	
	Dimensionar array(longitudfrase);
	
	Para contador<-0 Hasta longitudfrase-1 Hacer
		letra<-SubCadena(frase,contador,contador);
		
		array[contador]<- letra;
		
		Escribir array[contador];
		Escribir Sin Saltar ", ";
		
	FinPara
	
	
	
FinAlgoritmo
