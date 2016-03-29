/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listasimplismenteencadeada;

/**
 *
 * @author Eric Farias
 * @param <E> objeto generico que será guardado na lista
 * @since 29/03/2016
 */
public interface Lista<E>{
    public void add(E o);
    public void add(int pos, E o);
    public E remove(int pos);
    public E remove(E o);
    
    public E getObject(int pos);
    
    
}
