package colas;

public class Operaciones {

    public static void main(String[] args) {
        System.out.println(sumar(1234));
    }

    public static void recorrer(int array[], int index){
        if(index < array.length){
            System.out.println(array[index]);
            recorrer(array, index+1);
        }
    }
    public static int invertir(int n, int index){
        if(n < 10){
            return n;
        }
        return (int) (((n % 10) * Math.pow(10, index)) + invertir(n/10, index-1));
    }
        
    public static String invertir(String cadena, int longitud){
        if(longitud == 0){
            return cadena.charAt(longitud)+"";
        }
        return cadena.charAt(longitud) + (invertir(cadena, longitud-1));
    }
    
    public static float potencia(int a,int b){
        if(b == 1 || b == 0){
            return 1;
        }else if (b < 0){
            return potencia(a, b+1) / a;
        }
        return a * potencia(a, b-1);
    }
    
    public static int sumar(int num){
        if(num < 10){
            return num;
        }
        return num%10 + sumar(num/10); 
    }
    
}
