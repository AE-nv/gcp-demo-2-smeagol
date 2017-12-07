package be.ae.googleclouddemo.smeagol.quote;

public class SmeagolQuote {
	private final String quote;
	private final String speaker;

	public SmeagolQuote(String quote, String speaker) {
		this.quote = quote;
		this.speaker = speaker;
	}

	public String getQuote() {
		return quote;
	}

	public String getSpeaker() {
		return speaker;
	}
}