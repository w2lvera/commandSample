/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Observable;



/**
 *
 * @author Netbeans
 */
public class Model extends Observable{
    Light light;
    Blinds blinds;
    Command activeEntity;
    int n;
   // boolean button[];

    public Model(int n) {
       blinds = new Blinds(); 
       light = new Light();
       activeEntity  = light;
       
    }
    public void execute(){
        activeEntity.execute();
        setChanged();
        notifyObservers(activeEntity);
        
    }
    public void unexecute(){
        activeEntity.unexecute();
        setChanged();
        notifyObservers(activeEntity);
    }

    public void setActiveEntityLight() {
        activeEntity = light;
    }

    public void setActiveEntityBlind() {
        activeEntity = blinds;
    }
   
}
