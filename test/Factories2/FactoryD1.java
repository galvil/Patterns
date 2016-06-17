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
import Implementations.ImplementationD1;
import Interfaces.*;
import servicelocator2.*;

public class FactoryD1 implements Factory<InterfaceD>{

    @Override
    public InterfaceD create(ServiceLocator s) throws LocatorError {

        int i = s.getObject(Integer.class);
        return new ImplementationD1(i);

    }

 
    
}
