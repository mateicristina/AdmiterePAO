package com.unibuc.specializare;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Specializare {
    private String numeSpecializare;
    private int nrLocuriSpecializare;
    private String tipAdmitereSpecializare;

    public Specializare(String numeSpecializare, int nrLocuriSpecializare, String tipAdmitereSpecializare) {
        this.numeSpecializare = numeSpecializare;
        this.nrLocuriSpecializare = nrLocuriSpecializare;
        this.tipAdmitereSpecializare = tipAdmitereSpecializare;
    }

    public Specializare(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);
        String numeS = null;
        String tipAdmitere = null;
        Integer nrLoc = 0;

        try {
            System.out.print("Numele Specializarii : ");
            numeS = reader.readLine();
            System.out.print("Nr Locuri : ");
            nrLoc = in.nextInt();
            System.out.print("Tip Admitere : ");
            tipAdmitere = reader.readLine();
        } catch (IOException e){
            e.printStackTrace();
        }
        this.numeSpecializare = numeS;
        this.nrLocuriSpecializare = nrLoc;
        this.tipAdmitereSpecializare = tipAdmitere;
    }

    public void setNumeSpecializare(String numeSpecializare) { this.numeSpecializare = numeSpecializare; }

    public void setNrLocuriSpecializare(int nrLocuriSpecializare) { this.nrLocuriSpecializare = nrLocuriSpecializare; }

    public void setTipAdmitereSpecializare(String tipAdmitereSpecializare) { this.tipAdmitereSpecializare = tipAdmitereSpecializare; }

    public String getNumeSpecializare() { return numeSpecializare; }

    public int getNrLocuriSpecializare() { return nrLocuriSpecializare; }

    public String getTipAdmitereSpecializare() { return tipAdmitereSpecializare; }
}
