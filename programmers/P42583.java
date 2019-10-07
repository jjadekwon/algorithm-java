package programmers;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/*
트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다. 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다. 트럭은 1초에 1만큼 움직이며, 다리 길이는 bridge_length이고 다리는 무게 weight까지 견딥니다.
※ 트럭이 다리에 완전히 오르지 않은 경우, 이 트럭의 무게는 고려하지 않습니다.

예를 들어, 길이가 2이고 10kg 무게를 견디는 다리가 있습니다. 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.

입출력 예 ---
2	10	[7,4,5,6]	8
100	100	[10]	101
100	100	[10,10,10,10,10,10,10,10,10,10]	110
 */

public class P42583 {
	public static void main(String[] args) {
		//System.out.println(solution(2, 10, new int[] {7, 4, 5, 6}));
		//System.out.println(solution(100, 100, new int[] {10}));
		System.out.println(solution(100, 100, new int[] {10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
	}
	
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> queue = new LinkedList<>();
        
        int index = 0;
        queue.offer(new Truck(truck_weights[index++], 0));
        
        int sec = 0;
        while (!queue.isEmpty()) {
        	++sec;
        	
        	Iterator<Truck> it = queue.iterator();
        	while (it.hasNext()) {
        		Truck truck = it.next();
        		++truck.position;
        	}
        	
        	Truck curr = queue.peek();
        	if (curr.position > bridge_length) {
        		queue.poll();
        	}

        	// 다리 위에 있는 트럭 무게 합
        	int sum = 0;
        	Iterator<Truck> it2 = queue.iterator();
        	while (it2.hasNext()) {
        		Truck truck = it2.next();
        		sum += truck.weight;
        	}
        	
        	if (index < truck_weights.length && 
        			sum + truck_weights[index] <= weight) {
        		queue.add(new Truck(truck_weights[index++], 1));
        	}
        }
        
        return sec;
    }
}

class Truck {
	int weight;
	int position;
	public Truck(int weight, int position) {
		this.weight = weight;
		this.position = position;
	}
}
