package ru.job4j.job4j_auth.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private long inn;

    @Column(name = "hiredate")
    private Timestamp hireDate;

    public static Employee of(String name, int age, long inn, Set<Person> persons) {
        Employee employee = new Employee();
        employee.name = name;
        employee.age = age;
        employee.inn = inn;
        employee.hireDate = new Timestamp(System.currentTimeMillis());
        return employee;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.LAZY)
    private Set<Person> accounts = new HashSet<>();

    public boolean addAccount(Person person) {
        return accounts.add(person);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
