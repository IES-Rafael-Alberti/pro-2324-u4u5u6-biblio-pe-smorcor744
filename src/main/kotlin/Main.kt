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
    private val catalogo: MutableMap<UUID,Libro> = mutableMapOf()
    //Lista que se encarga de almacenar los Préstamos
    private val registroPrestamos: MutableList<Prestamo> = mutableListOf()

    //Agregar un libro al catálogo a partir del id.
    fun agregarLibro(libro: Libro) {
        catalogo[UtilidadesBiblioteca.generarIdentificadorUnico()]=libro
    }

    //Eliminar un libro del catálogo.
    fun eliminarLibro(id: UUID) {
        catalogo.remove(id)
    }

    //Registrar un préstamo (cambia el estado del libro a prestado si está disponible).
    fun prestarLibro(libro: Libro, usuario: Usuario) {
        if (libro.estado == EstadoLibro.DISPONIBLE) {
            libro.estado = EstadoLibro.PRESTADO
            usuario.librosPrestados.add(libro)
            registroPrestamos.add(Prestamo(libro,usuario))//Se añade al registro de préstamos
            println("El libro '${libro.titulo}' ha sido prestado a ${usuario.nombre}")
        } else {
            println("El libro '${libro.titulo}' no está disponible para préstamo")
        }
    }

    //Devolver un libro (cambia el estado del libro a disponible).
    fun devolverLibro(libro: Libro, usuario: Usuario) {
        if (usuario.librosPrestados.contains(libro)) {
            libro.estado = EstadoLibro.DISPONIBLE
            usuario.librosPrestados.remove(libro)
            println("El libro '${libro.titulo}' ha sido devuelto por ${usuario.nombre}")
        } else {
            println("El usuario ${usuario.nombre} no tiene prestado el libro '${libro.titulo}'")
        }
    }

    //Consultar disponibilidad de un libro.
    fun consultarDisponibilidad(libro: Libro) {
        val estado = if (libro.estado == EstadoLibro.DISPONIBLE) "Disponible" else "Prestado"
        println("El libro '${libro.titulo}' está $estado")
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
                    catalogo.forEach { if( it.value.estado == EstadoLibro.DISPONIBLE )println(it) }
                    verificar = true

                }
                "3" -> {
                    catalogo.forEach { if(it.value.estado == EstadoLibro.PRESTADO)println(it) }
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
data class Libro(
    val id: Int,
    val titulo: String,
    val autor: String,
    val anioPublicacion: Int,
    val tematica: String,
    var estado: EstadoLibro = EstadoLibro.DISPONIBLE
)


/**
 * Data class encargada de almacenar la información necesaria de un libro
 * @property id Id del usuario.
 * @property nombre Nombre del usuario.
 * @property librosPrestados Listas de libros que se le a prestado al usuario.
 */
data class Usuario(
    val id: Int,
    val nombre: String,
    val librosPrestados: MutableList<Libro> = mutableListOf()
)


/**
 * Funcion encargada de gestionar un meno con todas las opciones del gestor de biblioteca
 * @property biblioteca Biblioteca para gestionar.
 * @property libro Libro que se quiere gestionar.
 * @property usuario Usuario que quiere realizar una accion.
 */
fun menuUsuario(biblioteca: GestorBiblioteca,libro: Libro,usuario: Usuario,id: UUID){
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
                biblioteca.eliminarLibro(id)
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
    val libro1 = Libro(12, "Cien años de soledad",  "Gabriel García Márquez",  1967,  "Realismo mágico")
    val libro2 = Libro( 11,"1984",  "George Orwell",  1949,  "Ciencia ficción")
    val libro3 = Libro(10,"El principito",  "Antoine de Saint-Exupéry",  1943,  "Literatura infantil")
    //Instanciamos un id
    val id:UUID = UtilidadesBiblioteca.generarIdentificadorUnico()

    //Agregamos al catálogo los 3 libros
    gestorBiblioteca.agregarLibro(libro1)
    gestorBiblioteca.agregarLibro(libro2)
    gestorBiblioteca.agregarLibro(libro3)
    //Instaciamos los 2 usuarios
    val usuario1 = Usuario( 1,"Juan")
    val usuario2 = Usuario(2,  "María")
    //Prestamos 2 libros y uno tiene que dar error
    gestorBiblioteca.prestarLibro(libro1, usuario1)
    gestorBiblioteca.prestarLibro(libro1, usuario2)
    //Devolvemos 2 libros y uno tiene que dar error
    gestorBiblioteca.devolverLibro(libro1,usuario1)
    gestorBiblioteca.devolverLibro(libro2,usuario2)
    //Consultamos la disponivilidad de los 3 libros
    gestorBiblioteca.consultarDisponibilidad(libro1)
    gestorBiblioteca.consultarDisponibilidad(libro2)
    gestorBiblioteca.consultarDisponibilidad(libro3)
    //Mostramos el menu con un libro y un usuario
    menuUsuario(gestorBiblioteca,libro3,usuario1,id)
}
