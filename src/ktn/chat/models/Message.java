package ktn.chat.models;

import java.time.LocalDateTime;
import java.util.Comparator;

import ktn.chat.enums.RelatedTarget;

public class Message {
	private User sender;
	private User receiver;
	private String messageContext;
	private File file;
	private LocalDateTime time;
	
	public Message (User sender, User receiver, String messageContext, File file) {
		this.sender = sender;
		this.receiver = receiver;
		this.messageContext = messageContext;
		this.file = file;
		this.time = LocalDateTime.now();
	}
	//Getter
	public RelatedTarget getRelation(Object unidentifiedEntity) {
        boolean isSender = unidentifiedEntity.equals(sender);
        boolean isReceiver = unidentifiedEntity.equals(receiver);

        if (!isSender && !isReceiver) {
            return RelatedTarget.Unrelated;
        }

        if (isSender) {
            return RelatedTarget.Sender;
        }

        return RelatedTarget.Receiver;
    }
    
    public boolean isRelatedTo(Object unidentifiedEntity) {
        if (this.getRelation(unidentifiedEntity) == RelatedTarget.Unrelated) {
            return false;
        }

        return true;
    }
    
	public User getSender() {
        return sender;
    }
	
	public User getReceiver() {
		return receiver;
	}
	
	public File getFile() {
		return file;
	}
	
	public String getMessage() {
		return messageContext;
	}
	
	public LocalDateTime getTime() {
		return time;
	}
	//Setter
	public void setSender(User sender) {
        this.sender = sender;
    }
	
	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}
	
	public void getFile(File file) {
		this.file = file;
	}
	
	public void getMessage(String message) {
		this.messageContext = message;
	}
}
