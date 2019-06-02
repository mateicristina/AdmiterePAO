package services;

import com.participant.candidat.Candidat;
import com.participant.dosar.Dosar;
import com.participant.examen.Examen;
import com.unibuc.facultate.Facultate;
import com.unibuc.specializare.Specializare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ConsoleTextService {

    private static ConsoleTextService ourInstance = new ConsoleTextService();

    public static ConsoleTextService getInstance() {
        return ourInstance;
    }

    private ConsoleTextService() {
    }

    public Facultate readConsoleFacultate(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);
        String nameFacultate = null;
        String adressFacultate = null;
        Integer nrLocuri = 0, nrSpec = 0;
        List<Specializare> specializari = new ArrayList<Specializare>();
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

        for ( int i = 0; i < nrSpec; i++ )
        {
            specializari.add(ConsoleTextService.getInstance().readConsoleSpecializare());
        }
        Facultate f = new Facultate(nameFacultate, adressFacultate, nrLocuri, nrSpec, specializari);
        return f;
    }


    public Specializare readConsoleSpecializare(){
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
        List<Candidat> c = new ArrayList<Candidat>();
        System.out.println("Cititi nr de candidati: ");
        int nrC = in.nextInt();
        for ( int i = 0; i < nrC; i++ )
        {
            c.add(ConsoleTextService.getInstance().readConsoleCandidat());
        }
        Specializare s = new Specializare(numeS, nrLoc, tipAdmitere, nrC, c);
        return s;
    }

    public Candidat readConsoleCandidat(){
//        public Candidat(String cnp, String nume, String prenume, Date data_nasterii, Integer medieAdmitere, Dosar dosar, Examen examen) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);

        Candidat c = null;

        String cnp, nume, prenume;
        String data_nasterii;
        Float medieAdmitere;
        Dosar dosar;
        Examen examen;

        try {
            System.out.print("CNP : ");
            cnp = reader.readLine();
            System.out.print("Nume : ");
            nume = reader.readLine();
            System.out.print("Prenume : ");
            prenume = reader.readLine();
            System.out.println("Data nasterii: ");
            // citire data
//            Calendar calendar = Calendar.getInstance();
//            calendar.set(1980, 0, 20);
//            data_nasterii = calendar.getTime();
            data_nasterii = reader.readLine();
            //System.out.println(date);

            System.out.println("Medie admitere: ");
            medieAdmitere = in.nextFloat();


            // Documente
            System.out.println("Nr documente: ");
            int nrDoc = in.nextInt();
            List<String> d = new ArrayList<String>();
            for ( int i = 0; i < nrDoc; i++ ){
                d.add(reader.readLine());
            }
            dosar = new Dosar(nrDoc, d);

            // Examen
            //nota,sala,id
            System.out.println("ID-ul candidatului la examen: ");
            int id = in.nextInt();
            System.out.println("Sala: ");
            int sala = in.nextInt();
            System.out.println("Nota: ");
            Float nota = in.nextFloat();

            examen = new Examen(id, sala, nota);
            c = new Candidat(cnp, nume, prenume, data_nasterii, medieAdmitere, dosar, examen);

        } catch (IOException e){
            e.printStackTrace();
        }
        return c;
    }
}
