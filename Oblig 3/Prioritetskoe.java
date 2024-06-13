public class Prioritetskoe<T extends Comparable<T>> extends Lenkeliste<T> {
    
    //Subklassen PrioritetsKoe av den abstrakte superklassen Lenkeliste. I denne klassen har man også muligheten for å sammenligne objekter som følge av extends Comparable for klassen.


    //LeggTil metoden har ingen int posisjon, men alle noder som legges til vil sammenlignes med hverandre for å finne noden med høyest/lavest verdi.
    //Listen skal struktureres fra lavest til størst verdi.

    @Override
    public void leggTil(T x){
      if(antNoder == 0){    //Dersom antNoder = 0 kan man benytte super sin leggTil metode.
        super.leggTil(x);
        return;
      }
      Node peker = start;                 //Itererer for peker, som tillater oss å sammenligne verdien som er allerede lagt til med den verdien som skal legges inn.
      for (int i = 0; i < antNoder; i++){
        if(i != 0){                       //Unntak for første gjennomkjøring, slik at vi også for sammenlignet den første noden.
          peker = peker.neste;
        }
        if (peker.data.compareTo(x) > 0){   //Dersom verdien til peker.data er høyere enn x så vil vi få utslag. Om ikke det gir noe utslag her, så benytter vi superklassens metode for leggTil.
          Node nyNode = new Node(x);

          if(i> antNoder || i < 0){         
            throw new UgyldigListeindeks(i);   
          }
          else if (i == antNoder){      //Dersom indeks == 0, kan vi benytte superklassens leggTil metode.
            super.leggTil(x);
            return;
          }
          else if(i == 0){            //Dersom indeks = 0, så må våre ny node bli tilordnet som vårt nye start punkt.
            nyNode.neste = peker;
            start = nyNode;
          }
          else {                      //Dersom indeks er et sted imellom start og slutt, gjennomføres denne kodesnutten. Har valgt å gjenbruke kode fra indeksertListe i form av peker metoden..
            Node nyPeker = peker(i-1);  //.. for å hente fram peker til indeksen like før den vi skal plassere noden i.
            nyNode.neste = peker;
            nyPeker.neste = nyNode;
          }
          antNoder++;
          return;
        }
      }
      super.leggTil(x);           //benyttes dersom verdien på den nye Noden er høyere enn alle andre så benytter vi superklassens leggTil metode.
    }

    //Dette er den samme peker metoden som ble benyttet i IndeksertListe.

    private Node peker(int pos){
      if(pos> antNoder - 1 || pos < 0){
        return null;
      }
      else if (pos == 0){
        return start;
      }
      else if(pos == antNoder){
        return slutt;
      }
      else {
        Node peker = start;
        for(int i = 0; i < pos; i++){
          peker = peker.neste;
        }
        return peker;
      }
    }
}
