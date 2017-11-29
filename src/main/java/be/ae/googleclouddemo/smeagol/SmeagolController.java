package be.ae.googleclouddemo.smeagol;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import be.ae.googleclouddemo.smeagol.quote.QuoteService;

@Controller
public class SmeagolController {

	private final QuoteService service;

	public SmeagolController(QuoteService service) {
		this.service = service;
	}

	@GetMapping
	@ResponseBody
	public String greeting() {
		return service.randomQuote();
	}
}
