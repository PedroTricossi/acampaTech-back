package com.ASPEL.camp.service.impl;

import com.ASPEL.camp.dto.CampistaDto;
import com.ASPEL.camp.model.Acampamento;
import com.ASPEL.camp.model.Campista;
import com.ASPEL.camp.repository.AcampamentoRepository;
import com.ASPEL.camp.repository.CampistaRepository;
import com.ASPEL.camp.service.CampistaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class CampistaServiceImpl implements CampistaService {
    private final CampistaRepository campistaRepository;

    private final AcampamentoRepository acampamentoRepository;

    public CampistaServiceImpl(CampistaRepository campistaRepository, AcampamentoRepository acampamentoRepository) {
        this.campistaRepository = campistaRepository;
        this.acampamentoRepository = acampamentoRepository;
    }

    @Override
    public Campista save(CampistaDto campista) {
        Campista novoCampista = new Campista();
        List<Acampamento> acampamentoSet = new LinkedList<>();

        novoCampista.setNome(campista.getNome());
        novoCampista.setNacionalidade(campista.getNacionalidade());
        novoCampista.setEstadoCivil(campista.getEstadoCivil());
        novoCampista.setEscolaridade(campista.getEscolaridade());
        novoCampista.setDataNascimento(campista.getDataNascimento());
        novoCampista.setRg(campista.getRg());
        novoCampista.setOrgaoExpeditor(campista.getOrgaoExpeditor());
        novoCampista.setCpf(campista.getCpf());
        novoCampista.setEndereco(campista.getEndereco());
        novoCampista.setBairro(campista.getBairro());
        novoCampista.setCidade(campista.getCidade());
        novoCampista.setEstado(campista.getEstado());
        novoCampista.setCep(campista.getCep());

        List<String> acampas = campista.getAcampamentosRealizados();

        if(acampas != null) {
            acampas.forEach(acampa -> {
                Acampamento acampamento = acampamentoRepository.findAcampamentoByNome(acampa)
                        .orElseThrow(() -> new RuntimeException("Error: Acampamento not found"));

                acampamentoSet.add(acampamento);
            });
        }

        novoCampista.setAcampamentosRealizados(acampamentoSet);
        return campistaRepository.save(novoCampista);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Campista> findCampistasInscritosByAcampamentoId(Long acampamentoId) {
        return campistaRepository.findCampistasIncritosByAcampamentoId(acampamentoId);
    }

    @Override
    public Optional<Campista> findCampistaByNome(String nome) {
        return campistaRepository.findCampistaByNome(nome);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Campista> findAll() {
        return campistaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Campista findById(long id) {
        return campistaRepository.findCampistaById(id);
    }
}
