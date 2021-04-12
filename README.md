#### Spring AOP
+ 언제 사용되는가?
  + 성능 검사
  + 트랜잭션 처리
  + 로깅
  + 예외 반환
  + 검증

```
실 예로, @Transactional, @Cache같은 애노테이션들은 AOP를 활용하여 동작하게 된다.
```

+ 구성요소
    + JoinPoint: 모듈의 기능이 삽입되어 동작할 수 있는 실행 가능한 특정 위치
    + PointCut: 어떤 클래스의 어느 JoinPoint를 사용할 것인지를 결정
    + Advice: 각 JoinPoint에 삽입되어져 동작할 수 있는 코드
    + Interceptor: InterceptorChain 방식의 AOP 툴에서 사용하는 용어로 주로 한개의 호출 메소드를 가지는 Advice
    + Weaving: PointCut에 의해서 결정된 JoinPoint에 지정된 Advice를 삽입하는 과정(CrossCutting)
    + Introduction: 정적인 방식의 AOP 기술
    + Aspect: PointCut + Advice + (Introduction)

+ Advice 종류
  + Before : join point가 실행되기 이전 시점에 실행되는 advice. Exception을 던지지 않는 이상에야 join point의 실행을 막을 수는 없음
  + After returning : join point가 완료되고 리턴한 다음에 실행되는 advice
  + After throwing : join point가 Exception을 던지며 종료된 다음에 실행되는 advice
  + After : join point가 정상적으로 종료된 여부에 관계 없이 항상 실행되는 advice
  + Around : method 호출처럼 join point를 둘러싸는 advice. 가장 강력한 종류의 advice로 method의 호출의 이전과 이후에 특정한 행동을 수행하도록 하는 것도 가능. join point를 실행할 것인가 아니면 자체적인 값을 리턴하거나 Exception을 던져서 생략할 것인가 결정할 수도 있음

+ Dependency
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
  ```
+ Gradle
```
compile('org.springframework.boot:spring-boot-starter-web')
compile('org.springframework.boot:spring-boot-starter-test')
compile('org.springframework.boot:spring-boot-starter-aop')

```

+ PointCut && JoinPoints
  | Pointcut | JoinPoints |
  | ----- | ----- |
  | execution(public * *(..)) | public 메소드 실행 |
  | execution(* set*(..)) | 이름이 set으로 시작하는 모든 메소드명 실행 |
  | execution(* get*(..)) | 이름이 get으로 시작하는 모든 메소드명 실행 |
  | execution(* com.jsh.service.TestAopService.*(..)) | TestAopService 인터페이스의 모든 메소드 실행 |
  | execution(* com.jsh.service.*.*(..)) | service 패키지의 모든 메소드 실행 | 
  | execution(* com.jsh.service..*.*(..)) | service 패키지와 하위 패키지의 모든 메소드 실행 | 
  | within(com.jsh.service.*) | service 패키지 내의 모든 결합점 (클래스 포함) | 
  | within(com.jsh.service..*) | service 패키지 및 하위 패키지의 모든 결합점 (클래스 포함) |
  | bean(*JSHRepository) | 이름이 “JSHRepository”로 끝나는 모든 빈 | 
  | bean(*) | 모든 빈 | 
  | bean(jsh*) | 이름이 'jsh'로 시작되는 모든 빈 |
  
