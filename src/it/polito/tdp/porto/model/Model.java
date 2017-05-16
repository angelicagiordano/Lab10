package it.polito.tdp.porto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import org.jgrapht.Graphs;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.porto.db.PortoDAO;

public class Model {

	private UndirectedGraph<Author, DefaultEdge> grafo;
	private PortoDAO pdao= new PortoDAO();
	private MappaAutori mappa;
	
	public void creaGrafo(){
		
		grafo= new SimpleGraph<Author, DefaultEdge>(DefaultEdge.class);
		mappa= new MappaAutori();
		pdao.addAllAutori(mappa);
		List<Author>autori= new ArrayList<Author>(mappa.getMappa().values());
		
		
		Graphs.addAllVertices(grafo, autori);
		
		for(Coautori c: pdao.idCoautori()){
			DefaultEdge e=grafo.addEdge(mappa.get(c.getA1()), mappa.get(c.getA2()));
				}
		//System.out.println(grafo);
		
		
	}
}
