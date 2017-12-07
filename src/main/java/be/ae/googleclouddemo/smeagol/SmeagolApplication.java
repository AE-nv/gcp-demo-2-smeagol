package be.ae.googleclouddemo.smeagol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.gcp.pubsub.core.PubSubOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.gcp.pubsub.outbound.PubSubMessageHandler;
import org.springframework.messaging.MessageHandler;

@EnableAutoConfiguration
@SpringBootApplication
public class SmeagolApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SmeagolApplication.class, args);
	}

	@Bean
	@ServiceActivator(inputChannel = "pubsubOutputChannel")
	public MessageHandler messageSender(PubSubOperations pubsubTemplate) {
		return new PubSubMessageHandler(pubsubTemplate, "message-bus");
	}


	@MessagingGateway(defaultRequestChannel = "pubsubOutputChannel")
	public interface MessageOutboundGateway {
		void sendToPubsub(String text);
	}



	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SmeagolApplication.class);
	}
}
