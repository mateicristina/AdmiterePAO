package com.unibuc;

import com.unibuc.facultate.Facultate;
import services.ConsoleTextService;

import java.util.HashSet;
import java.util.Set;

public class Universitate {
    String nameUniversitate;
    String oras;
    int nrFacultati;
    Set<Facultate> facultati = new HashSet<Facultate>();

    public Universitate(String nameUniversitate, String strada, int nrFacultati, Set<Facultate> facultati) {
        this.nameUniversitate = nameUniversitate;
        this.oras = strada;
        this.nrFacultati = nrFacultati;
        this.facultati = facultati;
    }

    public void setNameUniversitate(String nameUniversitate) { this.nameUniversitate = nameUniversitate; }

    public void setOras(String strada) { this.oras = strada; }

    public void setNrFacultati(int nrFacultati) { this.nrFacultati = nrFacultati; }

    public void setFacultati(Set<Facultate> facultati) { this.facultati = facultati; }

    public String getNameUniversitate() { return nameUniversitate; }

    public String getOras() { return oras; }

    public int getNrFacultati() { return nrFacultati; }

    public Set<Facultate> getFacultati() { return facultati; }

    public void addFacultate( Facultate newFacultate ){
        facultati.add(newFacultate);
    }
    public void addFacultate(){
        Facultate newFacultate = ConsoleTextService.getInstance().readConsoleFacultate();
        facultati.add(newFacultate);
    }

}
