package ktn.chat.models;

import java.util.UUID;

import ktn.chat.enums.FileType;

public class File {
	private String id;
	private String fileName;
	private FileType fileType;
	private String extension;

	public File(String filename, FileType fileType) {
		this.fileName = filename;
		this.fileType = fileType;
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

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}
}
