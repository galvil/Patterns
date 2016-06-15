/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testos;
import Factories1.*;
import Implementations1.*;
import java.util.HashMap;
import java.util.Map;
import servicelocator.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
/**
 *
 * @author Roger & Daniel
 */
public class Test1 {
    
    private ServiceLocator ssl;
    private ServiceLocator csl;
    private Factory fA1;
    private Factory fB1;
    private Factory fC1;
    private Factory fD1;
    private Object o1;
    private Object o2;
    
    
    
    @Before
    public void Test1(){
        
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
    public void SIMAfegirAmbSetServiceCorrectament(){
    
    }
    
    @Test (expected = LocatorError.class)
    public void SIMAfegirAmbSetServiceAfegit(){
        
    }
    
    @Test
    public void SIMAfegirAmbSetConstantCorrectament(){
    
    }
    
    @Test (expected = LocatorError.class)
    public void SIMAfegirAmbSetConstantAfegit(){
        
    }
    
    @Test (expected = LocatorError.class)
    public void SIMgetObjectAmbErrorNoObjecteNiFactory(){
        
    }
    
    @Test
    public void SIMgetObjectInstanciaCorrectaObject(){
    
    }
    
    @Test
    public void SIMgetObjectInstanciaCorrectaFactory(){
    
    }
    
    
    /*Testos de CachedServiceLocator començats amb C*/
    @Test
    public void CAfegirAmbSetServiceCorrectament(){
    
    }
    
    @Test (expected = LocatorError.class)
    public void CAfegirAmbSetServiceAfegit(){
        
    }
    
    @Test
    public void CAfegirAmbSetConstantCorrectament(){
    
    }
    
    @Test (expected = LocatorError.class)
    public void CAfegirAmbSetConstantAfegit(){
        
    }
    
    @Test (expected = LocatorError.class)
    public void CgetObjectAmbErrorNoObjecteNiFactory(){
        
    }
    
    @Test
    public void CgetObjectInstanciaCorrectaObject(){
    
    }
    
    @Test
    public void CgetObjectInstanciaCorrectaFactory(){
    
    }
    
    
}
