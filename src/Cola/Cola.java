package Cola;

public class Cola<T> {

    Nodo<T> cabeza;
    Nodo<T> cola;

    public Cola() {
        this.cabeza = null;
        this.cola = null;
    }

    public void encolar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);

        if (this.cabeza == null) {
            this.cabeza = nuevo;
            this.cola = nuevo;
        } else {
            this.cola.setSiguiente(nuevo);
            this.cola = nuevo;
        }
    }

    public T desencolar() {
        T dato = this.cabeza.getDato();
        this.cabeza = this.cabeza.getSiguiente();
        return dato;
    }

    public boolean estaVacia() {
        return this.cabeza == null;
    }

    public void vaciar() {
        this.cabeza = null;
    }

    public void invertir(){
        Pila<T> stack = new Pila<>();
        
        while(!this.estaVacia()){
            stack.push(this.desencolar());
        }
        
        while(!stack.isEmpty()){
            this.encolar(stack.pop());
        }
    }
    @Override
    public String toString() {
        String state = "";
        Nodo<T> aux = this.cabeza;

        if (!this.estaVacia()) {
            while (aux != null) {
                state += "[" + aux + "]->";
                aux = aux.getSiguiente();
            }
            state += "null";
            return state;
        } else {
            return "Cola vacia!";
        }
    }
}
