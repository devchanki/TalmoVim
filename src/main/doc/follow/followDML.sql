
/*샘플*/
INSERT INTO talmo_test_follow_table(follower, followee)
VALUES('1','5');

INSERT INTO talmo_test_follow_table(follower, followee)
VALUES('2','1');


SELECT 
	COUNT(*)
FROM
	talmo_test_follow_table
WHERE
	FOLLOWEE=1;