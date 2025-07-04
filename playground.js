
const roads = [
  "Alice's House-Bob's House",
  "Alice's House-Cabin",
  "Alice's House-Post Office",
  "Bob's House-Town Hall",
  "Daria's House-Ernie's House",
  "Daria's House-Town Hall",
  "Ernie's House-Grete's House",
  "Grete's House-Farm",
  "Grete's House-Shop",
  "Marketplace-Post Office",
  "Marketplace-Town Hall",
];

//axis is an array.
function plotGraph(axis) {
  let graph = Object.create(null); // {}

  function addEdge(from, to) {
    if (graph[from] == null) {
      graph[from] = [to];
    } else {
      graph[from].push(to);
    }
  }
  for(const [from,to] of axis.map(path => path.split("-"))){
     addEdge(from, to);
     addEdge(to, from);
  }
  return graph;
}

console.log(plotGraph(roads));


