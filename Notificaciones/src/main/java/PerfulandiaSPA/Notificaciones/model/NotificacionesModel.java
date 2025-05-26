package PerfulandiaSPA.Notificaciones.model;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "notificaciones")
public class NotificacionesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String mensaje;

    @Column(nullable = false)
    private String destinatario;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoNotificacion tipo;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    public enum TipoNotificacion {
        PROMOCION, NUEVO_PRODUCTO, CONFIRMACION_PEDIDO, RECORDATORIO
    }
}