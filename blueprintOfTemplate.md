구조 제안
==============
>루트
>>domain 도메인(모델)   
>>>DAO,DTO,VO(인터페이스, DAO 추상 메소드 협의 필요)   
>>>각자 서비스에 필요한 패키지
>>>>DAO, DTO, VO 상속 (구현은 알아서, 매퍼파일(xml)도 좋고 impl 자바클래스도 좋고 => impl경우 중간 매개체 abstract 클래스 생성 추천-impl의 구성이 추상메소드들을 전부 나열하지 않아도 되서, 단순해짐)   
>>컨트롤러   
>>서비스   
>테스트 루트


>webapp
>>resources
>>>css
>>>>각자 페이지에 필요한 css 폴더. 알아서...
>>>js
>>>>각자 페이지에 필요한 js 폴더. 알아서...
>>WEB-INF
>>>spring
>>>>root-context (공통 사용 협의필요)
>>>>appServlet
>>>>jdbc
>>>>>jdbc-context.xml
>>>>>사용할 녀석 스프링설정파일
>>>views
>>>>각자 jsp 등의 페이지 폴더. 알아서...
