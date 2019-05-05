package com.participant.persoana;

import java.util.Date;

public class Persoana {
    private String cnp;
    private String nume, prenume;
    private Date data_nasterii;

    public Persoana(String cnp, String nume, String prenume, Date data_nasterii) {
        this.cnp = cnp;
        this.nume = nume;
        this.prenume = prenume;
        this.data_nasterii = data_nasterii;
    }

    public void setCnp(String cnp) { this.cnp = cnp; }

    public void setNume(String nume) { this.nume = nume; }

    public void setPrenume(String prenume) { this.prenume = prenume; }

    public void setData_nasterii(Date data_nasterii) { this.data_nasterii = data_nasterii; }

    public String getCnp() { return cnp; }

    public String getNume() { return nume; }

    public String getPrenume() { return prenume; }

    public Date getData_nasterii() { return data_nasterii; }
}
