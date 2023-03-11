package ktn.chat.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.sound.midi.Receiver;
import javax.swing.text.html.parser.Entity;

import ktn.chat.data.DataStorage;
import ktn.chat.enums.RelatedTarget;
import ktn.chat.enums.Role;
import ktn.chat.models.File;
import ktn.chat.models.Group;
import ktn.chat.models.Message;
import ktn.chat.models.User;

public class MessageServices {
	private DataStorage dataStorage;
	private List<Message> messages;

    public MessageServices() {
        dataStorage = DataStorage.getDataStorage();
        messages = new ArrayList<>();
        messages = (List<Message>) dataStorage.getMessageRepository();
    }
    
    public List<Message> getLatestMessages(List<Message> messages, int K, int M) {
        return messages.stream()
            .sorted(Comparator.comparing(Message::getTime).reversed())
            .limit(messages.size() - M)
            .limit(K)
            .collect(Collectors.toList());
    }
    
    public void deleteMessage(Message message) {
    	dataStorage.getMessageRepository().delete(message);
    }
    
    public List<File> getAllFiles(Group group) {
        List<File> files = new ArrayList<>();
        
        for (Message message : messages) {
            if (message.getGroup().getId() == group.getId()) {
                files.addAll(message.getFiles());
            }
        }
        return files;
    }
    
    public void addMessage(Message message) {
         messages.add(message);
    }
        
    public List<Message> deleteMessagesUser(User user, int K, int M) {
        List<Message> relatedMessages = new ArrayList<>();
        List<Message> resultMessage = new ArrayList<>();
        
        for (Message message : messages) {
            if (message.getRelation(user).equals(user)) {
            	relatedMessages.add(message);
            }
        }
        
        resultMessage = getLatestMessages(messages, K, M);
        return resultMessage;
    }
        
    public List<Message> getMessagesUser(User user, RelatedTarget target) {
        List<Message> relatedUserMessages = new ArrayList<>();
        
        for (Message message : messages) {
            if (message.getRelation(user).equals(target)) {
            	relatedUserMessages.add(message);
            }
        }
        
        return relatedUserMessages;
    }
    
    public List<Message> getMessagesGroup(Group group) {
        List<Message> relatedGroupMessages = new ArrayList<>();
        
        for (Message message : messages) {
            if (message.getGroup().getId().equals(group.getId())) {
            	relatedGroupMessages.add(message);
            }
        }
        
        return relatedGroupMessages;
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
