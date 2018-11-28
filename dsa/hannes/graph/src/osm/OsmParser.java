package osm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;

import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;


/**
 * Die Klasse OsmParser implementiert einen Rahmen f�r einen Parser von
 * OpenStreetMap Daten. Als Parser wird ein StaXParser verwendet.
 * 
 * @author coors
 *
 */
public class OsmParser {

	// Instance
	public static OsmParser parser = null;
	public static Graph g = null;
	HashMap<Vertex, ArrayList<Edge>> knoten;

	/**
	 * Singleton
	 * 
	 * @return Instance
	 */
	public static OsmParser getInstance() {
		if (parser == null) {
			parser = new OsmParser();
		}
		return parser;
	}

	/**
	 * Liest die osm Datei, z�hlt die Knoten und die Knoten, die zu Stra�en geh�ren
	 * <tag k="highway" .../> . Grundlage f�r die Weiterentwicklung eines osm
	 * Parsers.
	 * 
	 * 
	 * @param fileName
	 *            Input file name
	 * @return void
	 */
	public void parse(String InputFileName) {
		try {
			this.knoten = new HashMap<>();
			// First, create a new XMLInputFactory
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			// Setup a new eventReader
			InputStream in = new FileInputStream(InputFileName);
			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
			// read the XML document
			int nodes = 0;
			int highways = 0;
			String nodeid = null;
			double lat = 0;
			double lon = 0;
			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();

				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();
					// If we have an item element, we create a new item
					if (startElement.getName().getLocalPart() == "node") {
						nodes++;
						// We read the attributes from this tag and add the date
						// attribute to our object
						Iterator<Attribute> attributes = startElement.getAttributes();
						while (attributes.hasNext()) {
							Attribute attribute = attributes.next();
							if (attribute.getName().toString().equals("id")) {
								nodeid = attribute.getValue();
							}
							if (attribute.getName().toString().equals("lat")) {
								lat = Double.parseDouble(attribute.getValue());
								System.out.println(lat);
							}
							if (attribute.getName().toString().equals("lon")) {
								lon = Double.parseDouble(attribute.getValue());
								knoten.put(new Vertex(nodeid, lat, lon), new ArrayList<Edge>());
							}
							
						}

					} else if (startElement.getName().getLocalPart() == "way") {
						Iterator<Attribute> attributes = startElement.getAttributes();
						while (attributes.hasNext()) {
							Attribute attribute = attributes.next();
							if (attribute.getName().toString().equals("k")) {
								if (attribute.getValue().equals("highway")) {
									highways++;
								}
							}

						}
					}

				} else if (event.isEndElement()) {
					EndElement endElement = event.asEndElement();

					if (endElement.getName().getLocalPart() == ("node")) {
						// to something
					}
				}

			}
			System.out.println("Number of nodes=" + nodes);
			System.out.println("Number of highway nodes=" + highways);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}

		return;
	}

	public double getDistance(double lat1, double lon1, double lat2, double lon2) {
		double lat = (lat1 + lat2) / 2 * 0.01745;
		double dx = 111.3 * Math.toRadians(Math.cos(lat)) * (lon1 - lon2);
		
		double dy = 111.3 * (lat1 - lat2);
		double distance = Math.sqrt(dx * dx + dy * dy);
		return distance;
				
	}

}