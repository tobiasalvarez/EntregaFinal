package app.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Comanda;
import app.repository.ComandaRepository;

@Service
public class ComandaService {

    @Autowired
    private ComandaRepository comandaRepository;

    public List<Comanda> listarTodas() {
        return comandaRepository.findAll();
    }

    public List<Comanda> findById(Long id) {
        return comandaRepository.findById(id);
    }

    public Comanda salvar(Comanda comanda) {
        return comandaRepository.save(comanda);
    }

    public void deletar(Long id) {
        comandaRepository.deleteById(id);
    }
}
