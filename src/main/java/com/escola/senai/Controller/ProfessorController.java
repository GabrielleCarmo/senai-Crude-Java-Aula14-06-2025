package com.escola.senai.Controller;


import com.escola.senai.Model.Aluno;
import com.escola.senai.Model.Professor;
import com.escola.senai.Service.AlunoService;
import com.escola.senai.Service.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
    private final ProfessorService service;

    public ProfessorController(ProfessorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Professor> buscarProfessor (){
        return service.listaTodos();
    }

    @PostMapping
    public Professor salvarNovoProfessor(@RequestBody Professor professor){
        return service.salvar(professor);
    }

    @GetMapping("/{id}")
    public Professor buscarProfessorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarProfessor(@PathVariable Long id){
        service.excluirProfessor(id);
    }


    @PutMapping("/{id}")
    public Professor atualizaProfessor(@PathVariable Long id, @RequestBody Professor professor){
        Professor existeProfessor = service.buscarPorId(id);

        boolean existeProfessor = false;
        if (existeProfessor == null) return null;
        existeProfessor.setNome(professor.getNome());
        existeProfessor.setEmail(professor.getEmail());
        existeProfessor.setTelefone(professor.getTelefone());

        return  service.salvar(existeProfessor);
    }

}
