package com.participant.candidat;

import com.participant.dosar.Dosar;
import com.participant.examen.Examen;
import com.participant.persoana.Persoana;

import java.util.Date;

public class Candidat extends Persoana {
    private Float medieAdmitere;
    private Dosar dosar;
    private Examen examen;



    public Candidat(String cnp, String nume, String prenume, String data_nasterii, Float medieAdmitere, Dosar dosar, Examen examen) {
        super(cnp, nume, prenume, data_nasterii);
        this.medieAdmitere = medieAdmitere;
        this.dosar = dosar;
        this.examen = examen;
    }

    public Candidat(String cnp, String nume, String prenume, String data_nasterii, Float medieAdmitere) {
        super(cnp, nume, prenume, data_nasterii);
        this.medieAdmitere = medieAdmitere;
    }

    public Float getMedieAdmitere() { return medieAdmitere; }

    public void setMedieAdmitere(Float medieAdmitere) { this.medieAdmitere = medieAdmitere; }

    public Dosar getDosar() { return dosar; }

    public Examen getExamen() { return examen; }

    public void setDosar(Dosar dosar) { this.dosar = dosar; }

    public void setExamen(Examen examen) { this.examen = examen; }
}
