package karate.chops.trees.nary;

import java.util.*;

public class DuplicateFilesInAFolder {
	public static void main(String... strings) {
		DuplicateFilesInAFolder f = new DuplicateFilesInAFolder();
		NaryNode root = NaryTreeHelper.createFolderStructure();
		Set<String> alreadySeen = new HashSet<String>();
		List<String> duplicates = new ArrayList<String>();

		f.findDuplicates(root, alreadySeen, duplicates);

		duplicates.stream().forEach(System.out::println);
	}

	private void findDuplicates(NaryNode root, Set<String> alreadySeen, List<String> duplicates) {
		if (root.children == null) {
			if (alreadySeen.contains(root.val)) {
				duplicates.add(root.val);
			}
			alreadySeen.add(root.val);
			return;
		}

//		if we want duplicates from a specific folder, uncomment this
//		alreadySeen = new HashSet<String>();

		for (NaryNode internal : root.children)
			findDuplicates(internal, alreadySeen, duplicates);
	}
}