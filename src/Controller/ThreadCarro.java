package Controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread{

    private String sentido;
    private Semaphore semaforo;

    public ThreadCarro(String sentido, Semaphore semaforo){
        this.sentido= sentido;
        this.semaforo= semaforo;
    }

    @Override
    public void run() {
        try {
            semaforo.acquire();
            Carropassa();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaforo.release();
        }
    }

    private void Carropassa() {
        int metrosmax= 200;
        int metros= 50;
        int carro= 0;

        System.out.println("O carro "+ getId() +" Começou a andar em direção "+ sentido);
        while (carro < metrosmax){
            carro+=metros;
        }
        System.out.println("O carro "+ getId() +" passou.");

    }


}
