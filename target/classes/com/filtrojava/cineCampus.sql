DROP DATABASE cineCampus;
CREATE DATABASE cineCampus;
USE cineCampus;

CREATE TABLE tipo_actor(
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
    id_nacionalidad INT NOT NULL,
    edad INT NOT NULL,
    id_genero INT NOT NULL,
    FOREIGN KEY(id_nacionalidad) REFERENCES pais(id),
    FOREIGN KEY(id_genero) REFERENCES genero(id)
)ENGINE = INNODB;





CREATE TABLE pelicula(
    id INT NOT NULL PRIMARY KEY,
    codinterno VARCHAR(5) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    duracion VARCHAR(20) NOT NULL,
    sinopsis TEXT
)ENGINE = INNODB;

CREATE TABLE pelicula_protagonista(
    id_pelicula INT NOT NULL  ,
    id_protagonista INT NOT NULL  ,
    id_tipo_actor INT NOT NULL,
    PRIMARY KEY(id_pelicula, id_protagonista ),
    FOREIGN KEY(id_pelicula) REFERENCES pelicula(id),
    FOREIGN KEY(id_protagonista) REFERENCES actor(id),
    FOREIGN KEY(id_tipo_actor) REFERENCES tipo_actor(id)
)ENGINE = INNODB;


CREATE TABLE pelicula_formato(
    id_pelicula INT NOT NULL  ,
    id_formato INT NOT NULL  ,
    PRIMARY KEY(id_pelicula, id_formato ),
    FOREIGN KEY(id_pelicula) REFERENCES pelicula(id),
    FOREIGN KEY(id_formato) REFERENCES formato(id)
)ENGINE = INNODB;

