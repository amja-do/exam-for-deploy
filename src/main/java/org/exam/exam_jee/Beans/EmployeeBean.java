package org.exam.exam_jee.Beans;

import jakarta.annotation.PostConstruct;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ViewScoped;
import org.exam.exam_jee.Models.Employee;
import org.exam.exam_jee.Models.Post;
import org.exam.exam_jee.Repositories.EmployeeRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ManagedBean
@ViewScoped
public class EmployeeBean {

    private Employee employee;
    private List<Post> availablePosts;
    private EmployeeRepository employeeRepository;
    private String skillsAsString;


    @PostConstruct
    public void init(){
        employeeRepository = new EmployeeRepository();
        employee = new Employee();
        availablePosts = Arrays.asList(Post.values());
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Post> getAvailablePosts() {
        return availablePosts;
    }

    public void setAvailablePosts(List<Post> availablePosts) {
        this.availablePosts = availablePosts;
    }

    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public String getSkillsAsString() {
        return skillsAsString;
    }

    public void setSkillsAsString(String skillsAsString) {
        this.skillsAsString = skillsAsString;
    }

    public void save(){
        employee.setSkills(getSkillsList());
        employeeRepository.addEmployee(this.employee);
        NavigationBean.redirectToIndexPage();
    }

    private List<String> getSkillsList() {
        if (skillsAsString != null && !skillsAsString.isEmpty()) {
            return Arrays.asList(skillsAsString.split("\\s*,\\s*"));
        } else {
            return new ArrayList<>();
        }
    }
}
