package JWTAuthorization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import JWTAuthorization.model.UserInfo;
import JWTAuthorization.repo.UserRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo user=repo.findByEmail(username).orElseThrow(()-> new RuntimeException("User Not found"));
		return user;
	}

}
