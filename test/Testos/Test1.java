/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Roger & Daniel
 */

package Testos;
import Factories1.*;
import servicelocator.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class Test1 {
    
    private ServiceLocator ssl;
    private ServiceLocator csl;
    private Factory fA1;
    private Factory fB1;
    private Factory fC1;
    private Factory fD1;
    
    @Before
    public void Test1(){
        
        ssl = new SimpleServiceLocator();
        csl = new CachedServiceLocator();
  
        fA1 = new FactoryA1();
        fB1 = new FactoryB1();
        fC1 = new FactoryC1();
        fD1 = new FactoryD1();
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
        afegirAmbSetConstant(ssl);
    }
    
    @Test (expected = LocatorError.class)
    public void SIMAfegirAmbSetConstantAfegit() throws LocatorError{
        afegirAmbSetConstant(ssl);
        afegirAmbSetConstant(ssl);
    }
    
    @Test (expected = LocatorError.class)
    public void SIMgetObjectAmbErrorNoObjecteNiFactory() throws LocatorError{
        getObjectInexistent(ssl);
    }
    
    @Test
    public void SIMgetObjectInstanciaCorrectaObject() throws LocatorError{
        afegirAmbSetConstant(ssl);
        getObjectGenericAmbInsercióDObjectes(ssl);
        
    }
    
    @Test
    public void SIMgetObjectInstanciaCorrectaFactory() throws LocatorError{
        afegirAmbSetService(ssl);
        afegirAmbSetConstant(ssl);
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
        afegirAmbSetConstant(ssl);
        afegirAmbSetConstant(ssl);
    }
    
    @Test (expected = LocatorError.class)
    public void CgetObjectAmbErrorNoObjecteNiFactory() throws LocatorError{
        getObjectInexistent(csl);
    }
    
    @Test
    public void CgetObjectInstanciaCorrectaObject() throws LocatorError{
        afegirAmbSetConstant(csl);
        getObjectGenericAmbInsercióDObjectes(csl);
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
        s1.setService("C", fC1);
        s1.setService("D", fD1);
        s1.setService("B", fB1);
        s1.setService("A", fA1);
    }
    
    public void afegirAmbSetConstant(ServiceLocator s1) throws LocatorError{
        s1.setConstant("string", "string continguda en tipus InterfaceC");
        s1.setConstant("integer", 4);
    }
    
    public void getObjectInexistent (ServiceLocator s1) throws LocatorError{
        Object object;
        object = s1.getObject("fA4");
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
        objectA1 = s1.getObject("A");
        objectB1 = s1.getObject("B");
        objectC1 = s1.getObject("C");
        objectD1 = s1.getObject("D");
        objectA2 = s1.getObject("A");
        objectB2 = s1.getObject("B");
        objectC2 = s1.getObject("C");
        objectD2 = s1.getObject("D");
        
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
    
    public void getObjectGenericAmbInsercióDObjectes(ServiceLocator s1) throws LocatorError{
        Object object1;
        Object object2;
        object1 = s1.getObject("string");
        object2 = s1.getObject("integer");
        
        assertEquals("string continguda en tipus InterfaceC", object1);
        assertEquals(4, object2);
        
    }
}
