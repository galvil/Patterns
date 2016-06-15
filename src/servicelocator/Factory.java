package servicelocator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Roger & Daniel
 */
public interface Factory {
    
    Object create(ServiceLocator s1) throws LocatorError;
}
