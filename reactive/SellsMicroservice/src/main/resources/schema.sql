DROP TABLE IF EXISTS sell ;
CREATE TABLE sell ( id SERIAL PRIMARY KEY, amount FLOAT NOT NULL, seller_email TEXT NOT NULL );