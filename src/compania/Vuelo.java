package compania;
import java.time.format.*;
import java.time.*;

public class Vuelo {

	//---------Atributos--------//
	
	private String procedencia="";
	private String destino="";
	private String codigo="";
	private LocalTime horaSalida=LocalTime.now();
	private LocalTime horaDestino=LocalTime.now();
	private LocalDate fechaSalida=LocalDate.now();
	private LocalDate fechaDestino;
	
	
	
	//---------Metodos----------//
	

	//------Constructores-------//
	
	public Vuelo(String procedencia, String destino, String codigo,LocalDate fechaDestino) {
		super();
		this.procedencia = procedencia;
		this.destino = destino;
		this.codigo=codigo;
		this.fechaDestino = fechaDestino;
	}
	
	public Vuelo(String procedencia, String destino, String codigo, LocalTime horaSalida, LocalTime horaDestino,LocalDate fechaSalida,
			LocalDate fechaDestino) {
		super();
		this.procedencia = procedencia;
		this.destino = destino;
		this.codigo = codigo;
		this.horaSalida = horaSalida;
		this.horaDestino = horaDestino;
		this.fechaSalida = fechaSalida;
		this.fechaDestino = fechaDestino;
	}
	//----Setters && Getters----//

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getProcedencia() {
		return procedencia;
	}
	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}

	public LocalTime getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(LocalTime horaSalida) {
		this.horaSalida = horaSalida;
	}

	public LocalTime getHoraDestino() {
		return horaDestino;
	}

	public void setHoraDestino(LocalTime horaDestino) {
		this.horaDestino = horaDestino;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public LocalDate getFechaDestino() {
		return fechaDestino;
	}

	public void setFechaDestino(LocalDate fechaDestino) {
		this.fechaDestino = fechaDestino;
	}


}