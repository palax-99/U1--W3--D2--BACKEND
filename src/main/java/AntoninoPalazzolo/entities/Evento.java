package AntoninoPalazzolo.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity // annotazione obbligatoria per le entities
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Eventi")
@DiscriminatorColumn(name = "event_type")
//Affibbio il nome alla tabella che mi sembra piu appropriato
public class Evento {
    @Id // per stabilire la primary key
    // serve per generare automaticamente l'id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // creo la colonna e gli inserisco il nome che ritengo piu opportuno
    private long id;
    @Column(name = "titolo_evento")
    private String titolo;
    @Column(name = "data_evento")
    private LocalDate dataEvento;
    @Enumerated(EnumType.STRING)//cambio il tipo di default
    @Column(name = "tipo_evento")// prima della creazione devo impostare la classe enum, dopo procedo
    private TipoEvento tipoEvento;
    @Column(name = "numero_massimo_partecipanti")
    private int numeroMassimoPartecipanti;

    protected Evento() {
    }//obbligatorio un costruttore vuoto

    public Evento(String titolo, LocalDate dataEvento, TipoEvento tipoEvento, int numeroMassimoPartecipanti) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    } // Creo il costruttore

    public long getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", tipoEvento=" + tipoEvento +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                '}';
    }
}
