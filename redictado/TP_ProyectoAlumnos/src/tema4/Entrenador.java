
package tema4;


public class Entrenador extends Empleado{
    private int campeonatosGanados;

    public Entrenador(int campeonatosGanados, String nombre, double sueldoBasico, int antiguedad) {
        super(nombre, sueldoBasico, antiguedad);
        this.setCampeonatosGanados(campeonatosGanados);
    }
    
    
    
    @Override
    public double calcularEfectividad() {
        return this.getCampeonatosGanados()/this.getAntiguedad();
    }

    @Override
    public double calcularSueldoACobrar() {
        double aux = this.calcularSueldo();
        
        if (this.getCampeonatosGanados()> 0) {
            if (this.getCampeonatosGanados()< 5) {
                aux+= 5000;
            } else if (this.getCampeonatosGanados() <= 10) {
                aux += 30000;
            } else {
                aux += 50000;
            }
        }
        
        return aux;
    }

    public int getCampeonatosGanados() {
        return campeonatosGanados;
    }

    public void setCampeonatosGanados(int campeonatosGanados) {
        this.campeonatosGanados = campeonatosGanados;
    }
    
    
    
}
