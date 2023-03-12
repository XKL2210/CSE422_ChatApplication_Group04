package ktn.chat.data;

import ktn.chat.repositories.Repository;
import ktn.chat.models.File;
import ktn.chat.models.Group;
import ktn.chat.models.Message;
import ktn.chat.models.User;

public class DataStorage {
	private static DataStorage storage;

	private Repository<User> userRepository;
	private Repository<Group> groupRepository;
	private Repository<File> fileRepository;
	private Repository<Message> messageRepository;

	public DataStorage() {
		userRepository = new Repository<>();
		groupRepository = new Repository<>();
		fileRepository = new Repository<>();
		messageRepository = new Repository<>();
	}

	public static DataStorage getDataStorage() {
		if (storage == null) {
			storage = new DataStorage();
		}
		return storage;
	}

	public static DataStorage getStorage() {
		return storage;
	}

	public Repository<File> getFileRepository() {
		return fileRepository;
	}

	public static void setStorage(DataStorage storage) {
		DataStorage.storage = storage;
	}

	public Repository<Group> getGroupRepository() {
		return groupRepository;
	}

	public Repository<User> getUserRepository() {
		return userRepository;
	}

	public Repository<Message> getMessageRepository() {
		return messageRepository;
	}

	public void setUserRepository(Repository<User> userRepository) {
		this.userRepository = userRepository;
	}

	public void setGroupRepository(Repository<Group> groupRepository) {
		this.groupRepository = groupRepository;
	}

	public void setFileRepository(Repository<File> fileRepository) {
		this.fileRepository = fileRepository;
	}

	public void setMessageRepository(Repository<Message> messageRepository) {
		this.messageRepository = messageRepository;
	}
}
