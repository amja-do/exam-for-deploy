package org.exam.exam_jee.Config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DB {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    private DB(){}



    public static EntityManager getEntityManager(){
        if (DB.entityManager == null) {
            DB.entityManagerFactory = Persistence.createEntityManagerFactory("mysql-eclipselink");
            DB.entityManager = entityManagerFactory.createEntityManager();
        }
        return DB.entityManager;
    }

    public static void clearCache(){
        if(DB.entityManager != null){
            entityManager.getEntityManagerFactory().getCache().evictAll();
            entityManager.clear();
        }
    }
}
