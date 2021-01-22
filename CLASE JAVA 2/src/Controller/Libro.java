package Controller;

public class Libro {

    private String titulo;
    private String isbn;
    private String autor;
    private boolean prestamo;


    public Libro(String titulo, String isbn, String autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.prestamo = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isPrestamo() {
        return prestamo;
    }

    public void setPrestamo(boolean prestamo) {
        this.prestamo = prestamo;
    }

    public void Prestar(){
        this.prestamo = true;
    }

    public void Devolver(){
        this.prestamo = false;
    }

    public String toString(){
        return getTitulo()+", "+getIsbn()+", "+getAutor();
    }
}
