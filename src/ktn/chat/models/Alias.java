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
	
	private User getTargetUser() {
		return currentUser;
	}
	
	private String getAlias() {
		return alias;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Alias)) {
            return false;
        }

        Alias alias = (Alias) obj;
        return alias.getCurrentUser().equals(this.currentUser) 
        		&& alias.getTargetUser().equals(this.targetedUser);
    }
}
