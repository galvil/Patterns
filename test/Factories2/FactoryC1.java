/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Roger & Daniel
 */

package Factories2;
import Implementations.ImplementationC1;
import Interfaces.*;
import servicelocator2.*;

public class FactoryC1 implements Factory<InterfaceC> {

    @Override
    public InterfaceC create(ServiceLocator s) throws LocatorError {
       
         String strng = s.getObject(String.class);
         return new ImplementationC1(strng);
        
    }

  
    
}
