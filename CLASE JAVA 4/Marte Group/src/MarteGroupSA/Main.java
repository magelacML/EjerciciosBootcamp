package MarteGroupSA;

/**
 * Trabajo realizado con Ignacio Probst
 */
public class Main {
    public static void main(String[] args) {
        Invitado invitado1 = new InvitadoMeli("Juan");
        Invitado invitado2 = new InvitadoStandard("pablo");
        Invitado invitado3 = new InvitadoMeli("Maria");
        Invitado invitado4 = new InvitadoStandard("Roberto");

        Evento ev = new Evento();

        ev.agregarInvitado(invitado1);
        ev.agregarInvitado(invitado2);
        ev.agregarInvitado(invitado3);
        ev.agregarInvitado(invitado4);

        ev.apagarVelas();
    }
}
