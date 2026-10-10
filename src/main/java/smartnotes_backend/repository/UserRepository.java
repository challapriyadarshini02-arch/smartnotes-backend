package smartnotes_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import smartnotes_backend.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmailAndPassword(String email, String password);
}
