package AntoninoPalazzolo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("u1w3d2");
    //mi sono assicurato di essere connesso al database

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        System.out.println("Hello World!");
    }
}
