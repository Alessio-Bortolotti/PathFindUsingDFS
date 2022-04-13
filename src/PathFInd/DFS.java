package PathFInd;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {

	private Stack<Node> myStack;
	private List<Node> nodeVisited;
	private int startNodeIndex;
	private int targetNodeIndex;
	private boolean targetFound;
	
	public DFS() {
		this.myStack = new Stack<>();
		this.nodeVisited = new ArrayList<>();
		this.targetFound = false;
	}
	
	public List<Node> dfs(Graph g, int startNodeIndex, int targetNodeIndex) {
		List<Node> nodeList = g.getAllNodes();
		
		
		this.startNodeIndex = startNodeIndex;
		this.targetNodeIndex = targetNodeIndex;
				
		dfsInStack(nodeList.get(this.startNodeIndex));
		
		return this.nodeVisited;
	}

	private void dfsInStack(Node root) {
		
		this.myStack.push(root);
		root.setVisited(true);
		
		while(!this.myStack.isEmpty()) {
			Node currentNode = this.myStack.pop();
			System.out.println("Current node: " + currentNode.getElement().toString());
			
			if((int) currentNode.getElement() == this.targetNodeIndex) {
				this.targetFound = true;
				return;
			}else {
				this.nodeVisited.add(currentNode);
			}
			
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
