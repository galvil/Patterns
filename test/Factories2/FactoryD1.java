/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factories2;
import Implementations.ImplementationD1;
import Interfaces.*;
import servicelocator2.*;
/**
 *
 * @author Roger & Daniel
 */
public class FactoryD1 implements Factory<InterfaceD>{

    @Override
    public InterfaceD create(ServiceLocator s) throws LocatorError {

        int i = s.getObject(Integer.class);
        return new ImplementationD1(i);

    }

 
    
}
