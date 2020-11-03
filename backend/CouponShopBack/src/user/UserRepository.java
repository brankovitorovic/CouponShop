package user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;


public class UserRepository {

	private static List<UserEntity> users;
	
	static {
		try {
			users = loadUsers();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private synchronized static List<UserEntity> loadUsers() throws IOException{
		List<UserEntity> userEntityList = new ArrayList<>();
		
		
		
		BufferedReader br = new BufferedReader(new FileReader("D:/Program Files (x86)/Java/java-neon/Workspace/ProjekatWebBackend/WebContent/WEB-INF/database/users.txt"));
		// nisam nasao bolji nacin da pristupim fajlu jer ne mogu da dobiojem context
		StringTokenizer st;
		
		UserEntity user;
		
		
		String line = br.readLine();

	    while (line != null) {
	    	
	    	st = new StringTokenizer(line, ",");
	    	while(st.hasMoreTokens()){
	    		user = new UserEntity();
	    		user.setId(st.nextToken());
	    		user.setFirstName(st.nextToken());
	    		user.setLastName(st.nextToken());
	    		user.setPrivilegeLevel(PrivilegeLevel.valueOf(st.nextToken()));
	    		user.setUsername(st.nextToken());
	    		user.setPassword(st.nextToken());
	    		
	    		userEntityList.add(user);
	    	}
	    	
	    	line = br.readLine();
	    }
	    

	    br.close();
		
		return userEntityList;
	}
	
	public synchronized static List<UserEntity> getUsers(){
		return users;
	}
	
	public synchronized static void addUser(UserEntity userEntity) throws IOException{
		userEntity.setId(Integer.toString ( new Random().nextInt(Integer.MAX_VALUE) ) );
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("D:/Program Files (x86)/Java/java-neon/Workspace/ProjekatWebBackend/WebContent/WEB-INF/database/users.txt",true));
		
		String entityForDataBase = "\n" + userEntity.getId() + "," + userEntity.getFirstName() + "," + userEntity.getLastName() + "," 
				+ userEntity.getPrivilegeLevel() + "," + userEntity.getUsername() + "," + userEntity.getPassword();
		
		bw.append(entityForDataBase);
		
		bw.close();
		
		users.add(userEntity);
	}
	
}
