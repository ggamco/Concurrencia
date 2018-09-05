package com.cice;

import com.cice.hilos.Cronometro;
import com.cice.hilos.HiloPropio;
import com.cice.hilos.HiloRunnable;

public class Main {

    public static void main(String[] args) {
//        //OPCION 1 - Usamos la subclase que hemos creado de Thread
//        //Capturamos el tiempo del sistema en el momento de iniciar la ejecución
//        long inicio = System.currentTimeMillis();

//        //Creamos un objeto del tipo HiloPropio al cual hemos implementado la funcionalidad
//        HiloPropio hiloPropio = new HiloPropio();

//        //Lanzamos la ejecución del hilo
//        hiloPropio.start();

//        //Generamos la misma logica en el hilo principal para probar la concurrencia
//        for (int i = 0; i < 10000; i++){
//            System.out.println("Vuelta del main: " + i);
//        }
//        //Capturamos el tiempo del sistema al finalizar la ejecución
//        long fin = System.currentTimeMillis();

//        //Mostramos el resultado.
//        System.out.println("Tiempo total de ejecucion: "+(fin-inicio));

//        //OPCION 2 - Usamos la clase a la que hemos implementado la interfaz runnable
//        HiloRunnable hiloRunnable = new HiloRunnable();
//        Thread hilo = new Thread(hiloRunnable);
//        hilo.start();

//        //OPCION 3 - Usamos la interfaz funcional runnable con expresiones Lambda.
//        Runnable runnable = () -> {
//            for (int i = 0; i < 20; i++) {
//                System.out.println("Se ejecuta el hilo: " + Thread.currentThread().getName() + " Vuelta: " + i);
//                try {
//                    Thread.sleep(1000L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//
//        Thread hilo = new Thread(runnable);
//        hilo.start();


        //************************
        //****** RETO CRONO ******
        //************************

        /*
        * A continuación vamos a crear una aplicación que muestre un cronometro en el que se indique
        * el tiempo transcurrido desde que se ejecuta la aplicación.
        *
        * El tiempo debe ser mostrado con el siguiente formato: hh:mm:ss
        * */

/*        Runnable logica = () -> {
            int segundos = 0;
            int minutos = 0;
            int horas = 0;

            try {
                while (true) {
                    Thread.sleep(1000L);

                    ++segundos;

                    if(segundos == 60){
                        segundos = 0;
                        ++minutos;
                    }
                    if(minutos == 60) {
                        minutos = 0;
                        ++horas;
                    }
                    if(horas == 24) {
                        horas = 0;
                    }
                    System.out.println(String.format("%02d:%02d:%02d", horas, minutos, segundos));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread cronometro = new Thread(logica);
        cronometro.start();*/

        Cronometro crono = new Cronometro();
        Thread hilo = new Thread(crono);
        hilo.start();
        crono.setSemaforo(true);

        int contador = 0;
        for(;;){

            try {
                Thread.sleep(1000L);
                ++contador;
                if(contador == 3){
                    crono.setSemaforo(false);
                } else if (contador == 5){
                    crono.setSemaforo(true);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}
