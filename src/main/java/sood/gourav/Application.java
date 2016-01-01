package sood.gourav;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import sood.gourav.domain.User;
import sood.gourav.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 * Created by gouravsood on 1/01/2016.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(Application.class);

        System.out.println("Let's inspect the beans provided by Spring Boot:");

        addDefaultProfile(app);

        Environment env = app.run(args).getEnvironment();
        System.out.println(String.format("Access URLs:\n----------------------------------------------------------\n\t" +
                        "Local: \t\thttp://127.0.0.1:%s\n\t" +
                        "External: \thttp://%s:%s\n----------------------------------------------------------",
                env.getProperty("server.port"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port")));


    }

    /**
     * If no profile has been configured, set by default the "dev" profile.
     */
    private static void addDefaultProfile(SpringApplication app) {
        if (!System.getenv().containsKey("SPRING_PROFILES_ACTIVE")) {
            app.setAdditionalProfiles("dev");
        }
    }

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init()
    {
        userRepository.deleteAll();
        userRepository.save(new User("Gourav","Sood","gouravsood@gmail.com"));
    }

}
