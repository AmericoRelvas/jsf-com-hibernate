package model;

import javax.persistence.*;
import org.hibernate.HibernateError;
import java.util.List;

public class CRUD {
	
	// Método para inserir um novo Contato no banco de dados
	public static void inserir(Contato c1) {
		try {
			// Obtém o EntityManager a partir da classe DAO
			EntityManager entityManager = DAO.getEntityManager();
			
			// Inicia uma transação
			entityManager.getTransaction().begin();
			
			// Persiste o Contato no banco de dados
			entityManager.persist(c1);
			
			// Comita a transação
			entityManager.getTransaction().commit();
			
			// Fecha o EntityManager
			entityManager.close();
			
			// Exibe mensagem de sucesso
			System.out.println("Contato salvo!");
		}
		catch(HibernateError ex) {
			// Em caso de erro, imprime a exceção
			ex.printStackTrace();
		}
	}
	
	// Método para ler todos os nomes dos Contatos no banco de dados
	public static List<String> ler() {
		// Obtém o EntityManager a partir da classe DAO
		EntityManager entityManager = DAO.getEntityManager();
		
		// Inicia uma transação
		entityManager.getTransaction().begin();
		
		// Cria uma consulta para obter os nomes dos Contatos
		TypedQuery<String> query = entityManager.createQuery("SELECT c.nome FROM Contato c", String.class);
		
		// Executa a consulta e obtém a lista de nomes
        List<String> nomes = query.getResultList();
        
        // Comita a transação
		entityManager.getTransaction().commit();
		
		// Fecha o EntityManager
		entityManager.close();
		
		// Retorna a lista de nomes
		return nomes;
	}
	
	// Método para atualizar um Contato no banco de dados
	public static void atualizar(int id, String nome, String sobrenome, String telefone, String email) {
		try {
			// Obtém o EntityManager a partir da classe DAO
			EntityManager entityManager = DAO.getEntityManager();
			
			// Encontra o Contato pelo ID
			Contato emp = entityManager.find(Contato.class, Integer.valueOf(id));
			
			// Inicia uma transação
			entityManager.getTransaction().begin();
			
			// Atualiza os dados do Contato
			emp.setNome(nome);
			emp.setSobrenome(sobrenome);
			emp.setTelefone(telefone);
			emp.setEmail(email);
			
			// Comita a transação
			entityManager.getTransaction().commit();
			
			// Fecha o EntityManager
			entityManager.close();
			
			// Exibe mensagem de sucesso
			System.out.println("Registro atualizado");
		}
		catch(Exception ex) {
			// Em caso de erro, imprime a exceção
			ex.printStackTrace();
		}
	}
	
	// Método para remover um Contato do banco de dados pelo ID
	public static void remover(int id) {
		try {
			// Obtém o EntityManager a partir da classe DAO
			EntityManager entityManager = DAO.getEntityManager();
			
			// Inicia uma transação
			entityManager.getTransaction().begin();
			
			// Encontra o Contato pelo ID
			Contato c = entityManager.find(Contato.class, Integer.valueOf(id));
			
			// Remove o Contato do banco de dados
			entityManager.remove(c);
			
			// Comita a transação
			entityManager.getTransaction().commit();
			
			// Fecha o EntityManager
			entityManager.close();
			
			// Exibe mensagem de sucesso
			System.out.println("Registro removido!");
		}
		catch(Exception ex) {
			// Em caso de erro, imprime a exceção
			ex.printStackTrace();
		}
	}
}