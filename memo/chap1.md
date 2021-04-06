## 라이브러리 살펴보기
> gradle은 의존관계가 있는 라이브러리를 함께 다운로드한다

**스프링 부트 라이브러리**

 - spring-boot-starter-web
    - spring-boot-starter-tomcat:톰캣(웹서버)
    - spring-webmvc: 스프링 웹 MVC
 - spring-boot-starter-thymeleaf:타임리프 템플릿 엔진(View)
 - spring-boot-starter(공통): 공통 + 스프링 부트 + 스프링 코어 + 로깅
    - spring-boot
        - spring-core
    - spring-boot-starter-logging
        - logback, slf4j

**테스트 라이브러리**
 - spring-boot-starter-test
    - junit: 테스트 프레임워크
    - mockito: 목 라이브러리
    - assertj: 테스트 코드를 좀 더 편하게 작성하게 도와주는 라이브러리
    - spring-test: 스프링 통합 테스트 지원
    
## View 환경설정
### Welcom Page
 - 스프링부트가 제공하는 Welcom Page 기능
 - `static/index.html` 을 올려두면 Welcome page 기능을 제공한다
 - https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/html/spring-boot-features.html#boot-features-spring-mvc-welcome-page
```text
Spring Boot supports both static and templated welcome pages. 
It first looks for an index.html file in the configured 
static content locations.
 If one is not found, it then looks for an index template. If either is found, 
 it is automatically used as the welcome page of the application.
```

### thymeleaf 템플릿엔진
 - thymeleaf 공식 사이트: https://www.thymeleaf.org/
 - 스프링 공식 튜토리얼: https://spring.io/guides/gs/serving-web-content/
 - 스프링부트 메뉴얼: https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/html/spring-boot-features.html#boot-features-spring-mvc-template-engines

 - 컨트롤러에서 리턴 값으로 문자를 반환하면 뷰 리졸버(`viewResolver`)가 화면을 찾아서 처리한다.
    - 스프링 부트 템플릿 엔진 기본 viewName 매핑
    - `resources:templates/` + {ViewName} + `.html`
    
> 참고: `spring-boot-devtools` 라이브러리를 추가하면, `html`파일을 컴파일만 해주면 서버 재시작 없이 View 파일 변경이 가능하다
> 인텔리J 컴파일 방법: 메뉴 build -> Recompile

