package user;

import java.io.Serializable;

public class UserWrapper implements Serializable{

	private boolean isSuccessfull;
	private User user;
	
	public UserWrapper() {
	}
	public boolean getisSuccessfull() {
		return isSuccessfull;
	}
	public void setUsSuccessfull(boolean isSuccessfull) {
		this.isSuccessfull = isSuccessfull;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
