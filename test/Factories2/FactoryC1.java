/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factories2;
import Implementations.ImplementationC1;
import Interfaces.*;
import servicelocator2.*;
/**
 *
 * @author Roger & Daniel
 */
public class FactoryC1 implements Factory<InterfaceC> {

    @Override
    public InterfaceC create(ServiceLocator s) throws LocatorError {
       
         String strng = s.getObject(String.class);
         return new ImplementationC1(strng);
        
    }

  
    
}
