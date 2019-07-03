CREATE TABLE Account (
	 account_id number,	
	 account_owner varchar(100) ,
	 balance NUMERIC,
	 creation_date timestamp ,
	 CONSTRAINT PK_ACCOUNT PRIMARY KEY (account_id)
);

CREATE SEQUENCE account_seq
  START WITH 100
  INCREMENT BY 1;