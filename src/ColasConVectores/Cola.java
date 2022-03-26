package ColasConVectores;

public class Cola<T> {

    private final int limite = 100;
    private int cabeza;
    private int cola;
    private T[] Cola;

    public Cola() {
        this.cabeza = -1;
        this.cola = -1;
        this.Cola = (T[]) new Object[limite];
    }

    public void encolar(T dato) {
        if (this.cabeza == -1) {
            this.cabeza++;
            this.cola++;
            this.Cola[this.cabeza] = dato;
        } else {
            this.cola++;
            this.Cola[this.cola] = dato;
        }
    }

    public T desencolar() {
        if (this.estaVacia()) {
            return null;
        }
        T dato = this.Cola[this.cabeza];
        this.cabeza++;
        
        return dato;
    }

    public boolean estaVacia() {
        return this.cabeza == -1 && this.cola == -1 || this.cabeza - 1== this.cola;
    }

    @Override
    public String toString() {
        String datos = "";

        if (this.estaVacia()) {
            return "Cola vacia!";
        } else {
            int aux = this.cabeza;
            while (aux != this.cola + 1) {
                datos += "[" + this.Cola[aux] + "]👉";
                aux++;
            }
            datos += "null";
            return datos;
        }
    }

    public static void main(String[] args) {
        Cola<Integer> queue = new Cola<>();

        queue.encolar(10);
        queue.encolar(20);
        queue.encolar(30);
        queue.encolar(40);
        queue.encolar(50);

        queue.desencolar();
        queue.desencolar();
        queue.desencolar();
        queue.desencolar();
        queue.desencolar();
        queue.desencolar();

        System.out.println(queue);
    }
}
