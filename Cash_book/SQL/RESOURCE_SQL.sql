-- TABLE 생성 : MEMBER
CREATE TABLE MEMBER(
    PHONE               VARCHAR2(11),
    NAME                VARCHAR2(10)    NOT NULL,
    PW                  VARCHAR2(15)    NOT NULL,
    
    CONSTRAINT MEMBER_PK PRIMARY KEY(PHONE)
);
DESC MEMBER;


-- TABLE 생성 : DATE_LIST
CREATE TABLE DATE_LIST(
    PHONE               VARCHAR2(11)    NOT NULL,
    LOCAL_DATE          VARCHAR2(8)     NOT NULL,
    
    CONSTRAINT DATE_LIST_FK FOREIGN KEY(PHONE) 
                             REFERENCES MEMBER(PHONE),
    CONSTRAINT DATE_LIST_PK PRIMARY KEY(LOCAL_DATE, PHONE)
);
DESC DATE_LIST;


-- TABLE 생성 : INCOME
CREATE TABLE INCOME(
    INCOME_PHONE        VARCHAR2(11),
    INCOME_LOCAL_DATE   VARCHAR2(8),
    INCOME_INDEX        NUMBER(4),
    INCOME_NAME         VARCHAR2(50)    NOT NULL,
    INCOME_AMOUNT       NUMBER(11)      NOT NULL,
    INCOME_MEMO         VARCHAR2(100),
    
    CONSTRAINT INCOME_FK FOREIGN KEY(INCOME_PHONE, INCOME_LOCAL_DATE) 
                          REFERENCES DATE_LIST(PHONE, LOCAL_DATE),
    CONSTRAINT INCOME_PK PRIMARY KEY(INCOME_PHONE, INCOME_LOCAL_DATE, INCOME_INDEX)
);
DESC INCOME;


-- TABLE 생성 : OUTCOME
CREATE TABLE OUTCOME(
    OUTCOME_PHONE       VARCHAR2(11),
    OUTCOME_LOCAL_DATE  VARCHAR2(8),
    OUTCOME_INDEX       NUMBER(4),
    OUTCOME_NAME        VARCHAR2(50)    NOT NULL,
    OUTCOME_AMOUNT      NUMBER(11)      NOT NULL,
    OUTCOME_MEMO        VARCHAR2(100),
    
    CONSTRAINT OUTCOME_FK FOREIGN KEY(OUTCOME_PHONE, OUTCOME_LOCAL_DATE)
                           REFERENCES DATE_LIST(PHONE, LOCAL_DATE),
    CONSTRAINT OUTCOME_PK PRIMARY KEY(OUTCOME_PHONE, OUTCOME_LOCAL_DATE, OUTCOME_INDEX)
);
DESC OUTCOME;


-- TEST - DROP TABLE
DROP TABLE MEMBER;
DROP TABLE DATE_LIST;
DROP TABLE INCOME;
DROP TABLE OUTCOME;


-- TEST - INSERT
INSERT INTO MEMBER(NAME, 
                   PHONE, 
                   PW)
            VALUES('CHOCOBE', 
                   '01095513439', 
                   'COFFEE'
);
     
INSERT INTO DATE_LIST(PHONE, 
                      LOCAL_DATE)
               VALUES('01095513439',
                      '20191005'
);
     
INSERT INTO INCOME(INCOME_PHONE, 
                   INCOME_LOCAL_DATE, 
                   INCOME_INDEX, 
                   INCOME_NAME, 
                   INCOME_AMOUNT, 
                   INCOME_MEMO)
            VALUES('01095513439',
                   '20191005',
                   1, 
                   '월급', 
                   6000, 
                   'US 딸라');
                   
                   
INSERT INTO OUTCOME(OUTCOME_PHONE,
                    OUTCOME_LOCAL_DATE,
                    OUTCOME_INDEX,
                    OUTCOME_NAME,
                    OUTCOME_AMOUNT,
                    OUTCOME_MEMO)
             VALUES('01095513439',
                    '20191005',
                    1,
                    '간식',
                    50000,
                    '스테이크는 레어');


-- TEST - SELECT
SELECT * FROM MEMBER;
SELECT * FROM DATE_LIST;
SELECT * FROM INCOME;
SELECT * FROM OUTCOME;


-- TEST - DELETE
DELETE FROM INCOME 
      WHERE INCOME_PHONE = '01095513439'
        AND INCOME_LOCAL_DATE = '20191005'
        AND INCOME_INDEX = 1;
        
DELETE FROM OUTCOME
      WHERE OUTCOME_PHONE = '01095513439'
        AND OUTCOME_LOCAL_DATE = '20191005'
        AND OUTCOME_INDEX = 1;
        
DELETE FROM DATE_LIST
      WHERE PHONE = '01095513439'
        AND LOCAL_DATE = '20191005';
        
DELETE FROM MEMBER
      WHERE PHONE = '01095513439';