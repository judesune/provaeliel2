package services;

import models.FuncionarioModel;
import repositories.FuncionarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
public class FuncionarioServices {

   private final FuncionarioRepository funcionarioRepository;

   public FuncionarioServices(FuncionarioRepository funcionarioRepository) {
       this.funcionarioRepository = funcionarioRepository;
   }

   public List<FuncionarioModel> findAll(){
       return  funcionarioRepository.findAll();
   }

   public FuncionarioModel buscarPorId(Long id){
       return funcionarioRepository.findById(id)
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionário não encontrado"));
   }

   public FuncionarioModel criarPessoa(FuncionarioModel funcionarioModel) {
       return  funcionarioRepository.save( funcionarioModel);
   }

   //deletar
    public void deletar(Long id){
       funcionarioRepository.deleteById(id);
    }
    //atualizar
    public FuncionarioModel atualizar(Long id, FuncionarioModel funcionarioModel){
       FuncionarioModel func = funcionarioRepository.findById(id)
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionário não encontrado"));
       func.setNome(funcionarioModel.getNome());
       func.setCpf(funcionarioModel.getCpf());
       func.setRua(funcionarioModel.getRua());
       return funcionarioRepository.save(func);
    }



}
