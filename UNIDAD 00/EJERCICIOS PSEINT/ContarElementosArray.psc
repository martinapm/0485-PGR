Algoritmo ContarElementosArray
	
	Definir arrayPalabras como Cadena;
	Definir contador como Entero;
	Definir lista como Cadena;
	Definir letra Como Caracter;
	Definir inicio como Entero;
	Definir palabra como Cadena;
	Definir contador2 como Entero;
	Definir fruta como Caracter;

	
	Dimensionar arrayPalabras[100];
	
	Escribir "Ingrese una lista de palabras separadas por comas";
	Leer lista;
	
	inicio<-0;
	contador2<-0;
	Para contador<-0 Hasta Longitud(lista)-1 Hacer 
		letra<-subcadena(lista, contador, contador);
		
		Si letra= "," O contador = (Longitud(lista)-1) Entonces 
			Si contador<>Longitud(lista)-1 Entonces
				palabra<-subcadena(lista, inicio, contador-1);
			Sino 
			palabra<-subcadena(lista, inicio, contador);
		FinSi
		
			inicio <- contador+1;
			arrayPalabras[contador2]<-palabra;
			contador2<-contador2+1;
		FinSi
	FinPara
	
	Para contador<-0 hasta contador2-1 Hacer
		Escribir arrayPalabras[contador];
	FinPara
	
	
	Escribir "Introduce la palabra que desea buscar";
	Leer fruta;
	
	Definir encontrado como logico;
	encontrado<-falso;
	contador<-0;
	
	
	Mientras contador <= numPalabras y encontrado=falso hacer
		Si (fruta = arrayPalabras[contador]) Entonces 
			Escribir "He encontrado " ,  fruta;
			encontrado<-verdadero;
		
		FinSi
		contador<-contador+1;
	FinMientras

	Si Encontrado=Falso Entonces
		Escribir "No se ha encontrado la palabra ", fruta;
	FinSi
	
	
	
FinAlgoritmo
