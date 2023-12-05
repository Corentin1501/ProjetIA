import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

public class View {
    public JFrame jFrame;

    private JCheckBox courbature, fatigue, fievre, toux, sueurs, mauxDeTete, pression, bonMedecin;

    public View(){
        this.jFrame = new JFrame("Menu des symptômes");

        // Création de la fenre au milieu de l'écran

            jFrame.setSize(new Dimension(800, 400));

            Dimension windowSize = jFrame.getSize();
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            Point centerPoint = ge.getCenterPoint();
            int dx = centerPoint.x - windowSize.width / 2;
            int dy = centerPoint.y - windowSize.height / 2;
            jFrame.setLocation(dx, dy);

            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Création de tous les éléments

            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Ajout de marges

            
            Font font = new Font("Comfortaa", Font.PLAIN, 20);  // Création d'une police pour les labels et les cases à cocher

            //################### HAUT DE LA PAGE #########################

                //------- Age -------

                    JPanel panelAge = new JPanel();
                    panelAge.setLayout(new GridLayout(1, 2));

                    JLabel labelAge = new JLabel("Age : ");
                        JTextField inputAge = new JTextField();
                    
                        labelAge.setFont(font);

                        panelAge.add(labelAge);
                        panelAge.add(inputAge);
                    panel.add(panelAge, BorderLayout.PAGE_START);
                
            //################### CENTRE DE LA PAGE #########################

                //------- Cases symptômes -------

                    JPanel panelTitreEtSymptomes = new JPanel();
                    panelTitreEtSymptomes.setLayout(new GridLayout(3, 1));
                    
                    JLabel labelTitre = new JLabel("----------------------------- Symptômes que vous présentez -----------------------------");
                    labelTitre.setFont(font);
                    panelTitreEtSymptomes.add(labelTitre);
                    
                    JPanel panelSymptomes = new JPanel();
                    panelSymptomes.setLayout(new GridLayout(4, 2));

                    courbature = new JCheckBox();
                    fatigue = new JCheckBox();
                    fievre = new JCheckBox();
                    toux = new JCheckBox();
                    sueurs = new JCheckBox();
                    mauxDeTete = new JCheckBox();
                    pression = new JCheckBox();
                    bonMedecin = new JCheckBox();

                    courbature.setText("Courbatures");
                    fatigue.setText("Fatigue");
                    fievre.setText("Fièvre");
                    toux.setText("Toux");
                    sueurs.setText("Sueurs froides");
                    mauxDeTete.setText("Maux de têtes");
                    pression.setText("Pression élevée");
                    bonMedecin.setText("Possède un bon médecin");

                    courbature.setFont(font);
                    fatigue.setFont(font);
                    fievre.setFont(font);
                    toux.setFont(font);
                    sueurs.setFont(font);
                    mauxDeTete.setFont(font);
                    pression.setFont(font);
                    bonMedecin.setFont(font);
                    
                    panelSymptomes.add(courbature);
                    panelSymptomes.add(fatigue);
                    panelSymptomes.add(fievre);
                    panelSymptomes.add(toux);
                    panelSymptomes.add(sueurs);
                    panelSymptomes.add(mauxDeTete);
                    panelSymptomes.add(pression);
                    panelSymptomes.add(bonMedecin);

                    panelTitreEtSymptomes.add(panelSymptomes);
                    panel.add(panelTitreEtSymptomes, BorderLayout.CENTER);

            //################### BAS DE LA PAGE #########################

                JPanel panelBas = new JPanel();
                panelBas.setLayout(new GridLayout(2, 1));

                //------- Méthodes -------

                JPanel panelMethodes = new JPanel();
                panelMethodes.setLayout(new GridLayout(1, 2));

                JTextField inputBut = new JTextField();

                String[] methodes = {"Chaînage Avant", "Chaînage Arrière"};
                JComboBox<String> methode = new JComboBox<>(methodes);
                inputBut.setEnabled(false);
                inputBut.setBackground(Color.lightGray);

                methode.addActionListener(new ActionListener() {//add actionlistner to listen for change
                    @Override
                    public void actionPerformed(ActionEvent e) {
                
                        String s = (String) methode.getSelectedItem();//get the selected item
                
                        switch (s) {//check for a match
                            case "Chaînage Avant":   inputBut.setEnabled(false); inputBut.setBackground(Color.lightGray); break;
                            case "Chaînage Arrière": inputBut.setEnabled(true);  inputBut.setBackground(Color.white);  break;
                            default:                 inputBut.setEnabled(false); inputBut.setBackground(Color.lightGray); break;
                        }
                    }
                });

 

                panelMethodes.add(Box.createHorizontalGlue()); // Ajout d'un espace horizontal
                panelMethodes.add(methode);
                panelMethodes.add(inputBut);
                panelMethodes.add(Box.createHorizontalGlue()); // Ajout d'un espace horizontal



                //------- Boutons -------
                    
                    JButton boutonEvaluate = new JButton("Évaluer");
                    JButton boutonQuit = new JButton("Quitter");

                    boutonEvaluate.setFont(font);
                    boutonQuit.setFont(font);

                    //-------- Actions des boutons --------

                        boutonEvaluate.addActionListener( new ActionListener() {
                            public void actionPerformed(ActionEvent evenement) {
                                // Récupération de toutes les données

                                    // base de faits
                                        ArrayList<String> baseFait = new ArrayList<String>();
                                        if (courbature.isSelected()) baseFait.add("COURBATURE");
                                        if (fatigue.isSelected()) baseFait.add("FATIGUE");
                                        if (fievre.isSelected()) baseFait.add("FIEVRE");
                                        if (toux.isSelected()) baseFait.add("TOUX");
                                        if (sueurs.isSelected()) baseFait.add("SUEURS_FROIDES");
                                        if (mauxDeTete.isSelected()) baseFait.add("MAUX_DE_TETE");
                                        if (pression.isSelected()) baseFait.add("PRESSION");
                                        if (bonMedecin.isSelected()) baseFait.add("PAS_BON_MEDECIN");
                                        if (Integer.parseInt(inputAge.getText()) > 80) baseFait.add("VIEUX");

                                    // base de regles

                                        Br baseDeRegles = new Br();
                                        readRulesFromFile(baseDeRegles);

                                    for (String fait : baseFait) {
                                        System.out.println(fait + ", ");
                                    }
                                    System.out.println(baseDeRegles.toString());

                                    ViewResults resultats = new ViewResults((String) methode.getSelectedItem(), baseFait, baseDeRegles);
                                    


                            }
                        });

                        boutonQuit.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent evenement) {
                                jFrame.dispose();
                            }
                        });
                    
                    JPanel panelBoutons = new JPanel();
                    panelBoutons.setLayout(new BoxLayout(panelBoutons, BoxLayout.X_AXIS));

                    panelBoutons.add(Box.createHorizontalGlue());
                    panelBoutons.add(boutonEvaluate);
                    panelBoutons.add(Box.createHorizontalStrut(10)); // Ajout d'un espace horizontal entre les boutons
                    panelBoutons.add(boutonQuit);
                    panelBoutons.add(Box.createHorizontalGlue());

                    //-----------------------

                    panelBas.add(panelMethodes);
                    panelBas.add(panelBoutons);
                    panel.add(panelBas, BorderLayout.PAGE_END);

            //#######################################################

            // panel.setBackground(Color.DARK_GRAY);

            jFrame.setContentPane(panel);
            jFrame.setVisible(true);
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
