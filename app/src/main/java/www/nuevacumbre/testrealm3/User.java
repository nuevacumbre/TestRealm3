package www.nuevacumbre.testrealm3;

import io.realm.RealmObject;

public class User extends RealmObject {

    int idLibro;
    int ISBN;
    String nombre;
    int paginas;
    String editorial;

    public User(){}         //para evitar error: Class "User" must declare a public constructor with no arguments if it contains custom constructors.

    public User(int idLibro, int ISBN, String nombre, int paginas, String editorial){
        this.idLibro = idLibro;
        this.ISBN = ISBN;
        this.nombre = nombre;
        this.paginas = paginas;
        this.editorial = editorial;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
}
