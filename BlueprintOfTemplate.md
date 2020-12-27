구조 제안
==============
    
프로그램 소스
--------
>src/main/java/com/(서비스 명)   
>>domain 도메인(모델)   
>>>DAO.java(인터페이스)   
>>>>select(VO vo)   
>>>>insert(VO vo)   
>>>>delete(VO vo)   
>>>>update(VO vo)   
>>>>=>복수 데이터 삽입, 수정은 batch 이용을 적극 추천   
>>>   
>>>DTO.java(깡통인터페이스)   
>>>: 데이터 활용 용도   
>>>   
>>>VO.java(깡통인터페이스)   
>>>: DB로의 데이터 요청용   
>>>샘플 : https://github.com/devchanki/TalmoVim/blob/main/sample_PostVO.java   
>>>깡통 인터페이스를 활용하는 이유 : 다형성, 유지보수 향상   
>>>
>>>AjaxResult.java   
>>>: REST response   
>>>샘플 : https://github.com/devchanki/TalmoVim/blob/main/sample_AjaxResult
>>>
>>>AjaxList.java   
>>>: extends AjaxResult   
>>>복수 데이터 전송 시   
>>>샘플 : https://github.com/devchanki/TalmoVim/blob/main/sample_AjaxList
>>>   
>>>각자 서비스에 필요한 패키지   
>>>>DAO, DTO, VO 상속
>>>> ex) DAO.java(공용) > PostDAO.java > PostDAO.xml (매핑 방식)
>>>>  (구현은 알아서, 매퍼파일(xml)도 좋고 impl 자바클래스도 좋고 => impl경우 중간 매개체 abstract 클래스 생성 추천-impl의 구성이 추상메소드들을 전부 나열하지 않아도 되서, 단순해짐)
>>>> ex) DAO.java(공용) > AbstractDAO.java(공용) > PostDAO.java (자바 구현 방식)
>>>> vo의 경우 type 주는걸 추천! // type : count, one, list, all 등..   
>>>> dto의 경우 당연한거지만, builder 패턴 활용 적극 추천   
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
