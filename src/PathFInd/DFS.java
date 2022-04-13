package PathFInd;

import java.util.List;
import java.util.Stack;

public class DFS {

	private Stack<Node> myStack;
	
	public DFS() {
		this.myStack = new Stack<>();
	}
	
	public void dfs(Graph g) {
		List<Node> nodelist = g.getAllNodes();
		
		for(Node n : nodelist) {
			if(!n.isVisited()){
				n.setVisited(true);
				dfsInStack(n);
			}
		}
	}

	private void dfsInStack(Node root) {
		
		this.myStack.push(root);
		root.setVisited(true);
		
		while(!this.myStack.isEmpty()) {
			Node currentNode = this.myStack.pop();
			System.out.println("Current node: " + currentNode.getElement().toString());
			
			for(int i = currentNode.getNeighbours().size() - 1; i>=0; i--) {
				Node n = currentNode.getNeighbours().get(i);
				
				if(!n.isVisited()) {
					this.myStack.push(n);
					n.setVisited(true);
				}
			}
		}
	}
}
