package ktn.chat.data;

import java.io.File;

import javax.swing.GroupLayout.Group;

import ktn.chat.models.User;
import ktn.chat.repositories.Repository;

public class DataStorage {
	private static DataStorage storage;

    public Repository<User> userRepository;
    private Repository<Group> groupRepository;
    private Repository<File> fileRepository;

    public DataStorage() {
        userRepository = new Repository<>();
        groupRepository = new Repository<>();
        fileRepository = new Repository<>();
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

    public void setUserRepository(Repository<User> userRepository) {
        this.userRepository = userRepository;
    }

    public void setGroupRepository(Repository<Group> groupRepository) {
        this.groupRepository = groupRepository;
    }

    public void setFileRepository(Repository<File> fileRepository) {
        this.fileRepository = fileRepository;
    }
}
