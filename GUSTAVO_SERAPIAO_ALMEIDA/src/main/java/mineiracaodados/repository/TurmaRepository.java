package mineiracaodados.repository;

import mineiracaodados.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
    // Ex.: Optional<Turma> findByNome(String nome);
}
