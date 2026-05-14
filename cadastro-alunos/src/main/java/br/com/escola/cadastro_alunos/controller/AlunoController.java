package br.com.escola.cadastro_alunos.controller;

import br.com.escola.cadastro_alunos.model.Aluno;
import br.com.escola.cadastro_alunos.repository.AlunoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AlunoController {

    private final AlunoRepository alunoRepository;

    public AlunoController(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/alunos";
    }


    @GetMapping("/alunos")
    public String listarAlunos(Model model) {

        model.addAttribute("aluno", new Aluno());
        model.addAttribute("alunos", alunoRepository.listarTodos());

        return "alunos-painel";
    }

    @PostMapping("/alunos")
    public String salvarAluno(@ModelAttribute Aluno aluno) {

        alunoRepository.salvar(aluno);

        return "redirect:/alunos";
    }

    @PostMapping("/alunos/{id}/excluir")
    public String excluirAluno(@PathVariable Integer id) {

        alunoRepository.excluir(id);

        return "redirect:/alunos";
    }

  
    // EDITAR ALUNO
   

    @GetMapping("/alunos/{id}/editar")
public String editarAluno(@PathVariable Integer id, Model model) {

    Aluno aluno = alunoRepository.buscarPorIdAluno(id);

    model.addAttribute("aluno", aluno);

    return "editar-aluno";
}

    @PostMapping("/alunos/atualizar")
    public String atualizarAluno(@ModelAttribute Aluno aluno) {

        alunoRepository.atualizar(aluno);

        return "redirect:/alunos";
    }

  
    // API REST JSON
  

    @GetMapping("/alunos/api")
    @ResponseBody
    public List<Aluno> listarAlunosApi() {

        return alunoRepository.listarTodos();
    }

    @GetMapping("/alunos/api/{id}")
    @ResponseBody
    public Aluno buscarAlunoApi(@PathVariable Integer id) {

        return alunoRepository.buscarPorIdAluno(id);
    }

    @PostMapping("/alunos/api")
    @ResponseBody
    public Aluno criarAlunoApi(@RequestBody Aluno aluno) {

        alunoRepository.salvar(aluno);

        return aluno;
    }

    @PutMapping("/alunos/api/{id}")
    @ResponseBody
    public Aluno atualizarAlunoApi(
            @PathVariable Integer id,
            @RequestBody Aluno aluno) {

        aluno.setId(id);

        alunoRepository.atualizar(aluno);

        return alunoRepository.buscarPorIdAluno(id);
    }

    @DeleteMapping("/alunos/api/{id}")
    @ResponseBody
    public String excluirAlunoApi(@PathVariable Integer id) {

        alunoRepository.excluir(id);

        return "Aluno excluído com sucesso";
    }
}