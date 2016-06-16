/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testos;
import Factories1.*;
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
    public void SIMAfegirAmbSetServiceCorrectament() throws LocatorError{
        afegirAmbSetService(ssl);
    }
    
    @Test (expected = LocatorError.class)
    public void SIMAfegirAmbSetServiceAfegit() throws LocatorError{
        ssl.setService("fA1", fA1);
        ssl.setService("fA1", fA1);
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
        Object object1;
        Object object2;
        object1 = ssl.getObject("o1");
        object2 = ssl.getObject("o2");
        assertEquals(o1, object1);
        assertEquals(o2, object2);
    }
    
    @Test
    public void SIMgetObjectInstanciaCorrectaFactory() throws LocatorError{
        ssl.setService("A", fA1);
        ssl.setService("B", fB1);
        ssl.setService("C", fC1);
        ssl.setService("D", fD1);
        ssl.setConstant("string", "string continguda en tipus InterfaceC");
        ssl.setConstant("integer", 4);
        Object objectA1;
        Object objectB1;
        Object objectC1;
        Object objectD1;
        Object objectA2;
        Object objectB2;
        Object objectC2;
        Object objectD2;
        objectA1 = ssl.getObject("A");
        objectB1 = ssl.getObject("B");
        objectC1 = ssl.getObject("C");
        objectD1 = ssl.getObject("D");
        objectA2 = ssl.getObject("A");
        objectB2 = ssl.getObject("B");
        objectC2 = ssl.getObject("C");
        objectD2 = ssl.getObject("D");
       /* assertNotEquals("Les instàncies creades de fA1 són diferents", objectA1, objectA2);
        assertNotEquals("Les instàncies creades de fB1 són diferents", objectB1, objectB2);
        assertNotEquals("Les instàncies creades de fC1 són diferents", objectC1, objectC2);
        assertNotEquals("Les instàncies creades de fD1 són diferents", objectD1, objectD2);
        */
        assertFalse("Les instàncies creades de fA1 són diferents",objectA1.equals(objectA2));
        assertFalse("Les instàncies creades de fB1 són diferents",objectB1.equals(objectB2));
        assertFalse("Les instàncies creades de fC1 són diferents",objectC1.equals(objectC2));
        assertFalse("Les instàncies creades de fD1 són diferents",objectD1.equals(objectD2));
        
        
    }
    
    
    /*Testos de CachedServiceLocator començats amb C*/
    @Test
    public void CAfegirAmbSetServiceCorrectament() throws LocatorError{
       afegirAmbSetService(csl);
//FALTA AFEGIR COSES AL SERVICElOCATOR PER A QUE FUNCIONI LA LINIA COMENTADA
    }
    
    @Test (expected = LocatorError.class)
    public void CAfegirAmbSetServiceAfegit() throws LocatorError{

        
        csl.setService("fA1", fA1);
        csl.setService("fA1", fA1);
       // afegirAmbSetService(csl);
       // afegirAmbSetService(csl);

// s'HA DE TINDRE EN COMTE QUE AL CREAR OBJECTES ES NECESSITEN COSES DINS EL ServiceLocator, igual que a dalt.
// ESTARIA BÑE FER UNA FUNCIÓ AUXILIAR QUE INICIALITZES EL ServiceLocator AMB AQUESTS PARÀMETRES
// UN COP TINGUEM TOTS ELS MÈTODES AUXILIARS CREC QUE ES PODRIEN PASSAR TOTS A UN ARXIU DIFERENT PER NO TINDRE-HO TOT 
// JUNT AMB ELS TESTOS (N'HI HA DE CREATS A BAIX DE TOT)
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
    public void CgetObjectInstanciaCorrectaObject(){
    //FALTA AFEGIR COSES AL SERVICElOCATOR PER A QUE FUNCIONI EL MÈTODE create
    }
    
    @Test
    public void CgetObjectInstanciaCorrectaFactory(){
//FALTA AFEGIR COSES AL SERVICElOCATOR PER A QUE FUNCIONI EL MÈTODE create    
    }



//    mètodes auxiliars
    public void afegirAmbSetService(ServiceLocator s1) throws LocatorError{
        s1.setService("fA1", fA1);
        s1.setService("fB1", fB1);
        s1.setService("fC1", fC1);
        s1.setService("fD1", fD1);
    }
    
    public void afegirAmbSetConstant(ServiceLocator s1) throws LocatorError{
        s1.setConstant("o1", o1);
        s1.setConstant("o2", o2);
    }
    
    public void getObjectInexistent (ServiceLocator s1) throws LocatorError{
        Object object;
        object = s1.getObject("fA4");
    }
    
}
