package  etu1854.test.model;
import etu1854.framework.annotation.Method;
public class Emp{
    String name;
    @Method(url="emp-all")
    public Emp[] findAll(){
        Emp[] empall=null;
        return empall;
    }
    @Method(url="emp-add")
    public void save(){

    }

}