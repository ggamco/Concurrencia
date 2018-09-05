package com.cice.hilos;

public class Cronometro implements Runnable{

    private volatile boolean semaforo;

    @Override
    public void run() {
        int segundos = 0;
        int minutos = 0;
        int horas = 0;

        try {
            for(;;) {
                while (semaforo) {
                    Thread.sleep(1000L);

                    ++segundos;

                    if (segundos == 60) {
                        segundos = 0;
                        ++minutos;
                    }
                    if (minutos == 60) {
                        minutos = 0;
                        ++horas;
                    }
                    if (horas == 24) {
                        horas = 0;
                    }
                    System.out.println(String.format("%02d:%02d:%02d", horas, minutos, segundos));
                }
                //System.out.println("estamos...");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized boolean isSemaforo() {
        return semaforo;
    }

    public synchronized void setSemaforo(boolean semaforo) {
        this.semaforo = semaforo;
    }
}
