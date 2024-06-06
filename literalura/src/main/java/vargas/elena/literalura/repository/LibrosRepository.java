package vargas.elena.literalura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vargas.elena.literalura.model.Libros;

import java.util.List;

public interface LibrosRepository extends JpaRepository<Libros, Long> {

    List<Libros> findByIdiomas(String idiomas);
}
