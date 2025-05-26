package PerfulandiaSPA.Notificaciones.repository;

import PerfulandiaSPA.Notificaciones.model.NotificacionesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NotificacionesRepository extends JpaRepository<NotificacionesModel, Long> {
    List<NotificacionesModel> findByDestinatario(String destinatario);
}