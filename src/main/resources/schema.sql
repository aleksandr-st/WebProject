CREATE TABLE CONTACT(
	ID INT NOT NULL AUTO_INCREMENT
	, FIRST_NAME VARCHAR(60) NOT NULL
	, LAST_NAME VARCHAR(40) NOT NULL
	, BIRTH_DATE DATE
	, VERSION INT NOT NULL DEFAULT 0
	, UNIQUE UQ_CONTACT_1 (FIRST_NAME,LAST_NAME)
	,PRIMARY KEY (ID)
);
CREATE TABLE HOBBY(
	HOBBY_ID VARCHAR(30) NOT NULL
	, HOBBY_DESCR VARCHAR(100) NOT NULL
	, PRIMARY KEY (HOBBY_ID)
);
CREATE TABLE PLACE(
	PLACE_ID VARCHAR(50) NOT NULL
	, PLACE_DESCR VARCHAR(100) NOT NULL
	, PLACE_LONGITUDE DOUBLE NOT NULL DEFAULT 0
	, PLACE_LATITUDE DOUBLE NOT NULL DEFAULT 0
	, PRIMARY KEY (PLACE_ID)
);
CREATE TABLE CONTACT_HOBBY(
	CONTACT_ID NOT NULL
	, HOBBY_ID NOT NULL
	, PRIMARY KEY (CONTACT_ID,HOBBY_ID)
	, CONSTRAINT FK_CONTACT_HOBBY_1 FOREIGN KEY (CONTACT_ID) REFERENCES CONTACT (ID) ON DELETE CASCADE
	, CONSTRAINT FK_CONTACT_HOBBY_2 FOREIGN KEY (HOBBY_ID) REFERENCES HOBBY (HOBBY_ID)
);
CREATE TABLE CONTACT_PLACE(
	CONTACT_ID NOT NULL
	, PLACE_ID NOT NULL
	, PRIMARY KEY (CONTACT_ID,PLACE_ID)
	, CONSTRAINT FK_CONTACT_PLACE_1 FOREIGN KEY (CONTACT_ID) REFERENCES CONTACT (ID) ON DELETE CASCADE
	, CONSTRAINT FK_CONTACT_PLACE_2 FOREIGN KEY (PLACE_ID) REFERENCES PLACE (PLACE_ID)
);
CREATE TABLE CONTACT_FRIEDSHIP(
	CONTACT_ID NOT NULL
	, CONTACT_ID NOT NULL
	, PRIMARY KEY (CONTACT_ID,CONTACT_ID)
	, CONSTRAINT FK_CONTACT_FRIENDSHIP_1 FOREIGN KEY (CONTACT_ID) REFERENCES CONTACT (ID) ON DELETE CASCADE
	, CONSTRAINT FK_CONTACT_FRIENDSHIP_2 FOREIGN KEY (CONTACT_ID) REFERENCES CONTACT (ID)
);