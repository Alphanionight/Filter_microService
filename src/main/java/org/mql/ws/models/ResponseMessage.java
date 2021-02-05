package org.mql.ws.models;

public class ResponseMessage {
	private String message;
	private Object object;
	
	public ResponseMessage() {}
	
	public ResponseMessage(String message, Object object) {
		super();
		this.message = message;
		this.object = object;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getObject() {
		return object;
	}
	
	public void setObject(Object object) {
		this.object = object;
	}
}
