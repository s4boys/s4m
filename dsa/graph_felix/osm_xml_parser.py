import xml.etree.ElementTree as xml

def osm_xml_parser(path_to_file, graph):
    """Parses an osm file and creates a graph.

    Parameters:
        path_to_file - The relative path of the file to be parsed.
        graph - graph object in which the data should be stored
    Returns:
        graph - The created graph our custom format
    """

    # Parse the xml structure and initialize variables.
    root = xml.parse(path_to_file).getroot()
    node_dict_tmp = {}
    # G = nx.DiGraph()

    # Allow these types of streets to be represented in the network by an edge.
    way_types = ["motorway", "trunk", "primary", "secondary", "tertiary", "unclassified", "residential", "service",
                 "living_street"]

    # Create nodes and edges.
    for child in root:
        # Nodes.
        if child.tag == "node":
            node_dict_tmp[child.attrib["id"]] = [child.attrib["lat"], child.attrib["lon"]]

        # Edges.
        if child.tag == "way":
            insert = False
            directed = False
            max_speed_v = None
            way_tmp = []
            for path in child:
                if path.tag == "nd":
                    way_tmp.append(path.attrib["ref"])
                if path.tag == "tag":
                    if path.attrib["k"] == "oneway" and path.attrib["v"] == "yes":
                        directed = True
                    if path.attrib["k"] == "highway" and path.attrib["v"] in way_types:
                        insert = True
                    if path.attrib["k"] == "maxspeed":
                        try:
                            max_speed_v = (float(path.attrib["v"]) * 1000) / 3600
                            if max_speed_v <= 0 or max_speed_v > 25:
                                max_speed_v = None
                        except:
                            max_speed_v = None
            if insert:
                if max_speed_v is None:
                    # print(way_tmp)
                    # G.add_path(way_tmp)
                    graph.add_path(way_tmp)
                    if not directed:
                        # G.add_path(list(reversed(way_tmp)))
                        graph.add_path(list(reversed(way_tmp)))
                else:
                    # G.add_path(way_tmp, max_speed=max_speed_v)
                    graph.add_path(way_tmp)
                    if not directed:
                        # G.add_path(list(reversed(way_tmp)), max_speed=max_speed_v)
                        graph.add_path(way_tmp)

    # Extend the nodes by their geographical coordinates.
    # network_nodes = G.nodes()
    # for child in network_nodes:
    #     current_node_coords = node_dict_tmp[child]
    #     G.node[child]["coords"] = [float(current_node_coords[0]), float(current_node_coords[1])]

    # Return the generated graph.
    # return (G, graph)
    return graph

if __name__ == "__main__":
    import graph as felixnicograph
    
    empty = felixnicograph.Graph()
    # (nxgraph, ourgraph) = osm_xml_parser("map.osm", empty)
    ourgraph = osm_xml_parser("map.osm", empty)

    # print(g.nodes())
    # print(nxgraph.edges())
    # print(ourgraph.get_edges())
    # print(ourgraph.get_nodes())
