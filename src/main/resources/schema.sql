CREATE TABLE product (id SERIAL PRIMARY KEY, product_id VARCHAR(255), value VARCHAR(255));

INSERT INTO product(id, product_id, value) VALUES ('1', '098', 'productName098'),
                                                  ('2', '088', 'productName088'),
                                                  ('3', '087', 'productName087');