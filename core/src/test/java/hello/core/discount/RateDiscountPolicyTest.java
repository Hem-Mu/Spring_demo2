package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName(("VIP는 10프로 할인이 적용된다."))
    void vip_O(){
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        //when
        int discount = discountPolicy.discount((member), 10000);
        //then
        assertThat(discount).isEqualTo(1100); //alt+enter 로 static import
    }
    @Test
    @DisplayName("VIP 아니면 할인 미적용")
    void vip_x(){
        //given
        Member member = new Member(2L, "memberBasic", Grade.Basic);
        //when
        int discount = discountPolicy.discount((member), 10000);
        //then
        assertThat(discount).isEqualTo(0);
}}