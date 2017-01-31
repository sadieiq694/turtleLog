package com.example.sadiela.app1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sadie.la on 1/30/2017.
 */
public class Turtle {
    String ID;
    String name;
    List<Capture> captures = new ArrayList<Capture>();
    String species;
    List<String> tags = new ArrayList<String>();

    //String imagePath;
    Turtle (String ident, String nm, String spcs){
        ID = ident;
        name = nm;
        species = spcs;
    }

    public String toString() {
        return ID + " " + name + " " + species;
    }
}

//yagni