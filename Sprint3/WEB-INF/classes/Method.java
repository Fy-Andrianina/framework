package etu1854.framework.annotation;
import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME) //Donnee accessible pendant tout
@Target(ElementType.METHOD)//Annotation pour les methodes
public @interface Method{
 public String url();
}