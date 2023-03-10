package ua.wubulab.taskapplication.service;

import java.time.LocalDate;
import java.time.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.wubulab.taskapplication.dto.PersonDto;
import ua.wubulab.taskapplication.entity.Person;
import ua.wubulab.taskapplication.repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public PersonDto getPersonById(Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found"));

        int age = Period.between(person.getDateOfBirth(), LocalDate.now()).getYears();
        return new PersonDto(person.getFirstName(), person.getLastName(), age);
    }

}
