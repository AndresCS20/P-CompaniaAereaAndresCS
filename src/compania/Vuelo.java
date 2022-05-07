package compania;
import java.time.format.*;
import java.time.*;

public class Vuelo {

	//---------Atributos--------//
	
	private String procedencia="";
	private String destino="";
	private String codigo="";
	private LocalDateTime fechaProcedencia=LocalDateTime.now();
	private LocalDateTime fechaDestino;
	
	
	
	//---------Metodos----------//
	

	//------Constructores-------//
	
	public Vuelo(String procedencia, String destino, String codigo,LocalDateTime fechaDestino) {
		super();
		this.procedencia = procedencia;
		this.destino = destino;
		this.codigo=codigo;
		this.fechaDestino = fechaDestino;
	}
	
	public Vuelo(String procedencia, String destino, String codigo, LocalDateTime fechaProcedencia,
			LocalDateTime fechaDestino) {
		super();
		this.procedencia = procedencia;
		this.destino = destino;
		this.codigo = codigo;
		this.fechaProcedencia = fechaProcedencia;
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
	public LocalDateTime getFechaProcedencia() {
		return fechaProcedencia;
	}
	public void setFechaProcedencia(LocalDateTime fechaProcedencia) {
		this.fechaProcedencia = fechaProcedencia;
	}
	public LocalDateTime getFechaDestino() {
		return fechaDestino;
	}
	public void setFechaDestino(LocalDateTime fechaDestino) {
		this.fechaDestino = fechaDestino;
	}

}