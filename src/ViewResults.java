import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class ViewResults {
    public JFrame jFrame;
    private String methode;

    public ViewResults(String methode, ArrayList<String> BF, Br BR) {
        this.jFrame = new JFrame("Résultats");
        this.methode = methode;

        // Création de la fenre au milieu de l'écran

            jFrame.setSize(new Dimension(800, 400));

            Dimension windowSize = jFrame.getSize();
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            Point centerPoint = ge.getCenterPoint();
            int dx = centerPoint.x - windowSize.width / 2;
            int dy = centerPoint.y - windowSize.height / 2;
            jFrame.setLocation(dx, dy);

            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Création des éléments

        
        if (methode == "Chaînage Avant") {
            ChainageAvant.solve(BF, BR, "MORT");
        }
        else {
            ArrayList<String> buts = new ArrayList<String>();
            buts.add("MORT");
            ChainageArriere.solve(BF, BR, buts);
        }


    }

    
}
