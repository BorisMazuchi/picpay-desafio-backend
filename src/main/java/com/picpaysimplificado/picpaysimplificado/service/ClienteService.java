package com.picpaysimplificado.picpaysimplificado.service;

import com.picpaysimplificado.picpaysimplificado.dto.ClienteDto;
import com.picpaysimplificado.picpaysimplificado.entity.Cliente;
import com.picpaysimplificado.picpaysimplificado.repository.ClienteRepository;
import com.picpaysimplificado.picpaysimplificado.util.DocumentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public ClienteDto createCliente(ClienteDto clienteDto) {
        Cliente cliente = new Cliente();

        if (DocumentValidator.isCPFOrCNPJ(clienteDto.getCpf_cnpj())) {
            cliente.setNomeCompleto(clienteDto.getNomeCompleto());
            cliente.setEmail(clienteDto.getEmail());
            cliente.setCpf_cnpj(clienteDto.getCpf_cnpj());
            cliente.setSenha(clienteDto.getSenha());
            cliente.setTipoUsuario(clienteDto.getTipoUsuario());

            Cliente clienteSalvo = clienteRepository.save(cliente);
            clienteDto.setIdCliente(clienteSalvo.getIdCliente());
        }
        return clienteDto;
    }


    public List<ClienteDto> getAllClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        List<ClienteDto> clientesDto = new ArrayList<>();

        for (Cliente cliente : clientes) {
            ClienteDto clienteDto = new ClienteDto();
            clienteDto.setIdCliente(cliente.getIdCliente());
            clienteDto.setNomeCompleto(cliente.getNomeCompleto());
            clienteDto.setEmail(cliente.getEmail());
            clienteDto.setCpf_cnpj(cliente.getCpf_cnpj());
            clienteDto.setSenha(cliente.getSenha());
            clienteDto.setTipoUsuario(cliente.getTipoUsuario());
            clientesDto.add(clienteDto);
        }
        return clientesDto;
    }

    public ClienteDto getClienteById(Long id) {
        Cliente cliente = clienteRepository.findById(id).get();
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setIdCliente(cliente.getIdCliente());
        clienteDto.setNomeCompleto(cliente.getNomeCompleto());
        clienteDto.setEmail(cliente.getEmail());
        clienteDto.setCpf_cnpj(cliente.getCpf_cnpj());
        clienteDto.setSenha(cliente.getSenha());
        clienteDto.setTipoUsuario(cliente.getTipoUsuario());
        return clienteDto;
    }


}


