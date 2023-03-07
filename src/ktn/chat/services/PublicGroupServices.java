package ktn.chat.services;

import ktn.chat.data.DataStorage;
import ktn.chat.enums.Role;
import ktn.chat.models.Group;
import ktn.chat.models.PublicGroup;
import ktn.chat.models.User;

public class PublicGroupServices {
	DataStorage dataStorage;
	
	public PublicGroupServices() {
        dataStorage = DataStorage.getDataStorage();
    }

    public boolean joinWithAccessCode(User user, String groupId) {
        Group toJoinGroup = dataStorage.getGroupRepository().find(group -> {
            if (group instanceof PublicGroup) {
                return ((PublicGroup) group).getId().equals(groupId);
            }

            return false;
        });

        if (toJoinGroup == null) {
            return false;
        }

        toJoinGroup.addMember(user, Role.Member);
        return true;
    }
}
