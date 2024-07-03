DROP DATABASE cineCampus;
CREATE DATABASE cineCampus;
USE cineCampus;

CREATE TABLE tipoactor(
    id INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(50) NOT NULL
)ENGINE = INNODB;

CREATE TABLE genero(
    id INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(50) NOT NULL
)ENGINE = INNODB;

CREATE TABLE formato(
    id INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(50) NOT NULL
)ENGINE = INNODB;


CREATE TABLE pais(
    id INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(50) NOT NULL
)ENGINE = INNODB;

CREATE TABLE actor(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    idnacionalidad INT NOT NULL,
    edad INT NOT NULL,
    idgenero INT NOT NULL,
    FOREIGN KEY(idnacionalidad) REFERENCES pais(id),
    FOREIGN KEY(idgenero) REFERENCES genero(id)
)ENGINE = INNODB;





CREATE TABLE pelicula(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    codinterno VARCHAR(5) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    duracion VARCHAR(20) NOT NULL,
    sinopsis TEXT
)ENGINE = INNODB;

CREATE TABLE peliculaprotagonista(
    idpelicula INT NOT NULL  ,
    idprotagonista INT NOT NULL  ,
    idtipoactor INT NOT NULL,
    PRIMARY KEY(idpelicula, idprotagonista ),
    FOREIGN KEY(idpelicula) REFERENCES pelicula(id),
    FOREIGN KEY(idprotagonista) REFERENCES actor(id),
    FOREIGN KEY(idtipoactor) REFERENCES tipoactor(id)
)ENGINE = INNODB;


CREATE TABLE peliculaformato(
    idpelicula INT NOT NULL  ,
    idformato INT NOT NULL  ,
    PRIMARY KEY(idpelicula, idformato ),
    FOREIGN KEY(idpelicula) REFERENCES pelicula(id),
    FOREIGN KEY(idformato) REFERENCES formato(id)
)ENGINE = INNODB;

