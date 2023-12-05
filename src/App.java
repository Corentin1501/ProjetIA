
import java.io.*;
import java.util.*;

public class App {
     // base de faits pour Chainage avant
    public static ArrayList<String> baseFaitAvant = new ArrayList<String>();
     // base de faits pour Chainage arriere
    public static ArrayList<String> baseFaitArriere = new ArrayList<String>();

    public static void main(String[] args) throws Exception {
        // fait
        String faits = new String();
        ArrayList<String> fVal = new ArrayList<String>();
       
       
        // base de regles
        Br baseDeRegles = new Br();

        // read date from file
        readFromFile( fVal,  baseFaitAvant,  baseDeRegles );
        // workaround for global string variable problem
        faits+=fVal.get(0);

        // print base de faits
        System.out.println(baseFaitAvant.toString());

        // Print base de regles;
        System.out.println(baseDeRegles.toString());


        
        
        //################################################
        //                CHAINAGE AVANT                 #
        //################################################
        
            System.out.println("------------------- Chainage Avant: -------------------\n");
            
            ChainageAvant.solve(baseFaitAvant,baseDeRegles,faits);
            
            System.out.println("\n-------------------------------------------------------");
            
        //################################################
        //               CHAINAGE ARRIERE                #
        //################################################
            
            System.out.println("------------------- Chainage Arrière: -------------------\n");

            // reactivater toutes les règles si utilisés après le chainage avant  
            baseDeRegles.init();

            System.out.println( ChainageArriere.solve(baseFaitArriere, baseDeRegles, fVal)? "La regle " + faits + " est etabli\n": "La regle " + faits + " n'est pas etabli\n" );

            System.out.println("Base des faits apres l'application du chainage arriere: \n" + baseFaitArriere.toString() +"\n");
            
            System.out.println("\n-------------------------------------------------------");
            
        //################################################
        
    }

    public static void readFromFile(ArrayList<String> faits, ArrayList<String> baseFaitAvant, Br baseDeRegles){
        BufferedReader reader;
        
        try {
            reader = new BufferedReader(new FileReader("data/test.txt"));
            // read first line 
            String line = reader.readLine();
            faits.add(line.strip());
            
            // read second line
            line = reader.readLine();
            baseFaitAvant.addAll(Arrays.asList(line.split(",")));
            baseFaitArriere.addAll(Arrays.asList(line.split(",")));
            

            line= reader.readLine();
            
            Regle regle ;
            String [] temp ;
            while(line !=null){
                temp = line.trim().split("\\s+");
                regle = new Regle(temp[0].trim(), temp[1].trim());
                baseDeRegles.addRegle(regle);
                line= reader.readLine();  

            }
            reader.close();
            
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }
}