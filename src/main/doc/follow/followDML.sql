
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
	


SELECT 
	*
FROM
	talmo_test_follow_table LEFT OUTER JOIN talmo_test_user 
	ON talmo_test_follow_table.FOLLOWER = talmo_test_user.ID
WHERE
	talmo_test_follow_table.FOLLOWEE=#{user_id}
ORDER BY
	FOLLOWER
;