CREATE TABLE talmo_test_follow_table(
	FOLLOWER varchar(40) NOT NULL,
	FOLLOWEE varchar(40) NOT NULL,
	STATUS bit,
	PRIMARY KEY (FOLLOWER, FOLLOWEE)
);

DROP TABLE talmo_test_follow_table;



CREATE TABLE TMV_FOLLOW(
	FOLLOWER varchar(40) NOT NULL,
	FOLLOWEE varchar(40) NOT NULL,
	STATUS bit,
	PRIMARY KEY (FOLLOWER, FOLLOWEE)
);


#alter table table2 add FOREIGN KEY(id) REFERENCES table1(id);
ALTER TABLE TMV_FOLLOW
ADD CONSTRAINT FK_FOLLOW_FOLLOWER_USER_ID FOREIGN KEY (FOLLOWER)
REFERENCES TMV_USER (ID) ON DELETE CASCADE ON UPDATE CASCADE;
       
ALTER TABLE TMV_FOLLOW
ADD CONSTRAINT FK_FOLLOW_FOLLOWEE_USER_ID FOREIGN KEY (FOLLOWEE)
REFERENCES TMV_USER (ID) ON DELETE CASCADE ON UPDATE CASCADE;

DROP TABLE TMV_FOLLOW;