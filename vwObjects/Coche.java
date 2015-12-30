package vwObjects;

public class Coche {

	public String marca;
	public String modelo;
	public double precio;
	public String rutaImagen;
	public double kilometraje;
	public String urlDetalles;
	public Integer anio;

	
	
	
	@Override
	public String toString() {
		return "Coche [marca=" + marca + ", modelo=" + modelo + ", precio="
				+ precio + ", rutaImagen=" + rutaImagen + ", kilometraje="
				+ kilometraje + ", urlDetalles=" + urlDetalles + ", anio="
				+ anio + "]";
	}
	
	public String toFile(){
		return marca + "\t" + modelo + "\t" + anio + "\t" + precio + "\t" + urlDetalles;
	}

	public Coche(){

	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getKilometraje() {
		return kilometraje;
	}

	public void setKilometraje(double kilometraje) {
		this.kilometraje = kilometraje;
	}

	public String getUrlDetalles() {
		return urlDetalles;
	}

	public void setUrlDetalles(String urlDetalles) {
		this.urlDetalles = urlDetalles;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	
	
	
	
}
