package com.info.moodtrack.repository.usuario.specification;

public class EntradaDiariaSpecifications {

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
