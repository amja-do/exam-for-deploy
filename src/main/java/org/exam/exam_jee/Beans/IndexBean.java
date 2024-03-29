package org.exam.exam_jee.Beans;

import jakarta.annotation.PostConstruct;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ViewScoped;
import org.exam.exam_jee.Models.Employee;
import org.exam.exam_jee.Repositories.EmployeeRepository;

import java.util.List;

@ManagedBean
@ViewScoped
public class IndexBean {

    private List<Employee> employees;
    private EmployeeRepository employeeRepository;

    @PostConstruct
    public void init(){
        employeeRepository = new EmployeeRepository("mysql-eclipselink");
        employees = employeeRepository.selectAll();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void removeEmployee(Employee employee){
        employeeRepository.removeEmployee(employee);
    }
}
