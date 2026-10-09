package ec.edu.monster;

import ec.edu.monster.controladores.ws.WSConversorUnidades;
import ec.edu.monster.modelos.utilidades.enums.UnidadLongitud;
import ec.edu.monster.modelos.utilidades.enums.UnidadMasa;
import ec.edu.monster.modelos.utilidades.enums.UnidadTemperatura;
import ec.edu.monster.modelos.utilidades.mapeadores.UnidadMapper;
import ec.edu.monster.seguridad.AdministradorCredenciales;
import ec.edu.monster.seguridad.AdministradorToken;
import ec.edu.monster.seguridad.AdministradorTokens;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConversorUnidadesTest {

    private WSConversorUnidades servicio;

    @BeforeEach
    void setUp() {
        servicio = new WSConversorUnidades();
    }

    @Test
    void testConversionLongitud() {
        // 1 metro = 100 centímetros
        double resultado = servicio.convertirLongitud(1.0, "METRO", "CENTIMETRO");
        assertEquals(100.0, resultado, 0.001);

        // 1000 metros = 1 kilómetro
        resultado = servicio.convertirLongitud(1000.0, "m", "km");
        assertEquals(1.0, resultado, 0.001);
    }

    @Test
    void testConversionMasa() {
        // 1 kilogramo = 1000 gramos
        double resultado = servicio.convertirMasa(1.0, "KILOGRAMO", "GRAMO");
        assertEquals(1000.0, resultado, 0.001);

        // 1 tonelada = 1000 kilogramos
        resultado = servicio.convertirMasa(1.0, "TONELADA", "KILOGRAMO");
        assertEquals(1000.0, resultado, 0.001);
    }

    @Test
    void testConversionTemperatura() {
        // 0 °C = 32 °F
        double resultado = servicio.convertirTemperatura(0.0, "CELSIUS", "FAHRENHEIT");
        assertEquals(32.0, resultado, 0.001);

        // 100 °C = 212 °F
        resultado = servicio.convertirTemperatura(100.0, "c", "f");
        assertEquals(212.0, resultado, 0.001);

        // 0 °C = 273.15 K
        resultado = servicio.convertirTemperatura(0.0, "CELSIUS", "KELVIN");
        assertEquals(273.15, resultado, 0.001);
    }

    @Test
    void testLoginYCredenciales() {
        // Login exitoso
        String token = servicio.login("admin", "admin");
        assertNotNull(token);
        assertFalse(token.isBlank());
        assertTrue(AdministradorToken.validarToken(token));
        assertTrue(AdministradorTokens.validarToken(token));

        // Login fallido
        assertThrows(RuntimeException.class, () -> servicio.login("admin", "clave_invalida"));
    }

    @Test
    void testCambiarContrasenia() {
        AdministradorCredenciales.registrarUsuario("testuser", "clave123");
        assertTrue(AdministradorCredenciales.validarUsuario("testuser", "clave123"));

        AdministradorCredenciales.cambiarContrasenia("testuser", "clave123", "claveNueva456");
        assertTrue(AdministradorCredenciales.validarUsuario("testuser", "claveNueva456"));
    }

    @Test
    void testUnidadMapper() {
        assertEquals(UnidadLongitud.METRO, UnidadMapper.toLongitud("m"));
        assertEquals(UnidadLongitud.KILOMETRO, UnidadMapper.toLongitud("KILOMETROS"));
        assertEquals(UnidadMasa.KILOGRAMO, UnidadMapper.toMasa("kg"));
        assertEquals(UnidadTemperatura.CELSIUS, UnidadMapper.toTemperatura("celsius"));

        assertThrows(IllegalArgumentException.class, () -> UnidadMapper.toLongitud("unidad_falsa"));
    }
}
