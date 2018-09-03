package com.cice;

import com.cice.hilos.HiloPropio;

public class Main {

    public static void main(String[] args) {

        long inicio = System.currentTimeMillis();

        HiloPropio hilo = new HiloPropio();

        hiloNuevo();

        //hilo.start();
        for (int i = 0; i < 10000; i++){
            System.out.println("Vuelta del main: " + i);
        }

        long fin = System.currentTimeMillis();

        System.out.println("Tiempo total de ejecucion: "+(fin-inicio));

    }

    private static void hiloNuevo() {
        for (int i = 0; i < 10000; i++){
            System.out.println("Vuelta del hilo propio: " + i);
        }
    }


}
