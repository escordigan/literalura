package vargas.elena.literalura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vargas.elena.literalura.principal.Principal;
import vargas.elena.literalura.repository.AutoresRepository;
import vargas.elena.literalura.repository.LibrosRepository;

@SpringBootApplication

// Se agrega la implementacion del CommandLineRunner para poder ejecutar la aplicacion//

public class LiteraluraApplication implements CommandLineRunner {
	@Autowired
	LibrosRepository librosRepository;
	@Autowired
	AutoresRepository autoresRepository;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//Llamado de la clase Principal, para poder ejecutar el menu al principio del programa, creando la variable principal//
		
		Principal principal = new Principal(librosRepository,autoresRepository);

		//Ejecucion de lo obtenido desde la variable principal que proviene de la clase Principal y su metodo menuPrincipal//

		principal.menuPrincipal();

	}
}
