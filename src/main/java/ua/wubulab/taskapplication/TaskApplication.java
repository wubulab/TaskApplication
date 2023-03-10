package ua.wubulab.taskapplication;


import ch.qos.logback.classic.Logger;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ua.wubulab.taskapplication.entity.Person;
import ua.wubulab.taskapplication.repository.PersonRepository;

import java.time.LocalDate;


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
    public CommandLineRunner demo(PersonRepository repository, ObjectMapper objectMapper) {
        return (args) -> {
            repository.save(new Person("Jack", "Bauer", LocalDate.of(1990, 2, 5)));
            repository.save(new Person("Chloe", "O'Brian", LocalDate.of(2012, 6, 6)));
            repository.save(new Person("Kim", "Bauer", LocalDate.of(2002, 1, 1)));
            repository.save(new Person("David", "Palmer", LocalDate.of(2022, 1, 5)));
            repository.save(new Person("Michelle", "Dessler", LocalDate.of(2001, 1, 3)));


            log.info("Persons found with findAll():");
            log.info("-------------------------------");
            for (Person person : repository.findAll()) {
                log.info(objectMapper.writeValueAsString(person));
            }
            log.info("");


            Person person = repository.findById(1L);
            log.info("Person found with findById(1L):");
            log.info("--------------------------------");
            log.info(objectMapper.writeValueAsString(person));
            log.info("");


            log.info("Person found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Bauer").forEach(bauer -> {
                try {
                    log.info(objectMapper.writeValueAsString(bauer));
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            });
            log.info("");
        };
    }

}



