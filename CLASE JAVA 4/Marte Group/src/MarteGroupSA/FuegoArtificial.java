package MarteGroupSA;

public class FuegoArtificial {

    private String nombre;
    private boolean estado;
    private String ruido;

    public FuegoArtificial(String nombre, boolean estado, String ruido) {
        this.nombre = nombre;
        this.estado = estado;
        this.ruido = ruido;
    }

    public void explotar(){
        try {
            Thread.sleep( (long) (Math.random()*900));
            System.out.println(this.ruido);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getRuido() {
        return ruido;
    }

    public void setRuido(String ruido) {
        this.ruido = ruido;
    }

    @Override
    public String toString() {
        return "FuegoArtificial{" +
                "nombre='" + nombre + '\'' +
                ", estado=" + estado +
                ", ruido='" + ruido + '\'' +
                '}';
    }
}
