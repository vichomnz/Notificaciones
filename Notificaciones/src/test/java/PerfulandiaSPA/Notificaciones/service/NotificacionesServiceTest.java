package PerfulandiaSPA.Notificaciones.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import PerfulandiaSPA.Notificaciones.model.NotificacionesModel;
import PerfulandiaSPA.Notificaciones.repository.NotificacionesRepository;

public class NotificacionesServiceTest {

    @Mock
    private NotificacionesRepository notificacionesRepository;

    @InjectMocks
    private NotificacionesService notificacionesService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCrearNotificacion() {
        NotificacionesModel notificacion = new NotificacionesModel();
        notificacion.setDestinatario("user1@example.com");
        notificacion.setMensaje("Nueva notificación");
        NotificacionesModel notificacionGuardada = new NotificacionesModel();
        notificacionGuardada.setId(1L); // Asumimos un ID generado
        notificacionGuardada.setDestinatario("user1@example.com");
        notificacionGuardada.setMensaje("Nueva notificación");
        notificacionGuardada.setFechaCreacion(LocalDateTime.now());
        when(notificacionesRepository.save(notificacion)).thenReturn(notificacionGuardada);

        NotificacionesModel resultado = notificacionesService.crearNotificacion(notificacion);

        assertThat(resultado).isNotNull();
        assertThat(resultado.getDestinatario()).isEqualTo("user1@example.com");
        assertThat(resultado.getMensaje()).isEqualTo("Nueva notificación");
        assertThat(resultado.getFechaCreacion()).isNotNull();
        verify(notificacionesRepository).save(notificacion);
    }

    @Test
    void testObtenerNotificacionesPorDestinatario() {
        NotificacionesModel notificacion1 = new NotificacionesModel();
        notificacion1.setId(1L);
        notificacion1.setDestinatario("user1@example.com");
        notificacion1.setMensaje("Notificación 1");
        notificacion1.setFechaCreacion(LocalDateTime.now());
        NotificacionesModel notificacion2 = new NotificacionesModel();
        notificacion2.setId(2L);
        notificacion2.setDestinatario("user1@example.com");
        notificacion2.setMensaje("Notificación 2");
        notificacion2.setFechaCreacion(LocalDateTime.now());
        when(notificacionesRepository.findByDestinatario("user1@example.com")).thenReturn(Arrays.asList(notificacion1, notificacion2));

        List<NotificacionesModel> resultado = notificacionesService.obtenerNotificacionesPorDestinatario("user1@example.com");

        assertThat(resultado).hasSize(2);
        assertThat(resultado).contains(notificacion1, notificacion2);
        verify(notificacionesRepository).findByDestinatario("user1@example.com");
    }

    @Test
    void testObtenerTodasNotificaciones() {
        NotificacionesModel notificacion1 = new NotificacionesModel();
        notificacion1.setId(1L);
        notificacion1.setDestinatario("user1@example.com");
        notificacion1.setMensaje("Notificación 1");
        notificacion1.setFechaCreacion(LocalDateTime.now());
        NotificacionesModel notificacion2 = new NotificacionesModel();
        notificacion2.setId(2L);
        notificacion2.setDestinatario("user2@example.com");
        notificacion2.setMensaje("Notificación 2");
        notificacion2.setFechaCreacion(LocalDateTime.now());
        when(notificacionesRepository.findAll()).thenReturn(Arrays.asList(notificacion1, notificacion2));

        List<NotificacionesModel> resultado = notificacionesService.obtenerTodasNotificaciones();

        assertThat(resultado).hasSize(2);
        assertThat(resultado).contains(notificacion1, notificacion2);
        verify(notificacionesRepository).findAll();
    }
}