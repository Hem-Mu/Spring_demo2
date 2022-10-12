package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberServerImpl;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext applicationContextInfoTest = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        MemberService memberService = applicationContextInfoTest.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServerImpl.class);
    }
    @Test
    @DisplayName("이름없이 타입으로 조회")
    void findBeanByType(){
        MemberService memberService = applicationContextInfoTest.getBean(MemberService.class); //메소드 없어도 가능
        assertThat(memberService).isInstanceOf(MemberServerImpl.class);
    }

    @Test
    @DisplayName("구체 이름으로 조회") // 구현에 의존하는 것은 좋지 않음, 역할에 의존하는 것을 추천
    void findBeanByName2(){
        MemberService memberService = applicationContextInfoTest.getBean("memberService", MemberServerImpl.class);
        assertThat(memberService).isInstanceOf(MemberServerImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanNameX(){
        // MemberService xxxx = applicationContextInfoTest.getBean("xxxx", MemberService.class); // 등록된 "xxxx"빈이 없음 -> 오류
        assertThrows(NoSuchBeanDefinitionException.class, () ->
            applicationContextInfoTest.getBean("xxxx", MemberService.class)); // 등록된 빈이 없을 때 성공하는 테스트

    }
}
