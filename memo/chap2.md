# 스프링 웹개발 기초
 - 정적컨텐츠
 - MVC와 템플릿엔진
 - API

## 정적 컨텐츠
 - 스프링 부트 정적 컨텐츠 기능
 - https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/html/spring-boot-features.html#boot-features-spring-mvc-static-content
 - 내장 톰캣서버 -> 스프링컨테이너 내의 컨트롤러를 찾고 없으면 resources: static/요청받은 정책컨텐츠 파일을 찾아온다. 
   > ex) localhost:8080/hello-static.html 
   > -> 컨트롤러 검색.(없음) 
   > -> resources: static/hello-spring.html

## MVC와 템플릿 엔진
 - MVC: model, view, controller
   ```
   웹브라우저 (localhost:8080/hello-mvc) 
   -> 내장 톰캣 서버
   -> 스프링 컨테이너
      -> Contoller 
         return: hello-template
         model: (name: 계두식) 
      -> viewResolver
         template/hello-template.html(tymeleaf 템플릿 엔진 처리) 
   -> HTML(변환후)

   ```

## API
 **@ResponseBody 사용원리**
 - @ResponseBody를 사용
    - http의 Body에 문자내용을 직접반환
    - `viewResolver` 대신 `HttpMessageConverter`가 동작
    - 기본문자 처리: `StringHttpMessageConverter`
    - 기본객체 처리: `MappingJackson2HttpMessageConverter`
    - byte 처리등등 기타 여러 HttpMessageConverter가 기본으로 등록되어 있음
    
> 참고: 클라이언트의 HTTP Accept 헤더와 서버의 컨트롤러반환 타입정보 둘을 조합해서 
> `HttpMessageConverter` 가 선택된다.
