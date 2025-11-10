Algoritmo DeterminarPrimo
    Definir numero, i Como Entero;
	Definir esPrimo Como Logico;
	
    Escribir "Ingrese un número: ";
    Leer numero;
	
    Si numero <= 1 Entonces
        esPrimo <- Falso;
    Sino
        esPrimo <- Verdadero;
        Si numero > 2 Y numero MOD 2 = 0 Entonces
            esPrimo <- Falso;
        Sino
            i <- 3;
            Mientras i * i <= numero Y esPrimo Hacer
                Si numero MOD i = 0 Entonces
                    esPrimo <- Falso;
                FinSi
                i <- i + 2;
            FinMientras
        FinSi
    FinSi
	
    Si esPrimo Entonces
        Escribir "El número es primo.";
    Sino;
        Escribir "El número no es primo.";
    FinSi
FinAlgoritmo

// El algoritmo para determinar si un número es primo se basa en algunos principios clave de la teoría de números:

// 1. Eliminación de números triviales: 
// Los números 0 y 1 no son primos, por lo que se excluyen de inmediato. Esto simplifica el problema 
// al reducir el rango de números que necesitamos evaluar.

// 2. Propiedades de los números pares:
// Se reconoce que el único número par primo es el 2. Por lo tanto, cualquier número par mayor que 2 puede 
// ser descartado rápidamente, ya que no puede ser primo. Esto reduce considerablemente el número de verificaciones necesarias.

// 3. Verificación de divisibilidad:
// En lugar de probar todos los números hasta el número dado, el algoritmo solo verifica los divisores impares. 
// Esto se basa en el hecho de que si un número tiene un divisor, debe tener uno que sea menor o igual a su raíz cuadrada. 
// Al limitar las pruebas a los números impares (después de 2), se minimiza el número de divisiones necesarias.

// 4. Optimización mediante el uso de la raíz cuadrada:
// Solo es necesario verificar hasta la raíz cuadrada del número, porque si un número n no tiene divisores 
// menores o iguales a su raíz cuadrada, no los tendrá mayores. Esto reduce aún más el tiempo de ejecución del algoritmo.

// 5. Uso de una variable lógica:
// La variable esPrimo se utiliza para rastrear el estado de primalidad a medida que se realizan las verificaciones. 
// Si se encuentra un divisor, se marca el número como no primo y se evita realizar más verificaciones innecesarias.

// En conjunto, estos principios permiten al algoritmo ser eficiente al eliminar rápidamente números que no son primos 
// y al realizar verificaciones de manera efectiva solo en aquellos números que tienen el potencial de ser primos.
