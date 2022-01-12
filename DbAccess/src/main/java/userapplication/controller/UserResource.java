package userapplication.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import userapplication.entity.MasterUser;
import userapplication.entity.UserHistory;
import userapplication.repository.MasterUserRepository;
import userapplication.repository.UserHistoryRepository;
import userapplication.repository.UserHistoryRepository.UserHistoryDetails;

@RestController
public class UserResource {
	private static Logger log = LoggerFactory.getLogger(UserResource.class);
	
	@Autowired
	private MasterUserRepository masterUserRepository;

	@Autowired
	private UserHistoryRepository userHistoryRepository;

	@GetMapping(path="/users")
	public List<MasterUser> retrieveAllUsers(){

		return masterUserRepository.findAll();
	}

	@GetMapping(path="/user/{id}/history")
	public List<UserHistoryDetails> getUserHistory(@PathVariable("id") Integer id){
		log.info("id: {}",id);
		return userHistoryRepository.getUserHistory(id);
	}
	
	
	@GetMapping("/users/{id}")
	public MasterUser retrieveUser(@PathVariable Integer id) {

		return null;
	}

	@PostMapping("/user/create")
	public void createUser(@RequestBody MasterUser u){
		Timestamp current_time = new Timestamp(Calendar.getInstance().getTimeInMillis());
		u.setCreatedOn(current_time);
		
		UserHistory uh = new UserHistory();
		uh .setCreatedOn(current_time);
		uh.setEvent("create");
		uh.setMasterUser(u);
		
		u.getUserHistory().add(uh);
		masterUserRepository.save(u);
	}

	@PutMapping("/user/update")
	public void updateUser(@RequestBody MasterUser u){
		Timestamp current_time = new Timestamp(Calendar.getInstance().getTimeInMillis());
		u.setCreatedOn(current_time);
		
		UserHistory uh =new UserHistory();
		uh .setCreatedOn(current_time);
		uh.setEvent("update");
		uh.setUserId(u.getId());
		masterUserRepository.save(u);
		userHistoryRepository.save(uh);
	}

	@DeleteMapping("/user/delete")
	public void deleteUser(@RequestBody MasterUser u){
		Timestamp current_time = new Timestamp(Calendar.getInstance().getTimeInMillis());
		u.setCreatedOn(current_time);
		UserHistory uh =new UserHistory();
		uh.setCreatedOn(current_time);
		uh.setEvent("delete");
		uh.setUserId(u.getId());
		masterUserRepository.save(u);
		userHistoryRepository.save(uh);
	}

	public MasterUserRepository getMasterUserRepository() {
		return masterUserRepository;
	}
	public void setMasterUserRepository(MasterUserRepository masterUserRepository) {
		this.masterUserRepository = masterUserRepository;
	}

	public UserHistoryRepository getUserHistoryRepository() {
		return userHistoryRepository;
	}

	public void setUserHistoryRepository(UserHistoryRepository userHistoryRepository) {
		this.userHistoryRepository = userHistoryRepository;
	}

}
