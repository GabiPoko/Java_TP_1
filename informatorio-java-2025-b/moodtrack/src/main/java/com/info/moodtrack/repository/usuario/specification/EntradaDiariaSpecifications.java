package com.info.moodtrack.repository.usuario.specification;

import com.info.moodtrack.model.EntradaDiaria;
import org.springframework.data.jpa.domain.Specification;
import java.time.LocalDate;
import java.util.UUID;


public final class EntradaDiariaSpecifications {

    private EntradaDiariaSpecifications() {}

    public static Specification<EntradaDiaria> porUsuario(final UUID usuarioId) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.equal(root.get("usuario").get("id"), usuarioId); 
    }

    public static Specification<EntradaDiaria> fechaDesde(final LocalDate desde) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.greaterThanOrEqualTo(root.get("fecha"), desde);
    }

    public static Specification<EntradaDiaria> fechaHasta(final LocalDate hasta) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.lessThanOrEqualTo(root.get("fecha"), hasta);
    }

}
