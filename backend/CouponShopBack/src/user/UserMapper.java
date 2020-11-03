package user;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

	 public UserEntity mapToEntity(User user) {
	        if (user == null) {
	            return null;
	        }

	        UserEntity userEntity = new UserEntity();
	        
	        userEntity.setId(user.getId());
	        userEntity.setFirstName(user.getFirstName());
	        userEntity.setLastName(user.getLastName());
	        userEntity.setPrivilegeLevel(user.getPrivilegeLevel());
	        userEntity.setUsername(user.getUsername());
	        userEntity.setPassword(user.getPassword());
	        
	        return userEntity;
	    }

	    public User mapToModel(UserEntity userEntity) {
	        if (userEntity == null) {
	            return null;
	        }

	        User user = new User();
	        
	        user.setId(userEntity.getId());
	        user.setFirstName(userEntity.getFirstName());
	        user.setLastName(userEntity.getLastName());
	        user.setPrivilegeLevel(userEntity.getPrivilegeLevel());
	        user.setUsername(userEntity.getUsername());
	        user.setPassword(userEntity.getPassword());
	        
	        return user;
	    }

	    public List<User> mapToModelList(List<UserEntity> userEntities) {
	        return userEntities.stream().map(this::mapToModel).collect(Collectors.toList());
	    }
	
}
