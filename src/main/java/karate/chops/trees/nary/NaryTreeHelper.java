package karate.chops.trees.nary;

import java.util.ArrayList;
import java.util.List;

public class NaryTreeHelper {
	
	public static NaryNode createFolderStructure() {
		NaryNode root = new NaryNode("F");
		NaryNode folder1 = new NaryNode("F1");
		NaryNode folder2 = new NaryNode("F2");
		NaryNode folder3 = new NaryNode("F3");

		folder1.addChildren(new NaryNode("file"));

		folder2.addChildren(new NaryNode("file2"));
		folder2.addChildren(new NaryNode("file2"));
		folder2.addChildren(new NaryNode("anyfile"));

		folder3.addChildren(new NaryNode("file3"));
		folder3.addChildren(new NaryNode("file3"));
		folder3.addChildren(new NaryNode("anotherfile"));

		root.addChildren(folder1);
		root.addChildren(folder2);
		root.addChildren(folder3);
		root.addChildren(new NaryNode("file"));
		return root;
	}
	
	
	public static NaryNode createOrgStructure() {
		NaryNode root = new NaryNode("A", 5);
		NaryNode b = new NaryNode("B", 10);
		NaryNode c = new NaryNode("C",20);
		NaryNode d= new NaryNode("D",30);
		NaryNode e= new NaryNode("E",30);

		b.addChildren(new NaryNode("F", 20));
		b.addChildren(new NaryNode("G", 35));
		
		c.addChildren(new NaryNode("H", 32));
		
		d.addChildren(new NaryNode("I", 40));
		d.addChildren(new NaryNode("J", 15));
		d.addChildren(new NaryNode("K", 5));
		
		e.addChildren(new NaryNode("L", 10));
		e.addChildren(new NaryNode("M", 10));

		root.addChildren(b);
		root.addChildren(c);
		root.addChildren(d);
		root.addChildren(e);
		
		return root;
	}


}

class NaryNode {
	String val;
	int salary;
	List<NaryNode> children;

	public NaryNode(String v) {
		val = v;
	}
	
	public NaryNode(String v, int s) {
		val = v;
		salary = s;
	}

	public void addChildren(NaryNode n) {
		if (children == null)
			children = new ArrayList<NaryNode>();

		children.add(n);
	}
}

