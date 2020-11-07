
-- public.consultasdet definition

-- Drop table

-- DROP TABLE public.consultasdet;

CREATE TABLE public.consultasdet (
	codconsultadet int4 NOT NULL,
	ingreso varchar(5) NULL,
	nrohabitacion int4 NULL,
	fechaalta date NULL,
	CONSTRAINT codconsultadet PRIMARY KEY (codconsultadet)
);


-- public.consultascab definition

-- Drop table

-- DROP TABLE public.consultascab;

CREATE TABLE public.consultascab (
	codconsulta int4 NOT NULL,
	fecha date NULL,
	hora date NULL,
	codhospital int4 NULL,
	codservicio int4 NULL,
	diagnostico varchar(200) NULL,
	tratamiento varchar(200) NULL,
	codmedico int4 NULL,
	codconsultadet int4 NULL,
	CONSTRAINT codconsulta PRIMARY KEY (codconsulta)
);


-- public.historialclinico definition

-- Drop table

-- DROP TABLE public.historialclinico;

CREATE TABLE public.historialclinico (
	codhistorial int4 NOT NULL,
	ci varchar(50) NULL,
	nombre varchar(50) NULL,
	fechanacimiento date NULL,
	codconsulta int4 NULL,
	apellido varchar(50) NULL,
	CONSTRAINT codhistorial PRIMARY KEY (codhistorial)
);


-- public.hospital definition

-- Drop table

-- DROP TABLE public.hospital;

CREATE TABLE public.hospital (
	codhospital int4 NOT NULL,
	nombre varchar(50) NULL,
	ciudad varchar(50) NULL,
	telefono varchar(50) NULL,
	codmedico int4 NULL,
	CONSTRAINT codhospital PRIMARY KEY (codhospital)
);


-- public.medico_servicio definition

-- Drop table

-- DROP TABLE public.medico_servicio;

CREATE TABLE public.medico_servicio (
	codmedico int4 NOT NULL,
	codservicio int4 NOT NULL
);


-- public.medicos definition

-- Drop table

-- DROP TABLE public.medicos;

CREATE TABLE public.medicos (
	codmedico int4 NOT NULL,
	dni varchar(50) NULL,
	nombre varchar(50) NULL,
	apellido varchar(50) NULL,
	fechanacimiento date NULL,
	codhospital int4 NULL,
	esdirector varchar(5) NULL,
	CONSTRAINT codmedico PRIMARY KEY (codmedico)
);


-- public.servicios definition

-- Drop table

-- DROP TABLE public.servicios;

CREATE TABLE public.servicios (
	codservicio int4 NOT NULL,
	nombre varchar(50) NULL,
	comentario varchar(100) NULL,
	nrocamas int4 NULL,
	codhospital int4 NULL,
	CONSTRAINT codservicio PRIMARY KEY (codservicio)
);


-- public.consultascab foreign keys

ALTER TABLE public.consultascab ADD CONSTRAINT codconsultadet FOREIGN KEY (codconsultadet) REFERENCES consultasdet(codconsultadet);
ALTER TABLE public.consultascab ADD CONSTRAINT codhospital FOREIGN KEY (codhospital) REFERENCES hospital(codhospital);
ALTER TABLE public.consultascab ADD CONSTRAINT codmedico FOREIGN KEY (codmedico) REFERENCES medicos(codmedico);
ALTER TABLE public.consultascab ADD CONSTRAINT codservicio FOREIGN KEY (codservicio) REFERENCES servicios(codservicio);


-- public.historialclinico foreign keys

ALTER TABLE public.historialclinico ADD CONSTRAINT codconsulta FOREIGN KEY (codconsulta) REFERENCES consultascab(codconsulta);


-- public.hospital foreign keys

ALTER TABLE public.hospital ADD CONSTRAINT codmedico FOREIGN KEY (codmedico) REFERENCES medicos(codmedico);


-- public.medico_servicio foreign keys

ALTER TABLE public.medico_servicio ADD CONSTRAINT codmedico FOREIGN KEY (codmedico) REFERENCES medicos(codmedico);
ALTER TABLE public.medico_servicio ADD CONSTRAINT codservicio FOREIGN KEY (codservicio) REFERENCES servicios(codservicio);


-- public.medicos foreign keys

ALTER TABLE public.medicos ADD CONSTRAINT codhospital FOREIGN KEY (codhospital) REFERENCES hospital(codhospital);


-- public.servicios foreign keys

ALTER TABLE public.servicios ADD CONSTRAINT codhospital FOREIGN KEY (codhospital) REFERENCES hospital(codhospital);




-- public.codconsulta_id_seq definition

-- DROP SEQUENCE public.codconsulta_id_seq;

CREATE SEQUENCE public.codconsulta_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;


-- public.codconsultadetl_id_seq definition

-- DROP SEQUENCE public.codconsultadetl_id_seq;

CREATE SEQUENCE public.codconsultadetl_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;


-- public.codhistorial_id_seq definition

-- DROP SEQUENCE public.codhistorial_id_seq;

CREATE SEQUENCE public.codhistorial_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;


-- public.codhospital_id_seq definition

-- DROP SEQUENCE public.codhospital_id_seq;

CREATE SEQUENCE public.codhospital_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;


-- public.codmedico_id_seq definition

-- DROP SEQUENCE public.codmedico_id_seq;

CREATE SEQUENCE public.codmedico_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;


-- public.codservicio_id_seq definition

-- DROP SEQUENCE public.codservicio_id_seq;

CREATE SEQUENCE public.codservicio_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
