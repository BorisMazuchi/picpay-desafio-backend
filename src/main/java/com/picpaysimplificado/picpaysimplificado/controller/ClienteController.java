package com.picpaysimplificado.picpaysimplificado.controller;

import com.picpaysimplificado.picpaysimplificado.dto.ClienteDto;
import com.picpaysimplificado.picpaysimplificado.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping
    public ClienteDto createCliente(@RequestBody ClienteDto clienteDto) {
        return clienteService.createCliente(clienteDto);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDto>> getAllClientes() {
        List<ClienteDto> clienteDtoList = clienteService.getAllClientes();
        if(clienteDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(clienteDtoList, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> getClienteById(@PathVariable Long id) {
        Optional<ClienteDto> clienteDto = Optional.ofNullable(clienteService.getClienteById(id));
        if(clienteDto.isPresent()) {
            return new ResponseEntity<>(clienteDto.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }
}
