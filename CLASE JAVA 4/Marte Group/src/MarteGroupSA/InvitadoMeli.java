package MarteGroupSA;

public class InvitadoMeli extends Invitado {

    public InvitadoMeli(String nombreCompleto) {
        super(nombreCompleto);
    }

    @Override
    public void gritar(){
        System.out.println("Viva la Chiqui!!");
    }

    @Override
    public void comerTorta() {
        System.out.println("Comiendo la torta..");

        try {
            Thread.sleep( (long) (Math.random()*900));
            gritar();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
