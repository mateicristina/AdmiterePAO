package services;

import com.participant.candidat.Candidat;
import com.participant.dosar.Dosar;
import com.participant.examen.Examen;
import com.unibuc.facultate.Facultate;
import com.unibuc.specializare.Specializare;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FileTextService {
    private static FileTextService ourInstance = new FileTextService();

    public static FileTextService getInstance() {
        return ourInstance;
    }

    private FileTextService() {
    }


    public void writeTextToFile (String textToWrite, String fileNamePath) {

        try {
            PrintWriter printWriter = new PrintWriter(
                    new FileOutputStream(fileNamePath));

            printWriter.println(textToWrite);

            printWriter.flush();
            printWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

//    /**
//     *
//     * @param fileNamePath
//     * @return
//     */
    public Facultate readFacultateFromFile(String fileNamePathFacultate, String fileNamePathSpecializare) {
        Facultate facultate = null;
        List<Specializare> specializari = new ArrayList<Specializare>();
        try {

            LineNumberReader lineNumberReader = new LineNumberReader(
                    new FileReader(fileNamePathFacultate));

            String line = lineNumberReader.readLine();
            String[] values = line.split(",");
//          facultate = new Facultate("nume", "strada", 300, 3);

            LineNumberReader lineNumberReaderSpec = new LineNumberReader(
                    new FileReader(fileNamePathSpecializare));

            String lineSpec = lineNumberReaderSpec.readLine();
            while( lineSpec != null ){
                String[] valuesSpec = lineSpec.split(",");
                Specializare s = new Specializare(valuesSpec[0], Integer.parseInt(valuesSpec[1]), valuesSpec[2]);
                specializari.add(s);
                lineSpec = lineNumberReaderSpec.readLine();
            }
            facultate = new Facultate(values[0], values[1], Integer.parseInt(values[2]), Integer.parseInt(values[3]), specializari);
            lineNumberReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        return facultate;
    }

    public Dosar readDosarFromFile(String fileNamePath) {
        Dosar dosar = null;
        try {

            LineNumberReader lineNumberReader = new LineNumberReader(
                    new FileReader(fileNamePath));

            String line = lineNumberReader.readLine();

            String[] values = line.split(",");
            int nrDoc = 4;
//            nrDoc = Integer.parseInt(values[0]);    // nu parseaza bine int-ul
//            System.out.println(nrDoc);
            List<String> docs = new ArrayList<String>();
            for ( int i = 1; i <= nrDoc; i++ )
            {
                docs.add(values[i]);
            }
            dosar = new Dosar(nrDoc, docs);
            lineNumberReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dosar;
    }

    public Candidat readCandidatFromFile( String fileNamePath){
        Candidat candidat = null;
        Examen examen = null;
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(
                    new FileReader(fileNamePath));

            String line = lineNumberReader.readLine();
            String[] values = line.split(",");


            Dosar dosar = readDosarFromFile("/Users/cristinamatei/Desktop/AdmiterePAO/files/dosare_candidati.csv");
            examen = new Examen(Integer.parseInt(values[5]), Integer.parseInt(values[6]), Integer.parseInt(values[7]));
            SimpleDateFormat simpleDateFormat =
                    new SimpleDateFormat("dd/MM/yyyy");
            candidat = new Candidat(values[0], values[1], values[2], simpleDateFormat.parse(values[3]),Integer.parseInt(values[4]), dosar,examen);

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        return candidat;
    }



}

