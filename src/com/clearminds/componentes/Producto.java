package com.clearminds.componentes;

public class Producto {
	private String codigo;
	private String nombre;
	private double precio;

	public Producto(String codigo, String nombre, double precio) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void incrementarPrecio(double porcentajeIncremento) {
		if (porcentajeIncremento >= 0) {
			double incremento = 1 + porcentajeIncremento / 100.0;
			precio *= incremento;
		} else {
			System.out.println("El valor del incremento es menor a 0");
		}
	}

	public void disminuirPrecio(double valorDescuento) {
		if (valorDescuento >= 0) {
			double descuento = precio * valorDescuento;
			double valorFinal = precio - descuento;
			
			valorFinal = Math.ceil(valorFinal);

			precio = valorFinal;
		} else {
			System.out.println("Valor del descuento menor a 0");
		}
	}

}
