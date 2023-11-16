package Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiGatewayController {

    @Autowired
    private ServicioAlquiler servicioAlquiler; // Inyecta tu servicio de lógica de negocio aquí

    @GetMapping("/estaciones")
    public List<EstacionDTO> getEstaciones() {
        // Llamada al servicio para obtener el listado de estaciones
        return servicioAlquiler.obtenerEstaciones();
    }

    @GetMapping("/estacion-cercana")
    public EstacionDTO getEstacionCercana(@RequestParam double latitud, @RequestParam double longitud) {
        // Llamada al servicio para obtener la estación más cercana
        return servicioAlquiler.obtenerEstacionCercana(latitud, longitud);
    }

    @PostMapping("/iniciar-alquiler/{estacionId}")
    public void iniciarAlquiler(@PathVariable String estacionId) {
        // Llamada al servicio para iniciar un alquiler
        servicioAlquiler.iniciarAlquiler(estacionId);
    }

    @PostMapping("/finalizar-alquiler/{estacionIdDevolucion}")
    public AlquilerDTO finalizarAlquiler(@PathVariable String estacionIdDevolucion, @RequestParam String moneda) {
        // Llamada al servicio para finalizar un alquiler y obtener el DTO resultante
        return servicioAlquiler.finalizarAlquiler(estacionIdDevolucion, moneda);
    }

    @PostMapping("/agregar-estacion")
    public void agregarEstacion(@RequestBody EstacionDTO estacionDTO) {
        // Llamada al servicio para agregar una nueva estación
        servicioAlquiler.agregarEstacion(estacionDTO);
    }
}
