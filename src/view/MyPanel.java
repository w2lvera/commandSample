/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import controller.Controller;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import model.Blinds;
import model.Command;
import model.Light;

/**
 *
 * @author Netbeans
 */
public class MyPanel extends JPanel implements Observer {

    Controller c;
    JLabel lightEntity;
    JLabel blindEntity;

    public MyPanel(Controller c) {
        this.c = c;
        JButton blind = new JButton("Blind");
        JButton light = new JButton("Light");
        JButton on = new JButton("on");
        JButton off = new JButton("off");
        //     JLabel topLabel = new JLabel("Top");
        blindEntity = new JLabel("blinds0");
        lightEntity = new JLabel("light");
        // blindEntity.setForeground(Color.GREEN);
        blindEntity.setBackground(Color.GREEN);
        blindEntity.setOpaque(true);
        lightEntity.setBackground(Color.YELLOW);
        lightEntity.setOpaque(true);
        GridLayout myLayout = new GridLayout(0, 2);

        setLayout(myLayout);

        add(blind);add(blindEntity);
        add(light);add(lightEntity);
        add(on);   add(off);
        
        
        blind.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.changeEntityBlind();
            }
        });
        light.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.changeEntityLight();
            }
        });
        on.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.execute();
            }
        });
        off.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.unexecute();
            }
        });

    }

    public void setC(Controller c) {
        this.c = c;
    }

    @Override
    public void update(Observable o, Object arg) {
        Command com = (Command) arg;
        if (com.getClass().getName() == "model.Blinds") {
            Blinds b = (Blinds) com;
            blindEntity.setBackground(b.isOn_off() ? Color.BLACK : Color.WHITE);

        } else {
            Light b = (Light) com;
            lightEntity.setBackground(b.isOn_off() ? Color.YELLOW : Color.gray);
        }

        repaint();
    }

}
