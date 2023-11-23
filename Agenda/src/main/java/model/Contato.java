package model;

import javax.persistence.*;

// A anotação @Entity indica que esta classe é uma entidade JPA e será mapeada para uma tabela no banco de dados.
@Entity
// A anotação @Table especifica o nome da tabela no banco de dados (no caso, "contato").
@Table(name = "contato")
public class Contato {

    // A anotação @Id marca a chave primária da entidade.
    @Id
    // A anotação @GeneratedValue indica que o valor da chave primária será gerado automaticamente pelo banco de dados.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // A anotação @Column especifica o mapeamento para a coluna no banco de dados.
    @Column
    private int id;

    @Column
    private String nome;

    @Column
    private String sobrenome;

    @Column
    private String telefone;

    @Column
    private String email;

    // Métodos de acesso (getters e setters) para os campos da entidade.

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
