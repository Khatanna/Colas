package colas;

public class Cola<T> {

    private final int limite = 100;
    private int cabeza;
    private int cola;
    private T[] Cola;

    public Cola() {
        this.cabeza = 0;
        this.cola = 0;
        this.Cola = (T[]) new Object[limite];
    }

    public void encolar(T dato) {
        if (this.cabeza == this.limite) {
            System.out.println("Cola llena");
        } else {
            this.Cola[this.cola] = dato;
            this.cola++;
        }
    }

    public T desencolar() {
        if (this.cabeza == this.cola) {
            return null;
        }
        T dato = this.Cola[this.cabeza];
        this.cabeza++;

        return dato;
    }

    public boolean estaVacia() {
        return this.cabeza == -1 && this.cola == -1 || this.cabeza - 1 == this.cola;
    }

    @Override
    public String toString() {
        String datos = "";

        if (this.estaVacia()) {
            return "Cola vacia!";
        } else {
            int aux = this.cabeza;
            while (aux != this.cola) {
                datos += "[" + this.Cola[aux] + "]👉";
                aux++;
            }
            datos += "null";
            return datos;
        }
    }
    
    public void eliminarPrimos(){
        int auxFinal = this.cola;
        while(this.cabeza != auxFinal){
            T elemento = this.desencolar();
            if(!esPrimo((int) elemento)){
                this.encolar(elemento);
            }
        }
    }
    
    public boolean esPrimo(int n){
        int cont = 0;
        for (int i = 1; i <= n; i++) {
            if(n % i == 0){
                cont++;
            }
        }
        return cont == 2; 
    }
    
    public void invertir(){
        Pila<T> pila = new Pila<>();
        while(this.cabeza != this.cola){
            T elemento = this.desencolar();
            pila.push(elemento);
        }
        
        while(!pila.isEmpty()){
            this.encolar(pila.pop());
        }
    }

    public void invertir(int k, int m) {
        int auxFinal = this.cola;
        Pila pila = new Pila();
        int index = this.cabeza;

        while (index != auxFinal) {
            T elemento = this.desencolar();
            if (index >= k && index <= m) {
                pila.push(elemento);
            } else {
                this.encolar(elemento);
            }
            index++;
        }
        int iterator = 0;
        while (iterator < index) {
            if (iterator >= k && iterator <= m) {
                T dato = (T) pila.pop();
                this.encolar(dato);
            } else {
                T elemento = this.desencolar();
                this.encolar(elemento);
            }
            iterator++;
        }
    }

    public Cola interseccion(Cola<T> B) {
        Cola<T> union = new Cola<>();

        while (this.cabeza != this.cola) {
            union.encolar(this.desencolar());
        }

        while(B.cabeza != B.cola){
            union.encolar(B.desencolar());
        }
        
        return union;
    }

    public void forEach(T[] array) {
        for (int i = 0; i < array.length; i++) {
            this.encolar(array[i]);
        }
    }

    public static void main(String[] args) {
        Cola<Integer> queueOne = new Cola<>();
        Cola<Integer> queueTwo = new Cola<>();
        Integer[] foreachOne = {1,2,3,4,5,6,7,8,9};
        Integer[] foreachTwo = {20, 40, 60, 80};

        queueOne.forEach(foreachOne);
        queueTwo.forEach(foreachTwo);
        System.out.println(queueOne);
    }
}
