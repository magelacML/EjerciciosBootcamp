package MarteGroupSA;

import java.util.ArrayList;

public class PackFuegosArtificiales{

    private ArrayList packsFuegos;

    public PackFuegosArtificiales() {
        this.packsFuegos = new ArrayList();
    }

    public void agregarFuegos(FuegoArtificial fuego){
        this.packsFuegos.add(fuego);
    }

    public void agregarFuegos(PackFuegosArtificiales fuegos){
        this.packsFuegos.add(fuegos);
    }

    public void explotar(){
        for (int i = 0; i < packsFuegos.size(); i++) {
            if( packsFuegos.get(i) instanceof PackFuegosArtificiales){

            }
        }
    }



}
