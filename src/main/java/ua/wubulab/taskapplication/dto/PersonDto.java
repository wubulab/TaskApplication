package ua.wubulab.taskapplication.dto;

import jakarta.persistence.Entity;
import ua.wubulab.taskapplication.entity.Person;

@Entity
public class PersonDto extends Person {

    private String firstName;
    private String lastName;
    private int age;

    public PersonDto() {
    }

    public PersonDto(String firstName, String lastName, Integer age) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
    }


    @Override
    public String toString() {
        return "PersonDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
