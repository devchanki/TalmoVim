구조 제안
==============
    
프로그램 소스
--------
>src/main/java/com/(서비스 명)
>>domain 도메인(모델)   
>>>DAO.java   
>>>>selectList(VO vo)
>>>>select(VO vo)
>>>>insertList(VO vo)
>>>>insert(VO vo)
>>>>deleteList(VO vo)
>>>>delete(VO vo)
>>>>updateList(VO vo)
>>>>update(VO vo)
>>>
>>>DTO.java   
>>>VO.java    
>>>  (인터페이스, DAO 추상 메소드 협의 필요)   
>>>각자 서비스에 필요한 패키지
>>>>DAO, DTO, VO 상속    
>>>>  (구현은 알아서, 매퍼파일(xml)도 좋고 impl 자바클래스도 좋고 => impl경우 중간 매개체 abstract 클래스 생성 추천-impl의 구성이 추상메소드들을 전부 나열하지 않아도 되서, 단순해짐)   
>>
>>controller 컨트롤러   
>>
>>service 서비스   
   
테스트 프로그램 소스   
---------
>src/test/java/com/(서비스 명)
   
   
   
페이지   
---------
>WEB-INF   
>>spring   
>>>>root-context (공통 사용 협의필요)   
>>>>appServlet   
>>>>jdbc   
>>>>>jdbc-context.xml   
>>>>>사용할 디비 관련 스프링설정파일
>>>>>(ex mybatis-context.xml or jpa-context.xml 등..)   
>>>
>>>views   
>>>>각자 jsp 등의 페이지 폴더 구상. 알아서...   
    
페이지 리소스 파일
---------
>webapp/resources   
>>css   
>>>각자 페이지에 필요한 css 폴더 구상. 알아서...    
>>
>>js   
>>>각자 페이지에 필요한 js 폴더 구상. 알아서...   

    
매퍼 파일
--------- 
>src/main/resources/com/(서비스 명)
>>domain
>>>각자 도메인과 동일한 폴더명 및 경로
>>>>DAO 매퍼파일