public class Lege {

    //Superklassen Lege med tilhørende konstruktør og instansvariabel navn.
    
    protected String navn;

    public Lege(String navn){
        this.navn = navn;
    }

    //return av navnet på legen.

    public String hentLege(){
        return navn;
    }

    //toString for navnet på legen.

    public String toString(){
        return (" Navn: " + navn);
    }
}
