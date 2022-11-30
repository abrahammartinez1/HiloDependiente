public class Programa {
    public static void main(String args[]) throws InterruptedException {

        System.out.println("SOY EL HILO PRINCIPAL --> " + Thread.currentThread().getName());

        TareaHilo1 tarea1 = new TareaHilo1();
        Thread hilo1 = new Thread(tarea1);

        TareaHilo2 tarea2 = new TareaHilo2(hilo1);
        Thread hilo2 = new Thread(tarea2);

        tarea1.nombre("Hilo1");
        hilo1.start();
        tarea2.nombre("Hilo2");
        hilo2.start();


        for (Integer i=1;i<5;i++){
            Thread.sleep(1000);
        }
        tarea1.finHilo1();
        Thread.sleep(2000);
    }
}
