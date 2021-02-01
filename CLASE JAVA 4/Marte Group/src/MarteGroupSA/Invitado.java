package MarteGroupSA;

abstract class Invitado {

    private String nombreCompleto;

    public Invitado(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;

    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    abstract void gritar();

    abstract void comerTorta();

}
