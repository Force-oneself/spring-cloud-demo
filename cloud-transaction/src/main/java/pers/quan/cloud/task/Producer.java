package pers.quan.cloud.task;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	public void send(String queue, String msg) {
		this.jmsMessagingTemplate.convertAndSend(new ActiveMQQueue(queue), msg);
	}

}