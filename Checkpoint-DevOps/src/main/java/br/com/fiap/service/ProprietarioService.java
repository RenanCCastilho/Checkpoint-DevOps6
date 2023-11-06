package br.com.fiap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.exceptions.ProprietarioNotFoundException;
import br.com.fiap.model.Proprietario;
import br.com.fiap.repository.ProprietarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProprietarioService {

	private final ProprietarioRepository proprietarioRepository;

	@Autowired
	public ProprietarioService(ProprietarioRepository proprietarioRepository) {
		this.proprietarioRepository = proprietarioRepository;
	}

	public List<Proprietario> findAll() {
		return proprietarioRepository.findAll();
	}

	public Optional<Proprietario> findById(Long id) {
		return proprietarioRepository.findById(id);
	}

	public Proprietario save(Proprietario proprietario) {
		return proprietarioRepository.save(proprietario);
	}

	public void deleteById(Long id) {
		proprietarioRepository.deleteById(id);
	}

	public Proprietario updateProprietario(Long id, Proprietario updatedProprietario) {
		Optional<Proprietario> existingProprietario = proprietarioRepository.findById(id);
		if (existingProprietario.isPresent()) {
			Proprietario proprietario = existingProprietario.get();
			proprietario.setNome(updatedProprietario.getNome());
			proprietario.setCidade(updatedProprietario.getCidade());
			proprietario.setTelefone(updatedProprietario.getTelefone());

			return proprietarioRepository.save(proprietario);
		} else {

			throw new ProprietarioNotFoundException("Proprietário não encontrado com ID: " + id);
		}
	}
}
