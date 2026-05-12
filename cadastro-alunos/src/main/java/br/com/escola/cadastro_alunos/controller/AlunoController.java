package br.com.escola.cadastro_alunos.controller;

import br.com.escola.cadastro_alunos.model.Aluno;
import br.com.escola.cadastro_alunos.repository.AlunoRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoRepository alunoRepository;

    public AlunoController(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @GetMapping
    public String listarAlunos(Model model) {

        model.addAttribute("aluno", new Aluno());
        model.addAttribute("alunos", alunoRepository.listarTodos());

        return "index";
    }

    @PostMapping
    public String salvarAluno(@ModelAttribute Aluno aluno) {

        alunoRepository.salvar(aluno);

        return "redirect:/alunos";
    }

    @PostMapping("/{id}/excluir")
    public String excluirAluno(@PathVariable Integer id) {

        alunoRepository.excluir(id);

        return "redirect:/alunos";
    }
}