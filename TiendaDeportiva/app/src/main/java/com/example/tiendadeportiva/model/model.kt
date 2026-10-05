package com.example.tiendadeportiva.model

class Categoria(
    val id: Int,
    val nombre: String,
    val descripcion: String
) {
    fun obtenerResumen(): String = "$nombre: $descripcion"
}

class Producto(
    val id: Int,
    val nombre: String,
    val marca: String,
    val precio: Double,
    stock: Int,
    val categoria: Categoria
) {
    var stock: Int = stock
        private set

    fun hayStock(): Boolean = stock > 0

    fun reducirStock(cantidad: Int) {
        if (cantidad in 1..stock) {
            stock -= cantidad
        }
    }

    fun obtenerResumen(): String = "$nombre ($marca) - Precio: $precio - Stock: $stock"
}

class Cliente(
    val id: Int,
    val nombre: String,
    val correo: String,
    val telefono: String
) {
    fun obtenerResumen(): String = "$nombre - $correo - $telefono"
}

class Pedido(
    val id: Int,
    val fecha: String,
    val cliente: Cliente
) {
    private val productos = mutableListOf<Producto>()

    fun agregarProducto(producto: Producto) {
        if (producto.hayStock()) {
            productos.add(producto)
        }
    }

    fun obtenerProductos(): List<Producto> = productos

    fun calcularTotal(): Double = productos.sumOf { it.precio }
}