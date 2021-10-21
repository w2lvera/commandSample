/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Blinds;
import model.Light;
import model.Model;
import view.MyFrame;
import view.MyPanel;

/**
 *
 * @author Netbeans
 */
public class Controller {

    MyFrame frame;
    MyPanel panel;
    Model model;

    public Controller() {

        panel = new MyPanel(this);
        frame = new MyFrame(panel);
        model = new Model(3);
        model.addObserver(panel);
    }

    

    public void changeEntityBlind() {
        model.setActiveEntityBlind();
    }

    public void changeEntityLight() {
        model.setActiveEntityLight();
    }

    public void execute() {
        model.execute();
    }

    public void unexecute() {
        model.unexecute();
    }

}
