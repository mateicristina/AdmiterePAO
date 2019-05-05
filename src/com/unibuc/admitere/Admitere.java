package com.unibuc.admitere;

import com.participant.candidat.Candidat;

import java.util.List;

public class Admitere {
    private int nrCandidati;
    private List<Candidat> listaCandidati;
    private String tipProbaAdmitere;

    public Admitere(int nrCandidati, List<Candidat> listaCandidati, String tipProbaAdmitere) {
        this.nrCandidati = nrCandidati;
        this.listaCandidati = listaCandidati;
        this.tipProbaAdmitere = tipProbaAdmitere;
    }

    public Admitere( String File ) {

    }

    public void setNrCandidati(int nrCandidati) { this.nrCandidati = nrCandidati; }

    public void setListaCandidati(List<Candidat> listaCandidati) { this.listaCandidati = listaCandidati; }

    public void setTipProbaAdmitere(String tipProbaAdmitere) { this.tipProbaAdmitere = tipProbaAdmitere; }

    public int getNrCandidati() { return nrCandidati; }

    public List<Candidat> getListaCandidati() { return listaCandidati; }

    public String getTipProbaAdmitere() { return tipProbaAdmitere; }
}
