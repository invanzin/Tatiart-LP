package br.ibmec.edu.Tatiart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.ibmec.edu.Tatiart.exception.ResourceNotFoundException;
import br.ibmec.edu.Tatiart.model.Produto;
import br.ibmec.edu.Tatiart.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    // Listar todos os produtos
    @GetMapping
    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    // Buscar produto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable Long id) {
        Produto produto = produtoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com id: " + id));
        return ResponseEntity.ok(produto);
    }

    // Buscar produto por nome (para URLs amigáveis)
    @GetMapping("/nome/{nome}")
    public ResponseEntity<Produto> getProdutoByNome(@PathVariable String nome) {
        Produto produto = produtoRepository.findByNome(nome);
        if (produto == null) {
            throw new ResourceNotFoundException("Produto não encontrado com nome: " + nome);
        }
        return ResponseEntity.ok(produto);
    }

    // Criar novo produto
    @PostMapping
    public ResponseEntity<Produto> createProduto(@RequestBody Produto produto) {
        return new ResponseEntity<>(produtoRepository.save(produto), HttpStatus.CREATED);
    }

    // Atualizar produto
    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @RequestBody Produto produtoDetails) {
        Produto produto = produtoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com id: " + id));

        produto.setNome(produtoDetails.getNome());
        produto.setHead(produtoDetails.getHead());
        produto.setHeader(produtoDetails.getHeader());
        produto.setHeroSection(produtoDetails.getHeroSection());
        produto.setGaleriaSection(produtoDetails.getGaleriaSection());
        produto.setFeaturesSection(produtoDetails.getFeaturesSection());
        produto.setDepoimentosSection(produtoDetails.getDepoimentosSection());
        produto.setPersonalizacaoSection(produtoDetails.getPersonalizacaoSection());
        produto.setComoFuncionaSection(produtoDetails.getComoFuncionaSection());
        produto.setTiposPersonalizacaoSection(produtoDetails.getTiposPersonalizacaoSection());
        produto.setCtaSection(produtoDetails.getCtaSection());
        produto.setFooter(produtoDetails.getFooter());

        return ResponseEntity.ok(produtoRepository.save(produto));
    }

    // Deletar produto
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduto(@PathVariable Long id) {
        return produtoRepository.findById(id).map(produto -> {
            produtoRepository.delete(produto);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com id: " + id));
    }
} 