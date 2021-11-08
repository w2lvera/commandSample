/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.grafModel;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import javax.swing.JLabel;

/**
 *
 * @author Netbeans
 */
public class GrafModel extends Observable{
    enum LabelColor{
        BLIND(Color.BLACK,Color.WHITE),
        LIGHT(Color.YELLOW,Color.GRAY);
        Color on;
        Color off;
            
        private LabelColor(Color on, Color off) {
            this.on = on;
            this.off = off;
        }
        
    }
    JLabel labelLight;
    JLabel labelBlind;
    JLabel current;
    
    LabelColor lb;

    public GrafModel(JLabel labelLight, JLabel labelBlind) {
        this.labelLight = labelLight;
        this.labelBlind = labelBlind;
        current = labelLight;
        lb = LabelColor.LIGHT;
    }
    
    
    
    public void execute() {
        current.setBackground(lb.on);
        current.setText("on");
        setChanged();
        notifyObservers();
    }

    public void unexecute() {
        current.setBackground(lb.off);
        current.setText("off");
        setChanged();
        notifyObservers();
    }

    public void setLableLight() {
        current = labelLight;
        lb=LabelColor.LIGHT;
        
    }

    public void setLableBlind() {
        current = labelBlind;
        lb=LabelColor.BLIND;
    }
    
}
    


