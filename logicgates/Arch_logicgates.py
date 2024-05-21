### conda install diagrams
from diagrams import Cluster, Diagram, Edge
from diagrams.custom import Custom
import os
os.environ['PATH'] += os.pathsep + 'C:/Program Files/Graphviz/bin/'

graphattr = {     #https://www.graphviz.org/doc/info/attrs.html
    'fontsize': '22',
}

nodeattr = {   
    'fontsize': '22',
    'bgcolor': 'lightyellow'
}

eventedgeattr = {
    'color': 'red',
    'style': 'dotted'
}
evattr = {
    'color': 'darkgreen',
    'style': 'dotted'
}
with Diagram('logicgatesArch', show=False, outformat='png', graph_attr=graphattr) as diag:
  with Cluster('env'):
     sys = Custom('','./qakicons/system.png')
### see https://renenyffenegger.ch/notes/tools/Graphviz/attributes/label/HTML-like/index
     with Cluster('ctxlocal', graph_attr=nodeattr):
          nor=Custom('nor','./qakicons/symActorSmall.png')
          controller=Custom('controller','./qakicons/symActorSmall.png')
     nor >> Edge(color='blue', style='solid',  decorate='true', label='<signals &nbsp; >',  fontcolor='blue') >> controller
     controller >> Edge(color='blue', style='solid',  decorate='true', label='<signals &nbsp; >',  fontcolor='blue') >> nor
diag
