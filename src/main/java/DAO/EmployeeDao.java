package DAO;

import ru.tarasov.entity.Employee;

import java.util.List;

public interface EmployeeDao {
     //void addEmployee(Employee employee);
     //void deleteEmployee(Employee employee);
     List<Employee> get();

     void save(Employee employee);

     Employee select(int id);

     void update(Employee employee);

     boolean delete(int id);


}
