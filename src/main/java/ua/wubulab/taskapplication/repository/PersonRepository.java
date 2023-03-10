package ua.wubulab.taskapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.wubulab.taskapplication.entity.Person;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByLastName(String lastName);

    Person findById(long id);


}
