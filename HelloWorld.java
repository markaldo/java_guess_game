package z03_eng;

import java.awt.*;
import javax.swing.*;

public class HelloWorld {

  public static void main(String[] args) {

    JFrame frame = new JFrame("Hello World");
    JLabel label = new JLabel("Hello World", JLabel.CENTER);
    frame.add(label);

    frame.setSize(300, 300);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
  }
}

