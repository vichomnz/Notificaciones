package PerfulandiaSPA.Notificaciones.controller;

import PerfulandiaSPA.Notificaciones.model.NotificacionesModel;
import PerfulandiaSPA.Notificaciones.service.NotificacionesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
@RequiredArgsConstructor
public class NotificacionesController {
    private final NotificacionesService notificacionesService;

    @PostMapping
    public ResponseEntity<NotificacionesModel> crearNotificacion(@RequestBody NotificacionesModel notificacion) {
        return ResponseEntity.ok(notificacionesService.crearNotificacion(notificacion));
    }

    @GetMapping("/destinatario/{destinatario}")
    public ResponseEntity<List<NotificacionesModel>> obtenerNotificacionesPorDestinatario(@PathVariable String destinatario) {
        return ResponseEntity.ok(notificacionesService.obtenerNotificacionesPorDestinatario(destinatario));
    }

    @GetMapping
    public ResponseEntity<List<NotificacionesModel>> obtenerTodasNotificaciones() {
        return ResponseEntity.ok(notificacionesService.obtenerTodasNotificaciones());
    }
}