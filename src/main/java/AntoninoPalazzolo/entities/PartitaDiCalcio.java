package AntoninoPalazzolo.entities;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class PartitaDiCalcio extends Evento {
    private String squadraDiCasa;
    private String squadraOspite;
    private String squadraVincente;
    private int numeroGolSquadraDiCasa;
    private int numeroGolSquadraOspite;

    public PartitaDiCalcio(String titolo, LocalDate dataEvento, TipoEvento tipoEvento,
                           int numeroMassimoPartecipanti, String squadraDiCasa,
                           String squadraOspite) {
        super(titolo, dataEvento, tipoEvento, numeroMassimoPartecipanti);
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
    }
}
