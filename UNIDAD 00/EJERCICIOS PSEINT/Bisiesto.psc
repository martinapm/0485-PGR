Algoritmo anio_bisiesto
	definir anio como Entero;
	Escribir "Escribe un anio:";
	leer anio;
	si anio mod 4 == 0 Entonces
		si anio mod 100 == 0 Entonces
			si anio mod 400 == 0 Entonces	
				escribir "el anio es bisiesto";
			SiNo
					escribir "el anio no es bisiesto";
				FinSi
			Sino 
				escribir "el anio es bisiesto";
			FinSi
			
				SiNo
				escribir "el anio no es bisiesto";
			FinSi
			
FinAlgoritmo
