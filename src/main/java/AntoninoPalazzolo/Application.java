package AntoninoPalazzolo;

import AntoninoPalazzolo.dao.EventiDAO;
import AntoninoPalazzolo.entities.Evento;
import AntoninoPalazzolo.entities.TipoEvento;
import AntoninoPalazzolo.exceptions.provaException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("u1w3d2");
    //mi sono assicurato di essere connesso al database

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EventiDAO EventiDAO = new EventiDAO(entityManager);
        Evento evento1 = new Evento("Concerto", LocalDate.of(2025, 7, 5), TipoEvento.PUBBLICO, 100);
        Evento evento2 = new Evento(
                "Conferenza Tech",
                LocalDate.of(2026, 9, 10),
                TipoEvento.PUBBLICO,
                200
        );

        Evento evento3 = new Evento(
                "Festa Privata",
                LocalDate.of(2026, 6, 5),
                TipoEvento.PRIVATO,
                50
        );
        EventiDAO.save(evento1); // testo il metodo save
        EventiDAO.save(evento2);
        EventiDAO.save(evento3);

        EventiDAO.foundById(1); // testo il metodo
        try {
            Evento eventoFromDB = EventiDAO.foundById(25); // metodo piu sicuro perchè gestisce gli errori
            System.out.println(eventoFromDB);
        } catch (provaException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("Hello World!");

        entityManager.close();
        entityManagerFactory.close();
    }
}
