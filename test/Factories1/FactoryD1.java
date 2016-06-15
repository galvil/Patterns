/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factories1;
import Interfaces.*;
import servicelocator.*;
import Implementations1.*;
/**
 *
 * @author Roger & Daniel
 */
public class FactoryD1 implements Factory{

    @Override
    public Object create(ServiceLocator s) throws LocatorError {
        try{
            int i = (int) s.getObject("D");
            return new ImplementationD1(i);
        }catch(ClassCastException ex){
            throw new LocatorError(ex);
        }
    }
    
}