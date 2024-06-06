package vargas.elena.literalura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vargas.elena.literalura.model.Autores;

import java.util.List;

public interface AutoresRepository extends JpaRepository<Autores, Long> {

    List<Autores> findByFechaDeFallecimientoGreaterThan(Integer fechaDeFallecimiento);
}
