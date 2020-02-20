
package br.com.projectoACAP.domain;

public class Contato {
    private Long idcontato;
    private String nome;

    public Long getIdcontato() {
        return idcontato;
    }

    public void setIdcontato(Long idcontato) {
        this.idcontato = idcontato;
    }
    private String email;
    private Provincias provincia;
    private String informcao;
   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Provincias getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincias provincia) {
        this.provincia = provincia;
    }

    public String getInformcao() {
        return informcao;
    }

    public void setInformcao(String informcao) {
        this.informcao = informcao;
    }
   
}
