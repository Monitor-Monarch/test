public class Main
{
    public static void main(String[] args) {
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

       
        PacManSteuerung dieSteuerung = new PacManSteuerung(); 
        PacManGUI frame = new PacManGUI();
        frame.setVisible(true);
        dieSteuerung.spielStart();
        
        
    }
}