package tema3;


public class Estante {
    private int dl = 0;
    private int df = 20;
    private  Libro[] v;

    public Estante() {
        this.v = new Libro[this.df];
    }
    
    public String cuantosLibrosHay(){
        String aux ="hay " + this.dl+" libros";
        return aux;
    }
    
    public boolean estanteLleno(){
        return this.df == this.dl;
    }
    
    public void agregarLibro(Libro l){
        if(this.v[dl] != null){
            System.out.println("estante Lleno");
        }
        else{
            System.out.println("hay lugar");
            this.v[dl] = l;
            dl++;
        }
        
        
        
    }
    
    public Libro buscarPorTitulo(String t) {
        int i = 0;
        boolean frenar = i >= this.dl;
        boolean encontrado = false;
        
        
        while (!frenar) {
            if (v[i].getTitulo().equals(t)) {
                frenar = true;
                encontrado = true;
            } else {
                i++;
                frenar = i >= this.dl;
            }
        }
        
        return encontrado ? v[i] : null;
    }
    
}

