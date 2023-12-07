
import java.io.*;
import java.util.*;

public class App {
     // base de faits pour Chainage avant
    public static ArrayList<String> baseFaitAvant = new ArrayList<String>();
     // base de faits pour Chainage arriere
    public static ArrayList<String> baseFaitArriere = new ArrayList<String>();

    public static void main(String[] args) throws Exception {

        //################################################
        //                    DONNÉES                    #
        //################################################

            //--------- BUTS ---------
            
                // String but = new String();
                // ArrayList<String> ensembleDeButs = new ArrayList<String>();
            
            //--------- BASE DE RÈGLES ---------
        
                // base de regles
                // Br baseDeRegles = new Br();

            //-----------------------------------

            // readFromFile( ensembleDeButs,  baseFaitAvant,  baseDeRegles );

            // but += ensembleDeButs.get(0);

            // System.out.println(baseFaitAvant.toString());
            // System.out.println(baseDeRegles.toString());

        //################################################
        //                CHAINAGE AVANT                 #
        //################################################
        
            System.out.println("------------------- Chainage Avant: -------------------\n");
            
            // ChainageAvant.solve(baseFaitAvant,baseDeRegles,but);
            
            System.out.println("\n-------------------------------------------------------");
            
        //################################################
        //               CHAINAGE ARRIERE                #
        //################################################
            
            System.out.println("------------------- Chainage Arrière: -------------------\n");

            // reactivater toutes les règles si utilisés après le chainage avant  
            // baseDeRegles.init();

            // System.out.println( ChainageArriere.solve(baseFaitArriere, baseDeRegles, ensembleDeButs)? "La regle " + but + " est etabli\n": "La regle " + but + " n'est pas etabli\n" );

            System.out.println("Base des faits apres l'application du chainage arriere: \n" + baseFaitArriere.toString() +"\n");
            
            System.out.println("\n-------------------------------------------------------");
            
        //################################################

        View menu = new View();
        menu.show();
        
    }

    public static void readFromFile(ArrayList<String> ensembleDeButs, ArrayList<String> baseFaitAvant, Br baseDeRegles){
        BufferedReader reader;
        
        try {
            reader = new BufferedReader(new FileReader("data/test.txt"));
            // read first line 
            String line = reader.readLine();
            ensembleDeButs.add(line.strip());
            
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
    public static void readRulesFromFile(Br baseDeRegles){
        BufferedReader reader;
        
        try {
            reader = new BufferedReader(new FileReader("data/regles.txt"));

            String line = reader.readLine();
            
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