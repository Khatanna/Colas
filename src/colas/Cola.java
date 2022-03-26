package colas;

public class Cola<T> {

    public Nodo<T> cabeza, cola;

    public Cola() {
        this.cabeza = null;
        this.cola = null;
    }

    public void push(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);

        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.setSiguiente(nuevo);
            cola = nuevo;
        }
    }

    public T pop() {
        if (cabeza == null && cola == null) {
            return null;
        } else {
            T dato = cabeza.getDato();
            cabeza = cabeza.getSiguiente();
            return dato;
        }
    }

    @Override
    public String toString() {
        String mostrar = "";

        if (cabeza == null && cola == null) {
            return "La cola está vacía";
        } else {
            Nodo<T> aux = cabeza;
            while (aux != null) {
                mostrar += aux + "";
                aux = aux.getSiguiente();
            }
            mostrar += "null";
        }

        return mostrar;
    }

    public static void main(String[] args) {
        Cola<Integer> cola = new Cola<>();

        cola.push(1);
        cola.push(2);
        cola.push(3);
        cola.push(4);
        cola.push(5);
        cola.pop();
        cola.pop();

        System.out.println(cola);
    }

}
