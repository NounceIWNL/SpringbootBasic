package org.setup.scan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication includes: @Configuration, @ComponentScan
@ComponentScan
public class Application {

    private class ExampleBean {
    }

    @Bean
    public ExampleBean exampleBean() {
        return new ExampleBean();
    }

    private static ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Application.class);

    public static void main(String[] args) {
        //вывести все экземпляры beans
        for (String bean : applicationContext.getBeanDefinitionNames())
            System.out.println(bean);

        applicationContext.getBean(Dog.class);
        applicationContext.getBean(Room.class).sound();

        System.out.println(applicationContext.containsBean("cat"));

    }
} 