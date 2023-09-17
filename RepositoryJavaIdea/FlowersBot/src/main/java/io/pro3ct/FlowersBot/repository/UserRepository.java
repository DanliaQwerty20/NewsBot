package io.pro3ct.FlowersBot.repository;

import io.pro3ct.FlowersBot.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

}
