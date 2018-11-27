package osm;

/**
 * Teste osm Parser
 * 
 * @author coors
 *
 */

public class OsmParserTest {
	
	

	public static void main(String[] args) {
		
		OsmParser parser = OsmParser.getInstance();

		long start = System.currentTimeMillis();
		try {
			
			parser.parse("map.osm");

		} catch (Exception e) {
			e.printStackTrace();
		}
		long time = System.currentTimeMillis() - start;
		
		
		System.out.println("runtime "+time+" ms");
		

	}

}
