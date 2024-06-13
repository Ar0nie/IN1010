public class SlangeKontroll {
    
    //Klassen SlangeKontroll. Initsierer modellen vår for rutenettet vi spiller på, kordinater til penger og slangekropp.
    //Dette programmet skal kjores, og main traaden er nederst i denne program-filen!

    private SlangeGUI gui;
    private SlangeModel model;
    private int lengde = 12, bredde = 12;
    private Thread traad;
    private Retninger retning = Retninger.NED;
    public boolean kjorer = true;

    

    public SlangeKontroll(){
        String[][] brett = lagBrett();
        gui = new SlangeGUI(brett,this, lengde,bredde,model);
        model = new SlangeModel(gui,brett, lengde, bredde,this);
        traad = new Thread(new Teller());
        traad.start();
    }

    //Opretter en 2D array av Stringverdier der vi lagrer kordinatene til hver rute. 

    private String[][] lagBrett(){
        String[][] brett = new String[lengde][bredde];

        for(int i = 0; i < lengde; i++){
            for(int j = 0; j < bredde; j++){
                brett[i][j] = lengde + "." + bredde;
            }
        }

        return brett;

    }

    //Klokken som benyttes i programmet, kaller på bevegelse for slangen og sjekker om slangen har kollidert, hvert 2.sekund.

    class Teller implements Runnable {

        @Override
        public void run(){
            while(kjorer){
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    return;
                }
                flytt();
                kollider();
            }
        }
    }

    private void flytt(){
        model.flytt(retning);
    }
    
    private void kollider(){
        model.kollider();
    }

    public void settRetning(Retninger retning){
        this.retning = retning;
    }

    //Main metoden for slangespillet.

    public static void main(String[] args) {
        new SlangeKontroll();
    }

}
