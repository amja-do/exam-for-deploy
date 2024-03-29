package org.exam.exam_jee.Repositories;

import org.exam.exam_jee.Models.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.exam.exam_jee.Models.Projet;

import java.util.List;

public class EmployeeRepository {
    
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;

    public EmployeeRepository(String name){
        entityManagerFactory = Persistence.createEntityManagerFactory(name);
        entityManager = entityManagerFactory.createEntityManager();
    }

    public List<Employee> selectAll(){
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


}
