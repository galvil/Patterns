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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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
    InterfaceC c;
    InterfaceD d;
    
  
    @Before
    public void Test2(){

        ssl = new SimpleServiceLocator();
        csl = new CachedServiceLocator();
        
        fA1 = new FactoryA1();
        fB1 = new FactoryB1();
        fC1 = new FactoryC1();
        fD1 = new FactoryD1();
        
        c = new ImplementationC1("implementació classe InterfaceC") ;
        d = new ImplementationD1(4);
        
        
        
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
        afegirAmbSetConstant(ssl);
        afegirAmbSetConstant(ssl);
    }
    
    @Test (expected = LocatorError.class)
    public void SIMgetObjectAmbErrorNoObjecteNiFactory() throws LocatorError{
        ssl.getObject(String.class);
    }
    
    @Test
    public void SIMgetObjectInstanciaCorrectaObject() throws LocatorError{
        afegirAmbSetConstant(ssl);
        getObjectGenericAmbInsercioDObjectes(ssl);
    }
    
    @Test
    public void SIMgetObjectInstanciaCorrectaFactory() throws LocatorError{
        afegirAmbSetService(ssl);
        creadordInstanciesDeFactories(ssl);
    }
    
    
    /*Testos de CachedServiceLocator començats amb C*/
    @Test
    public void CAfegirAmbSetServiceCorrectament() throws LocatorError{
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
        csl.getObject(String.class);
    }
    
    @Test
    public void CgetObjectInstanciaCorrectaObject() throws LocatorError{
        afegirAmbSetConstant(csl);
        getObjectGenericAmbInsercioDObjectes(csl);
        
    }
    
    @Test
    public void CgetObjectInstanciaCorrectaFactory() throws LocatorError{
        afegirAmbSetService(csl);
        creadordInstanciesDeFactories(csl);
    }
    
    
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
///////////////////////////    Mètodes auxiliars    ////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    public void afegirAmbSetService(ServiceLocator s1) throws LocatorError{
        if (s1.getClass().equals(csl.getClass())){
            afegirAmbSetConstant(s1);
        }
        s1.setService(InterfaceC.class, fC1);
        s1.setService(InterfaceD.class, fD1);
        s1.setService(InterfaceB.class, fB1); 
        s1.setService(InterfaceA.class, fA1); 
    }
    
    public void afegirAmbSetConstant(ServiceLocator s1) throws LocatorError{
        s1.setConstant(String.class, "String prova");
        s1.setConstant(Integer.class, 4);
    }
    
    public void getObjectGenericAmbInsercioDObjectes(ServiceLocator s1) throws LocatorError{
        Object object1;
        Object object2;
        object1 = s1.getObject(String.class);
        object2 = s1.getObject(Integer.class);
        
        assertEquals("String prova", object1);
        assertEquals(4, object2);
    }
    
    public void creadordInstanciesDeFactories(ServiceLocator s1) throws LocatorError{
        Object objectA1;
        Object objectB1;
        Object objectC1;
        Object objectD1;
        Object objectA2;
        Object objectB2;
        Object objectC2;
        Object objectD2;
        objectA1 = s1.getObject(InterfaceA.class);
        objectB1 = s1.getObject(InterfaceB.class);
        objectC1 = s1.getObject(InterfaceC.class);
        objectD1 = s1.getObject(InterfaceD.class);
        objectA2 = s1.getObject(InterfaceA.class);
        objectB2 = s1.getObject(InterfaceB.class);
        objectC2 = s1.getObject(InterfaceC.class);
        objectD2 = s1.getObject(InterfaceD.class);
        
        if(s1.getClass().equals(ssl.getClass())){
            assertFalse(objectA1.equals(objectA2));
            assertFalse(objectB1.equals(objectB2));
            assertFalse(objectC1.equals(objectC2));
            assertFalse(objectD1.equals(objectD2));
        }
        
        if(s1.getClass().equals(csl.getClass())){
            assertEquals(objectA1, objectA2);
            assertEquals(objectB1, objectB2);
            assertEquals(objectC1, objectC2);
            assertEquals(objectD1, objectD2);
        }
    }
}
