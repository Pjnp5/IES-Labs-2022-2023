package IES.Lab3_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import IES.Lab3_2.model.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    List<Employee> findByEmailId(String emailId);
    List<Employee> findByFirstName(String firstName);
    List<Employee> findByLastName(String lastName);
}