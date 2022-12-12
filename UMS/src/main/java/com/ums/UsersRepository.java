package com.ums;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ums.User;

public interface UsersRepository extends JpaRepository<User, Integer> {
}
