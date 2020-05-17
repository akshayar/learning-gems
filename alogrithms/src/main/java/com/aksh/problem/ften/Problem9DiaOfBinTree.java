/**
 * 
 */
package com.aksh.problem.ften;

import javax.swing.tree.TreeNode;

/**
 * @author aksha 
 * Given a binary tree , you need to compute the length of
 *         diameter of the tree. The diameter of a binary tree is the length of
 *         longest path between any two nodes in a tree. This path may of may
 *         not pass through the root.
 *         
 *         dia=max((lh, rh, 1),max(ld, rd))
 */
public class Problem9DiaOfBinTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int diameter() {
		return 1;
	}
	int heiht(TreeNode node) {
		if(node.isLeaf()) {
			return 1;
		}else {
			Integer.max(node.children().ne, b)
		}
	}

}
