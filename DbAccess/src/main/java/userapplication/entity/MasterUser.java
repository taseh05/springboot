package userapplication.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity(name = "MasterUser")
@Table(name = "master_user")
public class MasterUser implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5063013448053881669L;

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name="username")
	private String name;
	
	@Column(name="password")
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="phone_no")
	private String phoneNo;

	@Column(name="created_on")
	private Timestamp createdOn; 

	@Column(name="updated_on")
	private Timestamp updatedOn; 
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="user_id",referencedColumnName = "id",nullable = false,insertable = false, updatable = false)
    private List<UserHistory> userHistory;
	
	public List<UserHistory> getUserHistory() {
		return userHistory;
	}

	public void setUserHistory(List<UserHistory> userHistory) {
		this.userHistory = userHistory;
	}

	public MasterUser() {}

	

	public MasterUser(Integer id, String name, String password, String phoneNo, Timestamp createdOn,
			Timestamp updatedOn) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.phoneNo = phoneNo;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}

	public Timestamp getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

}
