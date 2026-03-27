/*
 Cárcamo Munguía Erika Audrey, 202334471, cm202334471@alm.buap.mx
 Cerón Reyes Geovanni, 202320421, cr202320421@alm.buap.mx
 Escalona Pérez Jovan Yeray, 202361489, ep202361489@alm.buap.mx
 Silva Madrid Manuel, 202356975, sm202356975@alm.buap.mx
*/
import java.io.*;
import java.util.ArrayList;
public class GestorCitas {
    private ArrayList<Cita> listaCitas; // Aqui esta todo lo guardado
    private final String NOMBRE_ARCHIVO = "citas_medicas.dat"; // Archivo donde guardamos todo
    public GestorCitas() {
        listaCitas = new ArrayList<>();
        cargarDesdeArchivo(); // Intentamos leer citas si ya existían
    }
    // Devuelve la lista completa la GUI usa esto para la tabla
    public ArrayList<Cita> getLista() {
        return listaCitas;
    }
    public void agregar(Cita c) {
        listaCitas.add(c);
        guardarEnArchivo(); // Guardamos de inmediato
    }
    public void modificar(int indice, Cita c) {
        listaCitas.set(indice, c);
        guardarEnArchivo(); // Guardado automtico para no perder cambios
    }
    public void eliminar(int indice) {
        listaCitas.remove(indice);
        guardarEnArchivo(); // guardamos en archivo
    }
    public Cita obtenerCita(int indice) {
        return listaCitas.get(indice);
    }
    // MÉTODOS PRIVADOS PARA ARCHIVO
    private void guardarEnArchivo() {
        // Guardamos toda la lista en un archivo binario
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(NOMBRE_ARCHIVO))) {
            out.writeObject(listaCitas);
        } catch (IOException e) {
            System.err.println("Error al guardar: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    private void cargarDesdeArchivo() {
        // Intentamos abrir el archivo de citas previas
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(NOMBRE_ARCHIVO))) {
            listaCitas = (ArrayList<Cita>) in.readObject();
        } catch (FileNotFoundException e) {
            // Si no existe el archivo, significa que es la primera vez que se usa
            listaCitas = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar: " + e.getMessage());
            listaCitas = new ArrayList<>();
        }
    }
}