package com.cice.hilos;

public class HiloRunnable implements Runnable {

    @Override
    public void run() {
        for(int i = 0; i < 20; i++) {
            System.out.println("Se ejecuta el hilo: " + Thread.currentThread().getName() + " Vuelta: " + i);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
