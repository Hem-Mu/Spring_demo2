package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;
    //인터페이스에만 의존하게 생성
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); //추상, 구체 인터페이스 두 가지 모두 의존함 -> DIP 위반
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); //고정할인을 정률 할인으로 변경하려면 현재 클래스 코드도 바꿔야함 -> OCP 위반


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        //인자값 4개 리턴

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
