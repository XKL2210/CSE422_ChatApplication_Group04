package ktn.chat.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import ktn.chat.data.DataStorage;
import ktn.chat.enums.GroupType;
import ktn.chat.enums.RelatedTarget;
import ktn.chat.enums.Role;
import ktn.chat.models.File;
import ktn.chat.models.Group;
import ktn.chat.models.Message;
import ktn.chat.models.PrivateGroup;
import ktn.chat.models.PublicGroup;
import ktn.chat.models.User;

public class GroupServices {
	private DataStorage dataStorage;

    public GroupServices() {
        dataStorage = DataStorage.getDataStorage();
    }

    public Group createGroup(GroupType groupType, String groupName, User creator, List<User> members) {
        if (members.size() < 2) {
            return null;
        }

        members.add(creator);

        String groupID = UUID.randomUUID().toString();
        String accessCode = UUID.randomUUID().toString();
        
        Group group;
        
        if(groupType == GroupType.PrivateGroup) {
        	group = new PrivateGroup(groupID, groupName, creator, members);
        } else {
        	group = new PublicGroup(groupID, groupName, creator, members, accessCode);
        }

        dataStorage.getGroupRepository().insert(group);

        return group;
    }

    public boolean addMember(User member, Group group) {
        if (group.isMember(member)) {
            return false;
        }

        group.addMember(member, Role.Member);
        return true;
    }

    public boolean removeMember(User member, Group group) {
        if (group.isMember(member)) {
            if (group instanceof PrivateGroup) {
                if (group.getRole(member) == Role.Admin && group.getAdminCount() == 1) {
                    return false;
                }
            }

            group.removeUser(member);
            return true;
        }

        return false;
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
