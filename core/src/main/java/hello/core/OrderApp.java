package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberServerImpl;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) { //psvm

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService(); //AppCoinfig를 참조하도록
        OrderService orderService = appConfig.orderService();

//        MemberService memberService = new MemberServerImpl(null);
//        OrderService orderService = new OrderServiceImpl(null,null);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order.toString()); //soutv
        System.out.println("calPrice = " + order.calculatePrice()); //soutv
    }
}
