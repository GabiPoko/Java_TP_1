package com.info.moodtrack.repository.usuario.entradadiaria;


import com.info.moodtrack.model.EntradaDiaria;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EntradaDiariaRepository extends JpaRepository<EntradaDiaria, Long>, JpaSpecificationExecutor<EntradaDiaria>{
    List<EntradaDiaria> findByUsuarioId(UUID usuarioId);
    List<EntradaDiaria> findByUsuarioIdAndFechaBetween(UUID usuarioId, LocalDate desde, LocalDate hasta);
    List<EntradaDiaria> findByUsuarioIdAndFechaGreaterThanEqual(UUID usuarioId, LocalDate desde);
    List<EntradaDiaria> findByUsuarioIdAndFechaLessThanEqual(UUID usuarioId, LocalDate hasta);
}
