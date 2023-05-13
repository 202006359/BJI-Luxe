-- Tabla Mujeres --> 
INSERT INTO MUJERES(ID,NOMBRE_P, URL, PRECIO) VALUES(1,'VESTIDO AZUL','${https://gusgusboutique.es/wp-content/uploads/2023/02/Vestido-coctel-corto-Couture-Club-fiesta.png}', 50);
INSERT INTO MUJERES(ID,NOMBRE_P, URL, PRECIO) VALUES(2,'VESTIDO ROJO','${https://d2tce2xojuu25e.cloudfront.net/2022/10/7J2O2_MARFIL_BARCELONA_1.jpg}', 40);
INSERT INTO MUJERES(ID,NOMBRE_P, URL, PRECIO) VALUES(3,'VESTIDO ROSA','${https://www.baunda.com/wp-content/uploads/2022/02/2021_5U191_AIRE_BARCELONA_FIESTA_-300x375.jpg}', 55);
INSERT INTO MUJERES(ID,NOMBRE_P, URL, PRECIO) VALUES(4,'VESTIDO BLANCO','${https://www.feversave.com/10509-home_default/vestido-ginebra-blanco.jpg}', 45);
INSERT INTO MUJERES(ID,NOMBRE_P, URL, PRECIO) VALUES(5,'VESTIDO NEGRO','${https://puravidaclothes.com/16163-large_default/vestido-clavage-negro.jpg}', 50);
INSERT INTO MUJERES(ID,NOMBRE_P, URL, PRECIO) VALUES(6,'VESTIDO VERDE','${https://www.logyz.com/wp-content/uploads/2022/09/the-are-vestido-mrs-taylor-verde-vestidos-mujer.jpg}', 60);

INSERT INTO USUARIOS (USERNAME, PASSWORD_ENCRYPTED, NAME_LOCATION) VALUES ('user1', 'contrasena1', null); 
-- si en un atributo como contraseña ponemos antes '{noop}contraseña' pues a este texto "contraseña" no se leva a Hashear para esconder la contraseña
INSERT INTO USUARIOS (USERNAME, PASSWORD_ENCRYPTED, NAME_LOCATION) VALUES ('user2', 'contrasena2', 'Madrid');
INSERT INTO USUARIOS(USERNAME, PASSWORD_ENCRYPTED, NAME_LOCATION) VALUES ('user0', 'CdK1033/qww=', 'Somo') --la contraseña es user0, pero encriptada