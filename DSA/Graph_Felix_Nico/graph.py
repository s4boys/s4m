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

    def get_connecting_nodes(self, nodename):
        connecting_nodes = list()
        for edges in self.edges_from(nodename):
            connecting_nodes.append(edges.dest)
        return connecting_nodes

    def breadth_first_search(self, node, visited=list()):
        """Breitensuche"""
        queue = [node]
        while queue:
<<<<<<< HEAD
            w = queue.pop
            visited.add(w)
            for edge_from, edge_to in zip(self.edges_from(node), self.edges_to(node)):
                if edge_from.dest not in visited:
                    queue.append(edge_from.dest)
                if edge_to.src not in visited:
                    queue.append(edge_to.src)
=======
            vertex = queue.pop(0)
            if vertex not in visited:
                visited.append(vertex)
                try:
                    queue.extend(self.get_connecting_nodes(vertex).remove(visited))
                except:
                    queue.extend(self.get_connecting_nodes(vertex))
>>>>>>> ae26fedf20f420b4f63d9f02c53ea8aaabb96ec3
        return visited
            # for other_node_from, other_node_to in zip(self.edges_from(node), self.edges_to(node)):
            #     if other_node_from.dest not in visited:
            #         queue.append[other_node_from.dest]
            #     if other_node_to.src not in visited:
            #         queue.append[other_node_to.src]
            


        print("not yet implemented")
        #stub

    def depth_first_search(self, node, visited=None):
        """Tiefensuche"""
<<<<<<< HEAD
        print(node)
        visited.add(node)

        for edge_from, edge_to in itertools.zip_longest(self.edges_from(node),self.edges_to(node)):
            if edge_from is not None:
                if edge_from.dest not in visited:
                    self.depth_first_search(edge_from.dest, visited)
            if edge_to is not None:
                if edge_to.source not in visited:
                    self.depth_first_search(edge_to.source, visited)

        return visited
        
    def depth_first_search_wrapper(self, node):
        """Wrapper around the recursive depth_first_search"""
        visited=set()
        return self.depth_first_search(node, visited)                
=======
        if visited is None:
            visited = list()
        visited.append(node)
        for nodes in self.get_connecting_nodes(node):
            if nodes not in visited:
                self.depth_first_search(nodes, visited)
        return visited

        # for other_node_from, other_node_to in itertools.zip_longest(self.edges_from(node),self.edges_to(node)):
        #     print("other from:", other_node_from)
        #     print("other to:", other_node_to)
        #     if other_node_from is not None:
        #         if other_node_from.dest not in visited:
        #             self.depth_first_search(other_node_from, visited)
        #     if other_node_to is not None:
        #         if other_node_to.src not in visited:
        #             self.depth_first_search(other_node_to, visited)
>>>>>>> ae26fedf20f420b4f63d9f02c53ea8aaabb96ec3

    def is_euler_graph(self):
        """Checks for euler graph"""
        is_euler = False
        


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
<<<<<<< HEAD
    g.depth_first_search_wrapper('A')
=======
    # visited = set()
    # for key in g.depth_first_search('A', visited):
    #    print(key)
>>>>>>> ae26fedf20f420b4f63d9f02c53ea8aaabb96ec3
    # print(g.depth_first_search('A'))

    print(g.depth_first_search('A'))
    print(g.breadth_first_search('A'))
    print("done.")


if __name__ == "__main__":
    main()