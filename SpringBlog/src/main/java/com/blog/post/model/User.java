package com.blog.post.model;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements UserDetails {
	
	
	private static final long serialVersionUID = 561432636585798943L;
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	@Column (unique=true)
    private String username;
	@Column (unique=true)
	private String email;
	@Column (nullable=false)
	@JsonIgnore
	private String password;
	@Column
	@JsonIgnore
    private Calendar createDate;
	@Column
	@JsonIgnore
    private Calendar lastModified;
	@Column
	@JsonIgnore
	private boolean enabled;
	
	
	public User(String userName2, String password2, List<GrantedAuthority> asList) {
		this.username = userName2;
		this.password = password2;
		
	}



	public User() {
	}



	public Long getId() {
		return id;
	}
	


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}



	@Override
	public String getUsername() {
		return this.username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Calendar getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Calendar createDate) {
		this.createDate = createDate;
	}

	public Calendar getLastModified() {
		return lastModified;
	}
	
	public void setLastModified(Calendar lastModified) {
		this.lastModified = lastModified;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}



	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
