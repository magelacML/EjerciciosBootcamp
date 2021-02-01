package MarteGroupSA;

import java.util.ArrayList;

public class Evento {

    private ArrayList<Invitado> invitados;

    public Evento() {
        this.invitados = new ArrayList<>();
    }

    public void agregarInvitado(Invitado invitado){

        this.invitados.add(invitado);
    }

    public void apagarVelas(){
        System.out.println("Apagando velas");
        for(Invitado invitado: invitados){
            invitado.comerTorta();
        }
    }

    public void reventarFuegosArtificiales(){

    }




}
