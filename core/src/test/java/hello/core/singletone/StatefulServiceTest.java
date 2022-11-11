package hello.core.singletone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = annotationConfigApplicationContext.getBean(StatefulService.class);
        StatefulService statefulService2 = annotationConfigApplicationContext.getBean(StatefulService.class);

        //ThreadA : A사용자가 10000주문
        int UserAprice = statefulService1.order("userA",10000);
        //ThreadB : B사용자가 20000주문
        int UserBprice = statefulService2.order("userB",20000);

        //ThreadA : A사용자 주문 금액 조회
//        int price = statefulService1.getPrice();
        System.out.println("price = " + UserAprice);

//        org.assertj.core.api.Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig{

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}