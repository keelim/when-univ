# Database_practice

# prepare
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
```
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

```
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
```
DELETE FROM TABLE WHERE 조건=조건식
SELECT *FROM[HumanResources].[Department] WHERE [Department ID] = 19
```
    - 필요 없는 데이터는 없다. 
    - 삭제의 경우에도 삭제를 하지 않는 것
    - WHERE 은 항상 붙어 있어야 한다.

> SELECT FROM
```
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

```
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
```
SELECT * FROM TABLE WHERE FIELD IN (조건1, 조건2....)
SELECT * FROM [Sales].[Store] WHERE [SalesPersonID]=277 OR [Sales PersonID]=281 OR [SalesPersonID]=283 OR [SalesPersonID] = 290
```

## 2019 08 14
> 형변환과 중복 제거

```
CONVERT(x1, x2, [x3])
SELECT CONVERT(VARCHAR(10), GETDATE()) AS CV01, CONVERT(VARCHAR(10)M GETDATE(), 23) AS CV02
SELECT [City] FROM [Person].[Address]

SELECT DISTINCT ([City]) AS DISTINCT_TEST FROM [Person].[Address]
```

> 그룹화
```
SELECT DISTINCT([Gender]) AS DC01 FROM [HumanResources].[Employee]
SELECT [Gender] FROM [HumanResources].[Employee] GROUP BY [Gender]
SELECT DISTINCT([Gender]) AS DC01, COUNT([Gender]) AS COUNTER01 FROM [HumanResources].[Employee]
SELECT [Gender],COUNT([Gender]) AS COUNTER01 FROM [HumanResources].[Emploee] GROUP BY [Gender]

```

> 집계 함수
```
STDEV, AVG, VAR, COUNT, SUM
SELECT MAX([Subtotal]) AS S_MAX, MIN([SubTotal]) AS S_MIN, STDEV([SubTotalS]) AS S_STDEV, AVG([SubTotal]) AS S_AVG FROM[Purchasing].[PurchaseOrderHeader]
```

## 2019 08 15
관계형 데이터베이스의 핵심

> IN-LINE VIEW and SUBQUERY
    
    - VIEW 물리적 공간을 차지하지 않는 가상의 테이블
    - view 수정 시 원본데이터도 영향을 받는다.
    
```
    SELECT * FROM TABLE_A
    SELECT * FROM(SELECT FIELD1, FIELD2 FROM TABLE_A) AS TEMP_T
    SELECT * FROM (SELECT[Color], COUNT([Color], AVG([ListPrice], SUM([ListPrice]) FROM [Production].[Product] GROUP BY ([Color]) 
    WHERE COUNT_c>10
    SELECT * FROM [HumanResources].[EmployeeDepartmentHistory] WHERE [DepartmentID] IN (SELECT [DepatmentIF] FROM [HumanResources].[Department] WHERE [GroupName]='Sales and Marketing'


```
> CROSS AND UNION
>
    - CROSS JOIN 
    - 모드 데이터들의 순서싸응로 결과를 나타내는 복합 query
    - CROSS UNION 
    - 두 테이블의 데이터를 하나로 합쳐 결과를 출력 복합 QUERY
    - 필드의 개수 동일
```
SELECT * FROM TABLE01 CROSS JOIN TABLE 02
SELECT * FROM FIELD01, FIELD02 FROM TABLE1 UNION SELECT FIELD1, FIELD2 FROM TABLE2
SELECT [BusinessEnityID].[LoginID] FROM [HumanResources].[Emplpoyee] UNION SELECT [DepartmentID].[Name] FROM [HumanResources].[Deparment]
```
> OUTER-JOIN

    - 서로 연결되는 복수 테이블 간의 키값
    - JOIN 은 반드시 조건이 명시되어야 한다.

```
SELECT * FROM TABLE 1 AS 별칭1 [LEFT OR RIGHT] OUTER JOIN TABLE2 AS 별칭2
SELECT * FROM TABLE1 AS T1 [LEFT OR RIGHT, FULL] OUTER JOIN TABLE2 AS T2 ON 조건식
SELECT * FROM TABLE AS 별칭1 INNER JOIN TABLE2 AS 별칭2 ON 조건식

```

## 2019 08 18 
> INNER JOIN

```
SELECT * FROM TABLE1 AS 별칭1 INNER JOIN TABLE2 AS 별칭2 ON 조건식
SELECT [ProductID], [Description] FROM [Production].[Product] INNER JOIN [Prdocuction].[ProductDescription] ON [ProductID]=[ProductDescription]D
SELECT * FROM TABLE1 AS 별칭1, TABLE2 AS 별칭2 WHERE 조건식
``` 
    - JOIN의 테이블 수 확인
    - 출력 필드 확인, 해당 필드의 SELECT 를 학인을 해볼 것
    - 각각의 테이블에서 완성된 최종 쿼리를 키 값에 따라 JOIN 하여 최종 쿼리 완성
    
> INSERT
    
```
SELECT * FROM INTO COPY_TABLE FROM BASIC_TABLE
INSERT INTO  TABLE1 SELECT* FROM TABLE2
```
    - 데이터를 보관을 할 수 있게 한다.
    - 특정 테이블에 저장된 데이터를 한번에 입력하는 방법 


## database class 2019 09 02
> 12월 데이터베이스 역량 자격증

    - pass, sqld
    - java, 네트워크, 보안 

> mid, final, quiz

    - 실습, 프로젝트
    
> 데이터베이스 시스템   

    - 컴퓨터를 사용하여 정보를 수집하고 분석,  데이터베이스 기술이 활용
    - 정보, 데이터는 서로 다름
    - 데이터베이스는 조직체의 응용시스템들이 공유해서 사용하는 운영데이터들이 구조적 통합된 모임.
       - 파일 files collections of record 레코드를 묶어놓은 것이 파일 
       - 레코드는 collection of data // field
       - 하나를 data item 이라 하고 record 라고 한다.
   
> DB 

    - collections of interrelative file 
    - realworld || coputer
        - 구조를 정리해서 정리하고자 싶다. 
     -  enitity 하나하나를 operation 개념이 없는 것을 --> 행동이 없는 것
     - entity --> 실제 세계에서 쓰는 말
     - record 는 entitty를 컴퓨터 상으로 만드는 것
     - entity 정보를 구별가능한 관심의 대상
     - entity type == record type
     - entity set == file
     - 레코드는 엔터티를 컴퓨터로 표현하는 것이다. --> 데이터의 집합
     - 파일의 모임은 데이터베이스 --> 파일과 파일과는 관계가 있을 수 있다. 
     - 둘 사이에는 관계가 있을 수 있다. --> 관계성을 전부 표현해야 한다. 
     
> 예시

    - 대학에서는 데이터베이스에 학생들에 관하여 신상 정보, 수강 과목, 성적 등을 기록
    - 각 학과에 개설되어 있는 과목들에 관한 정보를 유지하고, 교수에 관해서 신상정보, 담당 과목, 급여 정보를 유지
    - 항공기 예약 시스템에서는 여행사를 통해 항공기 좌석을 예약하면 모든 예약 정보가 데이터베이스에 기록된다. 
    - 스마트폰, TV, 방문자 데이터베이스, 교환기, --> 데이터베이스 응용프로그램
    - 데이터베이스의 기본을 다지는 것은 중요하다.
    - all as factor of life --> 서비스와 연결을 해주어야 한다.
    - 모바일 데이터베이스, 서버 데이터베이스

> File processing
    
    - 프로그램 + 데이터 
    - 데이터가 중복이 될 수 있다. --> 학생 학번들이 중복이 될 수 있다. 
    - 파일은 구조가 바뀔 수 있다.  --> 수시로 바뀔 수 있다. 
    - 파일을 받아서 프로그램을 처리해야 한다. --> maintenace가 많이 필요하다.
    - 확장 보안이 되지 않는다.  
    - program is dependant on data --> data dependency (데이터 의존성)
    - --> 데이터베이스 
    
> DB 

    - 파일을 구조화해서 통합을 한 것, 파일을 최적으로 구조화한 공유하는 집합
    - DB 도 구조가 바뀔 수 있다. 하지만 프로그램 영향이 없기 위해서는 middle ware
    - middle ware 가 서로 간 독립성을 유지하면서  보안 확장 가능
    - 프로그램 DBMS // DBMS -->DB
    - 레이어드 아키텍처
    - data independance, 데이터 인디펜던스를 제공하기 위해서 만들어졌다. 

> 단점

    - 구조화 하는 특징하는 모델
    - DBMS, 하드웨어, 그에 따른 언어
    - 어떠한 아키텍처를 유지를 하여야 하는가? 
    - 파일 프로세싱
        - 무결성
        - 동시 사용자
    - 통계청, 은행, 항공기 운영 --> IBM 50%
    - 파일 프로세싱을 보완하기 위해서 특히, 데이터 의존성을 벗어나기 위해서

> PC

    - 스티브 잡스
    - IBM --> super computer operator system
    - 범용성을 제공 전략 --> IBM
    - 라이센스 비즈니스 
    - venture  --> 생태계 조성, 전략 DBMS
    - IBM --> microsoft
    - os required
    - all category use database 
    - cloud

## 2019 10 11
> 
    데이터베이스 설계
    정규화 -> 가지 치기 > 필요 없는 것들을 가지 치기


## 2019 11 19
> 
    프로젝트 구조 정의
    erd 수정
    데이터베이스 만들 것
    
## 2019 11 22
0, 학부 
1, 대학원 
2, 교직원

## 2019 12 05
 
> 
    도서 대출 요청을 어떻게 해야 하는가?
    학부, 대학원 교직원 의 값을 받고 구분해서 넘겨야 하는데 