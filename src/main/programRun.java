package main;

public class programRun {
    public static void main(String[] args) {
        run();
    }
    
    public static void run() {
        tryToRun();
    }
    
    public static void tryToRun() {
        try {
          new Vista.InicioSesion().setVisible(true);
          
        } catch(Exception e) {
            System.err.println("Excepción encontrada! \n Mensaje: " + e.getMessage());
        }
    }
}
