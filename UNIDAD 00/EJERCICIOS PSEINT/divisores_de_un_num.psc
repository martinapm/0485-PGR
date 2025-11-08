Algoritmo divisores_de_un_num
	Definir dividendo, num, resto como Entero;
	Escribir "Escribe un numero: "; 
	Leer dividendo;
	Para num<- dividendo Hasta 1 Con Paso -1 Hacer
		resto<-dividendo%num;
		Si resto=0 Entonces
		  Escribir num, " Es un divisor";
		FinSi
	FinPara

FinAlgoritmo
