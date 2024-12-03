package com.pierre.hexagonal.adapters.in.consumer;

import com.pierre.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.pierre.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.pierre.hexagonal.application.core.domain.Customer;
import com.pierre.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @KafkaListener(topics = "tp-cpf-validated",groupId = "hexagonal")
    public void receive(CustomerMessage customerMessage){
        var customer = customerMessageMapper.toCustomer(customerMessage);
        updateCustomerInputPort.update(customer,customerMessage.getZipCode());
    }
}
