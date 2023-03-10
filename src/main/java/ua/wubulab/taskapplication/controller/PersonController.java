package ua.wubulab.taskapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ua.wubulab.taskapplication.dto.PersonDto;
import ua.wubulab.taskapplication.service.PersonService;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/person/{id}")
    public PersonDto getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }
}
