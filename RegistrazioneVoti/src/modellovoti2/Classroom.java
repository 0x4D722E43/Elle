/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modellovoti2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gianluca
 */
public class Classroom {
    public enum Feature {
        BLACK_BOARD,PROJECTOR;
    }
    String name;
    String position;
    Integer size;
    List<Feature> features;
    public Classroom(String name){
        this.name = name;
        this.features = new ArrayList<>();
        
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public Integer getSize() {
        return size;
    }
    void addFeature(Feature f){
        this.features.add(f);
    }
    void setPosition(String position) {
        this.position = position;
    }

    void setSize(Integer size) {
        this.size = size;
    }
    
}
