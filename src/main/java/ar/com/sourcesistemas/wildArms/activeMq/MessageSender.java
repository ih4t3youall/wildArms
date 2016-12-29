package ar.com.sourcesistemas.wildArms.activeMq;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.sourcesistemas.wildArms.entities.Command;


@Repository
public class MessageSender {
 
 
    private static final String URL = "tcp://localhost:61616";
 
    private static final String USER = "admin";
 
    private static final String PASSWORD = "admin";
 
    private static final String DESTINATION_QUEUE = "brazo_robot";
 
    private static final boolean TRANSACTED_SESSION = true;
    
    
    private ObjectMapper objMapper = new ObjectMapper();

    private ActiveMQConnectionFactory connectionFactory ;
    private Connection connection;
    private Session session; 
    private Destination destination; 
    private MessageProducer producer;
    
    
    public  MessageSender() throws JMSException {
 
        connectionFactory = new ActiveMQConnectionFactory(USER, PASSWORD, URL);
        connection = connectionFactory.createConnection();
        connection.start();
 
        session = connection.createSession(TRANSACTED_SESSION, Session.AUTO_ACKNOWLEDGE);
        destination = session.createQueue(DESTINATION_QUEUE);
 
        producer = session.createProducer(destination);
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        
    }
 
 
    public void sendMessage(Command command) throws JMSException {
    	
        TextMessage textMessage;
		try {
			textMessage = session.createTextMessage(objMapper.writeValueAsString(command));
			producer.send(textMessage);
			session.commit();
		} catch (JsonProcessingException e) {
			System.out.println("volo todo al carajo");
			e.printStackTrace();
		}
        
    }
 
}