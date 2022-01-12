package dbaccess.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDao {
	
	private static List<User> users=new ArrayList<>();
	static {
		users.add(new User(1,"Adam",new Date()));
		users.add(new User(2,"Betty",new Date()));
		users.add(new User(3,"Lee",new Date()));
	}
public List<User> findall(){
	return users;
	}
public User save(User user){
	
	users.add(user);
	return user;
}
public User findOne(int id)
{
	for(User u:users)
		if(u.getId()==id)
			return u;
	return null;
}

}
