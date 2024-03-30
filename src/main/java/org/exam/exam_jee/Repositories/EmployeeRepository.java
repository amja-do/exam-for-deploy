package org.exam.exam_jee.Repositories;

import org.exam.exam_jee.Config.DB;
import org.exam.exam_jee.Models.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.exam.exam_jee.Models.Projet;

import java.util.List;

public class EmployeeRepository {
    

    EntityManager entityManager;

    public EmployeeRepository(){
        entityManager = DB.getEntityManager();
    }

    public List<Employee> selectAll(){
        DB.clearCache();
        return entityManager.createNamedQuery("employee.findAll").getResultList();
    }

    public void addEmployee(Employee employee){
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
    }

    public void removeEmployee(Employee employee){
        entityManager.getTransaction().begin();
        entityManager.remove(employee);
        entityManager.getTransaction().commit();
    }

    public Employee find(Long id){
        return entityManager.find(Employee.class, id);
    }


}
