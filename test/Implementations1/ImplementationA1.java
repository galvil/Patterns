package Implementations1;
import Interfaces.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Interfaces.*;
/**
 *
 * @author Roger & Daniel
 */
public class ImplementationA1 implements InterfaceA{
    private InterfaceB b;
    private InterfaceC c;
    public ImplementationA1(InterfaceB b, InterfaceC c){
        this.b = b; this.c = c;
    }
}