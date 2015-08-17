package codingame.tools;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

public class GraphTest {

	@Test
	//@Ignore
	public void testIsLeaf() {
		Graph<String> g = new Graph<String>();
		g.addVertex(new Vertex<String>("0"));
		g.addVertex(new Vertex<String>("1"));
		g.addVertex(new Vertex<String>("2"));
		
		g.insertBiEdge(g.findVertexByName("0"), g.findVertexByName("1"), 1);
		g.insertBiEdge(g.findVertexByName("1"), g.findVertexByName("2"), 1);
		
		assertTrue(g.findVertexByName("0").isLeaf());
		assertTrue( ! g.findVertexByName("1").isLeaf());
		assertTrue(g.findVertexByName("2").isLeaf());
	}
	
	@Test
	//@Ignore
	public void testIsLeafInTree() {
		Graph<String> g = new Graph<String>();
		g.addVertex(new Vertex<String>("0"));
		g.addVertex(new Vertex<String>("1"));
		g.addVertex(new Vertex<String>("2"));
		g.addVertex(new Vertex<String>("3"));
		g.addVertex(new Vertex<String>("4"));
		g.addVertex(new Vertex<String>("5"));
		g.addVertex(new Vertex<String>("6"));
		
		g.insertBiEdge(g.findVertexByName("0"), g.findVertexByName("1"), 1);
		g.insertBiEdge(g.findVertexByName("0"), g.findVertexByName("2"), 1);
		g.insertBiEdge(g.findVertexByName("0"), g.findVertexByName("6"), 1);
		g.insertBiEdge(g.findVertexByName("1"), g.findVertexByName("3"), 1);
		g.insertBiEdge(g.findVertexByName("1"), g.findVertexByName("4"), 1);
		g.insertBiEdge(g.findVertexByName("2"), g.findVertexByName("5"), 1);
		
		assertTrue( ! g.findVertexByName("0").isLeaf());
		assertTrue( ! g.findVertexByName("1").isLeaf());
		assertTrue( ! g.findVertexByName("2").isLeaf());
		assertTrue(g.findVertexByName("3").isLeaf());
		assertTrue(g.findVertexByName("4").isLeaf());
		assertTrue(g.findVertexByName("5").isLeaf());
		assertTrue(g.findVertexByName("6").isLeaf());
	}
	
	@Test
	public void testBeginPath() {
		Graph<String> g = new Graph<String>();
		g.addVertex(new Vertex<String>("2"));
		g.addVertex(new Vertex<String>("3"));
		g.addVertex(new Vertex<String>("8"));
		g.addVertex(new Vertex<String>("13"));
		g.addVertex(new Vertex<String>("16"));
		g.addVertex(new Vertex<String>("17"));
		g.addVertex(new Vertex<String>("18"));
		g.addVertex(new Vertex<String>("19"));
		g.addVertex(new Vertex<String>("20"));
		g.addVertex(new Vertex<String>("23"));
		g.addVertex(new Vertex<String>("27"));
		g.addVertex(new Vertex<String>("30"));
		g.addVertex(new Vertex<String>("36"));
		
		g.insertBiEdge(g.findVertexByName("2"), g.findVertexByName("3"), 1);
		g.insertBiEdge(g.findVertexByName("3"), g.findVertexByName("8"), 1);
		g.insertBiEdge(g.findVertexByName("3"), g.findVertexByName("19"), 1);
		g.insertBiEdge(g.findVertexByName("3"), g.findVertexByName("20"), 1);
		g.insertBiEdge(g.findVertexByName("20"), g.findVertexByName("19"), 1);
		g.insertBiEdge(g.findVertexByName("19"), g.findVertexByName("18"), 1);
		g.insertBiEdge(g.findVertexByName("19"), g.findVertexByName("17"), 1);
		g.insertBiEdge(g.findVertexByName("18"), g.findVertexByName("17"), 1);
		g.insertBiEdge(g.findVertexByName("8"), g.findVertexByName("19"), 1);
		g.insertBiEdge(g.findVertexByName("8"), g.findVertexByName("17"), 1);
		g.insertBiEdge(g.findVertexByName("8"), g.findVertexByName("16"), 1);
		g.insertBiEdge(g.findVertexByName("8"), g.findVertexByName("36"), 1);
		g.insertBiEdge(g.findVertexByName("16"), g.findVertexByName("17"), 1);
		g.insertBiEdge(g.findVertexByName("13"), g.findVertexByName("36"), 1);
		g.insertBiEdge(g.findVertexByName("13"), g.findVertexByName("16"), 1);
		g.insertBiEdge(g.findVertexByName("16"), g.findVertexByName("23"), 1);
		g.insertBiEdge(g.findVertexByName("16"), g.findVertexByName("27"), 1);
		g.insertBiEdge(g.findVertexByName("16"), g.findVertexByName("30"), 1);
		g.insertBiEdge(g.findVertexByName("23"), g.findVertexByName("27"), 1);
		g.insertBiEdge(g.findVertexByName("27"), g.findVertexByName("30"), 1);
		
		g.dijkstra(g.findVertexByName("2"));
		
		assertFalse(g.findVertexByName("27").pathBeginWith(g.findVertexByName("17")));
		assertTrue(g.findVertexByName("27").pathBeginWith(g.findVertexByName("8")));
		assertFalse(g.findVertexByName("17").pathBeginWith(g.findVertexByName("27")));
	}
}
