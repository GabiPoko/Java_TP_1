package com.info.moodtrack.service.entradadiaria;

import java.time.LocalDate;

import com.info.moodtrack.dto.entradadiaria.EntradaDiariaCreateDto;
import com.info.moodtrack.dto.entradadiaria.EntradaDiariaDto;
import java.util.List;
import java.util.UUID;

public interface EntradaDiariaService {
    EntradaDiariaDto create(EntradaDiariaCreateDto createDto);

    List<EntradaDiariaDto> obtenerPorUsuarioYFecha(UUID usuarioId, LocalDate desde, LocalDate hasta);
}
