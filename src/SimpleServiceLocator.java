
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author galvil
 */
public class SimpleServiceLocator implements ServiceLocator {

    HashMap <String,Factory> hm;
    HashMap <String,Object> hm2;
    
    public SimpleServiceLocator(){
        hm = new HashMap<>();
        hm2 = new HashMap<>();
    }
    
    @Override
    public void setService(String name, Factory factory) throws LocatorError {

        if (hm.containsKey(name)) throw new LocatorError();
        else hm.put(name, factory);
    
    }

    @Override
    public void setConstant(String name, Object value) throws LocatorError {
        
        if(hm2.containsKey(name)) throw new LocatorError();
        else hm2.put(name,value);
        
    }

    @Override
    public Object getObject(String name) throws LocatorError {
    
            if (hm.containsKey(name)) return hm.get(name);
            if (hm2.containsKey(name)) return hm2.get(name);
            
            return new LocatorError();
    
    }
    
}
