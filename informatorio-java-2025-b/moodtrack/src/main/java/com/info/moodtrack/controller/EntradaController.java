package com.info.moodtrack.controller;

import com.info.moodtrack.dto.entradadiaria.EntradaDiariaCreateDto;
import com.info.moodtrack.dto.entradadiaria.EntradaDiariaDto;
import com.info.moodtrack.service.entradadiaria.EntradaDiariaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.apache.catalina.connector.Response;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalDate;
import java.util.UUID;
import java.util.List;

@RestController
@RequestMapping("/api/v1/entrada-diaria")
@RequiredArgsConstructor
@Validated
@Slf4j
public class EntradaController {

    private final EntradaDiariaService entradaDiariaService;

    @PostMapping
    public ResponseEntity<EntradaDiariaDto> crear(@Valid @RequestBody EntradaDiariaCreateDto createDto){
        try {
            EntradaDiariaDto entradaCreada = entradaDiariaService.create( createDto );
            return ResponseEntity.ok( entradaCreada );
        }catch (IllegalArgumentException illegalArgumentException){
            return ResponseEntity.badRequest().build();
        }catch (Exception e){
            log.error("Error desconocido", e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<List<EntradaDiariaDto>> obtenerPorUsuarioId(
            @PathVariable UUID usuarioId,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate desde,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate hasta
    ){
        log.info("Buscando entradas para usuarioId={}", usuarioId);
        log.info("Rango de fechas: desde={} hasta={}", desde, hasta);

        List<EntradaDiariaDto> resultados =
                entradaDiariaService.obtenerPorUsuarioYFecha(usuarioId, desde, hasta);

        return ResponseEntity.ok(resultados);
    }
}