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
with Diagram('pingpongrefereeArch', show=False, outformat='png', graph_attr=graphattr) as diag:
  with Cluster('env'):
     sys = Custom('','./qakicons/system.png')
### see https://renenyffenegger.ch/notes/tools/Graphviz/attributes/label/HTML-like/index
     with Cluster('ctxdef', graph_attr=nodeattr):
          pinger=Custom('pinger','./qakicons/symActorSmall.png')
          ponger=Custom('ponger','./qakicons/symActorSmall.png')
          referee=Custom('referee','./qakicons/symActorSmall.png')
     pinger >> Edge( label='connected', **eventedgeattr, decorate='true', fontcolor='red') >> sys
     ponger >> Edge( label='connected', **eventedgeattr, decorate='true', fontcolor='red') >> sys
     referee >> Edge( label='start', **eventedgeattr, decorate='true', fontcolor='red') >> sys
     referee >> Edge( label='end', **eventedgeattr, decorate='true', fontcolor='red') >> sys
     ponger >> Edge(color='blue', style='solid',  decorate='true', label='<pong &nbsp; >',  fontcolor='blue') >> pinger
     pinger >> Edge(color='blue', style='solid',  decorate='true', label='<ping &nbsp; >',  fontcolor='blue') >> ponger
     ponger >> Edge(color='blue', style='solid',  decorate='true', label='<pong &nbsp; >',  fontcolor='blue') >> referee
     pinger >> Edge(color='blue', style='solid',  decorate='true', label='<ping &nbsp; >',  fontcolor='blue') >> referee
diag
