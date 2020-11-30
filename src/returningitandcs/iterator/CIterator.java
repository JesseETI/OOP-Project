/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package returningitandcs.iterator;

/**
 *
 * @author sandman
 */
interface CIterator {
    public boolean hasNext();
    public Object Next();
}

interface CContainer {
    public CIterator createIterator();
} 
