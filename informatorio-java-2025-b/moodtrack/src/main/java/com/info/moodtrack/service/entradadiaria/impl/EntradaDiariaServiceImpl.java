package com.info.moodtrack.service.entradadiaria.impl;

import com.info.moodtrack.dto.entradadiaria.EntradaDiariaCreateDto;
import com.info.moodtrack.dto.entradadiaria.EntradaDiariaDto;
import com.info.moodtrack.mapper.entradadiaria.EntradaDiariaMapper;
import com.info.moodtrack.model.EntradaDiaria;
import com.info.moodtrack.model.Habito;
import com.info.moodtrack.model.Usuario;
import com.info.moodtrack.repository.habito.HabitoRepository;
import com.info.moodtrack.repository.usuario.UsuarioRepository;
import com.info.moodtrack.repository.usuario.entradadiaria.EntradaDiariaRepository;
import com.info.moodtrack.service.entradadiaria.EntradaDiariaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class EntradaDiariaServiceImpl implements EntradaDiariaService {

    private final EntradaDiariaRepository entradaDiariaRepository;
    private final UsuarioRepository usuarioRepository;
    private final HabitoRepository habitoRepository;

    @Override
    public EntradaDiariaDto create(EntradaDiariaCreateDto createDto) {
        log.info("Creando entrada Diaria");
        UUID uuidUsuario = createDto.getUsuarioId();

        Optional<Usuario> usuario = usuarioRepository.findById(uuidUsuario);

        if(usuario.isEmpty()){
            log.warn("Usuario no encontrado");
            throw new IllegalArgumentException("Usuario no encontrado id : " + uuidUsuario);
        }

        List<Habito> habitos = List.of();
        if(createDto.getHabitosIds() != null && !createDto.getHabitosIds().isEmpty()){
            habitos = habitoRepository.findAllById( createDto.getHabitosIds() );
            if(habitos.size() != createDto.getHabitosIds().size()){
                log.warn("Alguno de los habitos no se ha encontrado");
            }
        }

        EntradaDiaria entradaDiaria = new EntradaDiaria();
        entradaDiaria.setUsuario(usuario.get());
        entradaDiaria.setHabitos(habitos);
        entradaDiaria.setFecha(createDto.getFecha());
        entradaDiaria.setReflexion(createDto.getReflexion());
        entradaDiaria.setEmocion(createDto.getEmocion());

        EntradaDiaria saved = entradaDiariaRepository.save(entradaDiaria);

        log.info("Entrada guardado exitosamente");
        return EntradaDiariaMapper.toDto( saved );
    }

    @Override
    public List<EntradaDiariaDto> obtenerPorUsuarioYFecha(UUID usuarioId, LocalDate desde, LocalDate hasta) {
    
        log.info("Service: Iniciando búsqueda de entradas para usuario {} con filtros. Desde: {}, Hasta: {}", 
             usuarioId, desde, hasta);

        if (usuarioRepository.findById(usuarioId).isEmpty()) {
            log.warn("Usuario no encontrado id={}. Lanzando excepción 404.", usuarioId);
            throw new UsuarioNoEncontradoException(usuarioId.toString()); 
    }
        
        Specification<EntradaDiaria> spec = Specification.unrestricted();

        spec = spec.and(EntradaDiariaSpecifications.porUsuario(usuarioId));
    
        spec = spec.and(EntradaDiariaSpecifications.porUsuario(usuarioId));
    
        if (desde != null) {
            log.info("Añadiendo filtro Specification: Desde");
            spec = spec.and(EntradaDiariaSpecifications.fechaDesde(desde));
    }
    
        if (hasta != null) {
            log.info("Añadiendo filtro Specification: Hasta");
            spec = spec.and(EntradaDiariaSpecifications.fechaHasta(hasta));
    }
    
        List<EntradaDiaria> entradas = entradaDiariaRepository.findAll(spec);
    
        log.info("Búsqueda finalizada. Se encontraron {} entradas.", entradas.size());
        return EntradaDiariaMapper.toDtoList(entradas);
}
}