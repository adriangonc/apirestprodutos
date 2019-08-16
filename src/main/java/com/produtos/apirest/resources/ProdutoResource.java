package com.produtos.apirest.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.IProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value="API RESET Produtos")
@CrossOrigin(origins="*")
//@CrossOrigin(origins="http://dominioquepodeacessar")
public class ProdutoResource {

	@Autowired
	IProdutoRepository produtoRepository;

	@GetMapping("/produtos")
	@ApiOperation(value="Lista todos os produtos")
	public List<Produto> listaProdutos() {
		return produtoRepository.findAll();
	}

	@GetMapping("/produto/{id}")
	@ApiOperation(value="Lista um produto por ID")
	public Optional<Produto> listarProduto(@PathVariable(value = "id") Long id) {
		return produtoRepository.findById(id);
	}

	@PostMapping("/produto")
	@ApiOperation(value="Cadastra um produto")
	public Produto salvarProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

	@DeleteMapping("/produto/{id}")
	@ApiOperation(value="Deleta produto por ID")
	public String deletarProduto(@PathVariable(value = "id") Long id) {
		try {
			produtoRepository.deleteById(id);
			return "Produto excluído com sucesso!";
		} catch (Exception e) {
			e.printStackTrace();
			return "Não foi possível excluir!";
		}
	}

	@PutMapping("/produto")
	@ApiOperation(value="Atualiza um produto")
	public Produto atualizaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

}
