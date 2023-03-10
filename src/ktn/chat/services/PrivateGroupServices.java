package ktn.chat.services;

import ktn.chat.data.DataStorage;
import ktn.chat.enums.Role;
import ktn.chat.models.Group;
import ktn.chat.models.PublicGroup;
import ktn.chat.models.User;

public class PrivateGroupServices {
DataStorage dataStorage;
	
	public PrivateGroupServices() {
        dataStorage = DataStorage.getDataStorage();
    }

    public boolean joinWithAccessCode(User user, String accessPasscode) {
        Group toJoinGroup = dataStorage.getGroupRepository().find(group -> {
            if (group instanceof PublicGroup) {
                return ((PublicGroup) group).getPasscode().equals(accessPasscode);
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