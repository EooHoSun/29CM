INSERT INTO TB_ORIGIN_M(ORIGIN_CD, ORIGIN_NAME) VALUES
('001', 'KOREA'),
('002', 'AMERICA');

INSERT INTO TB_SKU_MAIN(SKU_ID, SKU_SALE_PRICE, SKU_PURCHASE_PRICE, SKU_NAME, ORIGIN_CD) VALUES
('skumain1', 100, 50, 'salmon', '001'),
('skumain2', 200, 100, 'crap', '001'),
('skumain3', 300, 70, 'steak', '002');

INSERT INTO TB_PRODUCT_M(PRODUCT_ID, PRODUCT_CONTENTS, PRODUCT_NAME, PRODUCT_QUANTITY, SKU_MAIN_ID) VALUES
('product1', 'salmon sushi', 'salmon sushi', 100, 'skumain1'),
('product2', 'crap rice', 'crap rice', 100, 'skumain2'),
('product3', 'cow steak', 'cow steak', 0, 'skumain3');



INSERT INTO TB_SKU_SUB(SKU_ID, SKU_SALE_PRICE, SKU_PURCHASE_PRICE, SKU_NAME, PRODUCT_ID, ORIGIN_CD) VALUES
('skusub1', 10, 10, 'kim', 'product1', '001'),
('skusub2', 10, 10, 'source', 'product1', '001'),
('skusub3', 10, 10, 'rice', 'product2', '001'),
('skusub4', 10, 10, 'kim', 'product2', '001');
