package examples.serialization;

import java.io.Serializable;

@SuppressWarnings("serial")
public final class Message implements Serializable {

	private final String content;

	public String getContent() {
		return content;
	}

	public Message(String content) {
		this.content = content;
	}
}
