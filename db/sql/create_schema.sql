CREATE TABLE rol
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE usercessca
(
    id       SERIAL PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    surname  VARCHAR(255) NOT NULL,
    email    VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    rol_id   INT,
    FOREIGN KEY (rol_id) REFERENCES "rol" (id) ON DELETE SET NULL
);

CREATE TABLE customer
(
    id            SERIAL PRIMARY KEY,
    rfc           VARCHAR(255) NOT NULL,
    denomination  VARCHAR(255) NOT NULL,
    address       VARCHAR(255) NOT NULL,
    password      VARCHAR(255) NOT NULL,
    usercessca_id INT,
    FOREIGN KEY (usercessca_id) REFERENCES "usercessca" (id) ON DELETE SET NULL
);



CREATE TABLE norm
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL
);

CREATE TABLE requirement
(
    id          SERIAL PRIMARY KEY,
    requirement VARCHAR(255) NOT NULL,
    foundation  VARCHAR(500) NOT NULL,
    norm_id     INT,
    FOREIGN KEY (norm_id) REFERENCES "norm" (id) ON DELETE SET NULL
);

CREATE TABLE content
(
    id             SERIAL PRIMARY KEY,
    id_customer    INT REFERENCES customer (id),
    id_norm        INT REFERENCES norm (id),
    id_requirement INT REFERENCES requirement (id),
    contains       BOOLEAN,
    does_not_contain BOOLEAN,
    not_applicable  BOOLEAN,
    observations   VARCHAR(255),
    annual_validity DATE,
    archive        VARCHAR(255)
);
