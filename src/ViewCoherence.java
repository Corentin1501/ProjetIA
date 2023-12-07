import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewCoherence {
    private JFrame jFrame;

    public ViewCoherence(String message) {
        this.jFrame = new JFrame("Affichage de la cohérence");
        jFrame.setSize(new Dimension(800, 400));

        Dimension windowSize = jFrame.getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;
        jFrame.setLocation(dx, dy);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // personnalisation des labels
            Font labelFont = new Font("Segoe UI", Font.BOLD, 16); // Police Segoe UI en gras pour une meilleure lisibilité
            Color labelColor = Color.BLACK; // Couleur du texte en noir pour un bon contraste            
        // personnalisation des boutons
            Font buttonFont = new Font("Segoe UI", Font.BOLD, 14); // Police Segoe UI pour la modernité
            Color buttonTextColor = Color.WHITE; // Couleur du texte en blanc pour un contraste
            Color buttonBackgroundColor = new Color(51, 153, 255); // Couleur de fond bleu clair

        JTextArea labelAffichageCoherence = new JTextArea(message);
            labelAffichageCoherence.setFont(labelFont);
            labelAffichageCoherence.setForeground(labelColor);
        JButton boutonOK = new JButton("OK");
            boutonOK.setFont(buttonFont);
            boutonOK.setForeground(buttonTextColor);
            boutonOK.setBackground(buttonBackgroundColor);
            boutonOK.setFocusPainted(false); // Supprime la bordure de focus (si nécessaire)
            boutonOK.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Ajoute un peu de marge intérieure

        boutonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evenement) {
                jFrame.dispose();
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(labelAffichageCoherence, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(boutonOK, gbc);

        jFrame.setContentPane(panel);
    }

    public void show(){ jFrame.setVisible(true); }


}