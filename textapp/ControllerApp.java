/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textapp;

//Controller adding object to control the view
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class ControllerApp extends JPanel {
  private ModelApp model;
  private JTextField jtfText = new JTextField();
  private JComboBox<String> jcboColor =  new JComboBox<String>(new String[]{"Black", "Blue", "Red"});
  private JSpinner jspSize =
      new JSpinner(new SpinnerNumberModel(24, 12, 48, 12));
  public ControllerApp() {
      
    JPanel panel1 = new JPanel();
    panel1.setLayout(new GridLayout(3, 1));
    panel1.add(new JLabel("Text"));
    panel1.add(new JLabel("Color"));
    panel1.add(new JLabel("Size"));
    
    JPanel panel2 = new JPanel();
    panel2.setLayout(new GridLayout(3,1 ));
    panel2.add(jtfText);
    panel2.add(jcboColor);
    panel2.add(jspSize);
    
    setLayout(new BorderLayout());
    add(panel1, BorderLayout.WEST);
    add(panel2, BorderLayout.EAST);
    
    jtfText.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (model != null) // Set Text in the model 
          model.setText(jtfText.getText());
      }
    });
    
       jcboColor.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int index = 0;
        if (model != null){ // Set Color property in the model
          index = jcboColor.getSelectedIndex();
          switch (index) {
          case 0: model.setColor(Color.BLACK); break;
          case 1: model.setColor(Color.BLUE); break;
          case 2: model.setColor(Color.RED); break;
          default: model.setColor(Color.BLACK); break;
          }
        }
      }
    });
 
    jspSize.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent e) {
        if (model != null)  
          model.setFontSize(((Integer)(jspSize.getValue())));
      }
    });
}
  public void setModel(ModelApp newModel) {
    model = newModel;
  }
  public ModelApp getModel() {
    return model;
  }
}
