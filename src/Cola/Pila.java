package Cola;

public class Pila<T> {
    
    Nodo<T> tope;
    
    public Pila(){
        this.tope = null;
    }
    
    public void push(T dato){
        Nodo<T> nuevo = new Nodo<>(dato);
        
        nuevo.setSiguiente(tope);
        tope = nuevo;
    }
    
    public T pop(){
        T dato = this.tope.getDato();
        this.tope = this.tope.getSiguiente();
        return dato;
    }
    
    public boolean isEmpty(){
        return this.tope == null;
    }
}
