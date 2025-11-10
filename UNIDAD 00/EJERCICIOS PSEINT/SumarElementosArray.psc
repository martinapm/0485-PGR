Algoritmo SumarElementosArray
	
	Definir arraynum como Caracter;
	Definir contador como Entero;
	Definir lista como Caracter;
	Definir num Como Caracter;
	Definir inicio como Entero;
	Definir nums como Caracter;
	Definir contador2 como Entero;
	Definir sumatorio como Entero;
	Definir resultado como Real;
	
	Escribir "Ingrese una lista de números separadas por comas";
	Leer lista;
	inicio<-0;
	contador2<-0;
	Dimensionar arraynums[100];
	

	Para contador<-0 Hasta Longitud(lista)-1 Hacer 
		num<-subcadena(lista, contador, contador);
		
		Si num= "," O contador = (Longitud(lista)-1) Entonces 
			Si contador<>Longitud(lista)-1 Entonces
				nums<-subcadena(lista, inicio, contador-1);
			Sino 
				nums<-subcadena(lista, inicio, contador);
			FinSi
			
			inicio <- contador+1;
			arraynums[contador2]<-nums;
			contador2<-contador2+1;
		FinSi
	FinPara
	
	Para contador<-0 Hasta contador2-1 Hacer
		sumatorio<-sumatorio+ConvertirANumero(arraynum[contador]);
	FinPara
	resultado<-sumatorio/contador2;
	Escribir contador2;
	
FinAlgoritmo
