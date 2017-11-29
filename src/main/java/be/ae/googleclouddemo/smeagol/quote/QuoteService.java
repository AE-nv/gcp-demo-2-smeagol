package be.ae.googleclouddemo.smeagol.quote;

import java.util.Random;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class QuoteService {

	private final QuoteRepository repository;

	@Value("${spring.cloud.gcp.sql.database-name}")
	private String speaker;

	public QuoteService(QuoteRepository repository) {
		this.repository = repository;
	}

	public String randomQuote(){
		Random random = new Random();
		String quote = repository.findOne(random.nextInt((int)repository.count()) + 1).getText();
		Logger.getGlobal().info(speaker + ": " + quote);
		return quote;
	}
}
