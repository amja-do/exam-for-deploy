package org.exam.exam_jee.Models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
@NamedQuery(name = "employee.findAll", query = "select e from Employee e")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name, email;
    private List<String> skills;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EmployeeProject> projects = new HashSet<EmployeeProject>();

    public Employee() {
    }

    public Employee(String name, String email, List<String> skills) {
        this.name = name;
        this.email = email;
        this.skills = skills;
    }

    public Set<EmployeeProject> getProjects() {
        return projects;
    }

    public void setProjects(Set<EmployeeProject> employeeProjects) {
        this.projects = employeeProjects;
    }

    public void addProject(EmployeeProject employeeProject) {
        projects.add(employeeProject);
        employeeProject.setEmployee(this);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

}
