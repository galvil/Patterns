/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicelocator2;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Roger & Daniel
 */
public class SimpleServiceLocator implements ServiceLocator {
    
    private Map<Class,Factory> mapaFactories;
    private Map<Class,Object> mapaConstants;

     public SimpleServiceLocator(){
        mapaFactories = new HashMap<>();
        mapaConstants = new HashMap<>();
    }
    
    
    @Override
    public <T> void setService(Class<T> klass, Factory<T> factory) throws LocatorError {
        
        if (mapaFactories.containsKey(klass)) throw new LocatorError();
        if (mapaConstants.containsKey(klass)) throw new LocatorError();
        else mapaFactories.put(klass, factory);
            
    }

    @Override
    public <T> void setConstant(Class<T> klass, T value) throws LocatorError {

        if (mapaFactories.containsKey(klass)) throw new LocatorError();
        if (mapaConstants.containsKey(klass)) throw new LocatorError();
        else mapaConstants.put(klass,value);
    
    }

    @Override
    public <T> T getObject(Class<T> klass) throws LocatorError {
        if (mapaConstants.containsKey(klass)) return (T) mapaConstants.get(klass);
        if (mapaFactories.containsKey(klass)){
            Factory<T> fctry = mapaFactories.get(klass);
            T o = fctry.create(this);
            return  o;
        }
        throw new LocatorError();
    }
    
}
