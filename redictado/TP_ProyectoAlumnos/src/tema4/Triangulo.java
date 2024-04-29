
package tema4;


public class Triangulo extends Figura {
    private double ladoA;
    private double ladoB;
    private double ladoC;

    public Triangulo(double ladoA, double ladoB, double ladoC, String unCR, String unCL) {
        super(unCR, unCL);
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
    }
    
    
    
    @Override
    public double calcularArea() {
        double s = this.calcularPerimetro()/2;
        return Math.sqrt(s * (s - ladoA) * (s - ladoB) * (s - ladoC));
        
    }

    @Override
    public double calcularPerimetro() {
       return this.ladoA + this.ladoB + this.ladoC;
    }
    
    @Override
    public String toString(){
        String str = super.toString();
        str += " Lados: " + this.ladoA + " - " + this.ladoB + " - " + this.ladoC;
        return str;
    }
    
    public double getLadoA() {
        return ladoA;
    }

    public void setLadoA(double ladoA) {
        this.ladoA = ladoA;
    }

    public double getLadoB() {
        return ladoB;
    }

    public void setLadoB(double ladoB) {
        this.ladoB = ladoB;
    }

    public double getLadoC() {
        return ladoC;
    }

    public void setLadoC(double ladoC) {
        this.ladoC = ladoC;
    }
        

    
}
