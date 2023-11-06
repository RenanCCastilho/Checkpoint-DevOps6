package br.com.fiap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.exceptions.VeiculoNotFoundException;
import br.com.fiap.model.Veiculo;
import br.com.fiap.repository.VeiculoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

	private final VeiculoRepository veiculoRepository;

	@Autowired
	public VeiculoService(VeiculoRepository veiculoRepository) {
		this.veiculoRepository = veiculoRepository;
	}

	public List<Veiculo> findAll() {
		return veiculoRepository.findAll();
	}

	public Optional<Veiculo> findById(Long id) {
		return veiculoRepository.findById(id);
	}

	public Veiculo save(Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}

	public void deleteById(Long id) {
		veiculoRepository.deleteById(id);
	}

	public Veiculo update(Long id, Veiculo updatedVeiculo) {
		Optional<Veiculo> existingVeiculo = veiculoRepository.findById(id);
		if (existingVeiculo.isPresent()) {
			Veiculo veiculo = existingVeiculo.get();
			veiculo.setModelo(updatedVeiculo.getModelo());
			veiculo.setMontadora(updatedVeiculo.getMontadora());
			veiculo.setAnoFabricacao(updatedVeiculo.getAnoFabricacao());
			veiculo.setKm(updatedVeiculo.getKm());
			veiculo.setProprietario(updatedVeiculo.getProprietario());

			return veiculoRepository.save(veiculo);
		} else {
			throw new VeiculoNotFoundException("Veículo não encontrado com ID: " + id);
		}
	}
}
