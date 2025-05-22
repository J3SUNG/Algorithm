SELECT ORDER_ID, PRODUCT_ID, DATE_FORMAT(OUT_DATE, '%Y-%m-%d'), CASE 
                                WHEN OUT_DATE IS NULL THEN '출고미정'
                                WHEN DATE_FORMAT(OUT_DATE, '%y-%m-%d') <= '22-05-01' THEN '출고완료'
                                WHEN DATE_FORMAT(OUT_DATE, '%y-%m-%d') > '22-05-01' THEN '출고대기'
                                END 출고여부
FROM FOOD_ORDER
ORDER BY ORDER_ID;