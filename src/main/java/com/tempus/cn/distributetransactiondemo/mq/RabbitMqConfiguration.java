package com.tempus.cn.distributetransactiondemo.mq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMqConfiguration {

    @Bean
    public MessageConverter messageConverter()
    {
        Jackson2JsonMessageConverter jsc = new Jackson2JsonMessageConverter();
        return jsc;
    }

    @Bean
    public RabbitTemplate getRabbitMqTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        // factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        //当消息有异常内容时（例如类型不匹配），将不再重新放入队列，直接丢弃
        factory.setDefaultRequeueRejected(false);
        factory.setMessageConverter(messageConverter());
        return factory;
    }
}
