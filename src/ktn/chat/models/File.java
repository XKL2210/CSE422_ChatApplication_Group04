package ktn.chat.models;

import java.util.UUID;

import models.enums.FileType;

public class File {
	private String id;
	private String fileName;
	private FileType fileType;
	private String sender;
	private String receiver;
	private String extension;

	public File(String filename, FileType fileType, String sender, String receiver) {
		this.fileName = filename;
		this.fileType = fileType;
		this.sender = sender;
		this.receiver = receiver;
		setId();
	}

	public String getId() {
		return id;
	}

	private void setId() {
		this.id = UUID.randomUUID().toString();
	}

	public String getFilename() {
		return fileName;
	}

	public void setFilename(String filename) {
		this.fileName = filename;
	}

	public FileType getFileType() {
		return fileType;
	}

	public void setFileType(FileType fileType) {
		this.fileType = fileType;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}
}
