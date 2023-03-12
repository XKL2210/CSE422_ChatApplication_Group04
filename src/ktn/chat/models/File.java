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
	}

	// Getter
	public String getId() {
		return id;
	}

	public String getFilename() {
		return fileName;
	}

	public FileType getFileType() {
		return fileType;
	}

	public String getExtension() {
		return extension;
	}

	// Setter
	private void setId() {
		this.id = UUID.randomUUID().toString();
	}

	public void setFilename(String filename) {
		this.fileName = filename;
	}

	public void setFileType(FileType fileType) {
		this.fileType = fileType;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}
}
