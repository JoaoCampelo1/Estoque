package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.EstoqueService;
import model.Estoque;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @GetMapping
    public List<Estoque> listarTodos() {
        return estoqueService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Estoque> buscarPorId(@PathVariable Long id) {
        return estoqueService.buscarPorId(id);
    }

    @PostMapping
    public Estoque adicionar(@RequestBody Estoque estoque) {
        return estoqueService.salvar(estoque);
    }

    @PutMapping("/{id}")
    public Estoque atualizar(@PathVariable Long id, @RequestBody Estoque estoque) {
        return estoqueService.salvar(estoque);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        estoqueService.deletar(id);
    }
}
