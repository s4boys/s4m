from collections import defaultdict
import sys
import osm_xml_parser as oxp

class Graph:
    def __init__(self):
        self.nodes = set()
        self.edges = defaultdict(list)
        self.weigth = {}

    def add_node(self, node):
        self.nodes.add(node)
    
    def get_nodes(self):
        return self.nodes

    def add_edge(self, src, dst, weigth):
        self.edges[src].append(dst)
        self.edges[dst].append(src)
        self.weigth[(src, dst)] = weigth
    
    def get_edges(self):
        return(self.edges)

    def add_path(self, path):
        for index, node in enumerate(path):
            if node not in self.nodes:
                self.add_node(node)
            if index is not 0:
                self.add_edge(node, path[index-1], 1) 
    
    def toString(self):
        print(self.get_nodes())
        print(self.get_edges())


    def dijkstra(self, src, dest, visited=[], distances = {}, predecessors = {}):
        if src == dest:
            path = []
            pred=dest

            while pred != None:
                path.append(pred)
                pred = predecessors.get(pred,None)

            print("shortest path: " + str(path) + " cost:" + str(distances[dest]))

        else:
            if not visited:
                distances[src] = 0
            for neighbor in self.get_edges()[src]:
                try:
                    new_distance = distances[src] + self.weigth[src,neighbor]
                except:
                    new_distance = distances[src] + self.weigth[neighbor,src]

                if new_distance < distances.get(neighbor,float('inf')):
                    distances[neighbor] = new_distance
                    predecessors[neighbor] = src

            visited.append(src)
            unvisited = {}

            for k in self.get_edges():
                if k not in visited:
                    unvisited[k] = distances.get(k, float('inf'))

            x = min(unvisited, key=unvisited.get)
            self.dijkstra(x,dest,visited,distances,predecessors)

    @classmethod
    def from_osm(cls, filename):
        instance = cls()
        graph = oxp.osm_xml_parser(filename, instance)
        return graph    