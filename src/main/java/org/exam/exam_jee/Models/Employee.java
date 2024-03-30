package org.exam.exam_jee.Models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import org.eclipse.persistence.annotations.CascadeOnDelete;

@Entity
@Table(name = "employees")
@NamedQuery(name = "employee.findAll", query = "select e from Employee e")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name, email;
    @ElementCollection
    @CascadeOnDelete
    private List<String> skills;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EmployeeProject> projects = new HashSet<EmployeeProject>();

    @Enumerated(EnumType.STRING)
    private Post post;

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


    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", skills=" + skills.size() +
                ", projects=" + projects.size() +
                '}';
    }

    public String getFormatedSkills(){
        StringBuilder stringBuilder = new StringBuilder();
        for (String skill : this.skills) {
            stringBuilder.append(skill).append("\n");
        }
        return stringBuilder.toString();
    }
    public void setFormatedSkills(String skill){

    }
    public String getFormatedProjects(){
        StringBuilder stringBuilder = new StringBuilder();
        for (EmployeeProject employeeProject : this.projects) {
            stringBuilder.append(employeeProject.getProject().getName())
                    .append(" (")
                    .append(employeeProject.getTaux())
                    .append("%)")
                    .append("\n");
        }
        return stringBuilder.toString();
    }
    public void setFormatedProjects(String skill){

    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Employee && ((Employee) obj).getName().equals(this.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
