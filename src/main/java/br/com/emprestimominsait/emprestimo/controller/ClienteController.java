package br.com.emprestimominsait.emprestimo.controller;

import br.com.emprestimominsait.emprestimo.dto.ClienteDto;
import br.com.emprestimominsait.emprestimo.model.ClienteModel;
import br.com.emprestimominsait.emprestimo.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
/*@ResponseStatus(HttpStatus.CREATED)*/
@RequestMapping(value = "clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public ResponseEntity<ClienteDto> criarUmCliente(@Valid @RequestBody ClienteDto dto) {
        ClienteModel clienteCriado = clienteRepository.save(dto.toModel()); //salvou o obj dto (Cliente criado)
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }


}
