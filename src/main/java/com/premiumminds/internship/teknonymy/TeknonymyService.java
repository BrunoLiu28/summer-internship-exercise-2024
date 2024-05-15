package com.premiumminds.internship.teknonymy;

import java.time.LocalDateTime;

import com.premiumminds.internship.teknonymy.Person;

class TeknonymyService implements ITeknonymyService {

	// Uso de variaveis globais para guardar a informação necessitada ao longo da
	// procura que é recursiva
	private int globalDepth = 0;
	private Person oldestChild = null;

	/**
	 * Method to get a Person Teknonymy Name
	 * 
	 * @param Person person
	 * @return String which is the Teknonymy Name
	 */
	public String getTeknonymy(Person person) {

		// Uso de uma Depth First Search para encontrar as maiores profundidades e o
		// descendente mais velho
		dfs(person, 0);

		// Utilização de um StringBuilder para construir o tecnónimo correto
		StringBuilder sb = new StringBuilder();
		if (globalDepth == 0) {
			return "";
		} else {
			Character sex = person.sex();
			for (int i = globalDepth; i > 0; i--) {
				if (i == 1) {
					if (sex.equals('M')) {
						sb.append("father of " + oldestChild.name());
					} else {
						sb.append("mother of " + oldestChild.name());
					}
				} else if (i == 2) {
					sb.append("grand");
				} else {
					sb.append("great-");
				}
			}
		}

		return sb.toString();
	};

	// Depth First Search
	private void dfs(Person person, int depth) {
		// Caso default onde chegamos a uma pessoa sem descendentes (leaf)
		if (person.children() == null) {
			if (depth > globalDepth) { // Se a profundidade atual for maior que a global guardada, atualiza de imediato
										// as informacoes
				globalDepth = depth;
				oldestChild = person;
			} else if (depth == globalDepth) { // Caso a profundidade atual seja igual a global guardada
				if (oldestChild == null) { // Verifica se é a primeira atualizacao da variavel global
					oldestChild = person;
				} else if (isOlder(person, oldestChild)) { // Caso contrario, compara a data de nascimento das 2 pessoas
					oldestChild = person; // e se a pessoa local for mais velha que a global, a
											// variavel global é atualizada
				}
			}
			return;
		}

		for (Person child : person.children()) { // Explora todos os filhos de cada nó aumentando a profundidade a cada
			dfs(child, depth + 1); // exploração
		}

	}

	// Funcao auxiliar para comparar 2 pessoas. 
	// Retorna true se a primeira pessoa for mais velha que a segunda, 
	// falso caso contrario
	private boolean isOlder(Person person1, Person person2) {
		LocalDateTime birthDate1 = person1.dateOfBirth();
		LocalDateTime birthDate2 = person2.dateOfBirth();
		return birthDate1.isBefore(birthDate2);
	}
}