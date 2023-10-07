package com.mycompany.practica3;
public class Ficha{
    private int valor1;
    private int valor2;
    
    public Ficha(int valor1, int valor2, int mula){
        if((valor2-valor1)>=0 && (valor1>=0 && valor1<=mula) && (valor2>=0 && valor2<=mula)){
            this.valor1 = valor1;
            this.valor2 = valor2;        
        }else{
            throw new IllegalArgumentException("Valores de ficha inválidos: valor1 = " + valor1 + ", valor2 = " + valor2);        
        }
    }
    public int getValor1(){
        return valor1;
    }
    
    public int getValor2(){
        return valor2;
    }
    public void intercambio(){
        int temp = valor1;
        valor1 = valor2;
        valor2 = temp;
    }
    
    public void mostrarConsola(){
        System.out.print("["+getValor1()+"/"+getValor2()+"]");
    }
}
