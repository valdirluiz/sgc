package br.com.sgc.users;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "USUARIOS")
@Access(AccessType.FIELD)
public class User extends PanacheEntity {

 
	@Column(name = "NOME", length = 100)
	private String name;

	@Column(name = "LOGIN", length = 100, unique = true)
	private String login;

	@Column(name = "SENHA", length = 250)
	private String password;

	@Column(name = "EMAIL", length = 250)
	private String email;

	@Column(name = "FL_ATIVO")
	private Boolean active;

	@Column(name = "DT_CRIACAO")
	private LocalDateTime creationTime;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_papeis", joinColumns = { @JoinColumn(name = "usuario_id") }, inverseJoinColumns = {
			@JoinColumn(name = "papel_id") })
	private List<Role> roles = new ArrayList<Role>();

	 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public LocalDateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public void markAsActive() {
		this.active = true;
	}

}