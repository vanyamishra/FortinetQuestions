package partition;

/**
 * Partitioning a list into k subsets of equal sum
 * 
 * @author vanyamishra
 */

import java.util.List;

public class Subsets {

	/*
	 * For a list to be separated into 'k' groups such that each group has the
	 * same sum, the sum of all the elements in the group should be divisible by
	 * 'k', i.e. if each subset adds up to 'x', the sum of all the elements
	 * becomes 'kx'.
	 * 
	 * 
	 * For example, if there is a list [1,2,3,4,5] and k=3, the sum of all
	 * elements is 15 and (15/3) = 5. the list can be separated into 3 groups,
	 * [1,4],[2,3],[5], with each subset adding up to 5.
	 */
	public boolean separate(List<Integer> list, int k) {

		// If only one subset is required, the list can be separated.
		if (k == 1)
			return true;

		// If the number of subsets is greater than the number of elements in
		// the list
		if (k > list.size()) {
			return false;
		}

		// Calculating the sum of the list
		int sum = 0;
		for (Integer each : list) {
			sum = sum + each;
		}
		// If the sum is not divisible by k
		if (sum % k != 0) {
			return false;
		}

		// Calculating the sum of each subset, as explained above
		int sumOfEachSubset = sum / k;

		int eachSubset[] = new int[k];

		// The following array helps in determining which elements
		// have already been included in a subset.
		boolean isUsed[] = new boolean[list.size()];

		// Initiating the first subset with the value of the last element
		// in the list, and accordingly setting the isUsed flag to true
		eachSubset[0] = list.get(list.size() - 1);
		isUsed[list.size() - 1] = true;

		if (eachSubset[0] > sumOfEachSubset) {
			return false;
		}

		/*
		 * Making a recursive call to the method isSeparateableRecursive(). The
		 * following arguments are passed (in order):
		 *  - List
		 *  - eachSubset array
		 *  - isUsed flag array
		 *  - required sumOfEachSubset
		 *  - k (number of subsets)
		 *  - list size
		 *  - Current index of eachSubset array (in this case, it is 0)
		 *  - The final index of the list, which is the last
		 *    element in this case.
		 */
		return isSeparateableRecursive(list, eachSubset, isUsed,
				sumOfEachSubset, k, list.size(), 0, list.size() - 1);
	}

	public boolean isSeparateableRecursive(List<Integer> list,
			int eachSubset[], boolean isUsed[], int sumOfEachSubset, int k,
			int size, int currentIndexOfSubset, int finalIndex) {

		if (eachSubset[currentIndexOfSubset] == sumOfEachSubset) {
			// If the list has already been separated into (k-1) subsets
			// of equal values, the following condition will be true.
			// In this case, the final result would be true.

			if (currentIndexOfSubset == (k - 2)) {
				return true;
			}

			// Otherwise, a recursive call must be made and the next subset
			// should be found.
			return isSeparateableRecursive(list, eachSubset, isUsed,
					sumOfEachSubset, k, list.size(), currentIndexOfSubset + 1,
					finalIndex);
		}

		// The following loop is required to calculate the sum of elements
		// in this list from beginning till the final available index.
		for (int i = finalIndex; i >= 0; i--) {

			if (isUsed[i] == false) {

				int newSum = eachSubset[currentIndexOfSubset] + list.get(i);

				if (newSum <= sumOfEachSubset) {
					isUsed[i] = true;
					eachSubset[currentIndexOfSubset] = eachSubset[currentIndexOfSubset]
							+ list.get(i);

					boolean check = isSeparateableRecursive(list, eachSubset,
							isUsed, sumOfEachSubset, k, list.size(),
							currentIndexOfSubset, i - 1);

					// Freeing up the element in case it did not fall into the
					// subset
					isUsed[i] = false;

					eachSubset[currentIndexOfSubset] = eachSubset[currentIndexOfSubset]
							- list.get(i);

					// If the subsets were successfully determined,
					if (check == true) {
						return true;
					}
				}
			}
		}

		return false;
	}
}
