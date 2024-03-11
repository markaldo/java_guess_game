package z03_eng;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SelfIntroduction {

  public static void main(String[] args) {

    JFrame frame = new JFrame("Self-Introduction");
    JPanel panel = new JPanel(new BorderLayout());
    JLabel label = new JLabel("Introduce yourself", JLabel.CENTER);
    JTextField textField = new JTextField();
    JButton button = new JButton("Hello");

    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String input = textField.getText();
        if (input.isEmpty()) {
          JOptionPane.showMessageDialog(null, "Introduce yourself");
        } else {
          label.setText("What's Up " + input + " ?");
        }
      }
    });

    panel.add(label, BorderLayout.NORTH);
    panel.add(textField, BorderLayout.CENTER);
    panel.add(button, BorderLayout.SOUTH);

    frame.add(panel);
    frame.setSize(300, 150);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
  }
}

