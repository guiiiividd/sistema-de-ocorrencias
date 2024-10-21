package com.fatec.ocorrencia.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.ocorrencia.entities.Turno;
import com.fatec.ocorrencia.services.TurnoService;

@RestController
@RequestMapping("/turnos")
@CrossOrigin
public class TurnoController {
    @Autowired
    private TurnoService turnoService;

    @GetMapping
    public List<Turno> listarTurnos(){
        return turnoService.listarTurnos();
    }

    @GetMapping("{id}")
    public Turno listarTurno(@PathVariable int id){
        return turnoService.listarTurno(id);
    }

    @PostMapping()
    public Turno salvarTurno(@RequestBody Turno turno) {
        turno = turnoService.salvarTurno(turno);
        return turno;
    }

    @PutMapping("{id}")
    public Integer editarTurno(@PathVariable int id, @RequestBody Turno turnoEditado) {
        return turnoService.atualizarTurno(id, turnoEditado);
    }
}
