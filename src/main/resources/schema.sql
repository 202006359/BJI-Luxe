DROP TABLE IF EXISTS MUJERES;

CREATE TABLE MUJERES(
  ID NUMBER NOT NULL PRIMARY KEY,
  NOMBRE_P VARCHAR(255) NOT NULL,
  URL VARCHAR(255) NOT NULL,
  PRECIO NUMBER NOT NULL
);


DROP TABLE IF EXISTS USUARIOS;
CREATE TABLE USUARIOS (
    USER_ID INT PRIMARY KEY AUTO_INCREMENT,
    USERNAME VARCHAR(25) NOT NULL UNIQUE,
    PASSWORD_ENCRYPTED VARCHAR(255) NOT NULL,
    NAME_LOCATION VARCHAR(255) -- REFERENCES LOCATIONS_SPAIN(NAME_LOCATION)
);

DROP TABLE IF EXISTS CARRITO;
CREATE TABLE CARRITO(
  ID NUMBER AUTO_INCREMENT NOT NULL PRIMARY KEY,
  ID_PROD NUMBER NOT NULL,
  NOMBRE_P VARCHAR(255) NOT NULL,
  PRECIO FLOAT NOT NULL
);

DROP TABLE IF EXISTS ACCESORIOS;

CREATE TABLE ACCESORIOS(
  ID INT NOT NULL PRIMARY KEY, --los ids de accesorios empiezan por 3XX
  NOMBRE VARCHAR(255) NOT NULL,
  DIR_IMAGE VARCHAR(255) NOT NULL,
  PRECIO FLOAT NOT NULL
  --CATEGORIA NUMBER FOREIGN KEY CATEGORIAS
);

DROP TABLE IF EXISTS PEDIDOS;
CREATE TABLE PEDIDOS(
  ID NUMBER AUTO_INCREMENT NOT NULL PRIMARY KEY,
  ID_USER NUMBER NOT NULL,
  ID_PROD NUMBER NOT NULL,
  NOMBRE_P VARCHAR(255) NOT NULL,
  CANTIDAD NUMBER NOT NULL
);



