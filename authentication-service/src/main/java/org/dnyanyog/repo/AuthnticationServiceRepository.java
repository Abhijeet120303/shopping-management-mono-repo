package org.dnyanyog.repo;

import java.util.List;
import java.util.Optional;

import org.dnyanyog.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface AuthnticationServiceRepository extends JpaRepository<Users, Long> {

	List<Users> findByUsernameAndPassword(String username, String password);

	List<Users> findByUsername(String userId);

	Optional<Users> findById(long Id);

	List<Users> deleteById(long Id);

}
