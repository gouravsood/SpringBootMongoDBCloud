package sood.gourav.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import sood.gourav.domain.User;

import java.util.List;

/**
 * Created by gouravsood on 1/01/2016.
 */
public interface UserRepository extends MongoRepository<User, String> {

    List<User> findByFirstName(String firstName);

    List<User> findByLastName(String lastName);

}
