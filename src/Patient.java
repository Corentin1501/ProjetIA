import java.util.ArrayList;
import java.util.List;

public class Patient {

    String _nom;
    int _age;
    List<Symptome> _symptomesDuPatient;

    public Patient(String nom, int age, List<Symptome> symptomes){
        this._nom = nom;
        this._age = age;
        this._symptomesDuPatient = new ArrayList<Symptome>();

        for (Symptome s : symptomes) {
            this._symptomesDuPatient.add(s);
        }
    }
 
}