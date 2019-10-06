package com.codar.vendas.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.codar.vendas.domain.Cidade;
import com.codar.vendas.domain.Cliente;
import com.codar.vendas.domain.Endereco;
import com.codar.vendas.domain.enums.Perfil;
import com.codar.vendas.domain.enums.TipoCliente;
import com.codar.vendas.dto.ClienteDTO;
import com.codar.vendas.dto.ClienteNewDTO;
import com.codar.vendas.repository.ClienteRepository;
import com.codar.vendas.repository.EnderecoRepository;
import com.codar.vendas.security.UserSS;
import com.codar.vendas.services.exceptions.AuthorizationException;
import com.codar.vendas.services.exceptions.DataIntegrityException;
import com.codar.vendas.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
		
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	public Cliente obter(Integer id) {
		UserSS user = UserService.authenticated();
		if (user==null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}
		
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id:" + id + ", Tipo: " + Cliente.class.getName()));
	}
	
	@Transactional
	public Cliente inserir(Cliente cliente) {
		cliente.setId(null);
		cliente = clienteRepository.save(cliente);
		enderecoRepository.saveAll(cliente.getEnderecos());
		return clienteRepository.save(cliente);
	}
	
	
	public Cliente atualizar(Cliente cliente) {
		Cliente newCliente = obter(cliente.getId());
		updateData(newCliente, cliente);
		return clienteRepository.save(newCliente);
	}
	
	public void deletar(Integer id) {
		obter(id);
		try {
			clienteRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir um cliente que possui pedidos.");
		}
	}
	
	public List<Cliente> listar() {
		List<Cliente> clientes = clienteRepository.findAll();
		return clientes;
	}
	
	public Page<Cliente> listarPorPagina(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return clienteRepository.findAll(pageRequest);
	}
	
	public Cliente fromDTO(ClienteDTO clienteDto) {
		return new Cliente(clienteDto.getId(), clienteDto.getNome(), clienteDto.getEmail(), null, null, null);
	}
	
	public Cliente fromDTO(ClienteNewDTO clienteNewDto) {
		Cliente cliente = new Cliente(null, clienteNewDto.getNome(), clienteNewDto.getEmail(), clienteNewDto.getCpfOuCnpj(), TipoCliente.toEnum(clienteNewDto.getTipo()), bCryptPasswordEncoder.encode(clienteNewDto.getSenha()));
		Cidade cidade = new Cidade(clienteNewDto.getIdCidade(),null,null);
		Endereco endereco = new Endereco(null, clienteNewDto.getLogradouro(), clienteNewDto.getNome(), clienteNewDto.getComplemento(), clienteNewDto.getBairro(), clienteNewDto.getBairro(), cidade, cliente);
		cliente.getEnderecos().add(endereco);
		cliente.getTelefones().add(clienteNewDto.getTelefone1());
		
		if(clienteNewDto.getTelefone2() != null) {
			cliente.getTelefones().add(clienteNewDto.getTelefone2());
		}
		
		if(clienteNewDto.getTelefone3() != null) {
			cliente.getTelefones().add(clienteNewDto.getTelefone3());
		}
		
		return cliente;
	}
	
	private void updateData(Cliente newCliente, Cliente cliente) {
		newCliente.setNome(cliente.getNome());
		newCliente.setEmail(cliente.getEmail());
	}
}
