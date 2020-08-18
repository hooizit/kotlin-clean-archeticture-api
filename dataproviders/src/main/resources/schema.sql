DROP TABLE IF EXISTS products;
CREATE TABLE products
(
    code VARCHAR,
    description VARCHAR NOT NULL ,
    price DECIMAL NOT NULL ,
    created_at BIGINT DEFAULT NULL
)