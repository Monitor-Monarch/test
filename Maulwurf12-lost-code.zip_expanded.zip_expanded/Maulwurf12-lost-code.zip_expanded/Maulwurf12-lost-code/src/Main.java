import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException {
        System.out.println("Test");

   /*
   EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PacManGUI frame = new PacManGUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        */
        PacManSteuerung steuerung = new PacManSteuerung();
    }
}