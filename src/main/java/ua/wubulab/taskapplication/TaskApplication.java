package ua.wubulab.taskapplication;


import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ua.wubulab.taskapplication.dto.PersonDto;
import ua.wubulab.taskapplication.entity.Person;
import ua.wubulab.taskapplication.repository.PersonRepository;


@SpringBootApplication
public class TaskApplication {

    private static final Logger log;

    static {
        log = (Logger) LoggerFactory.getLogger(TaskApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(TaskApplication.class);
    }


    @Bean
    public CommandLineRunner demo(PersonRepository repository) {
        return (args) -> {
            repository.save(new PersonDto("Jack", "Bauer", 31));
            repository.save(new PersonDto("Chloe", "O'Brian", 9));
            repository.save(new PersonDto("Kim", "Bauer", 19));
            repository.save(new PersonDto("David", "Palmer", 12));
            repository.save(new PersonDto("Michelle", "Dessler", 22));

            log.info("Persons found with findAll():");
            log.info("-------------------------------");
            for (Person person : repository.findAll()) {
                log.info(person.toString());
            }
            log.info("");

            PersonDto person = (PersonDto) repository.findById(1L);
            log.info("Person found with findById(1L):");
            log.info("--------------------------------");
            log.info(person.toString());
            log.info("");

            log.info("Person found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Bauer").forEach(bauer -> {
                log.info(bauer.toString());
            });
            log.info("");
        };
    }
}

