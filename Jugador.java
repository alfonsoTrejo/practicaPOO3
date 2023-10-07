package com.mycompany.practica3;
import java.util.ArrayList;
/**
 * Write a description of class Jugador here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Jugador
{
    // instance variables - replace the example below with your own
    private ArrayList<Ficha> inventario;
    private int puntos;
    private int id ;
    /**
     * Constructor for objects of class Jugador
     */
    public Jugador(){
        inventario = new ArrayList<Ficha>();
    }
    public void agregarFIcha(Ficha ficha){
        inventario.add(ficha);
    }
    public Ficha verFicha(int fichaIndex){
        return inventario.get(fichaIndex);
    }
    
    public Ficha ponerFicha(int fichaIndex){
        return inventario.remove(fichaIndex);
    }
    
    public void mostrarInventario(){
        for (int i = 0; i< inventario.size();i++){
            System.out.print(i+" ");
            inventario.get(i).mostrarConsola();
            System.out.print(" ");
        }
    }
    
    public int getPuntos(){
        return  puntos;
    }
    
    public void intercambio(int ficha){
    inventario.get(ficha).intercambio();
    }
    
    public int verFichasInverntario(){
        return inventario.size();
    }
    
    public void setID(int id){
        this.id =id;
    }
    public void setPuntos (int puntos){
    this.puntos = puntos;
    }
    public void limpiarInventario (){
        inventario.clear();
    }
 }
