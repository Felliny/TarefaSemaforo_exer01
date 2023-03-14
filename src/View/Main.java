package View;

import Controller.ThreadCarro;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        String sentido = "";
        Semaphore semaforo= new Semaphore(1);

        for (int i=1; i<=4; i++){
            if (i==1){
                sentido= "Sul";
            }
            if (i==2){
                sentido= "Norte";
            }
            if (i==3){
                sentido= "Oeste";
            }
            if (i==4){
                sentido= "Leste";
            }
            ThreadCarro carro = new ThreadCarro(sentido, semaforo);
            carro.start();
        }
    }
}
