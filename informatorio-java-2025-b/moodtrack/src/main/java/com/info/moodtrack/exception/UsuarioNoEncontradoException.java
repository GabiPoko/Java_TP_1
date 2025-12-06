package com.info.moodtrack.exception;

public class UsuarioNoEncontradoException extends RuntimeException {
    public UsuarioNoEncontradoException(String id) {
        super("El usuario con ID " + id + " no fue encontrado.");
    }

}
