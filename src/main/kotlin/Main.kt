package org.pebiblioteca
import java.util.UUID

/**
 * Clase encargada de implementar utilidades la biblioteca
 **/
class UtilidadesBiblioteca{
    companion object{
        //función encargada de generar un id único
        fun generarIdentificadorUnico(): UUID {
            return  UUID.randomUUID()
        }

    }
}

/**
 * Clase encargada de gestionar la biblioteca
 **/
class GestorBiblioteca {
    //Lista que se encarga de almacenar los libros
    private val catalogo: MutableList<Libro> = mutableListOf()
    //Lista que se encarga de almacenar los Préstamos
    private val registroPrestamos: MutableList<Prestamo> = mutableListOf()
//    companion object{
//        val registroPrestamos: MutableList<Prestamo> = mutableListOf()
//    }
    fun mostrarHistorial(){
        println(RegistroPrestamos.historial)
    }

    //Agregar un libro al catálogo a partir del id.
    fun agregarLibro(libro: Libro) {
        val id = UtilidadesBiblioteca.generarIdentificadorUnico()
        libro.modificarId(id)
        catalogo.add(libro)
    }

    //Eliminar un libro del catálogo.
    fun eliminarLibro(libro: Libro) {
        catalogo.remove(libro)
    }

    //Registrar un préstamo (cambia el estado del libro a prestado si está disponible).
    fun prestarLibro(libro: Libro, usuario: Usuario) {
        if (libro.mostrarEstado() == EstadoLibro.DISPONIBLE) {
            libro.modificarEstado(EstadoLibro.PRESTADO)
            registroPrestamos.add(Prestamo(libro,usuario))//Se añade al registro de préstamos
            usuario.agregarPerstamos(libro)
            RegistroPrestamos().registrarPrestamo(Prestamo(libro,usuario))//Se añade el registro al historial
            println("El libro '${libro.mostrarTitulo()}' ha sido prestado a ${usuario.nombre}")
        } else {
            println("El libro '${libro.mostrarTitulo()}' no está disponible para préstamo")
        }
    }

    //Devolver un libro (cambia el estado del libro a disponible).
    fun devolverLibro(libro: Libro, usuario: Usuario) {
        if (usuario.librosPrestados.contains(libro)) {
            libro.modificarEstado(EstadoLibro.DISPONIBLE)

            usuario.eliminarPerstamos(libro)
            RegistroPrestamos().devolverLibro(Prestamo(libro,usuario))//Devuelve el libro y lo añade al historial
            println("El libro '${libro.mostrarTitulo()}' ha sido devuelto por ${usuario.nombre}")
        } else {
            println("El usuario ${usuario.nombre} no tiene prestado el libro '${libro.mostrarTitulo()}'")
        }
    }

    //Consultar disponibilidad de un libro.
    fun consultarDisponibilidad(libro: Libro) {
        val estado = if (libro.mostrarEstado() == EstadoLibro.DISPONIBLE) "Disponible" else "Prestado"
        println("El libro '${libro.mostrarTitulo()}' está $estado")
    }

    //Retornar los libros en función de su estado (todos, disponibles y prestados).
    fun consultarCatalogo() {
        println("Que libros quieres ver:\n1.Todos\n2.Disponibles\n3.Prestados")
        val option = readln()
        var verificar = false
        while (!verificar) {
            when (option) {
                "1" -> {
                    println(catalogo)
                    verificar = true

                }
                "2" -> {
                    catalogo.forEach { if( it.mostrarEstado() == EstadoLibro.DISPONIBLE )println(it) }
                    verificar = true

                }
                "3" -> {
                    catalogo.forEach { if(it.mostrarEstado() == EstadoLibro.PRESTADO)println(it) }
                    verificar = true

                }
                else -> print("Opción no valida(1,2,3)")
            }
        }
    }

}

/**
 * Clase encargada de crear objetos para el Registro de Préstamos
 * @property libro Libro que se a prestado.
 * @property usuario Usuario al que se le ha prestado.
 */
data class Prestamo(val libro: Libro, val usuario: Usuario)


/**
 * Clase encargada de llevar lo
 * @property historial Es el historial de los préstamos.
 */
class RegistroPrestamos{
    private val registrosPrestamos:MutableList<Prestamo> = mutableListOf()
    companion object{
        val historial: MutableList<MutableList<Prestamo>> = mutableListOf()
    }
    fun registrarPrestamo(prestamo: Prestamo){
        registrosPrestamos.add(prestamo)
        historial.add(registrosPrestamos)
    }
    fun devolverLibro(prestamo: Prestamo){
        registrosPrestamos.add(prestamo)
        historial.add(registrosPrestamos)
    }
    fun consultarHistorialPrestamosEspecificoLibro(libro: Libro){
        registrosPrestamos.forEach { if(libro == it.libro) println(it) }//Se recorre el registrosPrestamos para encontrar el libro y dar su informacion
    }
    fun consultarHistorialPrestamosEspecificoUsuario(usuario: Usuario){
        registrosPrestamos.forEach { if(usuario == it.usuario) println(it) }
    }
}





/**
 * Enum clase da los dos estados de un libro
 */
enum class EstadoLibro{DISPONIBLE,PRESTADO}

/**
 * Data class encargada de almacenar la información necesaria de un libro
 * @property id Id del libro.
 * @property titulo Titulo del libro.
 * @property autor Autor del libro.
 * @property anioPublicacion Año de publicación del libro.
 * @property tematica Tematica del libro.
 * @property estado Estado del libro.

 */
class Libro(
    private var id: UUID,
    private val titulo: String,
    private var autor: String,
    private val anioPublicacion: Int,
    private val tematica: String,
    private var estado: EstadoLibro = EstadoLibro.DISPONIBLE
){
    fun modificarId(id: UUID){
        this.id = id
    }
    fun modificarEstado(estado: EstadoLibro){
        this.estado = estado
    }

    fun mostrarEstado(): EstadoLibro {
        return estado
    }
    fun mostrarTitulo(): String {
        return titulo
    }

    override fun toString(): String {
        return "Libro(id:$id, titulo:$titulo,autor:$autor, año:$anioPublicacion, tematica:$tematica, estado:$estado)"
    }

}


/**
 * Data class encargada de almacenar la información necesaria de un libro
 * @property id Id del usuario.
 * @property nombre Nombre del usuario.
 * @property librosPrestados Listas de libros que se le a prestado al usuario.
 */
class Usuario(
     val id: UUID,
     val nombre: String,
     val librosPrestados: MutableList<Libro> = mutableListOf()
){
    fun agregarPerstamos(libro: Libro){
        librosPrestados.add(libro)
    }
    fun eliminarPerstamos(libro: Libro){
        librosPrestados.remove(libro)
    }
    fun consultarPerstamos(){
        println(librosPrestados)
    }

    override fun toString(): String {
        return "Usuario(id:$id, nombre:$nombre, libros prestados:$librosPrestados)"
    }

}


/**
 * Funcion encargada de gestionar un meno con todas las opciones del gestor de biblioteca
 * @property biblioteca Biblioteca para gestionar.
 * @property libro Libro que se quiere gestionar.
 * @property usuario Usuario que quiere realizar una accion.
 */
fun menuUsuario(biblioteca: GestorBiblioteca,libro: Libro,usuario: Usuario){
    println("Que quieres hacer:\n1.Agregar un libro\n2.Eliminar un libro\n3.Prestar un libro\n4.Devolver un libro\n5.Comprobar la disponibilidad\n6.Consultar el catalogo")
    val option = readln()
    var verificar = false
    while (!verificar) {
        when (option) {
            "1" -> {
                biblioteca.agregarLibro(libro)
                verificar = true

            }

            "2" -> {
                biblioteca.eliminarLibro(libro)
                verificar = true

            }

            "3" -> {
                biblioteca.prestarLibro(libro,usuario)
                verificar = true

            }
            "4" -> {
                biblioteca.devolverLibro(libro,usuario)
                verificar = true

            }
            "5" -> {
                biblioteca.consultarDisponibilidad(libro)
                verificar = true

            }
            "6" -> {
                biblioteca.consultarCatalogo()
                verificar = true

            }


            else -> print("Opción no valida(1,2,3,4,5,6)")
        }
    }
}


fun main() {
    //Instaciamos el gestor de biblioteca
    val gestorBiblioteca = GestorBiblioteca()
    //Instaciamos 3 libros
    val libro1 = Libro(UtilidadesBiblioteca.generarIdentificadorUnico(), "Cien años de soledad",  "Gabriel García Márquez",  1967,  "Realismo mágico")
    val libro2 = Libro( UtilidadesBiblioteca.generarIdentificadorUnico(),"1984",  "George Orwell",  1949,  "Ciencia ficción")
    val libro3 = Libro(UtilidadesBiblioteca.generarIdentificadorUnico(),"El principito",  "Antoine de Saint-Exupéry",  1943,  "Literatura infantil")
    //Agregamos al catálogo los 3 libros
    gestorBiblioteca.agregarLibro(libro1)
    gestorBiblioteca.agregarLibro(libro2)
    gestorBiblioteca.agregarLibro(libro3)


    //Instaciamos los 2 usuarios
    val usuario1 = Usuario( UtilidadesBiblioteca.generarIdentificadorUnico(),"Juan")
    val usuario2 = Usuario(UtilidadesBiblioteca.generarIdentificadorUnico(),  "María")

    //Prestamos 2 libros
    gestorBiblioteca.prestarLibro(libro1, usuario1)
    gestorBiblioteca.prestarLibro(libro2, usuario2)
    //Devolvemos 1 libros y uno tiene que dar error
    gestorBiblioteca.devolverLibro(libro1,usuario1)
    //Muestra el historial de prestamos y devoluciones
    gestorBiblioteca.mostrarHistorial()
    println(libro2)
    println(usuario2)


}
