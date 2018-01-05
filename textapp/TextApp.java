/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textapp;

import java.awt.*;
import java.awt.event.*;

public class TextApp extends javax.swing.JPanel {
  private ModelApp model;
  public void setModel(ModelApp newModel) {
    model = newModel;
    if (model != null)
      model.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          repaint();
        }
      });
  }
  public ModelApp getModel() {
    return model;
  }
  @Override
  protected void paintComponent(Graphics g) {
    if (model != null) {
      super.paintComponent(g);
      setFont(new Font("Helvetica", Font.BOLD, model.getFontSize()));
      setForeground(model.getColor());
      FontMetrics fm = g.getFontMetrics();
      int stringWidth = fm.stringWidth(model.getText());
      int stringAscent = fm.getAscent();
      int xCoordinate = getWidth() / 2 - stringWidth / 2;
      int yCoordinate = getHeight() / 2 + stringAscent / 2;
      g.drawString(model.getText(), xCoordinate, yCoordinate);
    }
  }
}
