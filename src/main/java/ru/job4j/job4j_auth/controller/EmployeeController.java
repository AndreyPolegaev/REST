package ru.job4j.job4j_auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.job4j_auth.domain.Employee;
import ru.job4j.job4j_auth.domain.Person;
import ru.job4j.job4j_auth.repository.EmployeeRepository;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping("/")
    public List<Employee> findAll() {
        return StreamSupport.stream(this.repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable long id) {
        var employee = this.repository.findById(id);
        return new ResponseEntity<Employee>(employee.orElse(new Employee()),
                employee.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }

    @PostMapping("/")
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(
                this.repository.save(employee),
                HttpStatus.CREATED
        );
    }

    @PostMapping("/addNew")
    public ResponseEntity<Employee> createWithAccount(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(
                this.repository.save(employee),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<Void> update(@RequestBody Employee employee) {
        this.repository.save(employee);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Employee employee = new Employee();
        employee.setId(id);
        this.repository.delete(employee);
        return ResponseEntity.ok().build();
    }

}
