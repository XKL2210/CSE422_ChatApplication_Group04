package ktn.chat.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import ktn.chat.enums.RelatedTarget;

public class Message {
	private User sender;
	private User receiver;
	private Group relatedGroup;
	private String messageContext;
	private List<File> files;
	private LocalDateTime time;
	
	public Message (User sender, User receiver, String messageContext, File file, Group receivedGroup) {
		this.sender = sender;
		this.receiver = receiver;
		this.relatedGroup = receivedGroup;
		this.messageContext = messageContext;
		this.files = new ArrayList<>();
		this.time = LocalDateTime.now();
	}
	//Functional Methods
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
    //Temporary adding method modify later
    public void addFile(File file) {
    	if(!files.contains(file)) {
    		files.add(file);
    	}
    	
    }
    //Getter
	public User getSender() {
        return sender;
    }
	
	public User getReceiver() {
		return receiver;
	}
	
	public Group getGroup() {
		return relatedGroup;
	}
	
	public List getFiles() {
		return files;
	}
	
	public String getMessage() {
		return messageContext;
	}
	
	public LocalDateTime getTime() {
		return time;
	}
	
	public int getMessageContextCount() {
		return messageContext.split(" ").length;
	}
	
	//Setter
	public void setSender(User sender) {
        this.sender = sender;
    }
	
	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}
	
	public void setMessage(String message) {
		this.messageContext = message;
	}
	
}
