package servicelocator;


import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Roger & Daniel
 */
public class CachedServiceLocator implements ServiceLocator {

    HashMap <String,Object> hm;
    
    public CachedServiceLocator(){
        hm = new HashMap<>();
    }
    
    @Override
    public void setService(String name, Factory factory) throws LocatorError {

        if (hm.containsKey(name)) throw new LocatorError();
        else {
            Object o = factory.create(this);
            this.setConstant(name, o);
        }
    }

    @Override
    public void setConstant(String name, Object value) throws LocatorError {
        
        if(hm.containsKey(name)) throw new LocatorError();
        else hm.put(name,value);
    }

    @Override
    public Object getObject(String name) throws LocatorError {
        
        if (hm.containsKey(name)) return hm.get(name);
        throw new LocatorError();
    }
    
}
