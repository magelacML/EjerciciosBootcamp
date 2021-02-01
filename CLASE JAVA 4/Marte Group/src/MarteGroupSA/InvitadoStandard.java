package MarteGroupSA;

public class InvitadoStandard extends Invitado {

    public InvitadoStandard(String nombreCompleto) {
        super(nombreCompleto);
    }

    @Override
    public void gritar(){
        System.out.println("...");
    }

    @Override
    void comerTorta() {
        System.out.println("Comiendo la torta...");
    }
}
