package services;

import com.participant.candidat.Candidat;
import com.unibuc.facultate.Facultate;

public class service {

    public Facultate addFacultate(){
        Facultate f = ConsoleTextService.getInstance().readConsoleFacultate();
        return f;
    }

    public Candidat addCandidat(){
        Candidat c = ConsoleTextService.getInstance().readConsoleCandidat();
        return c;
    }

    public void addSpecializare( Facultate f ){

    }

}
