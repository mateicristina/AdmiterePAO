import com.participant.candidat.Candidat;
import com.participant.dosar.Dosar;
import com.unibuc.facultate.Facultate;
import services.ConsoleTextService;
import services.FileTextService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.CancellationException;

public class main {
//    public ArrayList<Facultate> facultati = new ArrayList<>();

    public static void main(String[] args) {

        ArrayList<Facultate> facultati = new ArrayList<>();
    MyForm myForm = new MyForm();
    myForm.setVisible(true);

//        StringBuilder stringBuilder = new StringBuilder("");
//
//        Facultate c = FileTextService.getInstance().readFacultateFromFile(
//                "/Users/cristinamatei/Desktop/AdmiterePAO/files/facultati.csv", "/Users/cristinamatei/Desktop/AdmiterePAO/files/specializari.csv")  ;
//
//        Dosar d = FileTextService.getInstance().readDosarFromFile("/Users/cristinamatei/Desktop/AdmiterePAO/files/dosare.csv");
//        Facultate a = ConsoleTextService.getInstance().readConsoleFacultate();
//        Candidat candidat = FileTextService.getInstance().readCandidatFromFile("/Users/cristinamatei/Desktop/AdmiterePAO/files/candidati.csv");
//
//        System.out.println(candidat);



    }



    public static void performPropertiesWork() {


        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(
                    "./files2/application.properties"));

            for( String propName : properties.stringPropertyNames()) {
                System.out.println("prop name = " + propName
                        + ", values = " + properties.getProperty(propName));
            }

            properties.put("newProp", "value of a new prop");

            properties.store(new FileOutputStream(
                    "./files2/application.properties"), "comentariu");

        } catch (IOException e) {
            e.printStackTrace();
        }

        Path pathSrc = Paths.get("./files2/application.properties");
        Path pathDest = Paths.get("./files2/application-copy.properties");

        try {
            Files.copy(pathSrc, pathDest);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void stuff() {

//        User user = new User("my user name -00", new Date(),
//                "my secret password");
//
//
//        FileSerializableService.getInstance().writeObjectToFile(user,
//                "/Users/clyde/IdeaProjects/Laborator-07/files2/my-user-01.txt");
//
//
//        User otherUser = (User) FileSerializableService.getInstance().readObjectFromFile(
//                "/Users/clyde/IdeaProjects/Laborator-07/files2/my-user-01.txt");
//
//        System.out.println(otherUser);
//        User user = new User("first user", new Date(), "my hash password");
//
//        FileObjectSerializableService.getInstance().writeObjectToFile(user,
//                "/Users/clyde/IdeaProjects/Laborator-07/files/user.txt");
//
//        User newUser = (User) FileObjectSerializableService.getInstance()
//                .readObjectFromFile("/Users/clyde/IdeaProjects/Laborator-07/files/user.txt");
//
//        System.out.println(newUser);

//        RandomAccessFileService.getInstance()
//                .performTask("/Users/clyde/IdeaProjects/Laborator-07/files/task2.txt");

//
//        Properties properties = new Properties();
//        try {
//
//            properties.load(new
//                    FileInputStream("/Users/clyde/IdeaProjects/Laborator-07/files/application.properties"));
//            for(String key : properties.stringPropertyNames()) {
//                System.out.println("key = " + key + ", valoare = " + properties.get(key));
//            }
//
//            properties.put("prop3", "value 3");
//
//            properties.store(new FileOutputStream("/Users/clyde/IdeaProjects/Laborator-07/files/application.properties"),
//                    "");
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
