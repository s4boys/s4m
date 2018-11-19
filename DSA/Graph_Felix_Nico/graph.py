from collections import namedtuple
import itertools

Edge = namedtuple("Edge", ["source", "dest"])

class Graph:
    def __init__(self):
        self.edges = {}

    def add_edge(self, edge, weight):
        """Adds a new, weighted edge to the graph. Replaces edge if it already exists."""
        self.edges[edge] = weight
        return self

    def set_edges(self, edges):
        """Replaces the current edges dict of the graph with the parameter dict"""
        self.edges = edges
        return self

    def edges_from(self, node):
        """Returns all edges beginning at to `node`. Does not mutate self."""
        return {k: v for k,v in self.edges.items() if k.source == node}

    def edges_to(self, node):
        """Returns all edges ending at to `node`. Does not mutate self."""
        return {k: v for k,v in self.edges.items() if k.dest == node}

    def edges_connecting(self, node):
        """Returns all edges connected to `node`. Does not mutate self."""
        return {k: v for k,v in self.edges.items() if k.source == node or k.dest == node}

    def breadth_first_search(self, node):
        """Breitensuche"""
        visited = set()
        queue = [node]
        while queue:
            w = queue.pop
            visited.add(w)
            for other_node_from, other_node_to in zip(self.edges_from(node), self.edges_to(node)):
                if other_node_from.dest not in visited:
                    queue.append[other_node_from.dest]
                if other_node_to.src not in visited:
                    queue.append[other_node_to.src]
        return visited
            


        print("not yet implemented")
        #stub

    def depth_first_search(self, node, visited):
        """Tiefensuche"""
        visited.add(node)

        for other_node_from, other_node_to in itertools.zip_longest(self.edges_from(node),self.edges_to(node)):
            print("other from:", other_node_from)
            print("other to:", other_node_to)
            if other_node_from is not None:
                if other_node_from.dest not in visited:
                    self.depth_first_search(other_node_from, visited)
            if other_node_to is not None:
                if other_node_to.src not in visited:
                    self.depth_first_search(other_node_to, visited)

        return visited                

    def is_euler_graph(self):
        """Checks for euler graph"""
        iseuler = False
        


    def __str__(self):
        l = []
        for key, value in self.edges.items():
            l.append("from {0} to {1}: weight {2} \n".format(key.source, key.dest, value))
        
        return "".join(l)



def main():

    g = Graph()
    edges = [
        (Edge('A','B'),12),
        (Edge('A','C'),8),
        (Edge('A','D'),2),
        (Edge('B','C'),4),
        (Edge('B','E'),7),
        (Edge('B','F'),2),
        (Edge('C','D'),5),
        (Edge('C','G'),1),
        (Edge('D','G'),3),
        (Edge('D','H'),5),
        (Edge('D','K'),10),
        (Edge('E','I'),9),
        (Edge('F','I'),1),
        (Edge('G','J'),6),
        (Edge('H','K'),3),
        (Edge('I','J'),2),
        (Edge('J','K'),1),
    ]

    for tpl in edges:
        g.add_edge(tpl[0], tpl[1])

    # print(g)
    # print(g.edges_connecting('A'))
    # print(g.edges[('A','B')])
    visited = set()
    for key in g.depth_first_search('A', visited):
        print(key)
    # print(g.depth_first_search('A'))
    print("done.")


if __name__ == "__main__":
    main()