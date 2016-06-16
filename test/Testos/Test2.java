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

    }
    
    @Test
    public void SIMgetObjectInstanciaCorrectaFactory() throws LocatorError{
        
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
        Object object1;
        Object object2;
        object1 = csl.getObject(InterfaceC.class);
        object2 = csl.getObject(InterfaceD.class);
        
    }
    
    @Test
    public void CgetObjectInstanciaCorrectaFactory(){
    }
    
    
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
///////////////////////////    Mètodes auxiliars    ////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    public void afegirAmbSetService(ServiceLocator s1) throws LocatorError{
        if (s1.getClass().equals(csl.getClass())){
            afegirCostantsNecessariesAServiceLocator(s1);
        }
        s1.setService(InterfaceC.class, fC1);
        s1.setService(InterfaceD.class, fD1);
        s1.setService(InterfaceB.class, fB1); 
        s1.setService(InterfaceA.class, fA1); 
    }
    
    public void afegirAmbSetConstant(ServiceLocator s1) throws LocatorError{
        s1.setConstant(InterfaceC.class, c);
        s1.setConstant(InterfaceD.class, d);
    }
    
    public void afegirCostantsNecessariesAServiceLocator(ServiceLocator s1) throws LocatorError{
        s1.setConstant(String.class, "string continguda en tipus InterfaceC");
        s1.setConstant(Integer.class, 4);
    }

}
