public class Programa {
    public static void main(String[] args) {

        System.out.println("SOY EL HILO PRINCIPAL --> " + Thread.currentThread().getName());

        TareaHilo1 tarea1 = new TareaHilo1();
        Thread hilo1 = new Thread(tarea1);

        TareaHilo2 tarea2 = new TareaHilo2(hilo1);
        Thread hilo2 = new Thread(tarea2);

        tarea1.nombre("Hilo1");
        hilo1.start();
        tarea2.nombre("Hilo2");
        hilo2.start();

        //Hacemos una parada de 5 segundos en el Thread main
        //Una vez transcurrida la parada finalizamos el hilo1
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Paramos el Hilo1 y provocaráque se pare el Hilo2 provocará el fin del hilo2
        tarea1.finHilo1();
    }
}
