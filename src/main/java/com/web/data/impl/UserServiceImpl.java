package com.web.data.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import com.web.data.model.User;
import com.web.data.repo.UserRepository;


@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository repo;//has -a relationship
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public Integer saveUser(User user) {
		// TODO Auto-generated method stub
		//read Form Password, encode it
				String encPwd = passwordEncoder.encode(user.getPwd());
				//set back to same object
				user.setPwd(encPwd);
		user=repo.save(user);
		return user.getUid();
	}
	


}

