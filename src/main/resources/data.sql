INSERT INTO BRAND(ID,NAME) VALUES (1,'ZARA');

INSERT INTO PRODUCT(ID,NAME) VALUES (35455,'Product 35455');

INSERT INTO PRICE(ID,BRAND_ID,PRODUCT_ID,START_DATE,END_DATE,PRIORITY,PRICE,CURR) VALUES (1,1,35455,'2020-06-14 00.00.00','2020-12-31 23.59.59',0,35.50,'EUR');
INSERT INTO PRICE(ID,BRAND_ID,PRODUCT_ID,START_DATE,END_DATE,PRIORITY,PRICE,CURR) VALUES (2,1,35455,'2020-06-14 15.00.00','2020-06-14 18.30.00',1,25.45,'EUR');
INSERT INTO PRICE(ID,BRAND_ID,PRODUCT_ID,START_DATE,END_DATE,PRIORITY,PRICE,CURR) VALUES (3,1,35455,'2020-06-15 00.00.00','2020-06-15 11.00.00',1,30.50,'EUR');
INSERT INTO PRICE(ID,BRAND_ID,PRODUCT_ID,START_DATE,END_DATE,PRIORITY,PRICE,CURR) VALUES (4,1,35455,'2020-06-15 16.00.00','2020-12-31 23.59.59',1,38.95,'EUR');