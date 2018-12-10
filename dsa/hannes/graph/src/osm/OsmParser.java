package osm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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

    HashMap<Vertex, HashSet<Edge>> knoten;
//    HashMap<Vertex, ArrayList<Edge>> knoten;

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
     * @param fileName Input file name
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
            String nodeid = null;
            double lat = 0;
            double lon = 0;
            int nodes = 0;
            Vertex pre = null;
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
//                                System.out.println(nodeid);
                            }
                            if (attribute.getName().toString().equals("lat")) {
                                lat = Double.parseDouble(attribute.getValue());
//                                System.out.println(lat);
                            }
                            if (attribute.getName().toString().equals("lon")) {
                                lon = Double.parseDouble(attribute.getValue());
//                                System.out.println(lon);
                            }
                        }
                        knoten.put(new Vertex(nodeid, lat, lon), new HashSet<>());
                        System.out.println();
                        // setze boolean isWay, wenn true dann solange bis kein way mehr ist vorgänger
                        // speichern und dann bis keine knoten mehr im weg sind
//					} else if (startElement.getName().getLocalPart() == "way") {
//						isWay = true;
                    } else if (startElement.getName().getLocalPart() == "nd") {
                        Iterator<Attribute> attributes = startElement.getAttributes();
                        while (attributes.hasNext()) {
                            Attribute attribute = attributes.next();
                            if (attribute.getName().toString().equals("ref")) {
                                Vertex current = getNodeFromName(attribute.getValue());
                                if (pre != null) {
                                    double distance = getDistance(pre.getLat(), pre.getLon(), current.getLat(),
                                            current.getLon());
                                    knoten.get(current).add(new Edge(pre, distance));
                                    knoten.get(pre).add(new Edge(current, distance));
                                    System.out.println("Distanz ziwschen " + pre.getName() + " " + pre.getLat() + " "
                                            + pre.getLon() + " und " + current.getName() + " " + current.getLat() + " "
                                            + current.getLon() + " = " + distance * 1000 + "m");
                                }
                                pre = current;
                            }
                        }

                    }
                } else if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();

                    if (endElement.getName().getLocalPart() == ("node")) {
                        // to something
                    }
                    if (endElement.getName().getLocalPart() == ("way")) {
                        // to something
                        pre = null;
                    }
                    if (endElement.getName().getLocalPart() == ("osm")) {
                        System.out.println("Nodes: " + nodes);
                    }
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

        g = new Graph(knoten);
    }

    public double getDistance(double lat1, double lon1, double lat2, double lon2) {
        double dx = Math.cos(Math.toRadians((lat1+lat2) / 2))  * 111.32 * (lon1-lon2);
        double dy  = 111.32 * (lat1 - lat2);
        return Math.sqrt(dx * dx + dy * dy);
    }

//    public double getDistance(double lat1, double lon1, double lat2, double lon2) {
//        double earthRadiusKm = 6371;
//        double dLat = Math.toRadians(lat2-lat1);
//        double dLon = Math.toRadians(lon2-lon1);
//
//
//        lat1 = Math.toRadians(lat1);
//        lat2 = Math.toRadians(lat2);
//
//        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
//                + Math.sin(dLon / 2) * Math.sin(dLon / 2) * Math.cos(lat1) * Math.cos(lat2);
//        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
//        return earthRadiusKm * c;
//    }

    Vertex getNodeFromName(String name) throws IllegalVertexException {
        for (Vertex v : knoten.keySet()) {
            if (v.getName().equals(name)) {
                return v;
            }
        }
        throw new IllegalVertexException();
    }

}