package com.participant.examen;


public class Examen {
    private Float notaExamen;
    private int salaExamen;
    private int idExamen;

    public Examen(int idExamen, int salaExamen, Float notaExamen) {
        this.notaExamen = notaExamen;
        this.salaExamen = salaExamen;
        this.idExamen = idExamen;
    }

    public Float getNotaExamen() { return notaExamen; }

    public int getSalaExamen() { return salaExamen; }

    public int getIdExamen() { return idExamen; }

    public void setNotaExamen(Float notaExamen) { this.notaExamen = notaExamen; }

    public void setSalaExamen(int salaExamen) { this.salaExamen = salaExamen; }

    public void setIdExamen(int idExamen) { this.idExamen = idExamen; }
}
