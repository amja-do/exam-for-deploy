package org.exam.exam_jee.Beans;

import jakarta.annotation.PostConstruct;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ViewScoped;
import org.exam.exam_jee.Models.Employee;
import org.exam.exam_jee.Models.EmployeeProject;
import org.exam.exam_jee.Models.Projet;
import org.exam.exam_jee.Repositories.EmployeeRepository;
import org.exam.exam_jee.Repositories.ProjectRepository;

import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class AffectBean {

    private List<Employee> employees;
    private List<Projet> projets;
    private ProjectRepository projectRepository;
    private EmployeeRepository employeeRepository;

    private Employee selectedEmployee;
    private List<Projet> selectedProjets;
    private double taux;



    @PostConstruct
    public void init(){
        selectedEmployee = new Employee();
        selectedProjets = new ArrayList<Projet>();

        projectRepository = new ProjectRepository("mysql-eclipselink");
        employeeRepository = new EmployeeRepository("mysql-eclipselink");
        projets = projectRepository.selectAll();
        employees =employeeRepository.selectAll();

    }


    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Projet> getProjets() {
        return projets;
    }

    public void setProjets(List<Projet> projets) {
        this.projets = projets;
    }

    public ProjectRepository getProjectRepository() {
        return projectRepository;
    }

    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee getSelectedEmployee() {
        return selectedEmployee;
    }

    public void setSelectedEmployee(Employee selectedEmployee) {
        this.selectedEmployee = selectedEmployee;
    }

    public List<Projet> getSelectedProjets() {
        return selectedProjets;
    }

    public void setSelectedProjets(List<Projet> selectedProjets) {
        this.selectedProjets = selectedProjets;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    public void affectEmployee(){
        this.selectedProjets.forEach(p->{
            EmployeeProject ep = new EmployeeProject(p, selectedEmployee, taux);
            selectedEmployee.addProject(ep);
            p.addEmployee(ep);
        });

        employeeRepository.addEmployee(selectedEmployee);
    }
}
