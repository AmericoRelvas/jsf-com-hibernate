package model;

import javax.persistence.*;

public class DAO {
	
	// Atributo para armazenar a fábrica de EntityManagers
	private static final EntityManagerFactory emFactory;
	
	// Bloco estático para inicializar a fábrica de EntityManagers quando a classe é carregada
	static {
		// Cria a fábrica de EntityManagers usando a unidade de persistência chamada "agendaPersist"
		emFactory = Persistence.createEntityManagerFactory("agendaPersist");
	}
	
	// Método para obter uma instância do EntityManager
	public static EntityManager getEntityManager() {
		// Retorna um novo EntityManager a partir da fábrica
		return emFactory.createEntityManager();
	}
	
	// Método para fechar a fábrica de EntityManagers
	public static void fecharFactory() {
		// Fecha a fábrica de EntityManagers
		emFactory.close();
	}
}
