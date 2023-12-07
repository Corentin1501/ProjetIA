import javax.swing.*;
import java.awt.*;

public class ViewCoherence {
    private JTextArea codeTextArea;

    public ViewCoherence(String message) {
        JFrame frame = new JFrame("Affichage du code");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        codeTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(codeTextArea);
        codeTextArea.setEditable(false);

        frame.add(scrollPane, BorderLayout.CENTER);

        codeTextArea.setText(message);

        frame.setVisible(true);
    }



}