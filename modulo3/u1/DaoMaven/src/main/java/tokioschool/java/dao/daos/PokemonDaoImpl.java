package tokioschool.java.dao.daos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import tokioschool.java.dao.models.Pokemon;

public class PokemonDaoImpl implements IPokemonDao {
	private List<Pokemon> lPokemon = new ArrayList<Pokemon>();
	
	public boolean isPresent(String name) {
		
		return lPokemon.stream().map(p->p.getName()).filter(n->n.equalsIgnoreCase(name)).findFirst().isPresent();
	}

	public boolean add(Pokemon pokemon) {
		return lPokemon.add(pokemon);
	}

	public boolean remove(Pokemon pokemon) {
		return lPokemon.removeIf(pok->pok.getName().equalsIgnoreCase(pokemon.getName()));
	}

	public void showAll() {
		lPokemon.forEach(System.out::println);
	}

	public boolean load() {
		File f = new File("src/main/resources/mock-pokemon.csv");
	
		try {
			if(f.exists()) {
				Reader r = new FileReader(f);
				BufferedReader br = new BufferedReader(r);
				br.lines().forEach(line->{
					this.lPokemon.add(new Pokemon(line));
					});
				br.close();
			}else {
				System.err.println("Not found: "+f.getAbsolutePath());
			}
		}catch(Exception e) {
			
		}
		return false;
	}

}
