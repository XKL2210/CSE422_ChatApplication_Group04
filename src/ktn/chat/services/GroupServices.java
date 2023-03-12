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

		if (groupType == GroupType.PRIVATEGROUP) {
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

		group.addMember(member, Role.MEMBER);
		return true;
	}

	public boolean removeMember(User member, Group group) {
		if (group.isMember(member)) {
			if (group instanceof PrivateGroup) {
				if (group.getRole(member) == Role.ADMIN && group.getAdminCount() == 1) {
					return false;
				}
			}

			group.removeUser(member);
			group.removeRole(member);
			return true;
		}

		return false;
	}
}
