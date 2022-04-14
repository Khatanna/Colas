package ColaCircular;

public class Cola {

    int inicio;
    int fin;
    char[] cola;
    boolean extraido;
    boolean insertado;

    Cola(int tam) {
        cola = new char[tam];
        inicio = 0;
        fin = inicio;
        extraido = true;
        insertado = false;
    }

    public void insertar(char x) {
        if (!llena()) {
            cola[fin] = x;
            if (fin == cola.length - 1) {
                fin = 0;
            } else {
                fin++;
            }
            extraido = false;
            insertado = true;
        } else {
            System.out.println("ERROR: COLA LLENA");
            System.out.println();
            System.out.println();
        }
    }

    public int extraer() {
        if (!vacia()) {
            extraido = true;
            insertado = false;
            if (inicio == cola.length - 1) {
                inicio = 0;
                return cola[cola.length - 1];
            } else {
                inicio++;
                return cola[inicio - 1];
            }
        } else {
            System.out.println("ERROR: COLA VACIA");
            System.out.println();
            System.out.println();
            return 0;
        }
    }

    public boolean vacia() {
        if (inicio == fin) {
            return !insertado;
        } else {
            return false;
        }
    }

    public boolean llena() {
        if (inicio == fin) {
            return !extraido;
        } else {
            return false;
        }
    }

    public void mostrar() {
        if (inicio < fin) {
            for (int i = inicio; i < fin; i++) {
                System.out.print(cola[i] + " ");
            }
        }
        if (inicio > fin || llena()) {
            for (int i = inicio; i < cola.length; i++) {
                System.out.print(cola[i] + " ");
            }
            for (int i = 0; i < fin; i++) {
                System.out.print(cola[i] + " ");
            }
        }
        if (vacia()) {
            System.out.println("Cola vacia");
        }
        System.out.println();
        System.out.println();
    }
    
    public static void main(String[] args) {
        Cola cola = new Cola(5);
        
        cola.insertar('a');
        cola.insertar('b');
        cola.insertar('c');
        cola.insertar('d');
        cola.insertar('e');
        cola.insertar('f');
        cola.mostrar();
    }
}
