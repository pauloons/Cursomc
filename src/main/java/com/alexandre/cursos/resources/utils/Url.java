package com.alexandre.cursos.resources.utils;

import java.util.List;
import java.util.ArrayList;


public class Url {
    public static List<Integer> decodeIntList(String s){

        String[] vet = s.split(",");
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<vet.length;i++){
        list.add(Integer.parseInt(vet[i]));
        }return list;
    }
}
