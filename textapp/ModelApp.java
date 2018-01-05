/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textapp;

import java.awt.Color;
import java.awt.event.*;
import java.util.*;
public class ModelApp 
{
  private String text = "Student ID is 18791";
  private int fontSize = 24;
  private java.awt.Color color;
  private ArrayList<ActionListener> actionListenerList;

  //getter and setter methods
  
  public String getText() {
    return this.text;
  }
  public void setText(String text) {
    this.text = text;
    processEvent(
      new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "text"));
  }
  public int getFontSize() {
    return fontSize;
  }
  public void setFontSize(int fontSize) {
    this.fontSize = fontSize;
    processEvent(
      new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "fontSize"));
  }
  public Color getColor() {
    return color;
  }
  public void setColor(Color color) {
    this.color = color;
    processEvent(
      new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "color"));
  }
  
  
  public synchronized void addActionListener(ActionListener l) {
    if (actionListenerList == null)
      actionListenerList = new ArrayList<ActionListener>();
    actionListenerList.add(l);
  }
  public synchronized void removeActionListener(ActionListener l) {
    if (actionListenerList != null && actionListenerList.contains(l))
      actionListenerList.remove(l);
  }
  private void processEvent(ActionEvent e) {
    ArrayList<ActionListener> list;
    synchronized (this) {
      if (actionListenerList == null) return;
      list = (ArrayList<ActionListener>)(actionListenerList.clone());
    }
    for (int i = 0; i < list.size(); i++) {
      ActionListener listener = list.get(i);
      listener.actionPerformed(e);
    }
  }
}
