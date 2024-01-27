package com.urbanbazaar.Repo;

import com.urbanbazaar.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

}
