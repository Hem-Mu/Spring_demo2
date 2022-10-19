package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberServerImpl;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) { //psvm

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService(); //AppCoinfig를 참조하도록
//        OrderService orderService = appConfig.orderService();
            //기존 자바코드

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //스프링은 ApplicationContext로 시작함.
        // 파라미터로 Bean이 등록된 클래스를 넣어주면됨
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        // 꺼낼메소드, 클래스 기입

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order = " + order.toString()); //soutv
        System.out.println("calPrice = " + order.calculatePrice()); //soutv
    }
}