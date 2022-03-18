package ru.job4j.job4j_auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.job4j_auth.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
