package ua.wubulab.taskapplication.dto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.persistence.Entity;
import ua.wubulab.taskapplication.entity.Person;
@Entity
public class PersonDto extends Person {

    private String firstName;
    private String lastName;
    private int age;

    public PersonDto() {
    }

    public PersonDto(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

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
