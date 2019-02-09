CREATE TABLE Usuario (
    idusuario serial NOT NULL,
    nombre text NOT NULL,
    correo text,
    contrasena text,
    fecha_nacimiento text,
    PRIMARY KEY	(idusuario)
);

CREATE TABLE Marcador (
    idmarcador serial NOT NULL,
    latitud double precision NOT NULL,
    longitud double precision NOT NULL,
    descripcion text,
    idusuario integer NOT NULL,
    PRIMARY KEY	(idmarcador),
    FOREIGN KEY (idusuario) REFERENCES Usuario (idusuario)
);


INSERT INTO Usuario VALUES (1,'Martin Carmona', '313075977@ciencias.unam.mx', 'contraseñaxd', '19-04-1997');
INSERT INTO Marcador VALUES (1, 123.1312, 64.2344, 'Ubicación', 1);
