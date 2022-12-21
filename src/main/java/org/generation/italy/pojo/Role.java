package org.generation.italy.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@NotEmpty
	@Column(unique = true)
	private String roleName;
	
	public Role () {}
	public Role (String roleName) {
		setRoleName(roleName);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	@Override
	public String toString() {

		return "(" + getId() + ")" + " - " + getRoleName();
	}
	
	@Override
	public int hashCode() {
		
		return getId();
	}
	@Override
	public boolean equals(Object obj) {
		
		if (!(obj instanceof Role)) return false;
		
		return obj.hashCode() == hashCode();
	}
}	

