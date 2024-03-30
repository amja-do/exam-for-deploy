package org.exam.exam_jee.Repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.exam.exam_jee.Config.DB;
import org.exam.exam_jee.Models.Employee;
import org.exam.exam_jee.Models.EmployeeProject;
import org.exam.exam_jee.Models.Projet;

import java.util.List;

public class EmployeeProjectRepository {

    EntityManager entityManager;

    public EmployeeProjectRepository(){
        entityManager = DB.getEntityManager();
    }
    public void saveEmployeeProject(Employee employee, Projet projet, double taux){
        DB.clearCache();
        entityManager.getTransaction().begin();
        EmployeeProject existingEmployeeProject = this.findByEmployeeAndProject(employee, projet);

        if (existingEmployeeProject != null) {
            existingEmployeeProject.setTaux(taux);
            entityManager.getTransaction().commit();

        } else {
            EmployeeProject newEmployeeProject = new EmployeeProject(projet, employee, taux);
            employee.addProject(newEmployeeProject);
            projet.addEmployee(newEmployeeProject);
            entityManager.persist(newEmployeeProject);
            entityManager.getTransaction().commit();
        }


    }

    private EmployeeProject findByEmployeeAndProject(Employee employee, Projet projet){
        TypedQuery<EmployeeProject> query = entityManager.createQuery(
                "SELECT ep FROM EmployeeProject ep WHERE ep.employee = :employee AND ep.project = :project",
                EmployeeProject.class
        );
        query.setParameter("employee", employee);
        query.setParameter("project", projet);
        List<EmployeeProject> resultList = query.getResultList();
        if (!resultList.isEmpty()) {
            return resultList.get(0);
        } else {
            return null;
        }
    }
}
