package com.mycompany.practica3;
import java.util.ArrayList;

public class Tablero
{
    private ArrayList<Ficha> mesa;
    public Tablero(){
        mesa = new ArrayList<>();
    }
    
    public void ponerFicha(Ficha ficha){
        mesa.add(ficha);
    }
    
    public void mostrarMesa(){
        for(int i =0; i< mesa.size();i++){
            mesa.get(i).mostrarConsola();    
        }
    }
    public Ficha getValorUltimaFIcha(){
        return mesa.get(mesa.size()-1);
    }
    public int getFichasPuestas(){
        return mesa.size();
    }
    public void limpiarTablero(){
    mesa.clear();
    }
}
