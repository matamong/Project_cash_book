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
    INCOME_NAME         VARCHAR2(50)    NOT NULL,
    INCOME_AMOUNT       NUMBER(11)      NOT NULL,
    INCOME_MEMO         VARCHAR2(100),
    
    CONSTRAINT INCOME_FK FOREIGN KEY(INCOME_PHONE, INCOME_LOCAL_DATE) 
                          REFERENCES DATE_LIST(PHONE, LOCAL_DATE)
);
DESC INCOME;


-- TABLE 생성 : OUTCOME
CREATE TABLE OUTCOME(
    OUTCOME_PHONE       VARCHAR2(11),
    OUTCOME_LOCAL_DATE  VARCHAR2(8),
    OUTCOME_NAME        VARCHAR2(50)    NOT NULL,
    OUTCOME_AMOUNT      NUMBER(11)      NOT NULL,
    OUTCOME_MEMO        VARCHAR2(100),
    
    CONSTRAINT OUTCOME_FK FOREIGN KEY(OUTCOME_PHONE, OUTCOME_LOCAL_DATE)
                           REFERENCES DATE_LIST(PHONE, LOCAL_DATE)
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

INSERT INTO DATE_LIST(PHONE,
                      LOCAL_DATE)
               VALUES('01095513439',
                      '20191016'
);

     
INSERT INTO INCOME(INCOME_PHONE, 
                   INCOME_LOCAL_DATE,  
                   INCOME_NAME, 
                   INCOME_AMOUNT, 
                   INCOME_MEMO)
            VALUES('01095513439',
                   '20191005',
                   '월급', 
                   6000, 
                   'US 딸라');
                   
                   
INSERT INTO OUTCOME(OUTCOME_PHONE,
                    OUTCOME_LOCAL_DATE,
                    OUTCOME_NAME,
                    OUTCOME_AMOUNT,
                    OUTCOME_MEMO)
             VALUES('01095513439',
                    '20191005',
                    '간식',
                    50000,
                    '스테이크는 레어');
                    
INSERT INTO OUTCOME(OUTCOME_PHONE,
                    OUTCOME_LOCAL_DATE,
                    OUTCOME_NAME,
                    OUTCOME_AMOUNT,
                    OUTCOME_MEMO)
             VALUES('01095513439',
                    '20191005',
                    '간식',
                    50000,
                    '스테이크는 레어');                    

INSERT INTO OUTCOME(OUTCOME_PHONE,
                    OUTCOME_LOCAL_DATE,
                    OUTCOME_NAME,
                    OUTCOME_AMOUNT,
                    OUTCOME_MEMO)
             VALUES('01095513439',
                    '20191005',
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
        AND INCOME_LOCAL_DATE = '20191005';
        
DELETE FROM OUTCOME
      WHERE OUTCOME_PHONE = '01095513439'
        AND OUTCOME_LOCAL_DATE = '20191005';
        
DELETE FROM DATE_LIST
      WHERE PHONE = '01095513439'
        AND LOCAL_DATE = '20191005';
        
DELETE FROM MEMBER
      WHERE PHONE = '01095513439';
      
commit;


SELECT * FROM MEMBER WHERE PHONE = '01095513438' AND PW = 'tiger' AND NAME = 'CHOCO';
SELECT * FROM DATE_LIST WHERE PHONE = '01095513438' AND LOCAL_DATE = '20191008';
SELECT * FROM INCOME WHERE INCOME_PHONE = '01095513438' 
                       AND INCOME_MEMO = '테스트_메모_1' 
                       AND INCOME_LOCAL_DATE = '20191008' 
                       AND INCOME_NAME = '테스트_1' 
                       AND INCOME_AMOUNT = 10000;
SELECT * FROM OUTCOME WHERE OUTCOME_PHONE = '01095513438' 
                       AND OUTCOME_NAME = 'outcome테스트_1' 
                       AND OUTCOME_LOCAL_DATE = '20191008' 
                       AND OUTCOME_MEMO = 'outcome테스트_메모_1' 
                       AND OUTCOME_AMOUNT = 5000;