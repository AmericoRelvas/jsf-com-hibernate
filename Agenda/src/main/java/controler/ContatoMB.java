package controler;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.*;

@ManagedBean
@RequestScoped
public class ContatoMB {

	// Construtor padrão do ManagedBean
    public ContatoMB() {
    }

    // Instância de Contato para manipulação na página JSF
    private Contato c = new Contato();

    // Métodos Getter e Setter para o campo "id"
    public String getId() {
        return String.valueOf(c.getId());
    }

    public void setId(String id) {
        c.setId(Integer.parseInt(id));
    }

    // Métodos Getter e Setter para o campo "nome"
    public String getNome() {
        return c.getNome();
    }

    public void setNome(String nome) {
        c.setNome(nome);
    }

    // Métodos Getter e Setter para a instância de Contato
    public Contato getC() {
        return c;
    }

    public void setC(Contato c) {
        this.c = c;
    }

    // Método para salvar um novo Contato
    public void salvar() {
        try {
            CRUD.inserir(c);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Método para obter a lista de nomes dos Contatos
    public List<String> getNomes() {
        return CRUD.ler();
    }

    // Método para atualizar um Contato existente
    public void atualizar() {
        try {
            int id = c.getId();
            String nome = c.getNome();
            String sobrenome = c.getSobrenome();
            String telefone = c.getTelefone();
            String email = c.getEmail();

            CRUD.atualizar(id, nome, sobrenome, telefone, email);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Método para remover um Contato pelo ID
    public void remover(int id) {
        try {
            CRUD.remover(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}