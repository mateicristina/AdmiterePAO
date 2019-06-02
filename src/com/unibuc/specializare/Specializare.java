package com.unibuc.specializare;

import com.participant.candidat.Candidat;
import java.util.ArrayList;
import java.util.List;

public class Specializare {
    private String numeSpecializare;
    private int nrLocuriSpecializare;
    private String tipAdmitereSpecializare;
    private Integer nrCandidati;
    private List<Candidat> candidati = new ArrayList<Candidat>();

    public Specializare(String numeSpecializare, int nrLocuriSpecializare, String tipAdmitereSpecializare, Integer nrCandidati ,List<Candidat> c) {
        this.numeSpecializare = numeSpecializare;
        this.nrLocuriSpecializare = nrLocuriSpecializare;
        this.tipAdmitereSpecializare = tipAdmitereSpecializare;
        this.nrCandidati = nrCandidati;
        this.candidati = c;
    }


    public void setNumeSpecializare(String numeSpecializare) { this.numeSpecializare = numeSpecializare; }

    public void setNrLocuriSpecializare(int nrLocuriSpecializare) { this.nrLocuriSpecializare = nrLocuriSpecializare; }

    public void setTipAdmitereSpecializare(String tipAdmitereSpecializare) { this.tipAdmitereSpecializare = tipAdmitereSpecializare; }

    public String getNumeSpecializare() { return numeSpecializare; }

    public int getNrLocuriSpecializare() { return nrLocuriSpecializare; }

    public String getTipAdmitereSpecializare() { return tipAdmitereSpecializare; }

    public List<Candidat> getCandidati(){ return candidati; }

    public void addCandidat(Candidat c ){ candidati.add(c); }

    public void setCandidati(List<Candidat> c){ this.candidati = c; }

    public void setNrCandidati(Integer nrCandidati) { this.nrCandidati = nrCandidati; }

    public Integer getNrCandidati() { return nrCandidati; }
}
