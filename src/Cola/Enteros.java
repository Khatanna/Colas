package Cola;

public class Enteros extends Cola<Integer> {

    public Enteros() {
        super();
    }

    public void generar(int dimension) {
        for (int i = 0; i < dimension; i++) {
            int dato = (int) (Math.random() * 10 + 1);
            super.encolar(dato);
        }
    }

    public boolean esPrimo(int n) {
        int cont = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                cont++;
            }
        }
        return cont == 2;
    }

    public void eliminarPrimos() {
        Cola<Integer> aux = new Cola<>();

        while (!estaVacia()) {
            int elemento = super.desencolar();
            if (!esPrimo(elemento)) {
                aux.encolar(elemento);
            }
        }

        while (!aux.estaVacia()) {
            super.encolar(aux.desencolar());
        }
    }

    public void invetirConRango(int k, int m) {
        Cola<Integer> aux = new Cola<>();
        Pila<Integer> pila = new Pila<>();
        int index = 1;

        while (!estaVacia()) {
            int elemento = super.desencolar();
            if (index >= k && index <= m) {
                pila.push(elemento);
            } else {
                aux.encolar(elemento);
            }
            index++;
        }
        int iterator = 1;
        while (iterator < index) {
            if (iterator >= k && iterator <= m) {
                super.encolar(pila.pop());
            } else {
                super.encolar(aux.desencolar());
            }
            iterator++;
        }
    }

    public void forEach(String[] array) {
        for (String item : array) {
            super.encolar(Integer.parseInt(item));
        }
    }
    
    public void forEach(Integer[] array) {
        for (Integer item : array) {
            super.encolar(item);
        }
    }

    public void union(Cola<Integer> colaB) {
        while (!colaB.estaVacia()) {
            super.encolar(colaB.desencolar());
        }
    }

    public Cola<Integer> interseccion(Cola<Integer> colaB) {
        Cola<Integer> aux = new Cola<>();
        Cola<Integer> colaFinal = new Cola<>();
        
        while (!super.estaVacia()) {
            int elemento = super.desencolar();
            while (!colaB.estaVacia()) {
                int dato = colaB.desencolar();
                if (elemento == dato) {
                    colaFinal.encolar(dato);
                } else {
                    aux.encolar(dato);
                }
            }

            while (!aux.estaVacia()) {
                colaB.encolar(aux.desencolar());
            }
        }
        return colaFinal;
    }
    
    public static void main(String[] args) {
        Enteros colaA = new Enteros();
        Enteros colaB = new Enteros();
        
        Integer[] arrayA = {1,2,3,4};
        Integer[] arrayB = {1,2,3};
        
        colaA.forEach(arrayA);
        colaB.forEach(arrayB);
 
        System.out.println(colaA);
        System.out.println(colaB);
        
        Cola<Integer> colaC = colaA.interseccion(colaB);
        
        System.out.println(colaC);
    }
}
