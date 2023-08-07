package JWTAuthorization.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import JWTAuthorization.model.UserInfo;

public interface UserRepo extends JpaRepository<UserInfo, Integer>{

	Optional<UserInfo> findByEmail(String email);
}
