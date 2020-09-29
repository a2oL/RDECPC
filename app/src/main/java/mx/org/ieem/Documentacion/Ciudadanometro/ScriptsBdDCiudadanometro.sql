-- **********************************************************************
-- CIUDADANOMETRO********************************************************
-- **********************************************************************
-- Se crea en encuesta juvenil
-- CREATE TABLE trdd_municipio
-- (
--     id_municipio                                         NUMERIC(3),    
--     nombre                                              VARCHAR(75),        
--   CONSTRAINT trdd_municipio_pk PRIMARY KEY (id_municipio)
-- );

-- INSERT INTO trdd_municipio (id_municipio, nombre) VALUES (1, 'TOLUCA');

-- CREATE TABLE trdd_nivel_educativo
-- (
--     id_nivel_educativo                                 NUMERIC(1),
--     nombre                                             VARCHAR(64),
--   CONSTRAINT trdd_nivel_educativo_pk PRIMARY KEY (id_nivel_educativo)
-- );

-- INSERT INTO trdd_nivel_educativo(id_nivel_educativo, nombre) VALUES(1,'Primaria');
-- INSERT INTO trdd_nivel_educativo(id_nivel_educativo, nombre) VALUES(2,'Secundaria');


CREATE TABLE trdd_c_grado_escolar(
    id_grado_escolar                                    NUMERIC(1),
    nombre                                              VARCHAR(35),
    siglas                                              VARCHAR(6),
    grado                                               VARCHAR(4),
  CONSTRAINT trdd_c_grado_escolar_pk PRIMARY KEY (id_grado_escolar)  
);

INSERT INTO trdd_c_grado_escolar (id_grado_escolar, nombre, siglas, grado) VALUES (1,'Primero', '1ero', '1º');
INSERT INTO trdd_c_grado_escolar (id_grado_escolar, nombre, siglas, grado) VALUES (2,'Segundo', '2do', '2º');
INSERT INTO trdd_c_grado_escolar (id_grado_escolar, nombre, siglas, grado) VALUES (3,'Tercero', '3ero', '3º');
INSERT INTO trdd_c_grado_escolar (id_grado_escolar, nombre, siglas, grado) VALUES (4,'Cuarto', '4to', '4º');
INSERT INTO trdd_c_grado_escolar (id_grado_escolar, nombre, siglas, grado) VALUES (5,'Quinto', '5to', '5º');
INSERT INTO trdd_c_grado_escolar (id_grado_escolar, nombre, siglas, grado) VALUES (6,'Sexto', '6to', '6º');

CREATE TABLE trdd_c_nied_gres(
    id_nivel_educativo                                 NUMERIC(1),
    id_grado_escolar                                   NUMERIC(1),
    CONSTRAINT trdd_c_nege_pk PRIMARY KEY (id_nivel_educativo, id_grado_escolar),
    CONSTRAINT trpd_c_nege_nivedu_fk FOREIGN KEY (id_nivel_educativo) REFERENCES trdd_nivel_educativo (id_nivel_educativo),  
    CONSTRAINT trpd_c_nege_graesc_fk FOREIGN KEY (id_grado_escolar) REFERENCES trdd_c_grado_escolar (id_grado_escolar)
);

-- Para nivel educativo primaria se dan 6 grados escolares
INSERT INTO trdd_c_nied_gres (id_nivel_educativo, id_grado_escolar) VALUES (1,1);
INSERT INTO trdd_c_nied_gres (id_nivel_educativo, id_grado_escolar) VALUES (1,2);
INSERT INTO trdd_c_nied_gres (id_nivel_educativo, id_grado_escolar) VALUES (1,3);
INSERT INTO trdd_c_nied_gres (id_nivel_educativo, id_grado_escolar) VALUES (1,4);
INSERT INTO trdd_c_nied_gres (id_nivel_educativo, id_grado_escolar) VALUES (1,5);
INSERT INTO trdd_c_nied_gres (id_nivel_educativo, id_grado_escolar) VALUES (1,6);
-- Para nivel educativo secundaria se dan 3 grados escolares
INSERT INTO trdd_c_nied_gres (id_nivel_educativo, id_grado_escolar) VALUES (2,1);
INSERT INTO trdd_c_nied_gres (id_nivel_educativo, id_grado_escolar) VALUES (2,2);
INSERT INTO trdd_c_nied_gres (id_nivel_educativo, id_grado_escolar) VALUES (2,3);

CREATE TABLE trdd_c_realizador
(
    id_realizador                                      NUMERIC(1),
    nombre                                             VARCHAR(64),
  CONSTRAINT trdd_c_realizador_pk PRIMARY KEY (id_realizador)
);

INSERT INTO trdd_c_realizador (id_realizador, nombre) VALUES (1,'Padres de familia o tutores');
INSERT INTO trdd_c_realizador (id_realizador, nombre) VALUES (2,'Docentes');
INSERT INTO trdd_c_realizador (id_realizador, nombre) VALUES (3,'Directores / Administrativos');
INSERT INTO trdd_c_realizador (id_realizador, nombre) VALUES (4,'Otros');

-- Esta tabla se crea en encuesta juvenil
-- CREATE TABLE trdd_cct
-- (
--     id_cct                                             VARCHAR(18),
--     nombre                                             VARCHAR(64),
--     domicilio                                          VARCHAR(128),
--     email                                              VARCHAR(128),
--     id_municipio                                       NUMERIC(1),
--     id_nivel_educativo                                 NUMERIC(1),
--     contrasenia                                        VARCHAR(32),
--   CONSTRAINT trdd_cct_pk PRIMARY KEY (id_cct),
--   CONSTRAINT trdd_cct_mun_fk FOREIGN KEY (id_municipio) REFERENCES trdd_municipio (id_municipio),
--   CONSTRAINT trdd_cct_niv_edu_fk FOREIGN KEY (id_nivel_educativo) REFERENCES trdd_nivel_educativo (id_nivel_educativo)
-- );

-- INSERT INTO trdd_cct (id_cct, nombre, domicilio, email, id_municipio, id_nivel_educativo) VALUES(1, 'PRIMARIA AMADO NERVO', 'ESQUINA HERIBERTO HENRIQUEZ CON CEBORUCO','gvaldez@ieem.org.mx',1,1);
-- INSERT INTO trdd_cct (id_cct, nombre, domicilio, email, id_municipio, id_nivel_educativo) VALUES(2, 'SECUNDARIA TÉCNICA #49 SAMUEL RAMOS', 'PRIVADA DE TLALOC #100','gvaldez@ieem.org.mx',1,2);

CREATE TABLE trdd_c_anio
(
    id_anio                                            VARCHAR(12),
  CONSTRAINT trdd_c_anio_pk PRIMARY KEY (id_anio)
);

INSERT INTO trdd_c_anio (id_anio) VALUES('2020');

CREATE TABLE trdd_c_pregunta(
    id_anio                                            VARCHAR(12),
    id_pregunta                                        VARCHAR(64),
    CONSTRAINT trdd_c_pre_pregunta_pk PRIMARY KEY (id_anio, id_pregunta),
    CONSTRAINT trdd_c_pre_anio_fk FOREIGN KEY (id_anio) REFERENCES trdd_c_anio (id_anio)
);

-- Anio 2020 y 8 preguntas
INSERT INTO trdd_c_pregunta (id_anio, id_pregunta) VALUES ('2020', '¿Pregunta 1?');
INSERT INTO trdd_c_pregunta (id_anio, id_pregunta) VALUES ('2020', '¿Pregunta 2?');
INSERT INTO trdd_c_pregunta (id_anio, id_pregunta) VALUES ('2020', '¿Pregunta 3?');
INSERT INTO trdd_c_pregunta (id_anio, id_pregunta) VALUES ('2020', '¿Pregunta 4?');
INSERT INTO trdd_c_pregunta (id_anio, id_pregunta) VALUES ('2020', '¿Pregunta 5?');
INSERT INTO trdd_c_pregunta (id_anio, id_pregunta) VALUES ('2020', '¿Pregunta 6?');
INSERT INTO trdd_c_pregunta (id_anio, id_pregunta) VALUES ('2020', '¿Pregunta 7?');
INSERT INTO trdd_c_pregunta (id_anio, id_pregunta) VALUES ('2020', '¿Pregunta 8?');

CREATE TABLE trdd_c_estatus_respuesta(
    id_estatus_respuesta                               NUMERIC(1),
    nombre                                             VARCHAR(35),
    CONSTRAINT trdd_c_estatus_respuesta_pk PRIMARY KEY (id_estatus_respuesta)
);

INSERT INTO trdd_c_estatus_respuesta(id_estatus_respuesta, nombre) VALUES (1,'Correcta');
INSERT INTO trdd_c_estatus_respuesta(id_estatus_respuesta, nombre) VALUES (2,'Incorrecta');

CREATE TABLE trdd_c_pregunta_respuesta(
    id_anio                                            VARCHAR(12),
    id_pregunta                                        VARCHAR(64),
    id_respuesta                                       NUMERIC(1),
    id_estatus_respuesta                               NUMERIC(1),
    respuesta                                          VARCHAR(35),
    CONSTRAINT trdd_c_prre_anipreresesrres_pk PRIMARY KEY (id_anio, id_pregunta, id_respuesta, id_estatus_respuesta),
    CONSTRAINT trdd_c_prre_anipre_fk FOREIGN KEY (id_anio, id_pregunta) REFERENCES trdd_c_pregunta (id_anio, id_pregunta),
    CONSTRAINT trdd_c_prre_estres_fk FOREIGN KEY (id_estatus_respuesta) REFERENCES trdd_c_estatus_respuesta (id_estatus_respuesta)
);

-- Año 2020 - Pregunta 1
-- respuesta 1..2, la primera Correcta y la 2da incorrecta
INSERT INTO trdd_c_pregunta_respuesta (id_anio, id_pregunta, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020','¿Pregunta 1?',1,1,'P1/R1: Correcta');
INSERT INTO trdd_c_pregunta_respuesta (id_anio, id_pregunta, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020','¿Pregunta 1?',2,2,'P1/R2: Incorrecta');

-- Año 2020 - Pregunta 2
-- respuesta 1..2, la primera Correcta y la 2da incorrecta
INSERT INTO trdd_c_pregunta_respuesta (id_anio, id_pregunta, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020','¿Pregunta 2?',1,1,'P1/R1: Correcta');
INSERT INTO trdd_c_pregunta_respuesta (id_anio, id_pregunta, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020','¿Pregunta 2?',2,2,'P1/R2: Incorrecta');

-- Año 2020 - Pregunta 3
-- respuesta 1..2, la primera Correcta y la 2da incorrecta
INSERT INTO trdd_c_pregunta_respuesta (id_anio, id_pregunta, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020','¿Pregunta 3?',1,1,'P1/R1: Correcta');
INSERT INTO trdd_c_pregunta_respuesta (id_anio, id_pregunta, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020','¿Pregunta 3?',2,2,'P1/R2: Incorrecta');

-- Año 2020 - Pregunta 4
-- respuesta 1..2, la primera Correcta y la 2da incorrecta
INSERT INTO trdd_c_pregunta_respuesta (id_anio, id_pregunta, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020','¿Pregunta 4?',1,1,'P1/R1: Correcta');
INSERT INTO trdd_c_pregunta_respuesta (id_anio, id_pregunta, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020','¿Pregunta 4?',2,2,'P1/R2: Incorrecta');

-- Año 2020 - Pregunta 5
-- respuesta 1..2, la primera Correcta y la 2da incorrecta
INSERT INTO trdd_c_pregunta_respuesta (id_anio, id_pregunta, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020','¿Pregunta 5?',1,1,'P1/R1: Correcta');
INSERT INTO trdd_c_pregunta_respuesta (id_anio, id_pregunta, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020','¿Pregunta 5?',2,2,'P1/R2: Incorrecta');

-- Año 2020 - Pregunta 6
-- respuesta 1..2, la primera Correcta y la 2da incorrecta
INSERT INTO trdd_c_pregunta_respuesta (id_anio, id_pregunta, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020','¿Pregunta 6?',1,1,'P1/R1: Correcta');
INSERT INTO trdd_c_pregunta_respuesta (id_anio, id_pregunta, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020','¿Pregunta 6?',2,2,'P1/R2: Incorrecta');

-- Año 2020 - Pregunta 7
-- respuesta 1..2, la primera Correcta y la 2da incorrecta
INSERT INTO trdd_c_pregunta_respuesta (id_anio, id_pregunta, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020','¿Pregunta 7?',1,1,'P1/R1: Correcta');
INSERT INTO trdd_c_pregunta_respuesta (id_anio, id_pregunta, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020','¿Pregunta 7?',2,2,'P1/R2: Incorrecta');

-- Año 2020 - Pregunta 8
-- respuesta 1..2, la primera Correcta y la 2da incorrecta
INSERT INTO trdd_c_pregunta_respuesta (id_anio, id_pregunta, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020','¿Pregunta 8?',1,1,'P1/R1: Correcta');
INSERT INTO trdd_c_pregunta_respuesta (id_anio, id_pregunta, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020','¿Pregunta 8?',2,2,'P1/R2: Incorrecta');

CREATE TABLE trdd_c_realicador_edad(
    id_edad                                            NUMERIC(1),
    nombre                                             VARCHAR(35),
    CONSTRAINT trdd_c_realizador_edad_pk PRIMARY KEY (id_edad)
);

INSERT INTO trdd_c_realicador_edad (id_edad, nombre) VALUES (1,'Menos de 18 años');
INSERT INTO trdd_c_realicador_edad (id_edad, nombre) VALUES (2,'De 18 a 29 años');
INSERT INTO trdd_c_realicador_edad (id_edad, nombre) VALUES (3,'De 30 a 45 años');
INSERT INTO trdd_c_realicador_edad (id_edad, nombre) VALUES (4,'De 46 a 60 años');

CREATE TABLE trdd_c_realicador_genero(
    id_genero                                          NUMERIC(1),
    nombre                                             VARCHAR(35),
    CONSTRAINT trdd_c_realizador_genero_pk PRIMARY KEY (id_genero)
);

INSERT INTO trdd_c_realicador_genero (id_genero, nombre) VALUES (1,'Mujer');
INSERT INTO trdd_c_realicador_genero (id_genero, nombre) VALUES (2,'Hombre');
INSERT INTO trdd_c_realicador_genero (id_genero, nombre) VALUES (3,'Otro');

CREATE TABLE trdd_c_realicador_escolaridad(
    id_escolaridad                                     NUMERIC(1),
    nombre                                             VARCHAR(35),
    CONSTRAINT trdd_c_realizador_escolaridad_pk PRIMARY KEY (id_escolaridad)
);

INSERT INTO trdd_c_realicador_escolaridad (id_escolaridad, nombre) VALUES (1,'Solo leer y escribir');
INSERT INTO trdd_c_realicador_escolaridad (id_escolaridad, nombre) VALUES (2,'Hasta primaria y/o secundaria');
INSERT INTO trdd_c_realicador_escolaridad (id_escolaridad, nombre) VALUES (3,'Hasta preparatoria');
INSERT INTO trdd_c_realicador_escolaridad (id_escolaridad, nombre) VALUES (4,'Hasta licenciatura o postgrado');


CREATE TABLE trdd_c_encuesta(
    id_cct                                             VARCHAR(18),
    id_random                                          VARCHAR(64),
    id_encuesta                                        NUMERIC(6),
    id_realizador                                      NUMERIC(1),
    id_realizador_niv_edu                              NUMERIC(1),
    id_realizador_grad_esc                             NUMERIC(1),
    id_realizador_edad                                 NUMERIC(1),
    id_realizador_genero                               NUMERIC(1),
    id_realizador_escolaridad                          NUMERIC(1),
    CONSTRAINT trdd_c_enc_cctramenc_pk PRIMARY KEY (id_cct, id_random, id_encuesta),
    CONSTRAINT trdd_c_enc_cct_fk FOREIGN KEY (id_cct) REFERENCES trdd_cct (id_cct),
    CONSTRAINT trdd_c_enc_realizador_fk FOREIGN KEY (id_realizador) REFERENCES trdd_c_realizador (id_realizador),
    CONSTRAINT trdd_c_enc_rea_nivedugraest_fk FOREIGN KEY (id_realizador_niv_edu, id_realizador_grad_esc) REFERENCES trdd_c_nied_gres (id_nivel_educativo, id_grado_escolar),
    CONSTRAINT trdd_c_enc_rea_edad_fk FOREIGN KEY (id_realizador_edad) REFERENCES trdd_c_realicador_edad (id_edad),
    CONSTRAINT trdd_c_enc_rea_genero_fk FOREIGN KEY (id_realizador_genero) REFERENCES trdd_c_realicador_genero (id_genero),
    CONSTRAINT trdd_c_enc_rea_escolaridad_fk FOREIGN KEY (id_realizador_escolaridad) REFERENCES trdd_c_realicador_escolaridad (id_escolaridad)
);

CREATE TABLE trdd_c_detalle_encuesta(
    id_cct                                             VARCHAR(18),
    id_random                                          VARCHAR(64),
    id_encuesta                                        NUMERIC(6),
    id_anio                                            VARCHAR(12),
    id_pregunta                                        VARCHAR(64),
    id_respuesta                                       NUMERIC(1),
    id_estatus_respuesta                               NUMERIC(1),
    CONSTRAINT trdd_c_detenc_camnegeirer_pk PRIMARY KEY (id_cct, id_random, id_encuesta, id_anio, id_pregunta, id_respuesta, id_estatus_respuesta),
    CONSTRAINT trdd_c_detenc_cctramenc_fk FOREIGN KEY (id_cct, id_random, id_encuesta) REFERENCES trdd_c_encuesta (id_cct, id_random, id_encuesta),
    CONSTRAINT trdd_c_detenc_amneirer_fk FOREIGN KEY (id_anio, id_pregunta, id_respuesta, id_estatus_respuesta) REFERENCES trdd_c_pregunta_respuesta (id_anio, id_pregunta, id_respuesta, id_estatus_respuesta)
);

-- ELiminación de las tablas de la base de datos
DROP TABLE trdd_c_detalle_encuesta;
DROP TABLE trdd_c_encuesta;
DROP TABLE trdd_c_realicador_escolaridad;
DROP TABLE trdd_c_realicador_genero;
DROP TABLE trdd_c_realicador_edad;
DROP TABLE trdd_c_pregunta_respuesta;
DROP TABLE trdd_c_estatus_respuesta;
DROP TABLE trdd_c_pregunta;
DROP TABLE trdd_c_anio;
DROP TABLE trdd_c_realizador;
DROP TABLE trdd_c_nied_gres;
DROP TABLE trdd_c_grado_escolar;