package JWTAuthorization.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import JWTAuthorization.model.UserInfo;
import JWTAuthorization.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	public UserInfo save(UserInfo userInfo) {
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
	passwordEncoder.encode(userInfo.getPassword());
		return userRepo.save(userInfo);
		
	}
	public List<UserInfo> getAll() {
		return userRepo.findAll();
		
	}
}
