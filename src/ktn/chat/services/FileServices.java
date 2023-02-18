package ktn.chat.services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import ktn.chat.data.DataStorage;
import ktn.chat.enums.FileType;

public class FileServices {
	private DataStorage dataStorage;
	private static String path;

	static {
		path = "FileData";
	}

	public FileServices() {
		dataStorage = DataStorage.getDataStorage();
		createFolder();
	}

	public boolean createFolder() {
		File folder = new File(FileServices.path);
		
		if (!folder.exists()) {
			return folder.mkdirs();
		}
		
		return false;
	}

	public ktn.chat.models.File createFile(String fileName, FileType fileType) {
		ktn.chat.models.File file = new ktn.chat.models.File(fileName, fileType);
		
		dataStorage.getFileRepository().insert(file);		
		createSaveFile(file);
		
		return file;
	}
	
	public void createSaveFile(ktn.chat.models.File file) throws IOException {
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter(path + "\\" + file.getFilename());
			bw = new BufferedWriter(fw);

			bw.write(file.toString());
			bw.newLine();

			bw.flush();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				fw.close();
				bw.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public boolean removeSavedFile(String fileName) {
		File file = new File(path + "\\" + fileName);
		
		try {
			return file.delete();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean removeFile(ktn.chat.models.File file) {
		boolean fileRemove = removeSavedFile(file.getFilename());

		if (file != null && fileRemove) {
			dataStorage.getFileRepository().delete(file);;
			return true;
		}
		
		return false;
	}

}
