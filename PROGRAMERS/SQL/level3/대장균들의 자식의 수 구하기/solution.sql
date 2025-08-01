WITH CHILD_DATA AS (SELECT PARENT_ID, COUNT(*) COUNT
                  FROM ECOLI_DATA
                  WHERE PARENT_ID IS NOT NULL
                  GROUP BY PARENT_ID)

SELECT E.ID, IF(C.COUNT IS NULL, 0, C.COUNT) CHILD_COUNT
FROM ECOLI_DATA E LEFT JOIN CHILD_DATA C
ON E.ID = C.PARENT_ID
ORDER BY E.ID;