import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class LegesystemLagrer {
    public static void lagreTilFil(String filnavn, Iterable<Pasient> pasienter, Iterable<Legemiddel> legemiddeler, Iterable<Lege> leger, Iterable<Resept> resepter){
        File fil = new File(filnavn);
        try {
            PrintWriter pw = new PrintWriter(fil, "UTF-8");
    
            System.out.print("Skriver til fil...");
            pw.append("# Pasienter (navn, fnr)\n");
            for (Pasient pasient : pasienter) {
                pw.append(pasient.hentDataString() + "\n");
            }

            pw.append("# Legemidler (navn,type,pris,virkestoff,[styrke])\n");
            for (Legemiddel legemiddel : legemiddeler) {
                pw.append(legemiddel.hentDataString() + "\n");
            }

            pw.append("# Leger (navn,kontrollid / 0 hvis vanlig lege)\n");
            for (Lege lege : leger) {
                pw.append(lege.hentDataString() + "\n");
            }

            pw.append("# Resepter (legemiddelNummer,legeNavn,pasientID,type,[reit])\n");
            for (Resept resept : resepter) {
                pw.append(resept.hentDataString() + "\n");
            }

            System.out.print("ferdig... ");
            
            pw.close();
            
            System.out.println("fil lukket");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (UnsupportedEncodingException e){
            System.out.println(e.getMessage());
        }
        return; 
    }
}
