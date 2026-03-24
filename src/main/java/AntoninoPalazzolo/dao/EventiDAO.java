package AntoninoPalazzolo.dao;

import AntoninoPalazzolo.entities.Evento;
import AntoninoPalazzolo.exceptions.provaException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;


public class EventiDAO {

    private final EntityManager entityManager;

    public EventiDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Evento newEvento) {//creo il metodo per salavare la colonna all'interno della tabella
        // 1. sto crendo una nuova transizione
        EntityTransaction transaction = this.entityManager.getTransaction();

        transaction.begin(); //2 con questo comando faccio partire la transizione
        entityManager.persist(newEvento);//3 lo faccio diventare MANAGED, in quella fase di transione prima di far parte del db

        transaction.commit();//$ creo la nuova riga della tabella facendo il commit ed enrea a far parte del database

        System.out.println("L'evento" + newEvento.getTitolo() + " è stato salvato con successo!");
        //5 controllo per vedere se l'operazione è andata a buon fine
    }

    public Evento foundById(long id) {
        Evento found = entityManager.find(Evento.class, id);
        System.out.println("L'evento è stato trovato");
        if (found == null) throw new provaException(id);
        return found;
    }

}
