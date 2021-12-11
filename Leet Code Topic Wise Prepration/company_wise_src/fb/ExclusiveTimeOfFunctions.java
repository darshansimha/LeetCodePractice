package Dec_07;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {
	class Log {
		int fid;
		boolean isStart;
		int time;

		Log(String log) {
			String[] splits = log.split(":");
			fid = Integer.parseInt(splits[0]);
			isStart = splits[1].equals("start");
			time = Integer.parseInt(splits[2]);
			;
		}
	}

	public int[] exclusiveTime(int n, List<String> logs) {
		int[] result = new int[n];
		Stack<Log> callStack = new Stack<Log>();

		Log log = new Log(logs.get(0));
		callStack.push(log);

		int startTime = log.time;

		for (int i = 1; i < logs.size(); i++) {
			log = new Log(logs.get(i));

			/*
			 *  If the current operation is start then there are 2 cases 
			 *  Case 1 : stack is empty and this is the first function you are putting on it.
			 *  For case one we only need to update our running time stamp and push to the stack 
			 *  Case 2 : If something is on the stack, that means it can't run any more because, 
			 *  This is a single threaded system so only 1 function at a time.
			 *  So we calculate the time the previous function ran,
			 *  and update it in our answer array
			 */
			if (log.isStart) {
				if (!callStack.isEmpty()) {
					int runTime = log.time - startTime;
					result[callStack.peek().fid] += runTime;
				}
				startTime = log.time;
				callStack.push(log);
			}
			/*  When a function ends the first thing we need to do is remove/pop it off out call stack
			 *  As any compiler would do. Once we pop it off we are no longer running and
			 *  So we calculate how long it was running before it got popped, we get the start time
			 *  From the start time variable we maintain and update at every iteration
			 *  Once we find the run time we add that to the result array 
			 *  We also update our current time stamp for the next calculation
			 * */
			else {
				callStack.pop();
				int runTime = log.time - startTime + 1;
				result[log.fid] += runTime;
				// We add 1 to the time because essentially the time end means that it ended 
				startTime = log.time + 1;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExclusiveTimeOfFunctions e = new ExclusiveTimeOfFunctions();
		System.out.println(e.exclusiveTime(2, Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6")));
	}

}
