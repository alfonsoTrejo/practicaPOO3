package com.mycompany.practica3;
import java.util.ArrayList;

public class Cementerio{
    private ArrayList<Ficha> fichasTotales;
    
    public Cementerio(int mula){
        fichasTotales = new ArrayList<Ficha>();
        this.llenar(mula);
    }

    public void llenar(int mula){
        for(int i=0; i<=mula;i++){
            for(int j= 0; i>=j; j++){
            fichasTotales.add(new Ficha(j,i,mula)) ;
            }
        }
    }
    
    public void mostrarConsola(){
        for(int i =0; i< fichasTotales.size();i++){
            fichasTotales.get(i).mostrarConsola();
        }
    }
    
    public Ficha tomarFicha(){
        int indice =(int) Math.floor(Math.random() * fichasTotales.size());
        return fichasTotales.remove(indice);
    }
    public int getFichas(){
        return fichasTotales.size();
    }
   
}
