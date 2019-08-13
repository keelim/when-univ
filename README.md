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

    - 문자 or 숫자
    - 정수 및 실수, 날짜 형식

> UPDATE SET 

    - UPDATE
    - 기존의 데이터를 수정을 하는 것
    - SET 이하의 절로 바꾸는 것을 의미

```SQL
UPDATE TABLE1 SET FIELD1=VALUE1, FIELD2=VALUE2
UPDATE TABLE1 SET FIELD1=VALUE1, FIELD2=VALUE2,...WHERE 조건=조건식
``` 
    - WHERE 은 조건을 지정을 해줄 때 사용 됨
    - UPDATE, DELETE WHERE 은 항상 같이 사용을 할 것
    - Select를 통화여 값을 확인

```SQL
UPDATE [HumanResources].[Department] SET [Name] = 'DATA ANALIST' WHERE [Name] = 'DATA SCIENCE'
SELECT *FROM [HumanResources].[Department]
UPDATE [HumanResouces].[Employee] SET [Jobtitle='Asia Sales Manager'] WHERE [BusinessEnityID] = 287
```
    
> PRIMARY KEY
    
    -기본키라고 불리면 고유값으로 산정
    - UPDATE 및 DELETE 에서 유용하게 사용되어 질 수 있음

## 2019 08 09
> DELETE FROM
```SQL
DELETE FROM TABLE WHERE 조건=조건식
SELECT *FROM[HumanResources].[Department] WHERE [Department ID] = 19
```
    - 필요 없는 데이터는 없다. 
    - 삭제의 경우에도 삭제를 하지 않는 것
    - WHERE 은 항상 붙어 있어야 한다.

> SELECT FROM
```SQL
SELECT * FROM TABLE 
SELECT * FROM [Production].[Product]
SELECT [ProductID].[Name].[ProductNumber] FROM [Production].[Product]
SELECT FIELD1, FIELD2 FROM TABLE WHERE 조건=조건식
SELECT * FROM TABLE WHERE 조건=조건식
SELECT * FROM [Production].[Product] WHERE [Name] = 'Chain'
SELECT FIELD1, FIELD2 FROM TABLE WHERE 조건=조건식 ORDER BY FIELD 명 (ASC/DESC)
SELECT * FROM [Sales].[SalesOrderHeader] WHERE [CustomerID] = '11901' ORDER BY [OrderDate] DESC

```

> LIKE

```SQL
SELECT *FROM TABLE WHERE FIELD LIKE  %조건%
```
    - 조건 포함 결과 출력 

## 2019 08 13
> BETWEEN
```sql 
SELECT * FROM[Production].[Product] WHERE [ListPrice] >= 1000 AND [ListPrice]<=3000
SELECT * FROM TABLE WHERE FIELD BETWEEN '조건1' AND '조건2'
SELECT * FROM [Production].[Product] WHERE [ListPrice] BETWEEN 1000 AND 3000
```

> IN
```sql
SELECT * FROM TABLE WHERE FIELD IN (조건1, 조건2....)
SELECT * FROM [Sales].[Store] WHERE [SalesPersonID]=277 OR [Sales PersonID]=281 OR [SalesPersonID]=283 OR [SalesPersonID] = 290
```

## 2019 08 14
> 형변환과 중복 제거
