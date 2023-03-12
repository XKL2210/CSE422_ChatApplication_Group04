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

	public Message(User sender, User receiver, String messageContext, File file, Group receivedGroup) {
		this.sender = sender;
		this.receiver = receiver;
		this.relatedGroup = receivedGroup;
		this.messageContext = messageContext;
		this.files = new ArrayList<>();
		this.time = LocalDateTime.now();
	}

	// Functional Methods
	public RelatedTarget getRelation(User user) {
		boolean isSender = user.getUserName().equals(sender.getUserName());
		boolean isReceiver = user.getUserName().equals(receiver.getUserName());

		if (!isSender && !isReceiver) {
			return RelatedTarget.UNRELATED;
		}

		if (isSender) {
			return RelatedTarget.SENDER;
		}

		return RelatedTarget.RECEIVER;
	}

	// Temporary adding method modify later
	public void addFile(File file) {
		if (!files.contains(file)) {
			files.add(file);
		}

	}

	// Getter
	public User getSender() {
		return sender;
	}

	public User getReceiver() {
		return receiver;
	}

	public Group getRelatedGroup() {
		return relatedGroup;
	}

	public List<File> getFiles() {
		return files;
	}

	public String getMessageContext() {
		return messageContext;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public int getMessageContextLength() {
		return messageContext.split(" ").length;
	}

	// Setter
	public void setSender(User sender) {
		this.sender = sender;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public void setMessageContext(String messageContext) {
		this.messageContext = messageContext;
	}

}
