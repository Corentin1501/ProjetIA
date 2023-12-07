import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class ViewResults {
    public JFrame jFrame;
    public String methode;
    public String explicationsComplete, explicationsAbrege;

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
                explicationsAbrege = chainage.getExplicationsFinales();
            }
            else {
                ArrayList<String> buts = new ArrayList<String>();

                if (but.isEmpty()) buts.add("MORT");
                else buts.add(but);

                ChainageArriere.solve(BF, BR, buts);

            }
            
        //////////////// Création des éléments ////////////////

            // personnalisation des labels
                Font labelFont = new Font("Segoe UI", Font.BOLD, 16); // Police Segoe UI en gras pour une meilleure lisibilité
                Color labelColor = Color.BLACK; // Couleur du texte en noir pour un bon contraste            
            // personnalisation des boutons
                Font buttonFont = new Font("Segoe UI", Font.PLAIN, 14); // Police Segoe UI pour la modernité
                Color buttonTextColor = Color.WHITE; // Couleur du texte en blanc pour un contraste
                Color buttonBackgroundColor = new Color(51, 153, 255); // Couleur de fond bleu clair
            
    

            // JPanel panel = new JPanel();
            // panel.setLayout(new GridLayout(4, 1));

            // JPanel panelResultats = new JPanel();
            // panelResultats.setLayout(new GridLayout(1, 2));

            // JPanel panelBoutons = new JPanel();
            // panelBoutons.setLayout(new GridLayout(1, 3));

            JLabel labelResText = new JLabel("Résultat : ");
            JLabel labelResChainage = new JLabel("Test");
            JLabel labelExplications = new JLabel("Explications : ");
            JTextArea labelAffichageExplications = new JTextArea("des explications...");
            
            JButton boutonExpl_1 = new JButton("Complète");
            JButton boutonExpl_2 = new JButton("Abrégé");

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

            JLabel[] labels = {labelResText, labelResChainage, labelExplications};
            JButton[] boutons = {boutonExpl_1, boutonExpl_2};

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

        jFrame.setContentPane(panel);
    }

    public void show(){ jFrame.setVisible(true); }
}