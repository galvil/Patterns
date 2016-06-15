
import servicelocator.Factory;
import servicelocator.LocatorError;
import servicelocator.ServiceLocator;

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
  public InterfaceA create (ServiceLocator s) throws LocalError{
      try{
          InterfaceB b = (InterfaceB) sl.getObject("B");
          InterfaceC c = (InterfaceC) sl.getObject("C");
          return new ImplementationA1(b,c);
      }catch(ClassCastException ex){
          throw new LocatorError(ex);
      }
  }  
}
