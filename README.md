# Database_practice

## 2019 07 22
> database 사용

    - input, output
    - input
        - create
        - update
        - delete
    - output
        - read
    - CRUD

> file vs database

    - 파일에 대한 것들을 다루기가 어렵다
    - 스프레드시트 구조 작성
    - file -> spreadsheet (구조적)
    - file -> spreadsheet -> database
    - 프로그램적으로 자동화가 가능
    - 구조적으로 데이터를 저장을 하면 데이터의 가공이 쉽다.
    
> Relational DBMS

    - Oracle
        - 기업, 관공서
    - MySQL
        - 무료, 오픈소스
        - 규모가 적은
        - 신뢰성
        
> MogoDB

    - Document store
    - sns, iot
    - NoSQL

## 2019 07 23
> Relational database

    - mysql
        - web + mysql
    - oracle
    - sql server
    - PostgreSql
    - DB2
    - Access

> 웹사이트의 정보를 데이터베이스에 반영을 할 수 있다. 

## 2019 08 08
> SQL

> INSERT INTO

    - 값을 추가한다.
```SQL
INSERT INTO TABLE(FIELD 1, FIELD2) VALUES (VALUE1, VALUE2)
INSERT INTO [HumanResources].[Department]([Name], [GroupName], [ModifiedDate]) VALUES('DATA SCIENCE', 'Research and Development', '2019-09-30')
SELECT* FROM [HumanResources].[Department]
INSERT INTO TABLE(FIELD1, FIELD2, FIELD3) VALUES(VALUE1, VALUE2, VALUE3)
```

## 2019 08 09
> 데이터 형식

> UPDATE SET 

> PRIMARY KEY
