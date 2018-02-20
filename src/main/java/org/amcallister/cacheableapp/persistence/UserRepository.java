package org.amcallister.cacheableapp.persistence;

import org.amcallister.cacheableapp.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByName(String name);
}
