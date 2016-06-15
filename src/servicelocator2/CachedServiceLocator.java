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
public class CachedServiceLocator implements ServiceLocator {

    Map<Class,Object> mapa;
    
    public CachedServiceLocator(){
        mapa = new HashMap<>();
    }
    
    
    @Override
    public <T> void setService(Class<T> klass, Factory<T> factory) throws LocatorError {

        if (mapa.containsKey(klass)) throw new LocatorError();
        else {
            T o = factory.create(this);
            this.setConstant(klass, o);
        }
    }

    @Override
    public <T> void setConstant(Class<T> klass, T value) throws LocatorError {

        if(mapa.containsKey(klass)) throw new LocatorError();
        else mapa.put(klass,value);
    }

    @Override
    public <T> T getObject(Class<T> klass) throws LocatorError {
        if (mapa.containsKey(klass)) return (T) mapa.get(klass);
        throw new LocatorError();
    }
    
}
