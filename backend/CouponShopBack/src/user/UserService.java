package user;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class UserService {

	private final UserMapper userMapper;

    public UserService() {
        this.userMapper = new UserMapper();
    }
    
    public UserWrapper isRegistered(UserLogIn user){
    	//sad user dobijes preko mapper.getUsers i ovde ih uporedjujes!!!
    	ArrayList<User> userList = new ArrayList<>();
    	userList = (ArrayList<User>) this.userMapper.mapToModelList(UserRepository.getUsers());
    	UserWrapper userWrapper = new UserWrapper();
    	userWrapper.setUser(null);
    	userWrapper.setUsSuccessfull(false);
    	for(User u:userList){
    		if( ( u.getUsername().equals(user.getUsername()) )  && ( u.getPassword().equals(user.getPassword()) ) ){
    			userWrapper.setUser(u);
    			userWrapper.setUsSuccessfull(true);
    		}
    	}
    	
    	return userWrapper;
    }
    //ja mislim da ovde treba da proveravam dal postoji clan i dal moze da se konektuje!!!
    
    public User addUser(User user) throws IOException{
    	UserRepository.addUser(this.userMapper.mapToEntity(user));
    	return user;
    }
    
	
}
