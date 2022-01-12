package userapplication.repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import userapplication.entity.UserHistory;

public interface UserHistoryRepository extends JpaRepository<UserHistory, UUID> {

	@Query(value="select mu.id as id "
			+ ",mu.username as userName, u.event as event,u.created_on as createdOn "
			+ "from master_user mu, \n"
			+ "user_history u where mu.id=u.user_id and mu.id=:id",nativeQuery = true)
	List<UserHistoryDetails> getUserHistory(Integer id);
	
	public static interface UserHistoryDetails {
		 Integer getId();
		 String getEvent();
		 Timestamp getCreatedOn();
		 Integer getUserId();
		 String getUserName();
	}
}
