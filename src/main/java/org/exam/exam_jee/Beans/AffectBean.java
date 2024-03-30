package org.exam.exam_jee.Beans;

import jakarta.annotation.PostConstruct;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ViewScoped;
import org.exam.exam_jee.Models.Employee;
import org.exam.exam_jee.Models.Projet;
import org.exam.exam_jee.Repositories.EmployeeProjectRepository;
import org.exam.exam_jee.Repositories.EmployeeRepository;
import org.exam.exam_jee.Repositories.ProjectRepository;

import java.io.IOException;
import java.util.List;


@ManagedBean
@ViewScoped
public class AffectBean {

    private List<Employee> employees;
    private List<Projet> projets;
    private ProjectRepository projectRepository;
    private EmployeeRepository employeeRepository;
    private EmployeeProjectRepository employeeProjectRepository;


    private Employee selectedEmployee;
    private String selectedEmployeeId;
    private Projet selectedProjet;
    private String selectedProjetId;
    private String progress;



    @PostConstruct
    public void init(){
        selectedEmployee = new Employee();
        selectedProjet = new Projet();

        projectRepository = new ProjectRepository();
        employeeRepository = new EmployeeRepository();
        employeeProjectRepository = new EmployeeProjectRepository();
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

    public String getSelectedEmployeeId() {
        return selectedEmployeeId;
    }

    public void setSelectedEmployeeId(String selectedEmployeeId) {
        this.selectedEmployeeId = selectedEmployeeId;
    }

    public String getSelectedProjetId() {
        return selectedProjetId;
    }

    public void setSelectedProjetId(String selectedProjetId) {
        this.selectedProjetId = selectedProjetId;
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

    public Projet getSelectedProjet() {
        return selectedProjet;
    }

    public void setSelectedProjet(Projet selectedProjet) {
        this.selectedProjet = selectedProjet;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public EmployeeProjectRepository getEmployeeProjectRepository() {
        return employeeProjectRepository;
    }

    public void setEmployeeProjectRepository(EmployeeProjectRepository employeeProjectRepository) {
        this.employeeProjectRepository = employeeProjectRepository;
    }

    public void save(){
        selectedEmployee = employeeRepository.find(Long.parseLong(selectedEmployeeId));
        selectedProjet = projectRepository.find(Long.parseLong(selectedProjetId));

        if(selectedEmployee.getId() != 0L && selectedProjet.getId() != 0L){
            employeeProjectRepository.saveEmployeeProject(selectedEmployee, selectedProjet, Double.parseDouble(progress));
            IndexBean.employees = employeeRepository.selectAll();
            NavigationBean.redirectToIndexPage();
        }
    }



}
