package com.participant.persoana;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Scanner;

public class Persoana {
    private String cnp;
    private String nume, prenume;
    private String data_nasterii;

    public Persoana(String cnp, String nume, String prenume, String data_nasterii) {
        this.cnp = cnp;
        this.nume = nume;
        this.prenume = prenume;
        this.data_nasterii = data_nasterii;
    }
    public Persoana(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("CNP : ");
            setCnp( reader.readLine());
            System.out.print("Nume : ");
            setNume( reader.readLine());
            System.out.print("Prenume : ");
            setPrenume(reader.readLine());
            System.out.print("Data nasterii : ");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setCnp(String cnp) { this.cnp = cnp; }

    public void setNume(String nume) { this.nume = nume; }

    public void setPrenume(String prenume) { this.prenume = prenume; }

    public void setData_nasterii(String data_nasterii) { this.data_nasterii = data_nasterii; }

    public String getCnp() { return cnp; }

    public String getNume() { return nume; }

    public String getPrenume() { return prenume; }

    public String getData_nasterii() { return data_nasterii; }
}
