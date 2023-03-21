package  etu1854.test.model;
import etu1854.framework.annotation.Method;
public class Dept{
    String name;
    @Method(url="dept-all")
    public Dept [] findAll(){
        Dept [] deptall=null;
        return deptall;
    }
    @Method(url="dept-add")
    public void save(){

    }
    
}