package com.fatec.ocorrencia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.ocorrencia.entities.Turno;
import com.fatec.ocorrencia.repositories.TurnoRepository;

@Service
public class TurnoService {
    @Autowired
    private TurnoRepository turnoRepository;

    public List<Turno> listarTurnos() {
        return turnoRepository.findByNativeQuery();
    }

    public Turno listarTurno(Integer id) {
        return turnoRepository.findByIdByNativeQuery(id);
    }

    public Turno salvarTurno(Turno turno) {
        return turnoRepository.insertByNativeQuery(turno.getHora_inicio(), turno.getHora_fim(), turno.getEscala(), turno.getId_equipe(), turno.getId_veiculo());
    }

    public Integer atualizarTurno(int id, Turno turnoEditado) {
        Turno turno = listarTurno(id);

        turno.setHora_inicio(turnoEditado.getHora_inicio());
        turno.setHora_fim(turnoEditado.getHora_fim());
        turno.setEscala(turnoEditado.getEscala());
        turno.setId_equipe(turnoEditado.getId_equipe());
        turno.setId_veiculo(turnoEditado.getId_veiculo());

        return turnoRepository.updateByNativeQuery(turno.getHora_inicio(), turno.getHora_fim(), turno.getEscala(), turno.getId_equipe(), turno.getId_veiculo(), id);
    }
}
