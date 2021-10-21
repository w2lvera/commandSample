/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JFrame;

/**
 *
 * @author Netbeans
 */
public class MyFrame extends JFrame{
    MyPanel panel;

    public MyFrame(MyPanel panel) {
        this.panel = panel;
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
    }
    
}
