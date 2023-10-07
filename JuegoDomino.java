package com.mycompany.practica3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
        
/**
 * Write a description of class JuegoDomino here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class JuegoDomino{
    // instance variables - replace the example below with your own
    private int turno=0;
    private int ronda=1;
    private int jugadores=0;
    private int mula =0;
    private ArrayList<Jugador> jugadoresObjs;

    public JuegoDomino(int jugadores)
    {   
        this.jugadores = jugadores;
        if(jugadores>=2 && jugadores<=3){
            mula = 6;
        }else if(jugadores>=4 && jugadores<=6){
            mula = 9;
        }else if (jugadores>=7 && jugadores<=10){
            mula = 12;
        }
        jugadoresObjs = new ArrayList<Jugador>();
        for (int i=0;i< jugadores;i++){
            jugadoresObjs.add(new Jugador());
        }
        
    }
    public void inicar(Cementerio cementerio){
        for(int i=0; i<jugadoresObjs.size();i++){
            jugadoresObjs.get(i).agregarFIcha(cementerio.tomarFicha());
            jugadoresObjs.get(i).agregarFIcha(cementerio.tomarFicha());
            jugadoresObjs.get(i).agregarFIcha(cementerio.tomarFicha());
            jugadoresObjs.get(i).setID(i+1);
        }
    }
    public int getMula(){
        return mula;
    }
    
    public void siguienteTurno(){
        this.turno += 1;
        if(turno >=jugadores) this.turno =0;
    }   
    
    public int getTurno(){
        return this.turno;
    }
    public int getJugadores(){
        return jugadoresObjs.get(turno).verFichasInverntario();
    }
    
    public void getJugador(){
        jugadoresObjs.get(turno).mostrarInventario();
    }
    public void ponerFicha( Tablero tablero, int numFich){
        Ficha fichatemp = jugadoresObjs.get(turno).verFicha(numFich);
            if(tablero.getFichasPuestas() == 0){
                tablero.ponerFicha(jugadoresObjs.get(turno).ponerFicha(numFich));
            }else if(tablero.getFichasPuestas() == 1) {
            if (tablero.getValorUltimaFIcha().getValor2() ==fichatemp.getValor1()){
                tablero.ponerFicha(jugadoresObjs.get(turno).ponerFicha(numFich));            
            }else if(tablero.getValorUltimaFIcha().getValor2() == fichatemp.getValor2()){
                jugadoresObjs.get(turno).intercambio(numFich);
                tablero.ponerFicha(jugadoresObjs.get(turno).ponerFicha(numFich));            
            }else if(tablero.getValorUltimaFIcha().getValor1() == fichatemp.getValor2()){
                //intercambio de ficha en tablero 
                tablero.getValorUltimaFIcha().intercambio();
                jugadoresObjs.get(turno).intercambio(numFich);
                tablero.ponerFicha(jugadoresObjs.get(turno).ponerFicha(numFich));            
            }else if(tablero.getValorUltimaFIcha().getValor1() == fichatemp.getValor1()){
                tablero.getValorUltimaFIcha().intercambio();
                tablero.ponerFicha(jugadoresObjs.get(turno).ponerFicha(numFich));            
            }
            }else{
            if(tablero.getValorUltimaFIcha().getValor1() == fichatemp.getValor1() && tablero.getValorUltimaFIcha().getValor2() ==fichatemp.getValor2()){
                tablero.ponerFicha(jugadoresObjs.get(turno).ponerFicha(numFich));
            }
            else if (tablero.getValorUltimaFIcha().getValor2() ==fichatemp.getValor1()){
                tablero.ponerFicha(jugadoresObjs.get(turno).ponerFicha(numFich));            
            } else if(tablero.getValorUltimaFIcha().getValor2() == fichatemp.getValor2()){
                jugadoresObjs.get(turno).intercambio(numFich);
                tablero.ponerFicha(jugadoresObjs.get(turno).ponerFicha(numFich));            
            }
            }
            
            }
        
         
    
    public boolean comprobar( Tablero tablero, int numFich){
       
        if(tablero.getFichasPuestas()==1){
        Ficha fichatemp = jugadoresObjs.get(turno).verFicha(numFich);
        Ficha utliamFichaTablero = tablero.getValorUltimaFIcha();
        if(fichatemp.getValor1() == utliamFichaTablero.getValor1()) return true;
        if(fichatemp.getValor2() == utliamFichaTablero.getValor1()) return true;
        if(fichatemp.getValor1() == utliamFichaTablero.getValor2()) return true;
        if(fichatemp.getValor2() == utliamFichaTablero.getValor2()) return true;       
    return false;
    }else if(tablero.getFichasPuestas()==0){
        return true ;
    }else if(tablero.getFichasPuestas()>=2){
        Ficha fichatemp = jugadoresObjs.get(turno).verFicha(numFich);
        Ficha utliamFichaTablero = tablero.getValorUltimaFIcha();
        if(fichatemp.getValor1() == utliamFichaTablero.getValor2()) return true;
        if(fichatemp.getValor2() == utliamFichaTablero.getValor2()) return true;  
        return false;
    }
        return false;
    }
    public void comerFicha(Ficha ficha){
    jugadoresObjs.get(turno).agregarFIcha(ficha);
    }
    
    public boolean seguirJugando (Tablero tablero){
        for(int i =0; i < jugadoresObjs.size();i++){ 
            for(int j=0; j< jugadoresObjs.get(i).verFichasInverntario();j++){
                if(tablero.getValorUltimaFIcha().getValor2() == jugadoresObjs.get(i).verFicha(j).getValor1()) return true;
                if(tablero.getValorUltimaFIcha().getValor2() == jugadoresObjs.get(i).verFicha(j).getValor2()) return true;
            }
        }
        return false;
    }
    
    public  void calcularPuntos(){
        int puntos=0;
        int puntosUno =0;
        
        for (int i = 0; i < jugadoresObjs.size(); i++) {
            for (int j = 0; j < jugadoresObjs.get(i).verFichasInverntario(); j++) {
                puntos += jugadoresObjs.get(i).verFicha(j).getValor1();
                puntos += jugadoresObjs.get(i).verFicha(j).getValor2();
            }
        }
        for (int j = 0; j < jugadoresObjs.get(turno).verFichasInverntario(); j++) {
            puntosUno += jugadoresObjs.get(turno).verFicha(j).getValor1();
            puntosUno += jugadoresObjs.get(turno).verFicha(j).getValor2();
        }
        jugadoresObjs.get(turno).setPuntos(puntos-puntosUno);
    }
    public boolean sinFIchas(){
        if(jugadoresObjs.get(turno).verFichasInverntario() == 0) return true;
        else return false;
    }
    public boolean ganador (int valorGanador){
        for (int i = 0; i < jugadoresObjs.size(); i++) {
           if(valorGanador<jugadoresObjs.get(i).getPuntos()) return true;
        }
        return false;
    } 
    public void siguienteRonda(Tablero tablero){
        this.ronda +=1;
        for (int i = 0; i < jugadoresObjs.size(); i++) {
            jugadoresObjs.get(i).limpiarInventario();           
        }
        tablero.limpiarTablero();
    }
    public void verPuntos (){
        for (int i = 0; i < jugadoresObjs.size(); i++) {
            System.out.println("jugador" + i + "puntos" + jugadoresObjs.get(i).getPuntos());
        }
    } 
}
