/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testos;

import org.junit.Before;
import org.junit.Test;
import servicelocator2.*;
import Factories2.*;
import Implementations.ImplementationC1;
import Implementations.ImplementationD1;
import Interfaces.*;

/**
 *
 * @author Roger & Daniel
 */
public class Test2 {
    
    private ServiceLocator ssl;
    private ServiceLocator csl;
    private Factory fA1;
    private Factory fB1;
    private Factory fC1;
    private Factory fD1;
    private Object o1;
    private Object o2;
    
  
    @Before
    public void Test2(){

        ssl = new SimpleServiceLocator();
        csl = new CachedServiceLocator();
        
        fA1 = new FactoryA1();
        fB1 = new FactoryB1();
        fC1 = new FactoryC1();
        fD1 = new FactoryD1();
        
        o1 = new Object();
        o2 = new Object();
        
        
        
    }
    
    /*Testos de SimpleServiceLocator començats amb SIM*/
    @Test
    public void SIMAfegirAmbSetServiceCorrectament() throws LocatorError{
      
        afegirAmbSetService(ssl);
    
    }
    
    @Test (expected = LocatorError.class)
    public void SIMAfegirAmbSetServiceAfegit() throws LocatorError{
     
        afegirAmbSetService(ssl);
        afegirAmbSetService(ssl);
        
    }
    
    @Test
    public void SIMAfegirAmbSetConstantCorrectament() throws LocatorError{
       
        afegirAmbSetConstant(csl);
        
    }
    
    @Test (expected = LocatorError.class)
    public void SIMAfegirAmbSetConstantAfegit() throws LocatorError{
    
        afegirAmbSetConstant(csl);
        afegirAmbSetConstant(csl);
        
    }
    
    @Test (expected = LocatorError.class)
    public void SIMgetObjectAmbErrorNoObjecteNiFactory() throws LocatorError{
        
    }
    
    @Test
    public void SIMgetObjectInstanciaCorrectaObject() throws LocatorError{

    }
    
    @Test
    public void SIMgetObjectInstanciaCorrectaFactory() throws LocatorError{
        
    }
    
    
    /*Testos de CachedServiceLocator començats amb C*/
    @Test
    public void CAfegirAmbSetServiceCorrectament() throws LocatorError{
    
       // InterfaceC c= new ImplementationC1("Prova");
        csl.setConstant(String.class, "Prova");
        csl.setConstant(Integer.class, 4);
        afegirAmbSetService(csl);
        
        
    }
    
    @Test (expected = LocatorError.class)
    public void CAfegirAmbSetServiceAfegit() throws LocatorError{

        afegirAmbSetService(csl);
        afegirAmbSetService(csl);
        
    }
    
    @Test
    public void CAfegirAmbSetConstantCorrectament() throws LocatorError{
        afegirAmbSetConstant(csl);
        
    }
    
    @Test (expected = LocatorError.class)
    public void CAfegirAmbSetConstantAfegit() throws LocatorError{
  
        afegirAmbSetConstant(csl);
        afegirAmbSetConstant(csl);
        
    }
    
    @Test (expected = LocatorError.class)
    public void CgetObjectAmbErrorNoObjecteNiFactory() throws LocatorError{
        
    }
    
    @Test
    public void CgetObjectInstanciaCorrectaObject(){

    }
    
    @Test
    public void CgetObjectInstanciaCorrectaFactory(){
    }
    
    
    
    public void afegirAmbSetService(ServiceLocator s1) throws LocatorError{
        s1.setService(InterfaceD.class, fA1);
        s1.setService(InterfaceC.class, fB1);  
    }
    
    public void afegirAmbSetConstant(ServiceLocator s1) throws LocatorError{
        
        InterfaceD d= new ImplementationD1(5);
        s1.setConstant(InterfaceD.class, d);
        
    }

}
