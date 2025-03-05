package org.example

import org.example.models.Personal
import org.example.storage.PersonalStorageJson
import java.io.File
<<<<<<< HEAD
import org.example.cache.CacheLRU
<<<<<<< HEAD
=======
=======
>>>>>>> upstream/dev
import org.example.exceptions.exceptions
import org.example.models.Jugador
import org.example.repository.PersonalRepository
import org.example.service.PersonalService
import org.example.storage.PersonalStorageCsv
import org.example.cache.CacheImpl
>>>>>>> upstream/dev
//import org.example.storage.PersonalStorageControlador
import org.lighthousegames.logging.logging


/*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import nl.adaptivity.xmlutil.dom2.Document
import nl.adaptivity.xmlutil.serialization.XML
import org.example.cache.CacheLRU
import org.example.models.Entrenador
import org.example.models.Jugador
import org.example.models.Personal
/*import org.example.storage.PersonalStorageJson*/
import nl.adaptivity.xmlutil.serialization.XML
import org.example.models.Entrenador
import org.example.models.Jugador
import org.example.models.Personal
import org.example.storage.storage.PersonalStorageXml
//import org.example.storage.storage.PersonalStorageXml
// import org.example.storage.storage.EntrenadorStorageJson
import java.io.File
import javax.xml.parsers.DocumentBuilderFactory
*/

<<<<<<< HEAD
/*
* Caché LRU (Least Recently Used) para almacenar objetos de tipo Personal.
*
* @property personalCache Es una instancia de CacheLRU que utiliza enteros como claves y objetos de tipo Personal como valores.
* La caché tiene un tamaño máximo de 5 elementos.
* */
val personalCache = CacheLRU<Int, Personal>(5)
fun generarId(): Long {
    return personalCache.listAll().size + 1L
=======

val personalCache = CacheImpl<Int, Personal>(5)
fun generarId(): Int {
    return personalCache.listAll().size + 1
>>>>>>> upstream/dev
}
fun main() {

    val logger = logging()



   // LEER EL JSON
   val storageJson = PersonalStorageJson()
   val fileJson = File("data", "personal.json")

   val personalList = storageJson.readFromFile(fileJson)
   personalList.forEach { println(it) }


   //SOBREESCRIBIR EL JSON
    /*
    val nuevoJugadorJson = Jugador(
        id = 41,
        nombre = "Lucia",
        apellidos = "Fuertes Cruz",
        fechaNacimiento = "1987-06-24",
        fechaIncorporacion = "2021-08-01",
        salario = 500000.0,
        pais = "Argentina",
        rol = "Jugador",
        posicion = Jugador.Posicion.DELANTERO,
        dorsal = 10,
        altura = 1.7,
        peso = 72.0,
        goles = 7000,
        partidosJugados = 9000
    )
    val listaNuevoJugadorJson = personalList + nuevoJugadorJson
    logger.debug { "Sobreescribiendo archivo Json..." }

    storageJson.writeToFile(listaNuevoJugadorJson, fileJson)
     */

//    //Leer cualquier tipo de archivos
//    val storage = PersonalStorageControlador()
//    val rutaArchivo = "data/-archivo-"
//    val file = File(rutaArchivo)
//    try {
//        val controlador = PersonalStorageControlador(file)
//
//    } catch(e:Exception){
//        println("Error al procesar el fichero")
//    }

    //storage.writeToFile(listaNuevoJugador, file)


    // LEER EL XML
    /*
    val fileXML = File("data", "personal.xml")
    val equipoXML = storage.readFromFile(fileXML)
    equipoXML.forEach { println(it) }
    */

    // Leer CSV
    val storageCSV = PersonalStorageCsv()
    val fileCsv = File("data", "personal.csv")

    val personalListCsv = storageCSV.readFromFile(fileCsv)
    personalList.forEach { println(it) }


   //SOBREESCRIBIR EL CSV
    /*
    val nuevoJugador = Jugador(
        id = 999L,
        nombre = "Lucia",
        apellidos = "Fuertes Cruz",
        fechaNacimiento = "1987-06-24",
        fechaIncorporacion = "2021-08-01",
        salario = 500000.0,
        pais = "Argentina",
        rol = "Jugador",
        posicion = Jugador.Posicion.DELANTERO,
        dorsal = 10,
        altura = 1.7,
        peso = 72.0,
        goles = 700,
        partidosJugados = 900
    )
    val listaNuevoJugador = personalList + nuevoJugador
    logger.debug { "Sobreescribiendo archivo Csv..." }
    storageCSV.writeToFile(listaNuevoJugador, fileCsv)
     */

}