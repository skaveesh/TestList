package com.example.samintha.myapplicationlist;

import java.util.ArrayList;

/**
 * Created by samintha on 1/20/2017.
 */

public class Data {

    public static ArrayList<Information>getData(){
        ArrayList<Information> data = new ArrayList<>();

        int[] images = {
                R.drawable.butter_,
                R.drawable.aranmustard,
                R.drawable.dsc01006,
                R.drawable.dsc00972,
                R.drawable.e6ebda4e,
                R.drawable.dsc01810,
                R.drawable.bostonbeans,
                R.drawable.red_chili,
                R.drawable.risotto,
                R.drawable.done16
        };

        String[] Categories = {"Butter Chicken","Aran Mustard","Pizza","Ole One Eye","Fudge Cookie Bars","Cheesy Chicken","Boston Bean Cake","Red Chili Burritos","Risotto","Campfire Lobster Tails"};

        String[] desc_plyr = {"desc1","desc2","desc3","desc4","desc5","desc6","desc7","desc8","desc9","desc10"};

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
