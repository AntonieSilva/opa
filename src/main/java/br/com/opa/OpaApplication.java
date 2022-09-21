package br.com.opa;

import javax.annotation.Resource;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class OpaApplication {
	@Resource
    private Environment env;


	public static void main(String[] args) {
		SpringApplication.run(OpaApplication.class, args);
		System.out.println("______Alpha______");
	}
	public ActiveMQConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(env.getRequiredProperty("spring.activemq.broker"));
        connectionFactory.setPassword(env.getRequiredProperty("spring.activemq.user"));
        connectionFactory.setUserName(env.getRequiredProperty("spring.activemq.password"));
        return connectionFactory;
    }
}