import Vista.InicioSesion;

public class program {
    public static void main(String[] args) {
        run();
    }
        
    public static void run() {
        tryToRun();
    }
    
    public static void tryToRun() {
        try {
          new InicioSesion().setVisible(true);
          
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
