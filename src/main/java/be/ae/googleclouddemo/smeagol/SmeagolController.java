package be.ae.googleclouddemo.smeagol;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import be.ae.googleclouddemo.smeagol.quote.QuoteService;
import be.ae.googleclouddemo.smeagol.quote.SmeagolQuote;

@Controller
public class SmeagolController {

	private QuoteService service;

	public SmeagolController(QuoteService service) {
		this.service = service;
	}

	@GetMapping("quote")
	@ResponseBody
	public SmeagolQuote greeting() {
		return service.randomQuote();
	}
}
