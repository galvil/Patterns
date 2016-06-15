
import servicelocator.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author galvil
 */

public class FactoryA1 implements Factory {
  @Override
  public InterfaceA create (ServiceLocator s) throws LocatorError{
      try{
          InterfaceB b = (InterfaceB) s.getObject("B");
          InterfaceC c = (InterfaceC) s.getObject("C");
          return new ImplementationA1(b,c);
      }catch(ClassCastException ex){
          throw new LocatorError(ex);
      }
  }  
}
