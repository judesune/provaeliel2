package controllers;


import models.FuncionarioModel;
import services.FuncionarioServices;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    private final FuncionarioServices funcionarioServices;

    public FuncionarioController(FuncionarioServices funcionarioServices) {
        this.funcionarioServices = funcionarioServices;
    }

    @GetMapping
    public List<FuncionarioModel> findAll(){
        return  funcionarioServices.findAll();
    }

    @GetMapping("/{id}")
    public FuncionarioModel buscarPorId( @PathVariable Long id){
        return  funcionarioServices.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id){
        funcionarioServices.deletar(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FuncionarioModel criarFuncionario(@RequestBody FuncionarioModel funcionarioModel){
        return funcionarioServices.criarPessoa(funcionarioModel);
    }

    @PutMapping("/{id}")
    public FuncionarioModel atualizar(@PathVariable Long id, @RequestBody FuncionarioModel funcionarioModel){
        return  funcionarioServices.atualizar(id,funcionarioModel);
    }















}
