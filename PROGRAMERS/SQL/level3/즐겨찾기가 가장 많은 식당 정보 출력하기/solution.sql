WITH MAX_REST AS (SELECT FOOD_TYPE, MAX(FAVORITES) FAVORITES
                FROM REST_INFO
                GROUP BY FOOD_TYPE)

SELECT R.FOOD_TYPE, R.REST_ID, R.REST_NAME, R.FAVORITES
FROM REST_INFO R JOIN MAX_REST M
ON R.FOOD_TYPE = M.FOOD_TYPE AND R.FAVORITES = M.FAVORITES
ORDER BY FOOD_TYPE DESC;