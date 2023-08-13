package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EstoqueRepository;
import model.Estoque;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {
    
    @Autowired
    private EstoqueRepository estoqueRepository;

    public List<Estoque> listarTodos() {
        return estoqueRepository.findAll();
    }

    public Optional<Estoque> buscarPorId(Long id) {
        return estoqueRepository.findById(id);
    }

    public Estoque salvar(Estoque estoque) {
        return estoqueRepository.save(estoque);
    }

    public void deletar(Long id) {
        estoqueRepository.deleteById(id);
    }
}
