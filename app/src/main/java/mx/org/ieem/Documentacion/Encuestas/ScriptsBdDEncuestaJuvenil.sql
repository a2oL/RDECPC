CREATE TABLE trdd_municipio
(
    id_municipio                                         NUMERIC(3),    
    nombre                                              VARCHAR(75),        
  CONSTRAINT trdd_municipio_pk PRIMARY KEY (id_municipio)
);

INSERT INTO trdd_municipio (id_municipio, nombre) VALUES (1, 'TOLUCA');

CREATE TABLE trdd_ej_anio
(
    id_anio                                            VARCHAR(12),
  CONSTRAINT trdd_ej_anio_pk PRIMARY KEY (id_anio)
);

INSERT INTO trdd_ej_anio (id_anio) VALUES('2020');

CREATE TABLE trdd_ej_mes(
    id_mes                                              NUMERIC(2),
    nombre                                              VARCHAR(10),
    CONSTRAINT trdd_ej_mes_pk PRIMARY KEY (id_mes)
);

INSERT INTO trdd_ej_mes (id_mes, nombre) VALUES (1,'Enero');
INSERT INTO trdd_ej_mes (id_mes, nombre) VALUES (2,'Febrero');
INSERT INTO trdd_ej_mes (id_mes, nombre) VALUES (3,'Marzo');
INSERT INTO trdd_ej_mes (id_mes, nombre) VALUES (4,'Abril');
INSERT INTO trdd_ej_mes (id_mes, nombre) VALUES (5,'Mayo');
INSERT INTO trdd_ej_mes (id_mes, nombre) VALUES (6,'Junio');
INSERT INTO trdd_ej_mes (id_mes, nombre) VALUES (7,'Julio');
INSERT INTO trdd_ej_mes (id_mes, nombre) VALUES (8,'Agosto');
INSERT INTO trdd_ej_mes (id_mes, nombre) VALUES (9,'Septiembre');
INSERT INTO trdd_ej_mes (id_mes, nombre) VALUES (10,'Octubre');
INSERT INTO trdd_ej_mes (id_mes, nombre) VALUES (11,'Noviembre');
INSERT INTO trdd_ej_mes (id_mes, nombre) VALUES (12,'Diciembre');


CREATE TABLE trdd_ej_anio_mes(
    id_anio                                            VARCHAR(12),
    id_mes                                              NUMERIC(2),
    CONSTRAINT trdd_ej_anio_mes_pk PRIMARY KEY (id_anio, id_mes),
    CONSTRAINT trdd_ej_anio_fk FOREIGN KEY (id_anio) REFERENCES trdd_ej_anio (id_anio),
    CONSTRAINT trdd_ej_mes_fk FOREIGN KEY (id_mes) REFERENCES trdd_ej_mes (id_mes)
);

INSERT INTO trdd_ej_anio_mes (id_anio, id_mes) VALUES ('2020', 1);
INSERT INTO trdd_ej_anio_mes (id_anio, id_mes) VALUES ('2020', 2);
INSERT INTO trdd_ej_anio_mes (id_anio, id_mes) VALUES ('2020', 3);
INSERT INTO trdd_ej_anio_mes (id_anio, id_mes) VALUES ('2020', 4);
INSERT INTO trdd_ej_anio_mes (id_anio, id_mes) VALUES ('2020', 5);
INSERT INTO trdd_ej_anio_mes (id_anio, id_mes) VALUES ('2020', 6);
INSERT INTO trdd_ej_anio_mes (id_anio, id_mes) VALUES ('2020', 7);
INSERT INTO trdd_ej_anio_mes (id_anio, id_mes) VALUES ('2020', 8);
INSERT INTO trdd_ej_anio_mes (id_anio, id_mes) VALUES ('2020', 9);
INSERT INTO trdd_ej_anio_mes (id_anio, id_mes) VALUES ('2020', 10);
INSERT INTO trdd_ej_anio_mes (id_anio, id_mes) VALUES ('2020', 11);
INSERT INTO trdd_ej_anio_mes (id_anio, id_mes) VALUES ('2020', 12);


CREATE TABLE trdd_nivel_educativo
(
    id_nivel_educativo                                 NUMERIC(1),
    nombre                                             VARCHAR(64),
  CONSTRAINT trdd_nivel_educativo_pk PRIMARY KEY (id_nivel_educativo)
);

INSERT INTO trdd_nivel_educativo(id_nivel_educativo, nombre) VALUES(1,'Primaria');
INSERT INTO trdd_nivel_educativo(id_nivel_educativo, nombre) VALUES(2,'Secundaria');


CREATE TABLE trdd_ej_grado_escolar(
    id_grado_escolar                                    NUMERIC(1),
    nombre                                              VARCHAR(35),
    siglas                                              VARCHAR(6),
    grado                                               VARCHAR(4),
  CONSTRAINT trdd_ej_grado_escolar_pk PRIMARY KEY (id_grado_escolar)  
);

INSERT INTO trdd_ej_grado_escolar (id_grado_escolar, nombre, siglas, grado) VALUES (1,'Primero', '1ero', '1º');
INSERT INTO trdd_ej_grado_escolar (id_grado_escolar, nombre, siglas, grado) VALUES (2,'Segundo', '2do', '2º');
INSERT INTO trdd_ej_grado_escolar (id_grado_escolar, nombre, siglas, grado) VALUES (3,'Tercero', '3ero', '3º');
INSERT INTO trdd_ej_grado_escolar (id_grado_escolar, nombre, siglas, grado) VALUES (4,'Cuarto', '4to', '4º');
INSERT INTO trdd_ej_grado_escolar (id_grado_escolar, nombre, siglas, grado) VALUES (5,'Quinto', '5to', '5º');
INSERT INTO trdd_ej_grado_escolar (id_grado_escolar, nombre, siglas, grado) VALUES (6,'Sexto', '6to', '6º');

CREATE TABLE trdd_ej_nied_gres(
    id_nivel_educativo                                 NUMERIC(1),
    id_grado_escolar                                   NUMERIC(1),
    CONSTRAINT trdd_ej_nege_pk PRIMARY KEY (id_nivel_educativo, id_grado_escolar),
    CONSTRAINT trpd_ej_nege_nivedu_fk FOREIGN KEY (id_nivel_educativo) REFERENCES trdd_nivel_educativo (id_nivel_educativo),  
    CONSTRAINT trpd_ej_nege_graesc_fk FOREIGN KEY (id_grado_escolar) REFERENCES trdd_ej_grado_escolar (id_grado_escolar)
);

-- Para nivel educativo primaria se dan 6 grados escolares
INSERT INTO trdd_ej_nied_gres (id_nivel_educativo, id_grado_escolar) VALUES (1,1);
INSERT INTO trdd_ej_nied_gres (id_nivel_educativo, id_grado_escolar) VALUES (1,2);
INSERT INTO trdd_ej_nied_gres (id_nivel_educativo, id_grado_escolar) VALUES (1,3);
INSERT INTO trdd_ej_nied_gres (id_nivel_educativo, id_grado_escolar) VALUES (1,4);
INSERT INTO trdd_ej_nied_gres (id_nivel_educativo, id_grado_escolar) VALUES (1,5);
INSERT INTO trdd_ej_nied_gres (id_nivel_educativo, id_grado_escolar) VALUES (1,6);
-- Para nivel educativo secundaria se dan 3 grados escolares
INSERT INTO trdd_ej_nied_gres (id_nivel_educativo, id_grado_escolar) VALUES (2,1);
INSERT INTO trdd_ej_nied_gres (id_nivel_educativo, id_grado_escolar) VALUES (2,2);
INSERT INTO trdd_ej_nied_gres (id_nivel_educativo, id_grado_escolar) VALUES (2,3);

CREATE TABLE trdd_ej_indicador(
    id_indicador                                        NUMERIC(1),
    nombre                                              VARCHAR(75),
    CONSTRAINT trdd_ej_indicador_pk PRIMARY KEY (id_indicador)
);

INSERT INTO trdd_ej_indicador (id_indicador, nombre) VALUES (1,'Determina si es niño o niña');
INSERT INTO trdd_ej_indicador (id_indicador, nombre) VALUES (2,'Identificación de los valores cívicos');
INSERT INTO trdd_ej_indicador (id_indicador, nombre) VALUES (3,'Actitudes cívicas');
INSERT INTO trdd_ej_indicador (id_indicador, nombre) VALUES (4,'Conocimiento del calendario cívico');
INSERT INTO trdd_ej_indicador (id_indicador, nombre) VALUES (5,'Identificación de las instituciones');
INSERT INTO trdd_ej_indicador (id_indicador, nombre) VALUES (6,'Identificación de los derechos de Niñas, Niños y Adolecentes (NNA)');


CREATE TABLE trdd_ej_nivedu_ind(
    id_nivel_educativo                                 NUMERIC(1),
    id_indicador                                       NUMERIC(1),
    CONSTRAINT trdd_ej_nei_nei_pk PRIMARY KEY (id_nivel_educativo, id_indicador),
    CONSTRAINT trdd_ej_nei_nivedu_fk FOREIGN KEY (id_nivel_educativo) REFERENCES trdd_nivel_educativo (id_nivel_educativo),
    CONSTRAINT trdd_ej_nei_indicador_fk FOREIGN KEY (id_indicador) REFERENCES trdd_ej_indicador (id_indicador)  
);

-- Nivel primaria 8 indicadores
INSERT INTO trdd_ej_nivedu_ind (id_nivel_educativo, id_indicador) VALUES (1,1);
INSERT INTO trdd_ej_nivedu_ind (id_nivel_educativo, id_indicador) VALUES (1,2);
INSERT INTO trdd_ej_nivedu_ind (id_nivel_educativo, id_indicador) VALUES (1,3);
INSERT INTO trdd_ej_nivedu_ind (id_nivel_educativo, id_indicador) VALUES (1,4);
INSERT INTO trdd_ej_nivedu_ind (id_nivel_educativo, id_indicador) VALUES (1,5);
INSERT INTO trdd_ej_nivedu_ind (id_nivel_educativo, id_indicador) VALUES (1,6);
-- Nivel secundaria 8 indicadores
INSERT INTO trdd_ej_nivedu_ind (id_nivel_educativo, id_indicador) VALUES (2,1);
INSERT INTO trdd_ej_nivedu_ind (id_nivel_educativo, id_indicador) VALUES (2,2);
INSERT INTO trdd_ej_nivedu_ind (id_nivel_educativo, id_indicador) VALUES (2,3);
INSERT INTO trdd_ej_nivedu_ind (id_nivel_educativo, id_indicador) VALUES (2,4);
INSERT INTO trdd_ej_nivedu_ind (id_nivel_educativo, id_indicador) VALUES (2,5);
INSERT INTO trdd_ej_nivedu_ind (id_nivel_educativo, id_indicador) VALUES (2,6);

CREATE TABLE trdd_ej_pregunta(
    id_anio                                            VARCHAR(12),
    id_mes                                             NUMERIC(2),
    id_nivel_educativo                                 NUMERIC(1),
    id_indicador                                       NUMERIC(1),
    pregunta                                           VARCHAR(64),
    CONSTRAINT trdd_ej_pre_pregunta_pk PRIMARY KEY (id_anio, id_mes, id_nivel_educativo, id_indicador),
    CONSTRAINT trdd_ej_pre_animes_fk FOREIGN KEY (id_anio, id_mes) REFERENCES trdd_ej_anio_mes (id_anio, id_mes),
    CONSTRAINT trdd_ej_pre_niveduind_fk FOREIGN KEY (id_nivel_educativo, id_indicador) REFERENCES trdd_ej_nivedu_ind (id_nivel_educativo, id_indicador)
);

-- Anio 2020, mes Enero, nivel educativo Primaria e indicadores 1..6
INSERT INTO trdd_ej_pregunta (id_anio, id_mes, id_nivel_educativo, id_indicador, pregunta) VALUES ('2020', 1, 1, 1, '¿Primis - Eres niña o niño?');
INSERT INTO trdd_ej_pregunta (id_anio, id_mes, id_nivel_educativo, id_indicador, pregunta) VALUES ('2020', 1, 1, 2, '¿Primis - Pregunta 2?');
INSERT INTO trdd_ej_pregunta (id_anio, id_mes, id_nivel_educativo, id_indicador, pregunta) VALUES ('2020', 1, 1, 3, '¿Primis - Pregunta 3?');
INSERT INTO trdd_ej_pregunta (id_anio, id_mes, id_nivel_educativo, id_indicador, pregunta) VALUES ('2020', 1, 1, 4, '¿Primis - Pregunta 4?');
INSERT INTO trdd_ej_pregunta (id_anio, id_mes, id_nivel_educativo, id_indicador, pregunta) VALUES ('2020', 1, 1, 5, '¿Primis - Pregunta 5?');
INSERT INTO trdd_ej_pregunta (id_anio, id_mes, id_nivel_educativo, id_indicador, pregunta) VALUES ('2020', 1, 1, 6, '¿Primis - Pregunta 6?');
-- Anio 2020, mes Enero, nivel educativo Secundaria e indicadores 1..6
INSERT INTO trdd_ej_pregunta (id_anio, id_mes, id_nivel_educativo, id_indicador, pregunta) VALUES ('2020', 1, 2, 1, '¿Secun - Eres niña o niño?');
INSERT INTO trdd_ej_pregunta (id_anio, id_mes, id_nivel_educativo, id_indicador, pregunta) VALUES ('2020', 1, 2, 2, '¿Secun - Pregunta 2?');
INSERT INTO trdd_ej_pregunta (id_anio, id_mes, id_nivel_educativo, id_indicador, pregunta) VALUES ('2020', 1, 2, 3, '¿Secun - Pregunta 3?');
INSERT INTO trdd_ej_pregunta (id_anio, id_mes, id_nivel_educativo, id_indicador, pregunta) VALUES ('2020', 1, 2, 4, '¿Secun - Pregunta 4?');
INSERT INTO trdd_ej_pregunta (id_anio, id_mes, id_nivel_educativo, id_indicador, pregunta) VALUES ('2020', 1, 2, 5, '¿Secun - Pregunta 5?');
INSERT INTO trdd_ej_pregunta (id_anio, id_mes, id_nivel_educativo, id_indicador, pregunta) VALUES ('2020', 1, 2, 6, '¿Secun - Pregunta 6?');


CREATE TABLE trdd_ej_estatus_respuesta(
    id_estatus_respuesta                               NUMERIC(1),
    nombre                                             VARCHAR(35),
    CONSTRAINT trdd_ej_estatus_respuesta_pk PRIMARY KEY (id_estatus_respuesta)
);

INSERT INTO trdd_ej_estatus_respuesta(id_estatus_respuesta, nombre) VALUES (1,'Correcta');
INSERT INTO trdd_ej_estatus_respuesta(id_estatus_respuesta, nombre) VALUES (2,'Incorrecta');

CREATE TABLE trdd_ej_pregunta_respuesta(
    id_anio                                            VARCHAR(12),
    id_mes                                             NUMERIC(2),
    id_nivel_educativo                                 NUMERIC(1),
    id_indicador                                       NUMERIC(1),
    id_respuesta                                       NUMERIC(1),
    id_estatus_respuesta                               NUMERIC(1),
    respuesta                                          VARCHAR(35),
    CONSTRAINT trdd_ej_prre_amneirer_pk PRIMARY KEY (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta),
    CONSTRAINT trdd_ej_prre_amnei_fk FOREIGN KEY (id_anio, id_mes, id_nivel_educativo, id_indicador) REFERENCES trdd_ej_pregunta (id_anio, id_mes, id_nivel_educativo, id_indicador),
    CONSTRAINT trdd_ej_prre_estres_fk FOREIGN KEY (id_estatus_respuesta) REFERENCES trdd_ej_estatus_respuesta (id_estatus_respuesta)
);

-- Primaria
-- Anio 2020, mes Enero, Primaria, indicador 1, respuesta 1..3, la primera Correcta y las 2 siguientes incorrectas
INSERT INTO trdd_ej_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020',1,1,1,1,1,'Primis/P1/R1: Correcta');
INSERT INTO trdd_ej_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020',1,1,1,2,2,'Primis/P1/R2: Incorrecta');
INSERT INTO trdd_ej_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020',1,1,1,3,2,'Primis/P1/R3: Incorrecta');
-- Anio 2020, mes Enero, Primaria, indicador 2, respuesta 1..3, la primera Correcta y las 2 siguientes incorrectas
INSERT INTO trdd_ej_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020',1,1,2,1,1,'Primis/P2/R1: Correcta');
INSERT INTO trdd_ej_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020',1,1,2,2,2,'Primis/P2/R2: Incorrecta');
INSERT INTO trdd_ej_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020',1,1,2,3,2,'Primis/P2/R3: Incorrecta');
-- Anio 2020, mes Enero, Primaria, indicador 3, respuesta 1..3, la primera Correcta y las 2 siguientes incorrectas
INSERT INTO trdd_ej_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020',1,1,3,1,1,'Primis/P3/R1: Correcta');
INSERT INTO trdd_ej_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020',1,1,3,2,2,'Primis/P3/R2: Incorrecta');
INSERT INTO trdd_ej_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020',1,1,3,3,2,'Primis/P3/R3: Incorrecta');
-- Anio 2020, mes Enero, Primaria, indicador 4, respuesta 1..3, la primera Correcta y las 2 siguientes incorrectas
INSERT INTO trdd_ej_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020',1,1,4,1,1,'Primis/P4/R1: Correcta');
INSERT INTO trdd_ej_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020',1,1,4,2,2,'Primis/P4/R2: Incorrecta');
INSERT INTO trdd_ej_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020',1,1,4,3,2,'Primis/P4/R3: Incorrecta');
-- Anio 2020, mes Enero, Primaria, indicador 5, respuesta 1..3, la primera Correcta y las 2 siguientes incorrectas
INSERT INTO trdd_ej_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020',1,1,5,1,1,'Primis/P5/R1: Correcta');
INSERT INTO trdd_ej_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020',1,1,5,2,2,'Primis/P5/R2: Incorrecta');
INSERT INTO trdd_ej_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020',1,1,5,3,2,'Primis/P5/R3: Incorrecta');
-- Anio 2020, mes Enero, Primaria, indicador 6, respuesta 1..3, la primera Correcta y las 2 siguientes incorrectas
INSERT INTO trdd_ej_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020',1,1,6,1,1,'Primis/P6/R1: Correcta');
INSERT INTO trdd_ej_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020',1,1,6,2,2,'Primis/P6/R2: Incorrecta');
INSERT INTO trdd_ej_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020',1,1,6,3,2,'Primis/P6/R3: Incorrecta');
-- Secundaria
-- Anio 2020, mes Enero, Secundaria, indicador 1, respuesta 1..3, la primera Correcta y las 2 siguientes incorrectas
INSERT INTO trdd_ej_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020',1,2,1,1,1,'Secun/P1/R1: Correcta');
INSERT INTO trdd_ej_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020',1,2,1,2,2,'Secun/P1/R2: Incorrecta');
INSERT INTO trdd_ej_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020',1,2,1,3,2,'Secun/P1/R3: Incorrecta');
-- Anio 2020, mes Enero, Secundaria, indicador 2, respuesta 1..3, la primera Correcta y las 2 siguientes incorrectas
INSERT INTO trdd_ej_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020',1,2,2,1,1,'Secun/P2/R1: Correcta');
INSERT INTO trdd_ej_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020',1,2,2,2,2,'Secun/P2/R2: Incorrecta');
INSERT INTO trdd_ej_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020',1,2,2,3,2,'Secun/P2/R3: Incorrecta');
-- Anio 2020, mes Enero, Secundaria, indicador 3, respuesta 1..3, la primera Correcta y las 2 siguientes incorrectas
INSERT INTO trdd_ej_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020',1,2,3,1,1,'Secun/P3/R1: Correcta');
INSERT INTO trdd_ej_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020',1,2,3,2,2,'Secun/P3/R2: Incorrecta');
INSERT INTO trdd_ej_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020',1,2,3,3,2,'Secun/P3/R3: Incorrecta');
-- Anio 2020, mes Enero, Secundaria, indicador 4, respuesta 1..3, la primera Correcta y las 2 siguientes incorrectas
INSERT INTO trdd_ej_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020',1,2,4,1,1,'Secun/P4/R1: Correcta');
INSERT INTO trdd_ej_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020',1,2,4,2,2,'Secun/P4/R2: Incorrecta');
INSERT INTO trdd_ej_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020',1,2,4,3,2,'Secun/P4/R3: Incorrecta');
-- Anio 2020, mes Enero, Secundaria, indicador 5, respuesta 1..3, la primera Correcta y las 2 siguientes incorrectas
INSERT INTO trdd_ej_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020',1,2,5,1,1,'Secun/P5/R1: Correcta');
INSERT INTO trdd_ej_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020',1,2,5,2,2,'Secun/P5/R2: Incorrecta');
INSERT INTO trdd_ej_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020',1,2,5,3,2,'Secun/P5/R3: Incorrecta');
-- Anio 2020, mes Enero, Secundaria, indicador 6, respuesta 1..3, la primera Correcta y las 2 siguientes incorrectas
INSERT INTO trdd_ej_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020',1,2,6,1,1,'Secun/P6/R1: Correcta');
INSERT INTO trdd_ej_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020',1,2,6,2,2,'Secun/P6/R2: Incorrecta');
INSERT INTO trdd_ej_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta, respuesta) VALUES ('2020',1,2,6,3,2,'Secun/P6/R3: Incorrecta');

-- Esta tabla es compartida por Encuesta juvenil y Ciudadanometro y se crea primero en Encuesta juvenil
CREATE TABLE trdd_cct
(
    id_cct                                             VARCHAR(18),
    nombre                                             VARCHAR(64),
    domicilio                                          VARCHAR(128),
    email                                              VARCHAR(128),
    id_municipio                                       NUMERIC(1),
    id_nivel_educativo                                 NUMERIC(1),
    contrasenia                                        VARCHAR(32),
  CONSTRAINT trdd_cct_pk PRIMARY KEY (id_cct),
  CONSTRAINT trdd_cct_mun_fk FOREIGN KEY (id_municipio) REFERENCES trdd_municipio (id_municipio),
  CONSTRAINT trdd_cct_niv_edu_fk FOREIGN KEY (id_nivel_educativo) REFERENCES trdd_nivel_educativo (id_nivel_educativo)
);

INSERT INTO trdd_cct (id_cct, nombre, domicilio, email, id_municipio, id_nivel_educativo) VALUES(1, 'PRIMARIA AMADO NERVO', 'ESQUINA HERIBERTO HENRIQUEZ CON CEBORUCO','gvaldez@ieem.org.mx',1,1);
INSERT INTO trdd_cct (id_cct, nombre, domicilio, email, id_municipio, id_nivel_educativo) VALUES(2, 'SECUNDARIA TÉCNICA #49 SAMUEL RAMOS', 'PRIVADA DE TLALOC #100','gvaldez@ieem.org.mx',1,2);


CREATE TABLE trdd_ej_encuesta(
    id_cct                                             VARCHAR(18),
    id_random                                          VARCHAR(64),
    id_encuesta                                        NUMERIC(6),
    id_nivel_educativo                                 NUMERIC(1),
    id_grado_escolar                                   NUMERIC(1),    
    CONSTRAINT trdd_ej_enc_camnegeirer_pk PRIMARY KEY (id_cct, id_random, id_encuesta, id_nivel_educativo),
    CONSTRAINT trdd_ej_enc_cct_fk FOREIGN KEY (id_cct) REFERENCES trdd_cct (id_cct),
    CONSTRAINT trdd_ej_enc_niedgres_cct_fk FOREIGN KEY (id_nivel_educativo, id_grado_escolar) REFERENCES trdd_ej_nied_gres (id_nivel_educativo, id_grado_escolar)
);

CREATE TABLE trdd_ej_detalle_encuesta(
    id_cct                                             VARCHAR(18),
    id_random                                          VARCHAR(64),
    id_encuesta                                        NUMERIC(6),
    id_anio                                            VARCHAR(12),
    id_mes                                             NUMERIC(2),
    id_nivel_educativo                                 NUMERIC(1),
    id_indicador                                       NUMERIC(1),
    id_respuesta                                       NUMERIC(1),
    id_estatus_respuesta                               NUMERIC(1),
    CONSTRAINT trdd_ej_detenc_creamneirer_pk PRIMARY KEY (id_cct, id_random, id_encuesta, id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta),
    CONSTRAINT trdd_ej_detenc_crene_fk FOREIGN KEY (id_cct, id_random, id_encuesta, id_nivel_educativo) REFERENCES trdd_ej_encuesta (id_cct, id_random, id_encuesta, id_nivel_educativo),
    CONSTRAINT trdd_ej_detenc_amneirer_fk FOREIGN KEY (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta) REFERENCES trdd_ej_pregunta_respuesta (id_anio, id_mes, id_nivel_educativo, id_indicador, id_respuesta, id_estatus_respuesta)
);

CREATE TABLE trdd_estatus_concurso_o_evento
(
    id_estatus_coneve                                   NUMERIC(1),
    nombre                                             VARCHAR(35),
 CONSTRAINT trdd_estconeve_pk PRIMARY KEY (id_estatus_coneve)   
);

INSERT INTO trdd_estatus_concurso_o_evento (id_estatus_coneve, nombre) VALUES(1, 'ACTIVO');
INSERT INTO trdd_estatus_concurso_o_evento (id_estatus_coneve, nombre) VALUES(2, 'INACTIVO');

CREATE TABLE trdd_concurso_o_evento
(
 id_con_eve                                            NUMERIC(3),
 nombre                                                VARCHAR(128),
 descripcion                                           VARCHAR(256),
 url                                                   VARCHAR(512),
 url_image                                             VARCHAR(512),
 id_estatus_coneve                                     NUMERIC(1),
 CONSTRAINT trdd_coneve_pk PRIMARY KEY (id_con_eve),
 CONSTRAINT trdd_coneve_ece_fk FOREIGN KEY (id_estatus_coneve) REFERENCES trdd_estatus_concurso_o_evento (id_estatus_coneve)
);

INSERT INTO trdd_concurso_o_evento (id_con_eve, nombre, descripcion, url, url_image, id_estatus_coneve) VALUES(1, 'CONCURSO DE ACTIVO', 'ESTE CONCURSO PRUEBA LA FUNCIONALIDAD DEL SERVICIO', 'www.google.com', 'https://www.ieem.org.mx/img/TRANSPARENCIA_2018.png',1);
INSERT INTO trdd_concurso_o_evento (id_con_eve, nombre, descripcion, url, url_image, id_estatus_coneve) VALUES(2, 'CONCURSO DE INACTIVO', 'ESTE CONCURSO PRUEBA LA FUNCIONALIDAD DEL SERVICIO', 'www.google.com', 'https://www.ieem.org.mx/img/TRANSPARENCIA_2018.png',2);

CREATE TABLE trdd_estatus_reporte
(
    id_estatus_reporte                                 NUMERIC(1),
    nombre                                             VARCHAR(35),
 CONSTRAINT trdd_estatus_reporte_pk PRIMARY KEY (id_estatus_reporte)   
);

INSERT INTO trdd_estatus_reporte (id_estatus_reporte, nombre) VALUES(1, 'ACTIVO');
INSERT INTO trdd_estatus_reporte (id_estatus_reporte, nombre) VALUES(2, 'INACTIVO');


CREATE TABLE trdd_tipo_reporte
(
    id_tipo_reporte                                 NUMERIC(1),
    nombre                                             VARCHAR(35),
 CONSTRAINT trdd_tipo_reporte_pk PRIMARY KEY (id_tipo_reporte)
);

INSERT INTO trdd_tipo_reporte (id_tipo_reporte, nombre) VALUES(1, 'ENCUESTA JUVENIL');
INSERT INTO trdd_tipo_reporte (id_tipo_reporte, nombre) VALUES(2, 'CIUDADANOMETRO');

CREATE TABLE trdd_reporte
(
 id_reporte                                            NUMERIC(3),
 nombre                                                VARCHAR(128),
 descripcion                                           VARCHAR(256),
 url                                                   VARCHAR(512),
 id_estatus_reporte                                    NUMERIC(1),
 id_tipo_reporte                                       NUMERIC(1),
 CONSTRAINT trdd_reporte_pk PRIMARY KEY (id_reporte),
 CONSTRAINT trdd_reporte_estrep_fk FOREIGN KEY (id_estatus_reporte) REFERENCES trdd_estatus_reporte (id_estatus_reporte),
 CONSTRAINT trdd_reporte_tiprep_fk FOREIGN KEY (id_tipo_reporte) REFERENCES trdd_tipo_reporte (id_tipo_reporte)
);

INSERT INTO trdd_reporte (id_reporte, nombre, descripcion, url, id_estatus_reporte, id_tipo_reporte) VALUES(1, 'REPORTE 1 ACTIVO EJ', 'PRIMER REPORTE ACTIVO', 'https://www.google.com', 1, 1);
INSERT INTO trdd_reporte (id_reporte, nombre, descripcion, url, id_estatus_reporte, id_tipo_reporte) VALUES(2, 'REPORTE 2 ACTIVO CIU', 'SEGUNDO REPORTE ACTIVO', 'https://www.google.com',1, 2);
INSERT INTO trdd_reporte (id_reporte, nombre, descripcion, url, id_estatus_reporte, id_tipo_reporte) VALUES(3, 'REPORTE 3 INACTIVO EJ', 'PRIMER REPORTE INACTIVO', 'https://www.google.com',2, 1);

-- ELiminación de las tablas de la base de datos    
DROP TABLE trdd_ej_detalle_encuesta;
DROP TABLE trdd_ej_encuesta;
DROP TABLE trdd_cct;
DROP TABLE trdd_ej_pregunta_respuesta;
DROP TABLE trdd_ej_estatus_respuesta;
DROP TABLE trdd_ej_pregunta;
DROP TABLE trdd_ej_nivedu_ind;
DROP TABLE trdd_ej_indicador;
DROP TABLE trdd_ej_nied_gres;
DROP TABLE trdd_ej_grado_escolar;
DROP TABLE trdd_nivel_educativo;
DROP TABLE trdd_ej_anio_mes;
DROP TABLE trdd_ej_mes;
DROP TABLE trdd_ej_anio;
DROP TABLE trdd_municipio;
// concursos y eventos
DROP TABLE trdd_concurso_o_evento;
DROP TABLE trdd_estatus_concurso_o_evento;