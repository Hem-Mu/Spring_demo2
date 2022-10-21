package hello.core.singletone;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {
    @Test
    @DisplayName("스프링 없는 순수 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        MemberService memberService1 = appConfig.memberService(); // 호출 시 객체 생성
        MemberService memberService2 = appConfig.memberService(); // 호출 시 객체 생성

        System.out.println("memberService1 = " + memberService1); //메모리 값이 다름
        System.out.println("memberService2 = " + memberService2); //메모리 값이 다름

        //memberService1 != memberService2
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest(){
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService22 = SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonServic22 = " + singletonService22);

        //singletonService1 == singletonService22
        assertThat(singletonService1).isSameAs(singletonService22);
    }
}
