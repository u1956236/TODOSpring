package org.udg.pds.springtodo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity(name="usergroup")

public class Group implements Serializable {

	private static final long serialVersionUID = 1L;

	public Group(){
	}

	public Group(String name, String description){
		this.name = name;
		this.description = description;
	}

	@NotNull
	private String name;
	
	@NotNull
	private String description;

	public String getName() {
		return name;
	}

	public String getDescription() {
        return description;
    }

	@ManyToOne(fetch = FetchType.EAGER)
  	@JoinColumn(name = "fk_user")
  	private User user;

 	@Column(name = "fk_user", insertable = false, updatable = false)
  	private Long userId;

	@JsonIgnore
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}

