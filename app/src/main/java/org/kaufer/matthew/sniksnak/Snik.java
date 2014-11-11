package org.kaufer.matthew.sniksnak;

import java.util.HashMap;

/**
 * Created by 2016mkaufer on 11/10/2014.
 */
public class Snik {
    double[] coordinates;//TODO - MAKE COORDINATES A LIST SO WE CAN PASS IT IN THE HASHMAP
    String url;
    String text;
    int score;

    public Snik(double[] coord,String u, String t){
        coordinates = coord;
        url = u;
        text = t;
        score = 0;
    }

    public double[] getCoordinates(){
        return coordinates;
    }

    public String getUrl(){
        return url;
    }

    public String getText(){
        return text;
    }

    public int getScore(){
        return score;
    }

    public HashMap<String, Object> toHashMap(){
        HashMap<String, Object> s = new HashMap<String, Object>();





    }
}
