package com.clearminds.test;
import com.clearminds.componentes.*;
import com.clearminds.maquina.MaquinaDulces;

public class TestBuscarMenores {

	public static void main(String[] args) {
		MaquinaDulces maquina = new MaquinaDulces();
		maquina.agregarCelda(new Celda("1"));
		maquina.agregarCelda(new Celda("2"));
		maquina.agregarCelda(new Celda("3"));
		maquina.agregarCelda(new Celda("4"));
		maquina.agregarCelda(new Celda("5"));
		maquina.agregarCelda(new Celda("6"));
		
		Producto producto1 = new Producto("KE34", "Papitas", 0.85);
		maquina.cargarProducto(producto1, "1", 4);
		
		Producto producto2 = new Producto("KE34", "Doritos", 10);
		maquina.cargarProducto(producto2, "2", 6);
		
		Producto producto3 = new Producto("KE34", "Agua", 5.50);
		maquina.cargarProducto(producto3, "3", 7);
		
		Producto producto4 = new Producto("KE34", "Papel", 4.50);
		maquina.cargarProducto(producto4, "4", 8);
		
		Producto producto5 = new Producto("KE34", "Alchol", 6.85);
		maquina.cargarProducto(producto5, "5", 11);
		
		Producto producto6 = new Producto("KE34", "Anbientador", 3.85);
		maquina.cargarProducto(producto6, "6", 12);
		
		maquina.buscarMenores(7.50);

	}

}
