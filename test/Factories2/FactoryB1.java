/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factories2;
import Implementations.ImplementationB1;
import Interfaces.*;
import servicelocator2.*;
/**
 *
 * @author Roger & Daniel
 */
public class FactoryB1 implements Factory<InterfaceB>{

    @Override
    public InterfaceB create(ServiceLocator s) throws LocatorError {
        
       InterfaceD d = s.getObject(InterfaceD.class);
       return new ImplementationB1(d);
    }

   
    
}
