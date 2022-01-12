package userapplication.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import userapplication.entity.MasterUser;

public interface MasterUserRepository extends JpaRepository<MasterUser, UUID> {

	
	
}
