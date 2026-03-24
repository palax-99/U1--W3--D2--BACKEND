package AntoninoPalazzolo.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity // annotazione obbligatoria per le entities
@Table(name = "Eventi") //Affibbio il nome alla tabella che mi sembra piu appropriato
public class Evento {
    @Id // per stabilire la primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // serve per generare automaticamente l'id
    @Column(name = "evento_id")// creo la colonna e gli inserisco il nome che ritengo piu opportuno
    private long id;
    @Column(name = "titolo_evento")
    private String titolo;
    @Column(name = "data_evento")
    private LocalDate dataEvento;
    @Column// prima della creazione devo impostare la classe enum
}
