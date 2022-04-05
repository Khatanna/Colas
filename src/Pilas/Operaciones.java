package Pilas;

import colas.Pila;

public class Operaciones {

    public void generarNumeros(Pila<Integer> pila, int dimension) {
        for (int i = 0; i < dimension; i++) {
            int numero = (int) (Math.random() * 10 + 1);
            pila.push(numero);
        }
    }

    public void generarCaracteres(Pila<Character> pila, int dimension) {
        for (int i = 0; i < dimension; i++) {
            char letra = (char) (Math.random() * 10 + 'a');
            pila.push(letra);
        }
    }

    public int sumar(Pila<Integer> pila) {
        Pila<Integer> aux = pila.copy();
        int total = 0;

        while (!aux.isEmpty()) {
            int dato = aux.pop();
            total += dato;
        }

        return total;
    }

    public int sumarPares(Pila<Integer> pila) {
        Pila<Integer> aux = pila.copy();
        int total = 0;

        while (!aux.isEmpty()) {
            int dato = aux.pop();
            if (dato % 2 == 0) {
                total += dato;
            }
        }

        return total;
    }

    public int primerElemento(Pila<Integer> pila) {
        Pila<Integer> copia = pila.copy();
        Pila<Integer> aux = new Pila<>();

        while (!copia.isEmpty()) {
            aux.push(copia.pop());
        }
        return aux.pop();
    }

    public float promedioUltimoPrimer(Pila<Integer> pila) {
        Pila<Integer> aux = pila.copy();
        return (Float.parseFloat(primerElemento(pila) + "") + aux.pop()) / 2;
    }

    public int elementoMayor(Pila<Integer> pila) {
        Pila<Integer> aux = pila.copy();
        int mayor = 0;

        while (!aux.isEmpty()) {
            int dato = aux.pop();
            if (dato > mayor) {
                mayor = dato;
            }
        }
        return mayor;
    }

    public int elementoMenor(Pila<Integer> pila) {
        int menor = elementoMayor(pila);
        Pila<Integer> aux = pila.copy();

        while (!aux.isEmpty()) {
            int dato = aux.pop();
            if (dato < menor) {
                menor = dato;
            }
        }

        return menor;
    }

    public int segundoElementoMenor(Pila<Integer> pila) {
        int menor = elementoMenor(pila);
        Pila<Integer> aux = pila.copy();
        Pila<Integer> menores = new Pila<>();

        while (!aux.isEmpty()) {
            int dato = aux.pop();
            if (dato != menor) {
                menores.push(dato);
            }
        }

        return elementoMenor(menores);
    }

    public String elementosCentrales(Pila<Integer> pila) {
        Pila<Integer> aux = pila.copy();

        if (pila.size() % 2 == 0) {
            while (aux.size() != (pila.size() / 2) + 1) {
                aux.pop();
            }
            return aux.pop() + ", " + aux.pop();
        }

        while (aux.size() != (pila.size() / 2) + 1) {
            aux.pop();
        }
        return aux.pop() + "";
    }

    public Pila<Integer> extraerMenor(Pila<Integer> pila) {
        Pila<Integer> aux = pila.copy();
        Pila<Integer> pilaFinal = new Pila<>();
        int menor = elementoMenor(pila);

        while (!aux.isEmpty()) {
            int elemento = aux.pop();
            if (elemento != menor) {
                pilaFinal.push(elemento);
            } else {
                break;
            }
        }

        while (!pilaFinal.isEmpty()) {
            aux.push(pilaFinal.pop());
        }
        return aux;
    }

    public Pila<Integer> trasladarPares(Pila<Integer> pila) {
        Pila<Integer> aux = pila.copy();
        Pila<Integer> pares = new Pila<>();
        while (!aux.isEmpty()) {
            int dato = aux.pop();
            if (dato % 2 == 0) {
                pares.push(dato);
            }
        }
        return pares;
    }

    public void ordenarPares(Pila<Integer> pila) {
        Pila<Integer> otra = pila.copy();
        Pila<Integer> ordenados = new Pila<>();
        Pila<Integer> pares = trasladarPares(pila);

        while (!otra.isEmpty()) {
            int dato = otra.pop();
            if (dato % 2 == 0) {
                ordenados.push(elementoMenor(pares));
                pares = extraerMenor(pares);
            } else {
                ordenados.push(dato);
            }
        }
        pila.vaciarPila();
        while (!ordenados.isEmpty()) {
            pila.push(ordenados.pop());
        }
    }

    public void ordenar(Pila<Integer> pila) {
        Pila<Integer> otra = pila.copy();
        Pila<Integer> o = pila.copy();
        Pila<Integer> ordenados = new Pila<>();

        while (!otra.isEmpty()) {
            int menor = elementoMenor(o);
            ordenados.push(menor);
            o = extraerMenor(o);
            otra.pop();
        }
        pila.vaciarPila();
        while (!ordenados.isEmpty()) {
            otra.push(ordenados.pop());
        }

        while (!otra.isEmpty()) {
            pila.push(otra.pop());
        }
    }

    public void eliminarRepetidos(Pila<Character> pila) {
        Pila<Character> unicos = new Pila<>();

        while (!pila.isEmpty()) {
            char letra = pila.pop();
            if (!existe(unicos, letra)) {
                unicos.push(letra);
            } else {
                eliminar(pila, letra);
                eliminar(unicos, letra);
            }
        }
        while (!unicos.isEmpty()) {
            pila.push(unicos.pop());
        }
    }

    public void eliminar(Pila<Character> pila, char letra) {
        Pila<Character> aux = new Pila<>();
        while (!pila.isEmpty()) {
            char elemento = pila.pop();
            if (letra != elemento) {
                aux.push(elemento);
            }
        }
        while (!aux.isEmpty()) {
            pila.push(aux.pop());
        }
    }

    public boolean existe(Pila<Character> pila, char letra) {
        Pila<Character> aux = pila.copy();
        boolean flag = false;

        while (!aux.isEmpty()) {
            char dato = aux.pop();
            letra = (letra + "").toLowerCase().charAt(0);
            if (dato == letra) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public void intercambiar(Pila<Integer> pila, int menor, int mayor){
        Pila<Integer> aux = new Pila();
        
        while(!pila.isEmpty()){
            int elemento = pila.pop();
            if(elemento == menor){
                aux.push(mayor);
                break;
            }else{
                aux.push(elemento);
            }
        }
        
        while(!aux.isEmpty()){
            pila.push(aux.pop());
        }
    }
    
    public void intercambiarMayorYMenor(Pila<Integer> pilaA, Pila<Integer> pilaB) {
        int menorA = elementoMenor(pilaA);
        int mayorB = elementoMayor(pilaB);
        
        intercambiar(pilaA, menorA, mayorB);
        intercambiar(pilaB, mayorB, menorA);
    }
}
