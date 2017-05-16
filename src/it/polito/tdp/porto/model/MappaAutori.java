package it.polito.tdp.porto.model;

import java.util.HashMap;
import java.util.Map;

public class MappaAutori {

	Map<Integer, Author> autori;

	public MappaAutori() {
		
		this.autori = new HashMap<Integer,Author>();
	}
	public Author get(int id){
		return autori.get(id);
	}
	public void put(Author a){
		autori.put(a.getId(), a);
	}
	public Map<Integer,Author> getMappa(){
		return autori;
	}
}
