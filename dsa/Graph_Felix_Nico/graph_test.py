from graph import Graph, Edge

def test_degree():
    g = Graph()
    
    edges = [
        (Edge('A','B'),12),
        (Edge('A','C'),8),
        (Edge('A','D'),2),
    ]

    for tpl in edges:
        g.add_edge(tpl[0], tpl[1])
    
    assert g.degree('A') is 3