package com.example.samintha.myapplicationlist;

import java.util.ArrayList;

/**
 * Created by samintha on 1/20/2017.
 */

public class Data {
    public static ArrayList<Information>getData(){
        ArrayList<Information> data = new ArrayList<>();

        int[] images = {
                R.drawable.a,
                R.drawable.b,
                R.drawable.c,
                R.drawable.d,
                R.drawable.e
        };

        String[] Categories = {"Player1","Player2","Player3","Player4","Player5"};

        String[] desc_plyr = {"Player1desc","Player2desc","Player3desc","Player4desc","Player5desc"};

        for(int i = 0; i <images.length; i++){
            Information current = new Information();
            current.imageId = images[i];
            current.title = Categories[i];
            current.desc = desc_plyr[i];

            data.add(current);
        }

        return data;
    }
}
