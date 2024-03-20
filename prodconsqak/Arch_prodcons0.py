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
with Diagram('prodcons0Arch', show=False, outformat='png', graph_attr=graphattr) as diag:
  with Cluster('env'):
     sys = Custom('','./qakicons/system.png')
### see https://renenyffenegger.ch/notes/tools/Graphviz/attributes/label/HTML-like/index
     with Cluster('ctxcustom', graph_attr=nodeattr):
          consumer=Custom('consumer','./qakicons/symActorSmall.png')
          producer1=Custom('producer1','./qakicons/symActorSmall.png')
          producer2=Custom('producer2','./qakicons/symActorSmall.png')
     producer1 >> Edge(color='magenta', style='solid', decorate='true', label='<myreq<font color="darkgreen"> rep</font> &nbsp; >',  fontcolor='magenta') >> consumer
     producer2 >> Edge(color='blue', style='solid',  decorate='true', label='<info &nbsp; >',  fontcolor='blue') >> consumer
diag
