import javax.swing.*;
import javax.swing.JSpinner.NumberEditor;
import javax.swing.plaf.DimensionUIResource;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class SlangeGUI {
    
    //GUI klassen vaar som tilordner grafiske verdier og fremstiller JFrame, Panel, og tilhorende JLabels for rutenettet som ble laget i kontroll.

    private JFrame vindu;
    private JPanel panel, brett, knapper;
    private SlangeModel slangeModel;
    private JLabel[][] ruter;
    private JLabel poengTeller;

    private int lengde, bredde;

    private int nyPengePosLengde = 4;
    private int nyPengePosBredde = 4;

    
    JButton opp = new JButton("Opp");
    JButton ned = new JButton("Ned");
    JButton hoyre = new JButton("Hoyre");
    JButton venstre = new JButton("Venstre");

    private SlangeKontroll c;

    private int slangeLengde = 1;
    private int poeng = slangeLengde;

    //Dette er slangekordinatene vaare, de blir sendt over fra Model klassen for hver gang flytt kalles paa.

    int x[];
    int y[];

    //Hver gang en penge forsvinner og faar ny posisjon vil dette arrayet fylles opp med nye verdier, fra model klassen.

    int[] xP = new int[10];
    int[] yP = new int[10];

    public SlangeGUI(String[][] stringBrett, SlangeKontroll c, int lengde, int bredde, SlangeModel slangeModel){
        this.c = c;
        this.lengde = lengde;
        this.bredde = bredde;
        this.slangeModel = slangeModel;

        ruter = new JLabel[lengde][bredde];
        vindu = new JFrame("Snake");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vindu.setResizable(true);
        vindu.setFocusable(true);

        panel = new JPanel();
        JPanel panelKnapp = new JPanel();

        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.white);

        panel.add(snakeTekst(), BorderLayout.NORTH);

        brett = lagBrett(stringBrett);
        panel.add(brett, BorderLayout.CENTER);

        knapper = lagKnapper();
        panel.add(knapper, BorderLayout.SOUTH);
        vindu.addKeyListener(new TrykketKnapp());

        vindu.add(panel);
        vindu.pack();
        vindu.setVisible(true);
    }

    //Oppdaterer posisjonen til slangen.

    public void sendTilGUI(int[] x, int[] y){
        this.x = x;
        this.y = y;
        this.tegnSlange();
    }

    //Implementasjon av knappene for spillet.

    class Buttons implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == opp){
                c.settRetning(Retninger.OPP);
            }
            if(e.getSource() == ned){
                c.settRetning(Retninger.NED);
            }
            if(e.getSource() == hoyre){
                c.settRetning(Retninger.HOYRE);
            }
            if(e.getSource() == venstre){
                c.settRetning(Retninger.VENSTRE);
            }
            vindu.requestFocusInWindow();
        }
    }

    //Implementasjon av bruk for tastatur i spillet.

    class TrykketKnapp implements KeyListener{

        @Override
        public void keyPressed(KeyEvent e){
            int nokkel = e.getKeyCode();
            if(nokkel == KeyEvent.VK_LEFT){
                c.settRetning(Retninger.VENSTRE);
            }
            if(nokkel == KeyEvent.VK_UP){
                c.settRetning(Retninger.OPP);
            }
            if(nokkel == KeyEvent.VK_DOWN){
                c.settRetning(Retninger.NED);
            }
            if(nokkel == KeyEvent.VK_RIGHT){
                c.settRetning(Retninger.HOYRE);
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
            // TODO Auto-generated method stub
            
        }
    }

    //Tekst og poeng panel.

    private JPanel snakeTekst(){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.BLACK);

        JLabel tittel = new JLabel("Slangespillet!");
        tittel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        tittel.setForeground(Color.yellow);
        panel.add(tittel, BorderLayout.LINE_START);

        JLabel poengTeller = new JLabel("Poeng: " + slangeLengde);
        poengTeller.setForeground((Color.YELLOW));
        panel.add(poengTeller, BorderLayout.LINE_END);

        return panel;
    }

    //Lager knapper og gir actionListener av riktig klasse.

    private JPanel lagKnapper() {
        JPanel knapperPanel = new JPanel();
        knapperPanel.setLayout(new BorderLayout());
        knapperPanel.setBackground(Color.black);
        knapperPanel.setSize(new Dimension(50,150));

        JButton[] knapper = new JButton[4];

        knapper[0] = opp;
        knapper[1] = ned;
        knapper[2] = hoyre;
        knapper[3] = venstre;

        for(int i = 0; i < 4; i++){
            knapper[i].addActionListener(new Buttons());
        }

        knapperPanel.add(opp, BorderLayout.NORTH);
        knapperPanel.add(ned, BorderLayout.SOUTH);
        knapperPanel.add(venstre, BorderLayout.WEST);
        knapperPanel.add(hoyre, BorderLayout.EAST);

        return knapperPanel;
    }
    
    //Lager brett bestaende av JLabels fra String brettet vart i kontroller.

    public JPanel lagBrett(String[][] stringBrett){
        JPanel brett = new JPanel();
        brett.setLayout(new GridLayout(lengde, bredde));
        brett.setBorder(BorderFactory.createLineBorder(Color.GREEN,1));
        for(int i = 0; i < lengde; i ++){
            for(int j = 0; j < bredde; j++){
                JLabel rute = lagRute(stringBrett[i][j]);
                rute.setBorder(BorderFactory.createLineBorder(Color.GREEN,1));
                brett.add(rute);
                ruter[i][j] = rute;
            }
        }

        return brett;
    }

    private JLabel lagRute(String tegn){
        JLabel rute;
        rute = new JLabel("", SwingConstants.CENTER);
        rute.setBackground(Color.black);
        rute.setForeground(Color.white);

        rute.setOpaque(true);
        rute.setPreferredSize(new Dimension(40,40));
        return rute;
    }

    //Tegn slange metoden kunne ha vaart fordelt mer, ettersom denne metoden ikke bare tegner slangen, men også maler om hele brettet paa nytt for hver gang metoden kalles.

    public void tegnSlange(){
        //alt settes til svart, for aa unngaa undøvendige spor fra slangen.
        for(int i = 0; i < lengde; i++){
            for(int j = 0; j < bredde; j++){
                JLabel rute = ruter[i][j];
                rute.setBackground(Color.BLACK);
                rute.setForeground(Color.BLACK);
                rute.setText("");
            }
        }

        //tegner pengene vaare.

        for(int i = 9; i >=0; i--){
            tegnPenge(xP[i], yP[i]);
        }
        //Tegner slangen.
        try {
            for(int i = 0; i < slangeLengde; i++){
                if(i == 0){
                    JLabel rute = ruter[x[i]][y[i]];
                    rute.setText(":)");
                    rute.setBackground(Color.GREEN);
                }
                else {
                   JLabel rute = ruter[x[i]][y[i]];
                   rute.setText("O");
                   rute.setForeground(Color.GREEN);
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("GAME OVER - DU KJORTE UTENFOR BRETTET!");
        }  
    }

    public void tegnPenge(int nyPengePosLengde, int nyPengePosBredde) {
        JLabel rute = ruter[nyPengePosLengde][nyPengePosBredde];
        rute.setText("$");
        rute.setForeground(Color.yellow);
    }

    public void oppdaterLengde(){
        slangeLengde++;
        panel.add(snakeTekst(),BorderLayout.NORTH);
    }

    //Oppdaterer pengeArray.

    public void sendPengeArray(int[] x, int[] y) {
        xP = x;
        yP = y;
    }
}
