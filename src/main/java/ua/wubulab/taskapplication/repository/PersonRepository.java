package ua.wubulab.taskapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.wubulab.taskapplication.dto.PersonDto;
import ua.wubulab.taskapplication.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<PersonDto, Long> {

    List<PersonDto> findByLastName(String lastName);

    Optional<PersonDto> findById(Long id);


}
