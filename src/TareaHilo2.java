public class TareaHilo2 extends Clase1 implements Runnable {
    private final Thread otroHilo;

    public TareaHilo2(Thread otroHilo) {
        this.otroHilo = otroHilo;
    }

    private String nombreHilo = "";

    public void nombre(String nom){
        this.nombreHilo = nom;
    }

    @Override
    public void run() {
        while (otroHilo.isAlive()) { //mientras el hilo1 este en ejecucion si se para el 1 se para el 2
            System.out.println("SOY EL HILO --> " + this.nombreHilo); //muestra el mensaje cada segundo
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("FIN HILO --> " + this.nombreHilo); //cuando finaliza el hilo2
    }
}
