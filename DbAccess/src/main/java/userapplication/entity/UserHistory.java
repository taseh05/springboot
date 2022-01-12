package userapplication.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "UserHistory")
@Table(name = "user_history")

public class UserHistory implements Serializable{

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue
		private Integer id;

		@Column(name="event")
		private String event;
		
		@Column(name="created_by")
		private String createdBy;

		
		@Column(name="created_on")
		private Timestamp createdOn;

		@Column(name = "user_id")
		private Integer userId;
		
		@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
		@JoinColumn(name="user_id",referencedColumnName = "id",insertable = false, updatable = false)
		private MasterUser masterUser;

		


		public MasterUser getMasterUser() {
			return masterUser;
		}


		public void setMasterUser(MasterUser masterUser) {
			this.masterUser = masterUser;
		}


		public Integer getUserId() {
			return userId;
		}


		public void setUserId(Integer userId) {
			this.userId = userId;
		}


		public Integer getId() {
			return id;
		}


		public void setId(Integer id) {
			this.id = id;
		}


		public String getEvent() {
			return event;
		}


		public void setEvent(String event) {
			this.event = event;
		}


		public String getCreatedBy() {
			return createdBy;
		}


		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}


		public Timestamp getCreatedOn() {
			return createdOn;
		}


		public void setCreatedOn(Timestamp createdOn) {
			this.createdOn = createdOn;
		}

		public UserHistory(Integer id, String event, String createdBy, Timestamp createdOn, Integer uid) {
			super();
			this.id = id;
			this.event = event;
			this.createdBy = createdBy;
			this.createdOn = createdOn;
			this.userId = uid;
		}


		public UserHistory() {}


}
