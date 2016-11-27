var COLOR_LIST = ['#f00', '#0f0', '#00f', '#0ff', '#f0f','#ff0' ];
vm = new Vue({
    el: "#app",
    data: {
        total_nodes:8,
        nodes: [0, 0, 0],
        edges:[],
        current_index: 0,
        color_used:[],
        color_list: [{
            name: 'Red',
            hex: '#f00',
        }, {
            name: 'Green',
            hex: '#0f0'
        }, {
            name: 'Blue',
            hex: '#00f'
        },  {
            name: 'Cyan',
            hex: '#0ff'
        }, {
            name: 'Magenta',
            hex: '#f0f'
        },{
            name: 'Yellow',
            hex: '#ff0'
        }]
    },
    methods: {
        greedy_step: function() {
            if (this.current_index == this.total_nodes) {
              return;
            }
            var current_color  = "#eee";
            neighbors = this.nodes[this.current_index].neighbors;
            for (color in COLOR_LIST){
              // console.log("================================");
              // console.log(COLOR_LIST[color]);
              var flag = true;
              for (index in neighbors){
                if (this.nodes[neighbors[index]].color==COLOR_LIST[color]){
                  // console.log(this.nodes[neighbors[index]].color);
                  flag = false;
                }
              }
              if (flag){
                current_color = COLOR_LIST[color];
                if (this.color_used.indexOf(current_color) == -1)
                   this.color_used.push(current_color);
                break;
              }
              else{
                flag = true;
              }
            }
            
            this.nodes[this.current_index].color = current_color;
            s.graph.clear(); 
            g = {
             nodes: this.nodes,
             edges: this.edges
            };
            // Instantiate sigma:
            s = new sigma({
                graph: g,
                container: 'container'
            });
            s.refresh();
            this.current_index += 1;
        },
        greedy_all: function() {
            while (this.current_index<this.total_nodes){
              this.greedy_step();
              this.color_used = this.color_used;
            }
        },
        color_step: function() {
            alert(this.current_index);
        },
        color_all: function() {
            alert(456);
        },
        reset_all: function() {
            this.current_index = 0;
            this.color_used = [];
            for (index in this.nodes){
              this.nodes[index].color = '#eee';
            }
            s.graph.clear(); 
            g = {
             nodes: this.nodes,
             edges: this.edges
            };
            // Instantiate sigma:
            s = new sigma({
                graph: g,
                container: 'container'
            });
            s.refresh();

        }
    }
});
var s,
    N = 8,
    E = 20,
    g = {
        nodes: [],
        edges: []
    };
// Generate a random graph:

for (var i = 0; i < N; i++)
    g.nodes.push({
        id: 'n' + i,
        label: 'Node ' + i,
        x: Math.random(),
        y: Math.random(),
        size: 1,
        color: '#eee'
    });

vm.nodes = g.nodes;
for (var i = 0; i < E; i++){
  var source =  (Math.random() * N | 0),
  target = (Math.random() * N | 0);
  if (target == source){
    continue;
  }
  g.edges.push({
        id: 'e' + i,
        source: 'n' + source,
        target: 'n' + target ,
        size: 1,
        color: '#fff'
    });
    if (vm.nodes[source].neighbors==null)
      vm.nodes[source].neighbors = [];
    if (vm.nodes[source].neighbors.indexOf(target) == -1)
      vm.nodes[source].neighbors.push(target);

    if (vm.nodes[target].neighbors==null)
      vm.nodes[target].neighbors = [];
    if (vm.nodes[target].neighbors.indexOf(source) == -1)
      vm.nodes[target].neighbors.push(source);
    
}
vm.edges = g.edges;
 g = {
   nodes: vm.nodes,
   edges: vm.edges
  };
// Instantiate sigma:
s = new sigma({
    graph: g,
    container: 'container'
});
s.settings({
    edgeColor: 'default',
    defaultEdgeColor: '#999'
});