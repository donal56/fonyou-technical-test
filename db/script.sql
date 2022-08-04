CREATE DATABASE fonyou_technical_test;
USE fonyou_technical_test;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Estructura de la tabla <aplicaciones_examenes>
-- ----------------------------
DROP TABLE IF EXISTS aplicaciones_examenes;
CREATE TABLE aplicaciones_examenes (
    id_aplicacion_examen INT(11) PRIMARY KEY AUTO_INCREMENT,
    id_examen INT(11) NOT NULL,
    fecha_aplicacion DATETIME NOT NULL,
    INDEX ix_aplicacion_examen_id_examen(id_examen) USING BTREE,
    CONSTRAINT fk_aplicacion_examen_id_examen FOREIGN KEY(id_examen) REFERENCES examenes(id_examen) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB ROW_FORMAT = Dynamic;

-- ----------------------------
-- Estructura de la tabla <aplicaciones_examenes_estudiantes>
-- ----------------------------
DROP TABLE IF EXISTS aplicaciones_examenes_estudiantes;
CREATE TABLE aplicaciones_examenes_estudiantes (
    id_aplicacion_examen_estudiante INT(11) PRIMARY KEY AUTO_INCREMENT,
    id_aplicacion_examen INT(11) NOT NULL,
    id_estudiante INT(11) NOT NULL,
    puntuacion INT(11),
    fecha_aplicacion DATETIME,
    UNIQUE INDEX ux_aplicacion_examen_estudiante (id_aplicacion_examen, id_estudiante) USING BTREE,
    CONSTRAINT fk_aplicacion_examen_estudiante_id_aplicacion_examen FOREIGN KEY(id_aplicacion_examen) REFERENCES aplicaciones_examenes(id_aplicacion_examen) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_aplicacion_examen_estudiante_id_estudiante FOREIGN KEY(id_estudiante) REFERENCES estudiantes(id_estudiante) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB ROW_FORMAT = Dynamic;

-- ----------------------------
-- Estructura de la tabla <aplicaciones_examenes_respuestas>
-- ----------------------------
DROP TABLE IF EXISTS aplicaciones_examenes_respuestas;
CREATE TABLE aplicaciones_examenes_respuestas (
    id_aplicacion_examen_respuesta INT(11) PRIMARY KEY AUTO_INCREMENT,
    id_aplicacion_examen_estudiante INT(11) NOT NULL,
    id_examen_pregunta INT(11) NOT NULL,
    id_examen_pregunta_opcion INT(11) NOT NULL,
    INDEX ix_aplicacion_examen_respuesta_id_aplicacion_examen_estudiante (id_aplicacion_examen_estudiante) USING BTREE,
    INDEX ix_aplicacion_examen_respuesta_id_examen_pregunta (id_examen_pregunta) USING BTREE,
    INDEX ix_aplicacion_examen_respuesta_id_examen_pregunta_opcion (id_examen_pregunta_opcion) USING BTREE,
    CONSTRAINT fk_aplicacion_examen_respuesta_id_aplicacion_examen_estudiante FOREIGN KEY(id_aplicacion_examen_estudiante) REFERENCES aplicaciones_examenes_estudiantes(id_aplicacion_examen_estudiante) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_aplicacion_examen_respuesta_id_examen_pregunta FOREIGN KEY(id_examen_pregunta) REFERENCES examenes_preguntas(id_examen_pregunta) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_aplicacion_examen_respuesta_id_examen_pregunta_opcion FOREIGN KEY(id_examen_pregunta_opcion) REFERENCES examenes_preguntas_opciones(id_examen_pregunta_opcion) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB ROW_FORMAT = Dynamic;

-- ----------------------------
-- Estructura de la tabla <estudiantes>
-- ----------------------------
DROP TABLE IF EXISTS estudiantes;
CREATE TABLE estudiantes (
    id_estudiante INT(11) PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    apellido_paterno VARCHAR(255) NOT NULL,
    apellido_materno VARCHAR(255),
    fecha_nacimiento DATE NOT NULL,
    edad INT(11) NOT NULL,
    ciudad VARCHAR(255) NOT NULL,
    zona_horaria VARCHAR(127) NOT NULL
) ENGINE = InnoDB ROW_FORMAT = Dynamic;

-- ----------------------------
-- Estructura de la tabla <examenes>
-- ----------------------------
DROP TABLE IF EXISTS examenes;
CREATE TABLE examenes (
    id_examen INT(11) PRIMARY KEY AUTO_INCREMENT,
    examen VARCHAR(255) NOT NULL,
    puntaje_total INT(11) NOT NULL
) ENGINE = InnoDB ROW_FORMAT = Dynamic;

-- ----------------------------
-- Estructura de la tabla <examenes_preguntas>
-- ----------------------------
DROP TABLE IF EXISTS examenes_preguntas;
CREATE TABLE examenes_preguntas (
    id_examen_pregunta INT(11) PRIMARY KEY AUTO_INCREMENT,
    id_examen INT(11) NOT NULL,
    orden INT(11) NOT NULL,
    inciso VARCHAR(64),
    pregunta VARCHAR(512) NOT NULL,
    puntaje INT(11) NOT NULL,
    INDEX ix_examen_pregunta_id_examen(id_examen) USING BTREE,
    CONSTRAINT fk_examen_pregunta_id_examen FOREIGN KEY(id_examen) REFERENCES examenes(id_examen) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB ROW_FORMAT = Dynamic;

-- ----------------------------
-- Estructura de la tabla <examenes_preguntas_opciones>
-- ----------------------------
DROP TABLE IF EXISTS examenes_preguntas_opciones;
CREATE TABLE examenes_preguntas_opciones (
    id_examen_pregunta_opcion INT(11) PRIMARY KEY AUTO_INCREMENT,
    id_examen_pregunta INT(11) NOT NULL,
    orden INT(11) NOT NULL,
    inciso VARCHAR(64),
    opcion VARCHAR(255) NOT NULL,
    correcta TINYINT(1) NOT NULL,
    INDEX ix_examen_pregunta_opcion_id_examen_pregunta(id_examen_pregunta) USING BTREE,
    CONSTRAINT fk_examen_pregunta_opcion_id_examen_pregunta FOREIGN KEY(id_examen_pregunta) REFERENCES examenes_preguntas(id_examen_pregunta) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

-- ----------------------------
-- Triggers
-- ----------------------------

DELIMITER $$
CREATE TRIGGER tbi_estudiantes
BEFORE INSERT
ON estudiantes FOR EACH ROW
BEGIN
	SET NEW.edad = TIMESTAMPDIFF(YEAR, NEW.fecha_nacimiento, CURDATE());
END $$
DELIMITER ;


DELIMITER $$
CREATE TRIGGER tbu_estudiantes
BEFORE UPDATE
ON estudiantes FOR EACH ROW
BEGIN
	SET NEW.edad = TIMESTAMPDIFF(YEAR, NEW.fecha_nacimiento, CURDATE());
END $$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER tbi_examenes_preguntas_opciones
BEFORE INSERT
ON examenes_preguntas_opciones FOR EACH ROW
BEGIN

	IF NEW.correcta = 1 
		AND EXISTS(SELECT 1 FROM examenes_preguntas_opciones 
			WHERE id_examen_pregunta = NEW.id_examen_pregunta AND correcta = 1) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Solo se adminte una opción correcta';
	END IF;
END $$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER tbu_examenes_preguntas_opciones
BEFORE UPDATE
ON examenes_preguntas_opciones FOR EACH ROW
BEGIN

	IF NEW.correcta = 1 
		AND EXISTS(SELECT 1 FROM examenes_preguntas_opciones 
			WHERE id_examen_pregunta = NEW.id_examen_pregunta AND correcta = 1) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Solo se adminte una opción correcta';
	END IF;
END $$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER tbi_aplicaciones_examenes_estudiantes
BEFORE INSERT
ON aplicaciones_examenes_estudiantes FOR EACH ROW
BEGIN
	DECLARE vFechaAplicacion DATE;
	DECLARE vZonaHoraria VARCHAR(255);
	
	SELECT fecha_aplicacion INTO vFechaAplicacion
	FROM aplicaciones_examenes 
	WHERE id_aplicacion_examen = NEW.id_aplicacion_examen;
	
	SELECT zona_horaria INTO vZonaHoraria
	FROM estudiantes 
	WHERE id_estudiante = NEW.id_estudiante;
	
	SET NEW.fecha_aplicacion = CONVERT_TZ(vFechaAplicacion, '+00:00', vZonaHoraria);
END $$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER tbu_aplicaciones_examenes_estudiantes
BEFORE UPDATE
ON aplicaciones_examenes_estudiantes FOR EACH ROW
BEGIN
	DECLARE vFechaAplicacion DATE;
	DECLARE vZonaHoraria VARCHAR(255);
	
	SELECT fecha_aplicacion INTO vFechaAplicacion
	FROM aplicaciones_examenes 
	WHERE id_aplicacion_examen = NEW.id_aplicacion_examen;
	
	SELECT zona_horaria INTO vZonaHoraria
	FROM estudiantes 
	WHERE id_estudiante = NEW.id_estudiante;
	
	SET NEW.fecha_aplicacion = CONVERT_TZ(vFechaAplicacion, '+00:00', vZonaHoraria);
END $$
DELIMITER ;