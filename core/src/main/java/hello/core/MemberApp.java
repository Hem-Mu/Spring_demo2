package hello.core;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberServerImpl;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
            //기존 자바코드

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
                //스프링은 ApplicationContext로 시작함.
                // 파라미터로 Bean이 등록된 클래스를 넣어주면됨
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        // 꺼낼메소드, 클래스 기입

        //MemberService memberService = new MemberServerImpl();
        Member member = new Member(1L, "MemberA", Grade.VIP);
        memberService.join(member);

        Member findmember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findmember.getName());
    }
}
