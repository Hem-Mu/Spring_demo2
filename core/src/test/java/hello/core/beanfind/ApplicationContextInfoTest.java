package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext applicationContextInfoTest = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력")
    void findAllBean(){
        String[] beanDefinitionNames = applicationContextInfoTest.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = applicationContextInfoTest.getBean(beanDefinitionName);
            System.out.println("beanDefinitionName = " + beanDefinitionName+"object = "+bean);
        } // 모든 빈 출력
    }

    @Test
    @DisplayName("애플리케이션 빈 출력")
    void findAppBean(){
        String[] beanDefinitionNames = applicationContextInfoTest.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = applicationContextInfoTest.getBeanDefinition(beanDefinitionName);

            // ROLE_APPLICATION : 직접 등록한 애플리케이션 빈.
            // ROLE_INFRASTRUCTURE : 스프링 내부에서 사용하는 빈.
            if(beanDefinition.getRole()==BeanDefinition.ROLE_APPLICATION) {
                Object bean = applicationContextInfoTest.getBean(beanDefinitionName);
                System.out.println("AppName = " + beanDefinitionName+"object = "+bean);
            }
        } // 애플리케이션 빈 출력
    }
}
