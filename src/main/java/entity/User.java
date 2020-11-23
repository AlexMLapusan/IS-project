package entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
	//TODO: Add all the necessary class variables, getters and setters
	@Id
	private String id;
	
	@Column
	private String name;

	public User(String name) {
		this.name = name;
	}
	
	public User() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
