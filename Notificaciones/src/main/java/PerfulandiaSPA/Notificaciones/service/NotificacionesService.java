package PerfulandiaSPA.Notificaciones.service;

import PerfulandiaSPA.Notificaciones.model.NotificacionesModel;
import PerfulandiaSPA.Notificaciones.repository.NotificacionesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificacionesService {
    private final NotificacionesRepository notificacionesRepository;

    public NotificacionesModel crearNotificacion(NotificacionesModel notificacion) {
        notificacion.setFechaCreacion(LocalDateTime.now());
        return notificacionesRepository.save(notificacion);
    }

    public List<NotificacionesModel> obtenerNotificacionesPorDestinatario(String destinatario) {
        return notificacionesRepository.findByDestinatario(destinatario);
    }

    public List<NotificacionesModel> obtenerTodasNotificaciones() {
        return notificacionesRepository.findAll();
    }
}