CREATE TABLE Libros (
    idLibro INT NOT NULL, 
    titulo VARCHAR(30), 
    precio INT NOT NULL, 
    CONSTRAINT claveLibro PRIMARY KEY (idLibro)
);
 
CREATE TABLE Autores (
    idAutor INT NOT NULL, 
    nombre VARCHAR(30), 
    nacionalidad VARCHAR(20), 
    CONSTRAINT claveAutor PRIMARY KEY (idAutor)
);
 
CREATE TABLE RelacionLibroAutor (
    idLibro INT, 
    idAutor INT, 
    CONSTRAINT claveRelacion PRIMARY KEY (idLibro, idAutor), 
    CONSTRAINT claveLibroForanea FOREIGN KEY (idLibro) REFERENCES Libros(idLibro), 
    CONSTRAINT claveAutorForanea FOREIGN KEY (idAutor) REFERENCES Autores(idAutor)
);
 
INSERT INTO Libros VALUES (1, 'Bambi', 3);
INSERT INTO Libros VALUES (2, 'Batman', 4);
INSERT INTO Libros VALUES (3, 'Spiderman', 2);
 
INSERT INTO Autores VALUES (1, 'Antonio', 'Español');
INSERT INTO Autores VALUES (2, 'Gerard', 'Frances');
 
INSERT INTO RelacionLibroAutor VALUES (1, 1);
INSERT INTO RelacionLibroAutor VALUES (2, 2);
INSERT INTO RelacionLibroAutor VALUES (3, 2);