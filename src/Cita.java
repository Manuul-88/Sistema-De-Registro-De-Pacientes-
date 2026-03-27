/*
 Cárcamo Munguía Erika Audrey, 202334471, cm202334471@alm.buap.mx
 Cerón Reyes Geovanni, 202320421, cr202320421@alm.buap.mx
 Escalona Pérez Jovan Yeray, 202361489, ep202361489@alm.buap.mx
 Silva Madrid Manuel, 202356975, sm202356975@alm.buap.mx
*/
import java.io.Serializable;
public class Cita implements Serializable {
private static final long serialVersionUID = 1L; // Para guardar y leer
    // Todos los datos que representan a una cita/paciente
    private String nombre;
    private String direccion;
    private String telefono;
    private String fechaNacimiento;
    private String fechaConsulta;
    private String doctor;
    private String motivo;
    private String diagnostico;
    private String peso;
    private String presion;
    private String temperatura;
    // Constructor con todo para crear objetos
    public Cita(String nombre, String direccion, String telefono,
        String fechaNacimiento, String fechaConsulta, String doctor,
        String motivo, String diagnostico, String peso,
        String presion, String temperatura) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaConsulta = fechaConsulta;
        this.doctor = doctor;
        this.motivo = motivo;
        this.diagnostico = diagnostico;
        this.peso = peso;
        this.presion = presion;
        this.temperatura = temperatura;
    }
    // Getters solo devuelven el dato
    public String getNombre() { return nombre; }
    public String getDireccion() { return direccion; }
    public String getTelefono() { return telefono; }
    public String getFechaNacimiento() { return fechaNacimiento; }
    public String getFechaConsulta() { return fechaConsulta; }
    public String getDoctor() { return doctor; }
    public String getMotivo() { return motivo; }
    public String getDiagnostico() { return diagnostico; }
    public String getPeso() { return peso; }
    public String getPresion() { return presion; }
    public String getTemperatura() { return temperatura; }
    // Setters por si luego ocupo editar directamente los atributos
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    public void setFechaConsulta(String fechaConsulta) { this.fechaConsulta = fechaConsulta; }
    public void setDoctor(String doctor) { this.doctor = doctor; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
    public void setDiagnostico(String diagnostico) { this.diagnostico = diagnostico; }
    public void setPeso(String peso) { this.peso = peso; }
    public void setPresion(String presion) { this.presion = presion; }
    public void setTemperatura(String temperatura) { this.temperatura = temperatura; }
}