package org.kaufer.matthew.sniksnak;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 2016mkaufer on 11/10/2014.
 */
public class Snik {
    List<Double> coordinates;//TODO - MAKE COORDINATES A LIST SO WE CAN PASS IT IN THE HASHMAP
    String url;
    String text;
    int score;

    public Snik(double[] coord,String u, String t){
        coordinates = new LinkedList<Double>();//we make it a list because firebase likes lists more than arrays, apparently
        coordinates.add(0,coord[0]);
        coordinates.add(1,coord[0]);
        url = u;
        text = t;
        score = 0;
    }

    public List<Double> getCoordinates(){
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
        s.put("url",url);
        s.put("text",text);
        s.put("score",score);
        s.put("coordinates",coordinates);
        return s;
    }
}
