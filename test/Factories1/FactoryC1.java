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
public class FactoryC1 implements Factory {
    
    @Override
    public Object create(ServiceLocator s) throws LocatorError {
        try{
            String strng = (String) s.getObject("string");
            return new ImplementationC1(strng);
        }catch (ClassCastException ex){
            throw new LocatorError(ex);
        }
    }
}
