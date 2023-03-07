/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.Vector;

/**
 *
 * @author PRINCIPALE
 */
public class Utilitaire {
   public String [] getParaInUrl(String uri,String ctxt){
      String [] splitted = uri.toString().split(ctxt+"/");
      String[] parameter = splitted[1].split("/");
       return parameter;
   }
}
