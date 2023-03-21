/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package etu1854.framework.util;
import etu1854.framework.Mapping;
import java.lang.reflect.Method;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.net.URISyntaxException;
import java.net.URL;
import javax.swing.text.Document;
import javax.xml.parsers.*;
/**
 *
 * @author PC
 */
public class Utilitaire {
    //fonction qui prends le parametre
      public String [] getParaInUrl(String uri,String ctxt){
      String [] splitted = uri.toString().split(ctxt+"/");
      String[] parameter = splitted[1].split("/");
       return parameter;
    }
    
    public static List<Class<?>> getChild(String packageName) throws ClassNotFoundException, IOException {
     
      String path = packageName.replace('.', '/');
      List<File> dirs = new ArrayList<>();
      File motherDirectory=new File(path);
      System.out.println(motherDirectory.getName());
      if(motherDirectory.isDirectory()){
       // System.out.println(motherDirectory.getName()+"isdirectory");
        File[] files=motherDirectory.listFiles();
        for (int i=0;i<files.length;i++) {
          System.out.println(files[i].getName());
            dirs.add(files[i]);
        }
      }
      
      List<Class<?>> classes = new ArrayList<>();
      for (File directory : dirs) {
        System.out.println(directory.getName());
          classes.addAll(findClasses(directory, packageName));
          System.out.println(classes.size()+"size");
      }
      return classes;
  }

  private static List<Class<?>> findClasses(File directory, String packageName) throws ClassNotFoundException {
      List<Class<?>> classes = new ArrayList<>();
      if (!directory.exists()) {
          return classes;
      }
      File[] files = directory.listFiles();
      for (File file : files) {
          if (file.isDirectory()) {
              assert !file.getName().contains(".");
              System.out.println(file.getName()+"isdirectory");
              classes.addAll(findClasses(file, packageName + "." + file.getName()));
          } else if (file.getName().endsWith(".class")) {
            System.out.println(file.getName()+"isclass");

              String className = packageName + '.' + file.getName().substring(0, file.getName().length() - 6);
              classes.add(Class.forName(className));
          }
      }
      return classes;
  }
    public HashMap<String,Mapping> fillHash(String packageName)throws Exception{
      
    HashMap<String,Mapping> theHashMap=new HashMap<>();

      Object[] allclass=getChild(packageName).toArray();
      System.out.println(allclass.length+"longueur");
      for(int i=0;i<allclass.length;i++){
        Class classtemp= (Class)allclass[i];
        Method[] method=classtemp.getDeclaredMethods();
          for(int a=0;a<method.length;a++){
            if(method[a].getAnnotation(etu1854.framework.annotation.Method.class).url()!=null){
              Mapping urlMapping=new Mapping();
              urlMapping.setClassName(classtemp.toString());
              urlMapping.setMethod(method[a].toString());
              theHashMap.put(method[a].getAnnotation(etu1854.framework.annotation.Method.class).url(),urlMapping);
              System.out.println(classtemp.toString()+""+method[a].toString()+" "+method[a].getAnnotation(etu1854.framework.annotation.Method.class).url());
            }
          }
        }
    return theHashMap;
  }

}
