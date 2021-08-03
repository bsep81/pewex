package pl.sdacademy.pewex.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sdacademy.pewex.user.db.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {
}
