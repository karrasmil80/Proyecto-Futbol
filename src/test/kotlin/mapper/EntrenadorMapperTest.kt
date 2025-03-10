package mapper

import org.example.Dto.EntrenadorDto
import org.example.mapper.toDto
import org.example.mapper.toModel
import org.example.models.Entrenador
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import toDto
import toModel

class EntrenadorMapperTest {

        @Test
        @DisplayName("Test Personal to Dto")
        fun EntrenadorToDto() {
            // Arrange: Creamos un objeto Entrenador con datos específicos.
            val entrenador = Entrenador(
                id = 1L,
                nombre = "Carlos",
                apellidos = "González",
                fechaNacimiento = "1985-05-12",
                fechaIncorporacion = "2010-08-01",
                salario = 2500.0,
                pais = "España",
                especialidad = Entrenador.Especializacion.ENTRENADOR_ASISTENTE,
                rol = "Entrenador"
            )

            // Act: Convertimos el Entrenador a un PersonalDto usando el método toDto.
            val personalDto = entrenador.toDto()

            // Assert: Verificamos que los valores del Entrenador se hayan mapeado correctamente en el PersonalDto.
            assertEquals(entrenador.id, personalDto.id)
            assertEquals(entrenador.nombre, personalDto.nombre)
            assertEquals(entrenador.apellidos, personalDto.apellidos)
            assertEquals(entrenador.fechaNacimiento, personalDto.fecha_nacimiento)
            assertEquals(entrenador.fechaIncorporacion, personalDto.fecha_incorporacion)
            assertEquals(entrenador.salario, personalDto.salario)
            assertEquals(entrenador.pais, personalDto.pais)
            assertEquals(entrenador.especialidad.toString(), personalDto.especialidad)
            assertEquals("Entrenador", personalDto.rol)
            assertEquals("", personalDto.posicion) // En el ejemplo es una cadena vacía
            assertEquals(null, personalDto.dorsal)
            assertEquals(null, personalDto.altura)
            assertEquals(null, personalDto.peso)
            assertEquals(null, personalDto.goles)
            assertEquals(null, personalDto.partidos_jugados)
        }

        @Test
        fun EntrenadorDtoToModel() {
            // Arrange: Creamos un objeto EntrenadorDto con datos específicos.
            val entrenadorDto = EntrenadorDto(
                id = 1L,
                nombre = "Carlos",
                apellidos = "González",
                fechaNacimiento = "1985-05-12",
                fechaIncorporacion = "2010-08-01",
                salario = 2500.0,
                pais = "España",
                especialidad = Entrenador.Especializacion.ENTRENADOR_ASISTENTE,
                rol = "Entrenador"
            )

            // Act: Convertimos el EntrenadorDto a un objeto Entrenador usando el método toModel.
            val entrenador = entrenadorDto.toModel() as Entrenador

            // Assert: Verificamos que los valores del EntrenadorDto se hayan mapeado correctamente en el Entrenador.
            assertEquals(entrenadorDto.id, entrenador.id)
            assertEquals(entrenadorDto.nombre, entrenador.nombre)
            assertEquals(entrenadorDto.apellidos, entrenador.apellidos)
            assertEquals(entrenadorDto.fechaNacimiento, entrenador.fechaNacimiento)
            assertEquals(entrenadorDto.fechaIncorporacion, entrenador.fechaIncorporacion)
            assertEquals(entrenadorDto.salario, entrenador.salario)
            assertEquals(entrenadorDto.pais, entrenador.pais)
            assertEquals(entrenadorDto.especialidad, entrenador.especialidad) // Asumimos que 'especialidad' es un enum en el modelo
            assertEquals(entrenadorDto.rol, entrenador.rol)
        }


    }