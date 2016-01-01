package sood.gourav.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sood.gourav.domain.User;
import sood.gourav.repository.UserRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by gouravsood on 1/01/2016.
 */
@RestController
@RequestMapping("/")
public class UserResource {

    private final Logger log = LoggerFactory.getLogger(UserResource.class);

    @Inject
    private UserRepository userRepository;

    /**
     * GET  / -> fetch all users.
     */
    @RequestMapping(value = "/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> fetchAllUsers() {

        log.debug("REST request to fetch all users");

        List<User> allUsers = userRepository.findAll();

        return ResponseEntity.ok()
                .body(allUsers);
    }

    /**
     * GET  /{firstName} -> fetch all users by first name.
     */
    @RequestMapping(value = "/firstname/{firstName}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> fetchByFirstName(@PathVariable String firstName) {

        log.debug("REST request to fetch all users by first name");

        List<User> allUsersByFirstName = userRepository.findByFirstName(firstName);

        return ResponseEntity.ok()
                .body(allUsersByFirstName);
    }

    /**
     * GET  /{firstName} -> fetch all users by last name.
     */
    @RequestMapping(value = "/lastname/{lastName}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> fetchByLastName(@PathVariable String lastName) {

        log.debug("REST request to fetch all users by last name");

        List<User> allUsersByLastName = userRepository.findByLastName(lastName);

        return ResponseEntity.ok()
                .body(allUsersByLastName);
    }
}
