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
        boolean Professor;
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
        Professor existeprofessor = service.buscarPorId(id);

        boolean existedProfessor = false;
        if (existeprofessor == null) return null;
        existeprofessor.setNome(professor.getNome());
        existeprofessor.setEmail(professor.getEmail());
        existeprofessor.setTelefone(professor.getTelefone());

        return  service.salvar(existedProfessor);
    }

}
