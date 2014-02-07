-- Table: app_user

-- DROP TABLE app_user;

CREATE TABLE app_user
(
  password text,
  login_name text,
  app_user_id integer NOT NULL,
  CONSTRAINT app_user_id_pk PRIMARY KEY (app_user_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE app_user
  OWNER TO postgres;

  
-- Table: lov

-- DROP TABLE lov;

CREATE TABLE lov
(
  id integer NOT NULL,
  name text,
  CONSTRAINT pk_id PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE lov
  OWNER TO postgres;
