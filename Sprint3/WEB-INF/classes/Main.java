package etu1854.test;
import etu1854.framework.util.*;
import java.util.HashMap;

public class Main{
    public static void main(String[] args){
        Utilitaire util=new Utilitaire();
        try {
            HashMap hash=util.fillHash("classes");
        } catch (Exception e) {
            // TODO: handle exception
        }
       
        
        // for(int i=0;i<hash.size();i++){
        //    System.out.println(hash.get(i).toString());
        // }
    }
}