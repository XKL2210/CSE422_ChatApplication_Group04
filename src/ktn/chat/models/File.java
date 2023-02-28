package ktn.chat.models;

import java.util.UUID;

import ktn.chat.enums.FileType;

public class File {
	private String id;
	private String fileName;
	private FileType fileType;
	private String extension;

	public File(String id, String filename, FileType fileType) {
		this.id = id;
		this.fileName = filename;
		this.fileType = fileType;
		extension = filename.substring(filename.lastIndexOf(".") + 1);
		setId();
	}
	//Functional methods
	public void generateID() {
		this.id = UUID.randomUUID().toString();
	}
	//Getter
	public String getId() {
		return id;
	}

	private void setId() {
		this.id = UUID.randomUUID().toString();
	}

	public String getFilename() {
		return fileName;
	}
	//Setter
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
