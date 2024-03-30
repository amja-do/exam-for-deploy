package org.exam.exam_jee.Models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "projects")
@NamedQuery(name = "projet.findAll", query = "select p from Projet p")
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private double budget;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private Set<EmployeeProject> employeeProjects = new HashSet<EmployeeProject>();


    public Projet() {
    }

    public Projet(String name, double budget) {
        this.name = name;
        this.budget = budget;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public Set<EmployeeProject> getEmployeeProjects() {
        return employeeProjects;
    }

    public void setEmployeeProjects(Set<EmployeeProject> employeeProjects) {
        this.employeeProjects = employeeProjects;
    }

    public void addEmployee(EmployeeProject employeeProject){
        this.employeeProjects.add(employeeProject);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Projet && ((Projet) obj).getName().equals(this.name);
    }


    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
    
}
