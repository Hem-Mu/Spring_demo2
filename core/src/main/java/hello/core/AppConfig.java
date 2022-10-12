package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServerImpl;
import hello.core.member.MemberService;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //설정정보를 -> @Bean
public class AppConfig {
    @Bean //스프링컨테이너에 등록
        // 빈 이름은 항상 다르게 지정
    public MemberService memberService(){
        return new MemberServerImpl(memberRepository());
    }

    @Bean
    public static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    } //ctrl+alt+m 구체화

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}//클래스를 인자로 넣어주자
