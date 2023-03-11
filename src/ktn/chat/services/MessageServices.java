package ktn.chat.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.sound.midi.Receiver;

import ktn.chat.data.DataStorage;
import ktn.chat.enums.RelatedTarget;
import ktn.chat.enums.Role;
import ktn.chat.models.File;
import ktn.chat.models.Group;
import ktn.chat.models.Message;
import ktn.chat.models.User;

public class MessageServices {
	private DataStorage dataStorage;

    public MessageServices() {
        dataStorage = DataStorage.getDataStorage();
    }
    
    public List<Message> getLatestMessages(List<Message> messages, int numMessages) {
        return messages.stream()
            .sorted(Comparator.comparing(Message::getTime).reversed())
            .limit(numMessages)
            .collect(Collectors.toList());
    }
    
    public void deleteMessage(Message message) {
    	dataStorage.getMessageRepository().delete(message);
    }
    
    public List <File> getAllFiles(Group group) {
        List<Message> messages = new ArrayList<>();
        List<File> files = new ArrayList<>();
        messages = (List<Message>) dataStorage.getMessageRepository();
        
        for (Message message : messages) {
            if (message.getGroup().getId() == group.getId()) {
                files.addAll(message.getFiles());
            }
        }
        return files;
    }
    
    public List<Message> deleteMessagesUser(User user, int numbers) {
    	List<Message> messages = new ArrayList<>();
        List<Message> relatedMessages = new ArrayList<>();
        List<Message> resultMessage = new ArrayList<>();
        messages = (List<Message>) dataStorage.getMessageRepository();
        
        for (Message message : messages) {
            if (message.getRelation(user).equals(user)) {
            	relatedMessages.add(message);
            }
        }
        resultMessage = getLatestMessages(messages, numbers);
        return resultMessage;
    }
    
    public List<Message> getMessagesUser(User user, RelatedTarget target) {
    	List<Message> messages = new ArrayList<>();
        List<Message> relatedMessages = new ArrayList<>();
        messages = (List<Message>) dataStorage.getMessageRepository();
        
        for (Message message : messages) {
            if (message.getRelation(user).equals(target)) {
            	relatedMessages.add(message);
            }
        }
        return relatedMessages;
    }
    
    public List<Message> getMessagesGroup(Group group) {
    	List<Message> messages = new ArrayList<>();
        List<Message> relatedMessages = new ArrayList<>();
        messages = (List<Message>) dataStorage.getMessageRepository();
        
        for (Message message : messages) {
            if (message.getGroup().getId().equals(group.getId())) {
            	relatedMessages.add(message);
            }
        }
        return relatedMessages;
    }
    
    public List<Group> GetGroupsOfUser(User user, Role role) {
    	List<Group> relatedGroups = new ArrayList<>();
    	for(Group group : (List<Group>) dataStorage.getGroupRepository()) {
    		if(group.getRole(user) == role) {
    			relatedGroups.add(group);
    		}
    	}
    	return relatedGroups;
    }
}
