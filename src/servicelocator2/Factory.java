/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Roger & Daniel
 */

package servicelocator2;

public interface Factory<T> {
    
    T create(ServiceLocator s1) throws LocatorError;
}
