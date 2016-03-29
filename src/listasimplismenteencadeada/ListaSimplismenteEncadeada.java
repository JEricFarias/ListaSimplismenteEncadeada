/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listasimplismenteencadeada;

/**
 *
 * @author Eric Farias
 */
public class ListaSimplismenteEncadeada<E> implements Lista<E> {

    public static class No {

        private Object value;
        private No next;

        public No(Object e) {
            this.value = e;
        }

        public void setValue(Object e) {
            this.value = e;
        }

        public Object getValue() {
            return this.value;
        }

        public void setNext(No n) {
            this.next = n;
        }

        public No getNext() {
            return this.next;
        }

    }

    private No first;
    private No last;
    private int length;

    @Override
    public void add(E o) {
        // adcionar o primeiro valor na lista vazia;
        if (this.first == null && this.last == null) {
            this.first = new No(o);
            this.last = this.first;
            this.length++;
        } else {
            addLast(o);
        }
    }

    private void addLast(E o){
        No aux = new No(o);
        this.last.setNext(aux);
        this.last = aux;
        this.length++;
    }

    @Override
    public void add(int pos, E o) {
        if(pos < 0){
            No aux = this.first;
            this.first = new No(o);
            this.first.setNext(aux);
            this.length++;
        }else if(pos > this.length){
            addLast(o);
        }else{
            // temp é o Nó anterior a posição que desejamos adicionar.
            No temp = getNo(pos - 1);
            No aux = temp.getNext();
            temp.setNext(new No(o));
            temp.getNext().setNext(aux); // setNext é chamado do novo Nó criado e nao do Nó temp
            this.length++;
        }
        
    }

    @Override
    public E remove(int pos) {
        No temp = null;
        if(this.first != null && pos < length){
            if(pos == 0){
                temp = this.first;
                this.first = this.first.getNext();
                this.length--;
            }else if(pos > 0 && pos < this.length - 1){
                No aux = getNo(pos - 1);
                temp = aux.getNext();
                aux.setNext(aux.getNext().getNext()); // pega o valor anterior ao que será apagado set o pnteiro pra o valor deposi do que será apagado
                this.length--;
            }else if(pos == this.length - 1){
                No aux = getNo(pos - 1);
                temp = this.last;
                aux.setNext(null);
                this.last = aux;
                this.length--;
            }
        }else{
            System.out.println("Valores fora do limite do array");
        }
        return (E) temp.getValue();
    }

    @Override
    public E remove(E o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E getObject(int pos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private No getNo(int pos) {
        No aux = this.first;
        for (int i = 0; i < pos; i++) {
            aux = aux.next;
        }
        return aux;
    }

}
