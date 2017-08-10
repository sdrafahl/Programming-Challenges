import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Challenge {

	public static void main(String[] args) {
		int[] A = {1, 1, 5, 6, 6 ,2, 2};
		int[] B = {1, 1, 2, 2};
		System.out.println(count(A));
		System.out.println(count(B));
	}

	public static int count(int[] A) {
		HashSet<Integer> hashSet = new HashSet<Integer>();

		for(int x: A) {
			hashSet.add(x);
		}

		int firstIndex = 0;
		int lastIndex = A.length - 1;

		ArrayList <Integer> list = new ArrayList<Integer>();

		boolean front = true;
		boolean last = true;

		while(firstIndex != lastIndex) {
			list.clear();
			if(isValid(firstIndex+1, lastIndex, A, hashSet)) {
				firstIndex++;
			} else {
				front = false;
			}

			if(isValid(firstIndex, lastIndex-1, A, hashSet)){
				lastIndex--;
			} else {
				last = false;
			}

			if(!front && !last) {
				return (lastIndex - firstIndex) + 1;
			}
		}
		return 1;
	}

	public static boolean isValid(int start, int end, int[] array, HashSet<Integer> hashSet) {
		HashSet<Integer> uniqueNumbers = new HashSet<Integer>();
		for(int x=start; x<=end;x++) {
			uniqueNumbers.add(array[x]);
		}
		return hashSet.size() == uniqueNumbers.size();
	}
}
