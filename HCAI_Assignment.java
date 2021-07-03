
import java.util.*;

class HealthCloudAI
{
// Represents a node of an n-ary tree
static class Node
{
	String key;
	Vector<Node >child = new Vector<>();
};

// Utility function to create a new tree node
static Node newNode(String key)
{
	Node temp = new Node();
	temp.key = key;
	return temp;
}

// Prints the n-ary tree level wise
static void LevelOrderTraversal(Node root)
{
	if (root == null)
		return;

	// Standard level order traversal code
	// using queue
	Queue<Node > q = new LinkedList<>(); // Create a queue
	q.add(root); // Enqueue root
	while (!q.isEmpty())
	{
		int n = q.size();

		// If this node has children
		while (n > 0)
		{
			// Dequeue an item from queue
			// and print it
			Node p = q.peek();
			q.remove();
			System.out.println(p.key + " ");

			// Enqueue all children of
			// the dequeued item
			for (int i = 0; i < p.child.size(); i++)
				q.add(p.child.get(i));
			n--;
		}
		
		// Print new line between two levels
		System.out.println();
	}
}

static void dfs(Node root)
{
	if (root == null)
		return;
	System.out.println(root.key);
	for (int i = 0; i < root.child.size(); i++)
		dfs(root.child.get(i));
	
}

//get a parent
static Node getParent(Node root,String key)
{
   if(root == null)
    return new Node();
   //if(root.key == key)
   // return root;
   for (int i = 0; i < root.child.size(); i++){
		if(root.child.get(i).key == key){
			return root;
		} 
   }
   for (int i = 0; i < root.child.size(); i++){
	   Node temp = getParent(root.child.get(i),key);
	   if(temp.key!=""){
	   	return temp;
	   }
   }
    return new Node();
}

// Driver Code
public static void main(String[] args)
{
	
	/* Let us create below tree
	*		10
	*	 / / \ \
	*	 2 34 56 100
	*	 / \		 | / | \
	*	 77 88	 1 7 8 9
	*/
	Node root = newNode("root");
	(root.child).add(newNode("Abdominal pain"));
	(root.child).add(newNode("Chest pain"));

	(root.child.get(0).child).add(newNode("Abdominal pain, right upper quadrant"));
	(root.child.get(0).child).add(newNode("Abdominal pain, right lower quadrant"));
	(root.child.get(0).child).add(newNode("Abdominal pain, left upper quadrant"));
	(root.child.get(0).child).add(newNode("Abdominal pain, right upper quadrant"));
	(root.child.get(0).child).add(newNode("Abdominal pain, mild"));
	(root.child.get(0).child).add(newNode("Abdominal pain, moderate"));
	(root.child.get(0).child).add(newNode("Abdominal pain, severe"));
	
	(root.child.get(1).child).add(newNode("Chest pain, left side"));
	(root.child.get(1).child).add(newNode("Chest pain, right side"));
	(root.child.get(1).child).add(newNode("Chest pain, mild"));
	(root.child.get(1).child).add(newNode("Chest pain, moderate"));
	(root.child.get(1).child).add(newNode("Chest pain, severe"));

	// TASK--- 1
	dfs(root);
	//input for TASK -- 2
	String input = "Abdominal pain, right upper quadrant";
	Node par = getParent(root,input);
	//System.out.println(par.key);
	for (int i = 0; i < par.child.size(); i++){
		if(par.child.get(i).key != input)
		 System.out.println(par.child.get(i).key);
   }
	
}
}
