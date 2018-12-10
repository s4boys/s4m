import graph
from collections import namedtuple
import re, sys

infile = sys.argv[1]
infile = open(infile, "r")

graph = graph.Graph()


for i, line in enumerate(infile):
    if i == 1:
        s = line.split(', ')
    if i > 2:
        nodes = graph.get_nodes()
        words = line.split()
        if words[0] not in graph.get_nodes():
            graph.add_node(words[0])
        elif words[1] not in graph.get_nodes():
            graph.add_node(words[1])
        graph.add_edge(int(words[0]),int(words[1]),int(words[2]))
print(s)
graph.dijkstra(1,10)