import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class View {
    public JFrame jFrame;

    private JCheckBox courbature, fatigue, fievre, toux, sueurs, mauxDeTete, pression, bonMedecin, triNombrePremiss;

    private ViewResults resultats;

    private Br baseDeRegles = new Br();
    private Br baseDeReglesTriee = new Br();

    public View(){
        this.jFrame = new JFrame("Menu des symptômes");
        readRulesFromFile(baseDeRegles);

        for (Regle r : baseDeRegles.baseRegles) 
            baseDeReglesTriee = baseDeReglesTriee.addRegle(new Regle(r.nbr, r.premiss, r.action, r.active));
        
        baseDeReglesTriee.trierReglesParOrdreDecroissantDePremisses();
        System.out.println(baseDeRegles.toString());
        System.out.println(baseDeReglesTriee.toString());

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

            
            // personnalisation des labels
                Font labelFont = new Font("Segoe UI", Font.BOLD, 16); // Police Segoe UI en gras pour une meilleure lisibilité
                Color labelColor = Color.BLACK; // Couleur du texte en noir pour un bon contraste            
            // personnalisation des boutons
                Font buttonFont = new Font("Segoe UI", Font.BOLD, 14); // Police Segoe UI pour la modernité
                Color buttonTextColor = Color.WHITE; // Couleur du texte en blanc pour un contraste
                Color buttonBackgroundColor = new Color(51, 153, 255); // Couleur de fond bleu clair

            ArrayList<JComponent> liste_components = new ArrayList<>();
            ArrayList<JButton> liste_boutons = new ArrayList<>();


            //################### HAUT DE LA PAGE #########################

                //------- Age -------

                JLabel labelAge = new JLabel("Age : ");
                    liste_components.add(labelAge);
                JTextField inputAge = new JTextField();
                
                JPanel panelAge = new JPanel();
                    panelAge.setLayout(new GridLayout(1, 2));
                    panelAge.add(labelAge);
                    panelAge.add(inputAge);
                panel.add(panelAge, BorderLayout.PAGE_START);
                
            //################### CENTRE DE LA PAGE #########################

                //------- Cases symptômes -------

                    JPanel panelTitreEtSymptomes = new JPanel();
                    panelTitreEtSymptomes.setLayout(new GridLayout(3, 1));
                    
                    JLabel labelTitre = new JLabel("----------------------------- Symptômes que vous présentez -----------------------------");
                    liste_components.add(labelTitre);
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

                    liste_components.add(courbature);
                    liste_components.add(fatigue);
                    liste_components.add(fievre);
                    liste_components.add(toux);
                    liste_components.add(sueurs);
                    liste_components.add(mauxDeTete);
                    liste_components.add(pression);
                    liste_components.add(bonMedecin);
                    
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
                panelMethodes.setLayout(new GridLayout(1, 3));

                JTextField inputBut = new JTextField();

                triNombrePremiss = new JCheckBox();
                triNombrePremiss.setText("Trier les règles par nombre de prémiss");
                liste_components.add(triNombrePremiss);

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
                panelMethodes.add(triNombrePremiss);
                panelMethodes.add(Box.createHorizontalGlue()); // Ajout d'un espace horizontal



                //------- Boutons -------

                    JButton boutonRegles = new JButton("Afficher les règles");
                    JButton boutonCoherence = new JButton("Test de Cohérence");
                    JButton boutonEvaluate = new JButton("Évaluer");
                    JButton boutonQuit = new JButton("Quitter");

                    liste_boutons.add(boutonRegles);
                    liste_boutons.add(boutonCoherence);
                    liste_boutons.add(boutonEvaluate);
                    liste_boutons.add(boutonQuit);

                    //-------- Actions des boutons --------

                    boutonRegles.addActionListener( new ActionListener() {
                        public void actionPerformed(ActionEvent evenement) {
                            ViewRules view;
                            if (triNombrePremiss.isSelected()) view = new ViewRules(baseDeReglesTriee.toString());
                            else view = new ViewRules(baseDeRegles.toString());

                            view.show();
                        }
                    });

                    boutonCoherence.addActionListener( new ActionListener() {
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
                                    if (!inputAge.getText().isEmpty() && Integer.parseInt(inputAge.getText()) > 80) baseFait.add("VIEUX");

                                // base de regles

                                    Br baseDeRegles = new Br();
                                    readRulesFromFile(baseDeRegles);

                                for (String fait : baseFait) {
                                    System.out.println(fait + ", ");
                                }
                                System.out.println(baseDeRegles.toString());

                                //Test coherence:


                                String message = "";
                                message += "*******************COHERENCE****************************\n\\n" + //
                                        "Vérification de la cohérence de la base de faits avant le chaînage :\\n" + //
                                        "";
                                boolean coherenceAvant = Coherence.estBaseFaitsCoherente(baseFait, baseDeRegles);
                                message +="La base de faits avant le chaînage est cohérente : " + coherenceAvant + "\n"; 

                                ViewCoherence viewCo  = new ViewCoherence(message);
                                viewCo.show();
                                
                        }
                    });

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
                                        if (!inputAge.getText().isEmpty() && Integer.parseInt(inputAge.getText()) > 80) baseFait.add("VIEUX");

                                    // but recherché
                                    String but = inputBut.getText();



                                    resultats = new ViewResults((String) methode.getSelectedItem(), baseFait, baseDeRegles, but);
                                    
                                    resultats.show();

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
                    panelBoutons.add(boutonRegles);
                    panelBoutons.add(Box.createHorizontalStrut(10));
                    panelBoutons.add(boutonCoherence);
                    panelBoutons.add(Box.createHorizontalStrut(10));
                    panelBoutons.add(boutonEvaluate);
                    panelBoutons.add(Box.createHorizontalStrut(10)); // Ajout d'un espace horizontal entre les boutons
                    panelBoutons.add(boutonQuit);
                    panelBoutons.add(Box.createHorizontalGlue());

                    //-----------------------

                    panelBas.add(panelMethodes);
                    panelBas.add(panelBoutons);
                    panel.add(panelBas, BorderLayout.PAGE_END);

            //#######################################################

            for (JComponent comp : liste_components) {
                comp.setFont(labelFont);
                comp.setForeground(labelColor);
            }
            for (JButton comp : liste_boutons) {
                comp.setFont(buttonFont);
                comp.setForeground(buttonTextColor);
                comp.setBackground(buttonBackgroundColor);
                comp.setFocusPainted(false); // Supprime la bordure de focus (si nécessaire)
                comp.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Ajoute un peu de marge intérieure
            }

            jFrame.setContentPane(panel);
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

    public void show(){ jFrame.setVisible(true); }
}
