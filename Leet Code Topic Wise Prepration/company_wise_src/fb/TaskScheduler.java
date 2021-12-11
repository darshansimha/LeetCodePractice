package Dec_10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {

	public int leastInterval(char[] tasks, int n) {
		if (tasks != null && n < 0) {
			return 0;
		}
		Map<Character, Integer> counts = new HashMap<Character, Integer>();
		for (char c : tasks) {
			counts.put(c, counts.getOrDefault(c, 0) + 1);
		}
		// Have a max heap of character count
		// We want this to show the most recurring character on top so that we can pair
		// it with others
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);

		// Add only unique characters to the heap
		maxHeap.addAll(counts.values());

		int result = 0;
		List<Integer> processing;

		while (!maxHeap.isEmpty()) {
			processing = new ArrayList<Integer>();

			// For the given time interval add as many distinct tasks as you can
			for (int i = 0; i < n + 1; i++) {
				if(!maxHeap.isEmpty()) {
					processing.add(maxHeap.poll());
				}
			}

			// Not all of the tasks will be complete in the first iteration
			// So We'd have to put it back in the heap to do the next iteration

			for (int process : processing) {
				if (process - 1 > 0) {
					maxHeap.add(process - 1);
				}
			}

			// If we had less than n tasks in our current, we didn't wait the whole n time
			// So we check pro actively if heap is empty i.e. if this is the last iteration

			if (maxHeap.isEmpty()) {
				result += processing.size();
			} else {
				result += n + 1;
			}

		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TaskScheduler t = new TaskScheduler();
		System.out.println(t.leastInterval(new char[] {'A','A','A','B','B','B'}, 2));
	}

}
