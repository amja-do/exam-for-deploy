package org.exam.exam_jee.Models;

import jakarta.persistence.*;
import org.eclipse.persistence.sessions.Project;


@Entity
@Table(name = "employee_project")
@NamedQuery(name = "employeeProject.findAll", query = "select ep from EmployeeProject ep")
public class EmployeeProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private Projet project;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;


    private double taux;

    public EmployeeProject() {
    }

    public EmployeeProject(Projet project, Employee employee, double taux) {
        this.project = project;
        this.employee = employee;
        this.taux = taux;
    }

    public Projet getProject() {
        return project;
    }

    public void setProject(Projet project) {
        this.project = project;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }


}
