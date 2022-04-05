package Cola;

public class Caracteres extends Cola<Character>{
    public Caracteres(){
        super();
    }
    
    public void generar(int dimension){
        for (int i = 0; i < dimension; i++) {
            char dato = (char) (Math.random() * 26 + 'a');
            super.encolar(dato);
        }
    }
}
