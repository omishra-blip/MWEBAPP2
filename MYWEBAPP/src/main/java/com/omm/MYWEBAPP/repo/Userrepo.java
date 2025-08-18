package com.omm.MYWEBAPP.repo;

import com.omm.MYWEBAPP.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Userrepo extends JpaRepository<User,Integer> {
}
