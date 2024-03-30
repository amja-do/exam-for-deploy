package org.exam.exam_jee.Beans;

import jakarta.annotation.PostConstruct;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ViewScoped;
import org.exam.exam_jee.Config.DB;
import org.exam.exam_jee.Models.Employee;
import org.exam.exam_jee.Models.EmployeeProject;
import org.exam.exam_jee.Models.Projet;
import org.exam.exam_jee.Repositories.EmployeeRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@ManagedBean
@ViewScoped
public class IndexBean {

    public static List<Employee> employees;
    private EmployeeRepository employeeRepository;


    @PostConstruct
    public void init(){
        employeeRepository = new EmployeeRepository();
        IndexBean.employees = employeeRepository.selectAll();
        System.out.println("****" + IndexBean.employees.size());
    }

    public List<Employee> getEmployees() {
        return IndexBean.employees;
    }

    public void setEmployees(List<Employee> employees) {
        IndexBean.employees = employees;
    }

    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void removeEmployee(Employee employee){
        employeeRepository.removeEmployee(employee);
        employees.remove(employee);
    }





}
