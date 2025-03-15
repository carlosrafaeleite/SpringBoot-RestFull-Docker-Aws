package com.br.carlos.services;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.br.carlos.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	private Logger logger = Logger.getLogger(UserService.class.getName());

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("FindUser aqui byname"+ username +"!");
		var user = userRepository.findByUserName(username);
		if (user != null) {
			return user;
		}else {
			throw new UsernameNotFoundException(" Usuario " + username + "não encontrado!");
		}
	}
}
