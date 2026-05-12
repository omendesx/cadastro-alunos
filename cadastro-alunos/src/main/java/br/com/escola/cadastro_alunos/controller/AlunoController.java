package br.com.escola.cadastro_alunos.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.escola.cadastro_alunos.repository.AlunoRepository;
import br.com.escola.cadastro_alunos.model.Aluno;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoRepository alunoRepository;

    public AlunoController(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @GetMapping
    public List<Aluno> listarAlunos(){
        return alunoRepository.listarTodos();
    }

    @PostMapping
    public Aluno salvarAluno(@RequestBody Aluno aluno){
        alunoRepository.salvar(aluno);
        return aluno;
    }

    @GetMapping("/{id}")
    public Aluno buscarAluno(@PathVariable Integer id){
        return alunoRepository.buscarPorIdAluno(id);
    }

    @PostMapping("/{id}/atualizar")
    public Aluno atualizarAluno(@PathVariable Integer id, @RequestBody Aluno aluno){
        aluno.setId(id);
        alunoRepository.atualizar(aluno);
        return aluno;
    }

    @DeleteMapping("/{id}")
    public void excluirAluno(@PathVariable Integer id) {
        alunoRepository.excluir(id);
    }

}
