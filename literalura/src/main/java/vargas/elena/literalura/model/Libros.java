package vargas.elena.literalura.model;


import jakarta.persistence.*;

import java.util.Optional;

@Entity
@Table(name = "librosBuscados")

public class Libros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true)
    private String titulo;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Autores autores;
    private String idiomas;
    private Integer conteoDeDescargas;

    public Libros(DatosLibros libros){
        this.titulo =libros.titulo();
        Optional<DatosDeAutor> autores = libros.autor().stream()
                .findFirst();
        if (autores.isPresent()){
            this.autores = new Autores(autores.get());
        } else {
            System.out.println("No se ha encontrado ningún autor");
        }
        this.idiomas = libros.idiomas().get(0);
        this.conteoDeDescargas = libros.conteoDeDescargas();
    }

    public Libros(){

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autores getAutores() {
        return autores;
    }

    public void setAutores(Autores autores) {
        this.autores = autores;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public Integer getConteoDeDescargas() {
        return conteoDeDescargas;
    }

    public void setConteoDeDescargas(Integer conteoDeDescargas) {
        this.conteoDeDescargas = conteoDeDescargas;
    }

    @Override
    public String toString() {
        return "Libros{" +
                "Id=" + Id +
                ", titulo='" + titulo + '\'' +
                ", autores=" + autores +
                ", idiomas='" + idiomas + '\'' +
                ", conteoDeDescargas=" + conteoDeDescargas +
                '}';
    }
}
