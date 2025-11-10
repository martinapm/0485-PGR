Algoritmo Concatena
	Definir nombre Como Cadena;
    Definir apellido Como Cadena;
    Definir nombreCompleto Como Cadena;
	Definir nombreCompleto2 Como Cadena;
	
	Escribir "Ingrese el nombre:"; 
	Leer nombre;
	
	Escribir "Ingrese el apellido: "; 
	Leer apellido;
	
	nombreCompleto <- Concatenar ( nombre, "");
	nombreCompleto2 <- Concatenar ( apellido, "");
	
	Escribir "Su nombre Completo es: ", nombreCompleto," ", nombreCompleto2; 
	
	
FinAlgoritmo
