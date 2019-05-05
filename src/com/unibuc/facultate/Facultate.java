package com.unibuc.facultate;

import com.unibuc.admitere.Admitere;
import com.unibuc.specializare.Specializare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Facultate {
    private String numeFacultate;
    private String adresaFacultate;
    private int nrLocuriTotal;
    private int nrSpecializari;
    private List<Specializare> specializari = new ArrayList();
//    private Admitere admitere;


    public Facultate(String numeFacultate, String adresaFacultate, int nrLocuriTotal, int nrSpecializari, List<Specializare> specializari) {
        this.numeFacultate = numeFacultate;
        this.adresaFacultate = adresaFacultate;
        this.nrLocuriTotal = nrLocuriTotal;
        this.nrSpecializari = nrSpecializari;
        this.specializari = specializari;
//        this.admitere = admitere;
    }

    public Facultate(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);
        String nameFacultate = null;
        String adressFacultate = null;
        Integer nrLocuri = 0, nrSpec = 0;
        try {
            System.out.print("Numele Facultatii : ");
            nameFacultate = reader.readLine();
            System.out.print("Adresa Facultatii : ");
            adressFacultate = reader.readLine();
            System.out.print("Nr locuri : ");
            nrLocuri = in.nextInt();
            System.out.print("Nr Specializari : ");
            nrSpec = in.nextInt();

        } catch (IOException e) {
            e.printStackTrace();
        }

        this.numeFacultate = nameFacultate;
        this.adresaFacultate = adressFacultate;
        this.nrLocuriTotal = nrLocuri;
        this.nrSpecializari = nrSpec;
        for ( int i = 0; i < nrSpec; i++ )
        {
            this.specializari.add(new Specializare());
        }
    }

    public Facultate(String numeFacultate, String adresaFacultate, int nrLocuriTotal, int nrSpecializari ){
        this.numeFacultate = numeFacultate;
        this.adresaFacultate = adresaFacultate;
        this.nrLocuriTotal = nrLocuriTotal;
        this.nrSpecializari = nrSpecializari;

        for ( int i = 0; i < nrSpecializari; i++ )
        {
            this.specializari.add(new Specializare());
        }
    }

    public void setNumeFacultate(String numeFacultate) { this.numeFacultate = numeFacultate; }

    public void setAdresaFacultate(String adresaFacultate) { this.adresaFacultate = adresaFacultate; }

    public void setNrLocuriTotal(int nrLocuriTotal) { this.nrLocuriTotal = nrLocuriTotal; }

    public void setNrSpecializari(int nrSpecializari) { this.nrSpecializari = nrSpecializari; }

    public void setSpecializari(List<Specializare> specializari) { this.specializari = specializari; }

    public String getNumeFacultate() { return numeFacultate; }

    public String getAdresaFacultate() { return adresaFacultate; }

    public int getNrLocuriTotal() { return nrLocuriTotal; }

    public int getNrSpecializari() { return nrSpecializari; }

    public List<Specializare> getSpecializari() { return specializari; }
}
