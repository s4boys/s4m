import graph

def test_from_osm():
    filename = "map.osm"
    g = graph.Graph.from_osm(filename)
    assert("87330735" in g.get_nodes())
