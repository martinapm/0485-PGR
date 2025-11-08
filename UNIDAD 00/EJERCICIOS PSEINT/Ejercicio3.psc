Algoritmo bisiesto
	
	Definir anyo como Entero;
	Escribir 'ingrese un año';
	Leer anyo;
	
	Si ( anyo MOD 4 ) = 0 Entonces
		Si ((anyo MOD 100) <> 0 ) O ( (anyo MOD 400) = 0 ) Entonces
			Escribir 'Es año bisiesto';
		SiNo
			Escribir 'No es un año bisiesto';
		FinSi
	SiNo
		Escribir 'No es un año bisiesto';
	FinSi
	
FinAlgoritmo
