package com.cognizant.movieservice.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="us_id")
	private Long id;
	
	@Column(name="us_name")
	private String name;
	
	@Column(name="us_user_name")
	private String userName;
	
	@Column(name="us_password")
	private String password;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="favorite",joinColumns=@JoinColumn(name="us_id"),inverseJoinColumns=@JoinColumn(name="mv_id"))
	private Set<Movie> favorites=new HashSet<>();

	public User() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Movie> getFavorites() {
		return favorites;
	}

	public void setFavorites(Set<Movie> favorites) {
		this.favorites = favorites;
	}

	public void addFavorites(Movie movie) {
		this.favorites.add(movie);
	}
	
	public void removeFavorites(Movie movie) {
		this.favorites.remove(movie);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", userName=" + userName + ", password=" + password
				+ ", favorites=" + favorites + "]";
	}
	
}
