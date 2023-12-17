package com.clearminds.maquina;

import java.util.ArrayList;

import com.clearminds.componentes.Celda;
import com.clearminds.componentes.Producto;

public class MaquinaDulces {

	private ArrayList<Celda> listaCeldas;
	private double saldo;

	public void agregarCelda(Celda celda) {

		if (listaCeldas == null) {
			listaCeldas = new ArrayList<Celda>();
		}

		listaCeldas.add(celda);
	}

	public void mostrarConfiguracion() {

		for (Celda celda : listaCeldas) {
			if (listaCeldas != null) {
				System.out.println("Codigos Celda: " + celda.getCodigo());
			} else {
				System.out.println("No existen celdas configuradas");
			}

		}

	}

	public Celda buscarCelda(String codigo) {

		if (listaCeldas != null) {
			for (Celda celda : listaCeldas) {
				if (codigo.equals(celda.getCodigo())) {
					return celda;
				}
			}
		}
		return null;
	}

	public void cargarProducto(Producto producto, String codigoCelda, int cantidadItemsIniciales) {
		Celda celdaRecuperada;
		celdaRecuperada = buscarCelda(codigoCelda);
		celdaRecuperada.ingresarProducto(producto, cantidadItemsIniciales);
	}

	public void mostrarProductos() {
		if (listaCeldas != null) {
			for (Celda celda : listaCeldas) {

				Producto producto = celda.getProducto();

				if (producto != null) {
					System.out.println(" Producto: " + celda.getProducto().getCodigo());
					System.out.println(" Precio: " + celda.getProducto().getPrecio());
				} else {
					System.out.println(" Sin producto asignado");
				}

				System.out.println(" Codigo celda: " + celda.getCodigo());
				System.out.println(" Stock actual: " + celda.getStock());
			}
		}
	}

	public Producto buscarProductoEnCelda(String codigoCelda) {

		if (listaCeldas != null) {
			for (Celda celda : listaCeldas) {
				if (codigoCelda.equals(celda.getCodigo())) {
					Producto producto = celda.getProducto();
					if (producto != null) {
						return producto;
					}
				}

			}
		}
		return null;

	}

	public double consultarPrecio(String codigoCelda) {

		if (listaCeldas != null) {
			for (Celda celda : listaCeldas) {
				if (codigoCelda.equals(celda.getCodigo())) {
					Producto producto = celda.getProducto();
					if (producto != null) {
						return producto.getPrecio();
					}
				}
			}
		}

		return 0.0;
	}

	public Celda buscarCeldaProducto(String codigoProducto) {

		if (listaCeldas != null) {
			for (Celda celda : listaCeldas) {
				Producto producto = celda.getProducto();
				if (producto != null && codigoProducto.equals(producto.getCodigo())) {
					return celda;
				}
			}
		}
		return null;
	}

	public void incrementarProductos(String codigoProducto, int cantidadItemsIncrementar) {
		Celda celdaEncontrada;
		celdaEncontrada = buscarCeldaProducto(codigoProducto);
		if (celdaEncontrada != null) {
			int stockActual = celdaEncontrada.getStock();
			celdaEncontrada.setStock(stockActual + cantidadItemsIncrementar);
		}

	}

	public void vender(String codigoCelda) {
		if (listaCeldas != null) {
			for (Celda celda : listaCeldas) {
				Producto producto = celda.getProducto();
				if (codigoCelda.equals(celda.getCodigo())) {
					if (producto != null) {
						int stockActual = celda.getStock();
						celda.setStock(stockActual - 1);
						double precioProducto = producto.getPrecio();
						saldo += precioProducto;
						System.out.println("Saldo: " + saldo);
					}
				}
			}

		}
		mostrarProductos();
	}

	public double venderConCambio(String codigoCelda, double valorIngresado) {
		if (listaCeldas != null) {
			for (Celda celda : listaCeldas) {
				Producto producto = celda.getProducto();
				if (codigoCelda.equals(celda.getCodigo())) {
					int stockActual = celda.getStock();
					if (stockActual > 0) {
						double precioProducto = producto.getPrecio();
						if (valorIngresado >= precioProducto) {
							double cambio = valorIngresado - precioProducto;
							saldo += precioProducto;
							System.out.println("Saldo: " + saldo);
							return cambio;
						} else {
							System.out.println("Dinero insuficiente.");
							return 0;
						}
					} else {
						System.out.println("No hay stock disponible para vender en la celda " + codigoCelda);
						return 0;
					}
				}
			}
		}
		System.out.println("No se encontró la celda con código " + codigoCelda);
		return 0;
	}

	public ArrayList<Producto> buscarMenores(double limite) {
		ArrayList<Producto> listaProductos = new ArrayList<Producto>();
		for (Celda celda : listaCeldas) {
			Producto producto = celda.getProducto();
			if (producto != null && producto.getPrecio() <= limite) {
				listaProductos.add(producto);

			}
		}
		
		System.out.println("Productos menores: " + listaProductos.size());
		for (Producto producto : listaProductos) {
			System.out.println("Nombre: " + producto.getNombre());
			System.out.println("Precio: " + producto.getPrecio());
		}

		return listaProductos;
	}

}
