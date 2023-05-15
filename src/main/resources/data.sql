-- Tabla Mujeres --> 
INSERT INTO MUJERES(ID,NOMBRE_P, URL, PRECIO) VALUES(101,'Vestido azul seda','https://gusgusboutique.es/wp-content/uploads/2023/02/Vestido-coctel-corto-Couture-Club-fiesta.png', 50.2);
INSERT INTO MUJERES(ID,NOMBRE_P, URL, PRECIO) VALUES(102,'Vestido rojo','https://d2tce2xojuu25e.cloudfront.net/2022/10/7J2O2_MARFIL_BARCELONA_1.jpg', 40.9);
INSERT INTO MUJERES(ID,NOMBRE_P, URL, PRECIO) VALUES(103,'Vestido rosa','https://www.baunda.com/wp-content/uploads/2022/02/2021_5U191_AIRE_BARCELONA_FIESTA_-300x375.jpg', 55);
INSERT INTO MUJERES(ID,NOMBRE_P, URL, PRECIO) VALUES(104,'Vestido blanco','https://www.feversave.com/10509-home_default/vestido-ginebra-blanco.jpg', 45);
INSERT INTO MUJERES(ID,NOMBRE_P, URL, PRECIO) VALUES(105,'Vestido negro','https://puravidaclothes.com/16163-large_default/vestido-clavage-negro.jpg', 50.7);
INSERT INTO MUJERES(ID,NOMBRE_P, URL, PRECIO) VALUES(106,'Vestido verde','https://www.logyz.com/wp-content/uploads/2022/09/the-are-vestido-mrs-taylor-verde-vestidos-mujer.jpg', 60.4);

-- Tabla Hombres
INSERT INTO HOMBRES(ID,NOMBRE_P, URL, PRECIO) VALUES(201,'Camiseta basica','https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2Ffc%2F3d%2Ffc3d74b3aed234b4c0de81b47e922ad3de395552.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BLOOKBOOK%5D%2Cres%5Bm%5D%2Chmver%5B1%5D&call=url[file:/product/fullscreen', 7.99);
INSERT INTO HOMBRES(ID,NOMBRE_P, URL, PRECIO) VALUES(202,'Polo con rayas azules','https://cdn.grupoelcorteingles.es/SGFM/dctm/MEDIA03/202301/05/00112240308440____1__967x1200.jpg', 69);
INSERT INTO HOMBRES(ID,NOMBRE_P, URL, PRECIO) VALUES(203,'Jersey de lana','https://es.benetton.com/dw/image/v2/BBSF_PRD/on/demandware.static/-/Sites-ucb-master/default/dw2a05bfc2/images/Full_Card_v/Benetton_22A_1002U4407_530_FY_Full_Card_v.jpg?sw=960&sh=1280', 49.95);
INSERT INTO HOMBRES(ID,NOMBRE_P, URL, PRECIO) VALUES(204,'Camisa de lino','https://cdn.shopify.com/s/files/1/0015/0942/5197/files/37636-LIGHTGREEN-P-2_1527x2200.jpg', 79.90);
INSERT INTO HOMBRES(ID,NOMBRE_P, URL, PRECIO) VALUES(205,'Pantalones vaqueros','https://static.pullandbear.net/2/photos//2023/V/0/2/p/3688/902/405/3688902405_2_1_8.jpg', 29.99);
INSERT INTO HOMBRES(ID,NOMBRE_P, URL, PRECIO) VALUES(206,'Pantalones chinos','https://static.zara.net/photos///2022/I/0/2/p/6786/310/710/2/w/750/6786310710_6_1_1.jpg?ts=1666280680211', 22.95);



INSERT INTO USUARIOS (USERNAME, PASSWORD_ENCRYPTED, NAME_LOCATION) VALUES ('user1', 'contrasena1', null); 
-- si en un atributo como contraseña ponemos antes '{noop}contraseña' pues a este texto 'contraseña' no se leva a Hashear para esconder la contraseña
INSERT INTO USUARIOS (USERNAME, PASSWORD_ENCRYPTED, NAME_LOCATION) VALUES ('user2', 'contrasena2', 'Madrid');
INSERT INTO USUARIOS(USERNAME, PASSWORD_ENCRYPTED, NAME_LOCATION) VALUES ('user0', 'CdK1033/qww=', 'Somo'); --la contraseña es user0, pero encriptada

INSERT INTO ACCESORIOS(ID, NOMBRE, DIR_IMAGE, PRECIO) VALUES(301, 'Reloj de cuarzo', 'https://e00-expansion.uecdn.es/assets/multimedia/imagenes/2019/07/18/15634474847872.jpg', 74.95);
INSERT INTO ACCESORIOS(ID, NOMBRE, DIR_IMAGE, PRECIO) VALUES(302, 'Colgante estrellado', 'https://sargadelos.com/58090-large_default/colgante-estrela.jpg', 14.95);
INSERT INTO ACCESORIOS(ID, NOMBRE, DIR_IMAGE, PRECIO) VALUES(303, 'Pulsera artesanal', 'https://tiendasolidariasjd.org/2051-thickbox_default/pulsera-rosa.jpg', 8);
INSERT INTO ACCESORIOS(ID, NOMBRE, DIR_IMAGE, PRECIO) VALUES(304, 'Reloj Casio rosa vintage', 'https://www.joyeriavictor.com/16105-thickbox_default/reloj-casio-vintage-pink-transparente-f91-rosa.jpg', 40);
INSERT INTO ACCESORIOS(ID, NOMBRE, DIR_IMAGE, PRECIO) VALUES(305, 'Colgante corazon', 'https://www.aristocrazy.com/dw/image/v2/BCBK_PRD/on/demandware.static/-/Sites-Aristocrazy-master-catalog/default/dwe554ab3f/images/hi-res/J05162-02-ROJENA-3.jpg?sw=1200&sh=1200&sm=fit', 22.25);
INSERT INTO ACCESORIOS(ID, NOMBRE, DIR_IMAGE, PRECIO) VALUES(306, 'Pulsera esmeralda', 'https://joyerialago.com/6071-large_default_2x/pulsera-swarovski-crystaldust-verde.jpg', 30.15);
INSERT INTO ACCESORIOS(ID, NOMBRE, DIR_IMAGE, PRECIO) VALUES(307, 'Anillo de ceniza volcanica', 'https://eguzkilorejoya.com/10910-large_default/anillo-carbono-negro-1-eguzkilore.jpg', 219);
INSERT INTO ACCESORIOS(ID, NOMBRE, DIR_IMAGE, PRECIO) VALUES(308, 'Pendientes hoja dorada', 'https://cdn.shopify.com/s/files/1/1631/3281/products/pendientes-hojas-dorados-cadenas-joyas-mujer-THE-ARE2.jpg?v=1649084093&width=1445', 57.55);

