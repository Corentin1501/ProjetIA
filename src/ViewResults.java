import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class ViewResults {
    public JFrame jFrame;
    public String methode;
    public String explicationsComplete, explicationsAbrege;
    public JLabel labelResChainage = new JLabel("");
    private Boolean resultatChainageArriere = false;

    public ViewResults(String methode, ArrayList<String> BF, Br BR, String but) {
        this.jFrame = new JFrame("Résultats");
        this.methode = methode;

        //////////////// Création de la fenre au milieu de l'écran ////////////////

            jFrame.setSize(new Dimension(1200, 800));

            Dimension windowSize = jFrame.getSize();
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            Point centerPoint = ge.getCenterPoint();
            int dx = centerPoint.x - windowSize.width / 2;
            int dy = centerPoint.y - windowSize.height / 2;
            jFrame.setLocation(dx, dy);

            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //////////////// Calcul du résultat ////////////////
            
            if (methode == "Chaînage Avant") {

                if (but.isEmpty()) but = "MORT";
                ChainageAvant chainage = new ChainageAvant(BF, BR, but);
                chainage.solve();

                explicationsComplete = chainage.getExplicationsCompletes();
                explicationsAbrege = chainage.getExplicationsAbrege();

                labelResChainage.setText(chainage.getResultat()?"MORT":"PAS MORT");
            }
            else {
                ArrayList<String> buts = new ArrayList<String>();

                if(but.isEmpty()) but = "MORT";
                buts.add(but);
                
                
                ChainageArriere chainage = new ChainageArriere();

                resultatChainageArriere = chainage.solve(BF, BR, buts);
                explicationsAbrege = chainage.getExplicationsAbrege();
                explicationsComplete = chainage.getExplicationsCompletes();
                
                labelResChainage.setText(resultatChainageArriere? but + " vérifié" : but + " NON vérifié");
                
            }
            
        //////////////// Création des éléments ////////////////

            // personnalisation des labels
                Font labelFont = new Font("Segoe UI", Font.BOLD, 16); // Police Segoe UI en gras pour une meilleure lisibilité
                Color labelColor = Color.BLACK; // Couleur du texte en noir pour un bon contraste            
            // personnalisation des boutons
                Font buttonFont = new Font("Segoe UI", Font.PLAIN, 14); // Police Segoe UI pour la modernité
                Color buttonTextColor = Color.WHITE; // Couleur du texte en blanc pour un contraste
                Color buttonBackgroundColor = new Color(51, 153, 255); // Couleur de fond bleu clair
            

            JLabel labelResText = new JLabel("Résultat : ");
            // JLabel labelResChainage = new JLabel("Test");
            JLabel labelExplications = new JLabel("Explications : ");
            JTextArea labelAffichageExplications = new JTextArea("...");
            
            JButton boutonExpl_1 = new JButton("Complète");
            JButton boutonExpl_2 = new JButton("Abrégé");
            JButton boutonOK = new JButton("OK");

            boutonExpl_1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evenement) {
                    labelAffichageExplications.setText(explicationsComplete);
                }
            });
            boutonExpl_2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evenement) {
                    labelAffichageExplications.setText(explicationsAbrege);
                }
            });
            boutonOK.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evenement) {
                    jFrame.dispose();
                }
            });

            JLabel[] labels = {labelResText, labelResChainage, labelExplications};
            JButton[] boutons = {boutonExpl_1, boutonExpl_2, boutonOK};

            for (JLabel label : labels) {
                label.setFont(labelFont);
                label.setForeground(labelColor);
            }
            labelAffichageExplications.setFont(labelFont);
            labelAffichageExplications.setForeground(labelColor);
            for (JButton button : boutons) {
                button.setFont(buttonFont);
                button.setForeground(buttonTextColor);
                button.setBackground(buttonBackgroundColor);
                button.setFocusPainted(false); // Supprime la bordure de focus (si nécessaire)
                button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Ajoute un peu de marge intérieure
            }
            
            // Création des panneaux avec de nouveaux agencements
            JPanel panel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(10, 10, 10, 10);

            JPanel panelResultats = new JPanel(new GridBagLayout());
            JPanel panelBoutons = new JPanel(new GridBagLayout());

            // Ajout des éléments aux panneaux avec des contraintes pour l'agencement
            gbc.gridx = 0;
            gbc.gridy = 0;
            panelResultats.add(labelResText, gbc);

            gbc.gridx = 1;
            gbc.gridy = 0;
            panelResultats.add(labelResChainage, gbc);

            gbc.gridx = 0;
            gbc.gridy = 0;
            panelBoutons.add(boutonExpl_1, gbc);

            gbc.gridx = 1;
            gbc.gridy = 0;
            panelBoutons.add(boutonExpl_2, gbc);

            gbc.gridx = 0;
            gbc.gridy = 0;
            panel.add(panelResultats, gbc);

            gbc.gridx = 0;
            gbc.gridy = 1;
            panel.add(labelExplications, gbc);

            gbc.gridx = 0;
            gbc.gridy = 2;
            panel.add(panelBoutons, gbc);

            gbc.gridx = 0;
            gbc.gridy = 3;
            panel.add(labelAffichageExplications, gbc);

            gbc.gridx = 0;
            gbc.gridy = 4;
            panel.add(boutonOK, gbc);

        jFrame.setContentPane(panel);
    }

    public void show(){ jFrame.setVisible(true); }
}
