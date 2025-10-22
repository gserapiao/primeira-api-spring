package mineiracaodados.controller;

import mineiracaodados.model.Turma;
import mineiracaodados.repository.TurmaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    private final TurmaRepository turmaRepo;

    public TurmaController(TurmaRepository turmaRepo) {
        this.turmaRepo = turmaRepo;
    }

    // C - create
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Turma create(@RequestBody Turma body) {
        return turmaRepo.save(body);
    }

    // R - read by id
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Turma getById(@PathVariable Long id) {
        return turmaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));
    }

    // R - read all
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Turma> list() {
        return turmaRepo.findAll();
    }

    // U - update
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Turma update(@PathVariable Long id, @RequestBody Turma body) {
        Turma t = turmaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));
        t.setNome(body.getNome());
        t.setQuantidadeAlunos(body.getQuantidadeAlunos());
        return turmaRepo.save(t);
    }

    // D - delete
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        Turma t = turmaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));
        turmaRepo.delete(t);
    }
}
