package ktn.chat.data;

import java.io.File;

import javax.swing.GroupLayout.Group;

import ktn.chat.models.User;
import ktn.chat.repositories.Repository;

public class DataStorage {
    private static DataStorage storage = null;
    public Repository<User> userRepository;
    public Repository<Group> groupRepository;
    public Repository<File> fileRepository;

    public static DataStorage createStorage() {
        if (storage == null) {
            storage = new DataStorage();
        }
        return storage;
    }
}
