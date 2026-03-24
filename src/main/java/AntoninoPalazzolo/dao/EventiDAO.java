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

    public void findByIdAndDelete(long id) { // metodo per cancellare tramite ID
        // 1. Cerco l'evento tramite ID
        Evento found = this.foundById(id); // Riutilizzo il metodo di sopra

        // 2. sto chidendo all'Entity Manager di creare una nuova transazione
        EntityTransaction transaction = this.entityManager.getTransaction();

        // 3. Faccio partire la transazione
        transaction.begin();

        // 4. metodo per rimuovere dall'entityManager un evento e tramite il metodo remove
        entityManager.remove(found);

        // 5. Dobbiamo fare il commit in modo tale che venga definitivamente cancellato dal DB

        transaction.commit();

        // 6. siamo sicuri che sia stato cancellato
        System.out.println("L'evento " + found.getId() + " è stato eliminato con successo!");

    }
}
