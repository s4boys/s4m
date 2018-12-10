package osm;

/**
 * Teste osm Parser
 * 
 * @author coors
 *
 */

public class OsmParserTest {
	
	

	public static void main(String[] args) {
//	    die 2 stimmen
//	    48.7215314 9.2714416
//	    48.7212168 9.2681260
	    
//	    die 2 auch 
//	    253873892 253873610
//	    48.7154764 9.2675577
//	    48.7161394 9.2722783
	    
	    //größerer weg von 253873500 nach 253872232
//	    48.7217983 9.2673533
//	    48.7196424 9.2699693
		OsmParser parser = OsmParser.getInstance();
//		System.out.println(parser.getDistance(48.750656, 9.221554,48.751291, 9.221207)*1000);
		

		
		// hauptbahnhof 20276019
		// 48.7823286 9.1818160
		// hft 1635727287
		// 48.7805287 9.1732356
		long start = System.currentTimeMillis();
		try {
			
			parser.parse("map(4).osm");
		} catch (Exception e) {
			e.printStackTrace();
		}
		long time = System.currentTimeMillis() - start;
		parser.g.shortestPath(parser.g.getNodeFromName("20276019"), parser.g.getNodeFromName("1635727287"));
//		parser.g.shortestPath(parser.g.getNodeFromName("1439746237"), parser.g.getNodeFromName("1435327784"));
//		parser.g.shortestPath(parser.g.getNodeFromName("253873892"), parser.g.getNodeFromName("253873610"));
		System.out.println("runtime "+time+" ms");

	}

}
