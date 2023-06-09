package com.fatec.fcmm.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.fatec.fcmm.model.Usuario.Usuario;
import com.fatec.fcmm.model.Usuario.Repositorys.MantemUsuarioRepository;

public class MantemUsuarioI implements MantemUsuario {
    Logger logger = LogManager.getLogger(this.getClass());
    @Autowired
    MantemUsuarioRepository repository;

    public List<Usuario> consultaTodos() {
        logger.info(">>>>>> servico consultaTodos chamado");
        return repository.findAll();
    }

    public Optional<Usuario> consultaPorId(Long id) {
        logger.info(">>>>>> servico consultaPorId chamado");
        return repository.findById(id);
    }

    public void delete(Long id) {
        logger.info(">>>>>> servico delete por id chamado");
        repository.deleteById(id);
    }

    public Optional<Usuario> consultaPorNome(String Nome) {
        logger.info(">>>>>> servico consultaPorNome chamado");
        return repository.findByNome(Nome);
    }

    public Optional<Usuario> save(Usuario usuario) {
        logger.info(">>>>>> servico save chamado ");
        return Optional.ofNullable(repository.save(usuario));
    }

    public Optional<Usuario> atualiza(Long id, Usuario usuario) {
        logger.info(">>>>>> 1.servico atualiza informações do usuario chamado");
        Usuario usuarioModificado = new Usuario(usuario.getNome(), usuario.getDataNascimento(), usuario.getEmail(),
                usuario.getSenha());
        usuarioModificado.setId(id);
        logger.info(usuarioModificado.getId());
        return Optional.ofNullable(repository.save(usuarioModificado));
    }

}
