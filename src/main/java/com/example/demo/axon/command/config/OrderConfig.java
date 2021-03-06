package com.example.demo.axon.command.config;

import org.axonframework.commandhandling.model.Repository;
import org.axonframework.eventsourcing.AggregateFactory;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.spring.eventsourcing.SpringPrototypeAggregateFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.demo.axon.command.aggregates.OrderAggregate;

/**
 * Created by Edison Xu on 2017/3/14.
 */
@Configuration
public class OrderConfig {

    @Autowired
    private EventStore eventStore;

    @Bean
    @Scope("prototype")
    public OrderAggregate orderAggregate(){
        return new OrderAggregate();
    }

    @Bean
    public AggregateFactory<OrderAggregate> orderAggregateAggregateFactory(){
        SpringPrototypeAggregateFactory<OrderAggregate> aggregateFactory = new SpringPrototypeAggregateFactory<>();
        aggregateFactory.setPrototypeBeanName("orderAggregate");
        return aggregateFactory;
    }

    @Bean
    public Repository<OrderAggregate> orderAggregateRepository(){
        EventSourcingRepository<OrderAggregate> repository = new EventSourcingRepository<OrderAggregate>(
                orderAggregateAggregateFactory(),
                eventStore
        );
        return repository;
    }
}
