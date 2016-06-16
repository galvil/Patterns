/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factories2;
import Implementations.ImplementationA1;
import Interfaces.*;
import servicelocator2.*;
/**
 *
 * @author Roger & Daniel
 */
public class FactoryA1 implements Factory<InterfaceA>{

    @Override
    public InterfaceA create(ServiceLocator s) throws LocatorError {

        InterfaceB b = s.getObject(InterfaceB.class);
        InterfaceC c = s.getObject(InterfaceC.class);
        return new ImplementationA1(b, c);

    }
    
}
