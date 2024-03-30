package com.hypersrot.assignment.demo.repositories;

import com.hypersrot.assignment.demo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
