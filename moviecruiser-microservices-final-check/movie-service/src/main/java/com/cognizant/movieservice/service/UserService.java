package com.cognizant.movieservice.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.movieservice.exception.ResourceNotFoundException;
import com.cognizant.movieservice.model.Movie;
import com.cognizant.movieservice.model.User;
import com.cognizant.movieservice.repository.MovieRepository;
import com.cognizant.movieservice.repository.UserRepository;

@Service
public class UserService {

	Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MovieRepository movieRepository;
	
	public User addUser(User user) {
		return userRepository.save(user);
	}

	public Iterable<Movie> addFavorites(Long userId, Long movieId) {
		LOGGER.info("Start");
		Optional<User> userDb=userRepository.findById(userId);
		if(!userDb.isPresent()) {
			throw new ResourceNotFoundException("User not found");
		}
		User user=userDb.get();
		LOGGER.debug("User: {}",user);
		Optional<Movie> movieDb=movieRepository.findById(movieId);
		if(!movieDb.isPresent()) {
			throw new ResourceNotFoundException("Movie not found");
		}
		Movie movie=movieDb.get();
		LOGGER.debug("Movie: {}",movie);
		user.addFavorites(movie);
		userRepository.save(user);
		LOGGER.debug("Updated user: {}",user);
		LOGGER.info("End");
		return user.getFavorites();
	}

	public Iterable<Movie> getFavorites(Long userId) {
		LOGGER.info("Start");
		Optional<User> userDb=userRepository.findById(userId);
		if(!userDb.isPresent()) {
			throw new ResourceNotFoundException("User not found");
		}
		User user=userDb.get();
		LOGGER.debug("User : {}",user);
		LOGGER.info("End");
		return user.getFavorites();
	}

	public Iterable<Movie> removeFavorites(Long userId, Long movieId) {
		LOGGER.info("Start");
		Optional<User> userDb=userRepository.findById(userId);
		if(!userDb.isPresent()) {
			throw new ResourceNotFoundException("User not found");
		}
		User user=userDb.get();
		LOGGER.debug("User: {}",user);
		Optional<Movie> movieDb=movieRepository.findById(movieId);
		if(!movieDb.isPresent()) {
			throw new ResourceNotFoundException("Movie not found");
		}
		Movie movie=movieDb.get();
		LOGGER.debug("Movie: {}",movie);
		user.removeFavorites(movie);
		userRepository.save(user);
		LOGGER.info("End");
		return user.getFavorites();
	}
	
}
