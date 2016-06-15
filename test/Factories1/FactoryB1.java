package Factories1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Implementations1.ImplementationB1;
import Interfaces.*;
import servicelocator.*;
/**
 *
 * @author Jaume
 */
public class FactoryB1 implements Factory {
    @Override
    public InterfaceB create (ServiceLocator s) throws LocatorError{
        try{
            InterfaceD d = (InterfaceD) s.getObject("D");
            return new ImplementationB1(d);
        }catch(ClassCastException ex){
            throw new LocatorError(ex);
        }
    }
}
