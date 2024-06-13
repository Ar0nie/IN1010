public class IndeksertListe<T> extends Lenkeliste<T> {

    //Subklassen IndeksertListe av den abstrakte superklassen Lenkeliste.

    //Her legger vi til tilleggs argumentet int posisjon paa flere metoder, dette vil derfor endre funksjonaliteten til metodene.

    //Metoden legg til vil foerst hente en peker for posisjonen som oppgis, metoden kan du finne lengre ned.

    public void leggTil(int pos, T x) throws UgyldigListeindeks{
        Node nyNode = new Node(x);
        Node peker = peker(pos);

        if(pos > antNoder || pos < 0){
            throw new UgyldigListeindeks(pos); //UgyldigListeIndeks kalles for ugyldige verdier.
        } else if (pos == antNoder){           // Dersom posisjonen == antNoder kan vi benytte superklassens leggTil metode.
            super.leggTil(x);
            return;
        } else if(pos == 0){                   // Dersom posisjonen er en ny start, eller indeks 0, saa tilordner vi den nye noden i plassen, gir den start referanse, og forskyver den gamle start noden frem.
            nyNode.neste = peker;
            start = nyNode;
        } else {
            Node nyPeker = peker(pos-1);       //Dersom posisjonen er et sted imellom vil vi benytte peker metoden for aa faa pekeren for noden like foer posisjonen vi vil plassere noden i. Deretter tilordnes det plasser.
            nyNode.neste = peker;
            nyPeker.neste = nyNode;
        }
        antNoder++;
    }

    //Sett metoden erstatter noden paa en gitt indeks med en ny Node. Til forskjell fra leggTil metoden saa maa vi altsaa fjerne alle koblinger til den gamle Node for aa faa erstattet den.

    public void sett(int pos, T x){
        Node nyNode = new Node(x);
        Node peker = peker(pos);

        if (pos > antNoder - 1 || pos < 0){
            throw new UgyldigListeindeks(pos);     ///UgyldigListeIndeks kalles for ugyldige verdier.
        } else if(antNoder == 1){                  // peker == start && peker == slutt
            start = nyNode;
            slutt = nyNode;
        } else if(peker == slutt){                  //Dersom peker == slutt kan man ogsaa skrive.
            Node nyPeker = peker(pos-1);
            nyPeker.neste = nyNode;
            slutt = nyNode;
        } else if(peker == start){                  //Dersom peker == start, vil starten erstattes. 
            nyNode.neste = peker.neste;
            start = nyNode;
        } else {
            nyNode.neste = peker.neste;            //Dersom peker er et sted imellom, vil vi gjoere slik som tidligere aa benyutte peker metoden for posisjonen som er èn foer.
            Node forrigeNode = peker(pos-1);
            forrigeNode.neste = nyNode;
        }
    }
    //Metoden hent() vil returnere dataen til noden paa en gitt indeks. Dersom posisjonen har ugyldig verdi, kaster man et nytt UgyldigListeIndeks kall paa posisjonen.

    public T hent(int pos) throws UgyldigListeindeks{
        if(pos > antNoder - 1 || pos < 0){
            throw new UgyldigListeindeks(pos);
        }
        Node peker = peker(pos);
        return peker.data;
    }

    //Metoden fjern() benytter ogsaa peker metoden for aa gi peker til posisjonen.

    // Vi returnerer dataen til noden som fjernes for gitt indeks. variabelen returData vil tilordnes nye verdier som foelge av hvilken indeks som fjernes.

    public T fjern(int pos){
        if(pos > antNoder - 1 || pos < 0 || antNoder == 0){
            throw new UgyldigListeindeks(pos);
        } 
        Node peker = peker(pos);

        T returData = start.data;        
        if (antNoder == 1){
            slutt = null;
            start = null;
        } else if (peker == slutt) {
            returData = peker.data;
            Node nyPeker = peker(pos-1);
            slutt = nyPeker;
            nyPeker.neste = null;
        } else if (peker == start){
            returData = peker.data;
            start = peker.neste;
        } else {
            returData = peker.data;
            Node nyPeker = peker(pos-1);
            nyPeker.neste = peker.neste;
        }
        antNoder--;
        return returData;
    }

    //Metoden peker() tillater oss aa gi en passende peker for posisjonene som benyttes for IndeksertListe, pekeren til posisjon returneres for bruk i andre metoder.

    private Node peker(int pos){
        if (pos > antNoder - 1 || pos < 0){
            return null;
        } else if( pos == 0){
            return start;
        } else if(pos == antNoder - 1){
            return slutt;
        } else {                             //Dersom posisjonen er et sted imellom start og slutt, saa vil vi tilordne pekeren gjennom en for loekke.
            Node peker = start;             
            for (int i = 0; i < pos; i++){
                peker = peker.neste;
            }
            return peker;
        }
    }
}