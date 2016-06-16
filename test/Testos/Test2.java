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
      
    }
    
    @Test (expected = LocatorError.class)
    public void SIMAfegirAmbSetServiceAfegit() throws LocatorError{
     
    }
    
    @Test
    public void SIMAfegirAmbSetConstantCorrectament() throws LocatorError{
       
    }
    
    @Test (expected = LocatorError.class)
    public void SIMAfegirAmbSetConstantAfegit() throws LocatorError{
    
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
    
    }
    
    @Test (expected = LocatorError.class)
    public void CAfegirAmbSetServiceAfegit() throws LocatorError{

    }
    
    @Test
    public void CAfegirAmbSetConstantCorrectament() throws LocatorError{
  
    }
    
    @Test (expected = LocatorError.class)
    public void CAfegirAmbSetConstantAfegit() throws LocatorError{
  
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

}
