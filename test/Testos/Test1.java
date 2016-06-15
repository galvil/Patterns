/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testos;
import Factories2.*;
import Implementations1.*;
import java.util.HashMap;
import java.util.Map;
import servicelocator.*;
import static org.junit.Assert.*;
import org.junit.Before;
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
    private Map<String,Factory> map;
    private Object o1;
    private Object o2;
    
    
    
    @Before
    public void Test1(){
        
        map = new HashMap<>();
        
        
        ssl = new SimpleServiceLocator(map);
        csl = new CachedServiceLocator(map);
  
        
        
    }
    
    
}
