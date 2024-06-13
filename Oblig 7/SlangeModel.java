import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class SlangeModel implements ActionListener{

    private SlangeGUI gui;
    private int slangeHodePosLengde, slangeHodePosBredde, lengde, bredde;
    private String[][] brett;

    //MÅ OPPDATERE DENNE NÅR MAN SPISER EN PENGE, SENDE INFO TILBAKE FRA GUI, DER SJEKKER JEG OM KORDINATET FOR HODET x[0], y[0] == pengeX og pengeY.

    private int slangeLengde = 1;
    private int maxLengde = slangeLengde;
    SlangeKontroll c;

    //En 2D array for kordinatene til alle kropsdelene på slangen i rutenettet, der index 0 for hver array inneholder kordinaten i x og y verdi for slangens hode.

    private int[] x = new int[144];
    private int[] y = new int[144];

    private int nyPengePosLengde = 4;
    private int nyPengePosBredde = 4;

    //En 2D array for kordinatene til alle pengene som er på rutenettet.

    private int[] xP = new int[10];
    private int[] yP = new int[10];

    public SlangeModel(SlangeGUI gui, String[][] brett, int lengde, int bredde, SlangeKontroll c){
        this.gui = gui;
        this.brett = brett;
        this.lengde = lengde;
        this.bredde = bredde;
        this.c = c;

        //Tilordning penge kords..
        for(int i = 9; i >= 0; i--){
           xP[i] = trekk(0, 11);
           yP[i] = trekk(0,11);
           gui.sendPengeArray(xP,yP);
        }
    }

    //Med utgangspunkt i retningen for slangen vår tilordnes det en unik kordinat verdi for hode paa slangen.

    public void flytt(Retninger retning){
        try {
            //Sjekk i løkke for aa se om noen av pengene treffes av hodet.
            for(int i = 9; i >=0; i --){
                if(brett[x[0]][y[0]] == (brett[xP[i]][yP[i]])){
                    nyPenge(i, i);
                    gui.sendPengeArray(xP, yP);   //Endre så hele arrayen sendes med.
                    slangeLengde++;
                    gui.oppdaterLengde();
                }
            }
            
            //For alle kroppsdeler utenom slangens hode, forflytt verdien paa en gitt kordinat en index nedover.
            for(int i = slangeLengde; i > 0; i--){
                x[i] = x[i-1];
                y[i] = y[i-1];
            }
            
        } catch (ArrayIndexOutOfBoundsException e) {
            c.kjorer = false;
            System.exit(-1);
        }
        
        //tilordner verdi for slangehode
        switch(retning){
            case OPP:
            x[0] = x[0] - 1;
            break;
            case NED:
                x[0] = x[0] + 1;
                break;
            case VENSTRE:
                y[0] = y[0] - 1;
                break;
            
            case HOYRE:
                y[0] = y[0] + 1;
                break;
        }

        //Sender utfylt array til GUI for aa tegnes.
        gui.sendTilGUI(x, y);
    }

    public void oppdaterLengde(){
        slangeLengde++;
    }

    public void nyPenge(int x, int p){
        // nyPengePosLengde = trekk(0,11);
        // nyPengePosBredde = trekk(0, 11);
        xP[x] = trekk(0,11);
        yP[p] = trekk(0,11);
    }

    private int trekk (int a, int b) {
        return (int)(Math.random()*(b-a+1))+a;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public void kollider() {
        for(int i = slangeLengde; i > 0; i--){
            if(x[0] == x[i] && y[0] == y[i]){
                c.kjorer = false;
                System.out.println("Du krasjet i deg selv!");
                System.exit(-1);
            }
        }
    }
}
