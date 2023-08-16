package Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mercado")
public class MercadoController {

    private final MercadoService mercadoService;

    public MercadoController(MercadoService mercadoService) {
        this.mercadoService = mercadoService;
    }

    @PostMapping
    public ResponseEntity<Void> venderProduto(@RequestBody ProdutoDTO produtoDTO) {
        mercadoService.venderProduto(produtoDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos() {
        return ResponseEntity.ok(mercadoService.listarProdutos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> detalhesProduto(@PathVariable int id) {
        return ResponseEntity.ok(mercadoService.getProduto(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerProduto(@PathVariable int id) {
        mercadoService.removerProduto(id);
        return ResponseEntity.ok().build();
    }
}
