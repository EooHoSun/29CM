INSERT INTO ORIGIN(CD, NAME) VALUES
('001', 'KOREA'),
('002', 'AMERICA');

INSERT INTO PRODUCTS(ID, CONTENTS, NAME, QUANTITY) VALUES
(1, 'salmon sushi', 'salmon sushi', 100),
(2, 'crap rice', 'crap rice', 100),
(3, 'cow steak', 'cow steak', 0);


INSERT INTO SKUS(SKUTYPE, ID, SALEPRICE, PURCHASEPRICE, NAME, ORIGIN_CD) VALUES
('MAIN', 1, 100, 50, 'salmon', '001'),
('MAIN', 2, 200, 100, 'crap', '001'),
('MAIN', 3, 300, 70, 'steak', '002'),
('SUB', 4, 10, 10, 'kim', '001'),
('SUB', 5, 10, 10, 'source', '001'),
('SUB', 6, 10, 10, 'rice', '001');

INSERT INTO PRODUCTS_SKUS(PRODUCT_ID, SKU_ID, QUANTITY) VALUES
(1,1,2),
(2,2,3),
(3,3,1),
(1,4,5),
(1,5,1),
(2,4,4),
(2,6,3);
