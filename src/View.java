import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.text.Position;

public class View {
    public JFrame jFrame;

    private JCheckBox courbature, fatigue, fievre, toux, sueurs, mauxDeTete, pression, bonMedecin;

    public View(){
        this.jFrame = new JFrame("Pacman Menu");

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


            //------- Nom - Age -------

                JPanel panelName = new JPanel();
                panelName.setLayout(new GridLayout(2, 2));

                JLabel labelName = new JLabel("Nom : ");
                    JTextField inputName = new JTextField();
                JLabel labelAge = new JLabel("Age : ");
                    JTextField inputAge = new JTextField();
                
                    labelName.setFont(font);
                    labelAge.setFont(font);

                    panelName.add(labelName);
                    panelName.add(inputName);
                    panelName.add(labelAge);
                    panelName.add(inputAge);
                panel.add(panelName, BorderLayout.PAGE_START);
                
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

            //------- Boutons -------
                
                JButton boutonEvaluate = new JButton("Évaluer");
                JButton boutonQuit = new JButton("Quitter");

                boutonEvaluate.setFont(font);
                boutonQuit.setFont(font);

                //-------- Actions des boutons --------

                    boutonEvaluate.addActionListener( new ActionListener() {
                        public void actionPerformed(ActionEvent evenement) {
                            
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

                panel.add(panelBoutons, BorderLayout.PAGE_END);

            //-----------------------

            // panel.setBackground(Color.DARK_GRAY);

            jFrame.setContentPane(panel);
            jFrame.setVisible(true);
    }

}
