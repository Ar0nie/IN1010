public class Prioritetskoe<T extends Comparable<T>> extends Lenkeliste<T> {
        
    //Subklassen PrioritetsKoe av den abstrakte superklassen Lenkeliste. I denne klassen har man ogsaa muligheten for aa sammenligne objekter som foelge av extends Comparable for klassen.


    //LeggTil metoden har ingen int posisjon, men alle noder som legges til vil sammenlignes med hverandre for aa finne noden med hoeyest/lavest verdi.
    //Listen skal struktureres fra lavest til stoerst verdi.

    @Override
    public void leggTil(T x){
        if(antNoder == 0){        //Dersom antNoder = 0 kan man benytte super sin leggTil metode.
            super.leggTil(x);
            return;
        }
        Node forrigeNode = null;
        Node peker = start;                                 //Itererer for peker, som tillater oss aa sammenligne verdien som er allerede lagt til med den verdien som skal legges inn.
        for (int i = 0; i < antNoder; i++){
            if(i != 0){                                            //Unntak for foerste gjennomkjoering, slik at vi ogsaa for sammenlignet den foerste noden.
                forrigeNode = peker;
                peker = peker.neste;
            }
            if (peker.data.compareTo(x) > 0){     //Dersom verdien til peker.data er hoeyere enn x saa vil vi faa utslag. Om ikke det gir noe utslag her, saa benytter vi superklassens metode for leggTil.
                Node nyNode = new Node(x);

                if(i> antNoder || i < 0){                 
                    throw new UgyldigListeindeks(i);     
                }
                else if (i == antNoder){            //Dersom indeks == 0, kan vi benytte superklassens leggTil metode.
                    super.leggTil(x);
                    return;
                }
                else if(i == 0 && antNoder > 0){                        //Dersom indeks = 0, saa maa vaare ny node bli tilordnet som vaart nye start punkt.
                    nyNode.neste = peker;
                    start = nyNode;
                }
                else {                                            //Dersom indeks er et sted imellom start og slutt, gjennomfoeres denne kodesnutten. Har valgt aa gjenbruke kode fra indeksertListe i form av peker metoden..
                    // forrigeNode != null, fordi i != 0
                    forrigeNode.neste = nyNode;
                    nyNode.neste = peker;
                }
                antNoder++;
                return;
            }
        }
        super.leggTil(x);                     //benyttes dersom verdien paa den nye Noden er hoeyere enn alle andre saa benytter vi superklassens leggTil metode.
    }
}
