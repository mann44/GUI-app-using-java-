/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textapp;



//showing the View Part
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIApp extends JApplet  {
  private JButton jbtController = new JButton("Show Controller");
  private JButton jbtView = new JButton("Show View");
  private ModelApp model = new ModelApp();

  public GUIApp() {
    setLayout(new FlowLayout());//setting layout
    add(jbtController);
    add(jbtView);

    jbtController.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JFrame frame = new JFrame("Controller");
        ControllerApp controller = new ControllerApp();
        controller.setModel(model);
        frame.add(controller);
        frame.setSize(200, 100);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
      }
    });

    jbtView.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JFrame frame = new JFrame("View");
        TextApp view = new TextApp();
        view.setModel(model);
        frame.add(view);
        frame.setSize(200, 200);
        frame.setLocation(200, 200);
        frame.setVisible(true);
      }
    });
  }
  public static void main(String[] args) {
    GUIApp applet = new GUIApp();
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("MVCDemo");
    frame.getContentPane().add(applet, BorderLayout.CENTER);
    frame.setSize(300, 200);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}

