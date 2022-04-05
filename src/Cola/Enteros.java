package Cola;

public class Enteros extends Cola<Integer>{
    public Enteros(){
        super();
    }
    
    public void generar(int dimension){
        for (int i = 0; i < dimension; i++) {
            int dato = (int) (Math.random() * 10 + 1);
            super.encolar(dato);
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
    
    public void eliminarPrimos(){
        Cola<Integer> aux = new Cola<>();
        
        while(!estaVacia()){
            int elemento = super.desencolar();
            if(!esPrimo(elemento)){
                aux.encolar(elemento);
            }
        }
        
        while(!aux.estaVacia()){
            super.encolar(aux.desencolar());
        }
    }
    
    public void invetirConRango(int k, int m){
        Cola<Integer> aux = new Cola<>();
        Pila<Integer> pila = new Pila<>();
        int index = 1;
        
        while(!estaVacia()){
            int elemento = super.desencolar();
            if(index >= k && index <= m){
                pila.push(elemento);
            }else{
                aux.encolar(elemento);
            }
            index++;
        }
        int iterator = 1;
        while(iterator < index){
            if(iterator >= k && iterator <= m){
                super.encolar(pila.pop());
            } else{
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
}
