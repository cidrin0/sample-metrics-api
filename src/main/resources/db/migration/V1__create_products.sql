CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    code UUID NOT NULL,
    name VARCHAR(70) NOT NULL,
    description VARCHAR(200),
    price NUMERIC(19,2) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT now(),
    updated_at TIMESTAMP,
    active BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE UNIQUE INDEX ux_product_code ON product (code);
