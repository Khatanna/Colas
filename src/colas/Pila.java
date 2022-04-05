package colas;

public class Pila<T> {

    private final int dimension = 50;
    private int Tope;
    private final T[] Pila;

    @SuppressWarnings("unchecked")
    public Pila() {
        this.Tope = -1;
        this.Pila = (T[]) new Object[dimension];
    }

    public void push(T dato) {
        this.Tope++;
        this.Pila[this.Tope] = dato;
    }

    public T pop() {
        if (this.isEmpty()) {
            return null;
        }
        T dato = this.Pila[this.Tope];
        this.Tope--;
        return dato;
    }

    public int size() {
        int length = 0;
        int aux = this.Tope;

        while (aux != -1) {
            length++;
            aux--;
        }
        return length;
    }

    public Pila<T> copy() {
        Pila<T> pilaAux = new Pila<>();
        Pila<T> copia = new Pila<>();
        int aux = this.Tope;

        while (aux != -1) {
            pilaAux.push(this.Pila[aux]);
            aux--;
        }

        while (!pilaAux.isEmpty()) {
            copia.push(pilaAux.pop());
        }

        return copia;
    }

    public T peek(){
        return this.Pila[this.Tope];
    }
    
    public void vaciarPila() {
        this.Tope = -1;
    }

    public boolean isEmpty() {
        return this.Tope == -1;
    }

    @Override
    public String toString() {
        String state = "";
        int aux = this.Tope;

        if (this.isEmpty()) {
            return "Esta vacia!";
        }

        while (aux != -1) {
            state += "[" + this.Pila[aux--] + "]\n";
        }
        
        return state;
    }
    
    public T[] toArray(){
        T[] array = (T[]) new Object[this.size()];
        int aux = this.Tope;
        
        if(this.isEmpty()){
            return null;
        }
        
        while(aux != -1){
            array[aux] = this.Pila[aux];
            aux--;
        }
        return array;
    }
}
