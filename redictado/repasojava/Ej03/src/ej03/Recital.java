
package ej03;


public abstract class Recital {
    private String nombreBanda;
    private String[] temas;
    private int dl =0;

    public Recital(String nombreBanda, int cantTemas) {
        this.setNombreBanda(nombreBanda);
        this.temas = new String[cantTemas];
    }

    public String getNombreBanda() {
        return nombreBanda;
    }

    public void setNombreBanda(String nombreBanda) {
        this.nombreBanda = nombreBanda;
    }

    
    public void agregarTema(String t){
        this.temas[this.dl]=t;
        this.dl++;
    }
    
    public void actuar(){
        for (int i = 0; i < this.dl; i++) {
            System.out.println("Y ahora tocaremos " + this.temas[i]); 
        }
    }
    
    public abstract double calcularCosto();
}
