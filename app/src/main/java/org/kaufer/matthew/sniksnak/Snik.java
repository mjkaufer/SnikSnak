package org.kaufer.matthew.sniksnak;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 2016mkaufer on 11/10/2014.
 */
public class Snik {
    String text;
    int score;

    public Snik(String t){
        text = t;
        score = 0;
    }


    public String getText(){
        return text;
    }

    public int getScore(){
        return score;
    }

    public HashMap<String, Object> toHashMap(){
        HashMap<String, Object> s = new HashMap<String, Object>();
        s.put("text",text);
        s.put("score",score);
        return s;
    }
}
