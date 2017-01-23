package com.example.samintha.myapplicationlist;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samintha on 1/23/2017.
 */

public class Data2 {
    static List Titles = new ArrayList();
    static List quantity = new ArrayList();
    static List desc_plyr = new ArrayList();

    public static ArrayList<Information2> getData(){
        ArrayList<Information2> data = new ArrayList<>();

        for(int i = 0; i <Titles.size(); i++){
            Information2 current = new Information2();
            current.title = Titles.get(i).toString();
            current.desc = desc_plyr.get(i).toString();
            current.quant = quantity.get(i).toString();
            data.add(current);
        }

        return data;
    }

    public static void setData(String title,String description){
        if(Titles.isEmpty()){
            quantity.add(1);
            Titles.add(title);
            desc_plyr.add(description);
        }else {
            for (int i = 0; i < Titles.size(); i++) {
                if (Titles.get(i) == title) {
                    //get quantity of that position
                    int quantityOfThePosition = (Integer) quantity.get(i);
                    quantityOfThePosition++;
                    quantity.set(i, quantityOfThePosition);
                    break;
                }
                if (Titles.size()-1 == i) {
                    //if no titles found which added before this will add new one
                    quantity.add(1);
                    Titles.add(title);
                    desc_plyr.add(description);
                    break;
                }
            }
        }
    }

    public static void removeWholeItem(int position){
        quantity.remove(position);
        Titles.remove(position);
        desc_plyr.remove(position);
    }

    public static void removeOneByOne(int position){
        if ((Integer) quantity.get(position) == 1 ) {
            quantity.remove(position);
            Titles.remove(position);
            desc_plyr.remove(position);
        }else if ((Integer) quantity.get(position) > 1 ){
            int quantityOfThePosition = (Integer) quantity.get(position);
            quantityOfThePosition--;
            quantity.set(position, quantityOfThePosition);
        }
    }
}
