--Verifica si existen las tablas usuario y marcador.
--De ser así, las elimina.
DROP TABLE IF EXISTS marcador;
DROP TABLE IF EXISTS usuario;

--Crea tabla para datos del usuario.
CREATE TABLE Usuario (
    idusuario serial NOT NULL,
    nombre text NOT NULL,
    correo text,
    contrasena text,
    fecha_nacimiento text,
    PRIMARY KEY	(idusuario)
);

--Crea tabla para datos de los marcadores.
CREATE TABLE Marcador (
    idmarcador serial NOT NULL,
    latitud double precision NOT NULL,
    longitud double precision NOT NULL,
    descripcion text,
    idusuario integer NOT NULL,
    PRIMARY KEY	(idmarcador),
    FOREIGN KEY (idusuario) REFERENCES Usuario (idusuario)
);


INSERT INTO Usuario VALUES (1,'Fernando Reyes', 'fer.reyesg@ciencias.unam.mx', 'sadfvafvfa', '02-04-1997');
INSERT INTO Marcador VALUES (1, 123.1312, 64.2344, 'Un lugar X', 1);
