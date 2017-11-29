package be.ae.googleclouddemo.smeagol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gcp.pubsub.core.PubSubOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.gcp.pubsub.outbound.PubSubMessageHandler;
import org.springframework.messaging.MessageHandler;

@SpringBootApplication
public class SmeagolApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmeagolApplication.class, args);
	}

	@Bean
	@ServiceActivator(inputChannel = "messageOutputChannel")
	public MessageHandler messageSender(PubSubOperations pubsubTemplate) {
		return new PubSubMessageHandler(pubsubTemplate, "message-bus");
	}


	@MessagingGateway(defaultRequestChannel = "messageOutputChannel")
	public interface MessageOutboundGateway {
		void sendToPubsub(String text);
	}
}
