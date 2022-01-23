package com.web.data.impl;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
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
public class UserServiceImpl implements IUserService,UserDetailsService {

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
	@Override
    public boolean exists(String email){
    	System.out.println("User mail exists already");
        return repo.existsByEmail(email);
     }
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		//make Database call using username
		Optional<User> opt = repo.findByEmail(username);
		if(!opt.isPresent()) {
			System.out.println("Not able to read user in imple class");//if user not exist
			throw new UsernameNotFoundException("User not found");
		} else { //if user is present
			System.out.println("User is present");
			User user = opt.get();
			
			//User Roles
			List<String> roles = user.getRoles();
			
			Set<GrantedAuthority> authorities = new HashSet<>();
			for(String role:roles) {
				authorities.add(new SimpleGrantedAuthority(role));
			}
			//spring Security user object
			return new org.springframework.security.core.userdetails.User(
					username, 
					user.getPwd(), 
					authorities
					);
			//User Roles
//			List<String> roles = user.getRoles();
//			
//			Set<GrantedAuthority> authorities = new HashSet<>();
//			for(String role:roles) {
//				authorities.add(new SimpleGrantedAuthority(role));
//			}
//			//spring Security user object
//			return new org.springframework.security.core.userdetails.User(
//					user.getEmail(), 
//					user.getPwd(), 
//					authorities
//					);
		}
	}
	


}

