package ktn.chat.models;

public class Alias {
	private User currentUser;
	private User targetedUser;
	private String alias;

	public Alias(User currentUser, User targetedUser, String alias) {
		this.currentUser = currentUser;
		this.targetedUser = targetedUser;
		this.alias = alias;
	}

	private User getCurrentUser() {
		return currentUser;
	}

	private User getTargetedUser() {
		return targetedUser;
	}

	private String getAlias() {
		return alias;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Alias)) {
			return false;
		}

		Alias other = (Alias) obj;
		return other.getCurrentUser().equals(this.currentUser) && other.getTargetedUser().equals(this.targetedUser);
	}
}
