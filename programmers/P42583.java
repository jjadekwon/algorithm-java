package programmers;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

//2	10	[7,4,5,6]	8
//100	100	[10]	101
//100	100	[10,10,10,10,10,10,10,10,10,10]	110

public class P42583 {
	public static void main(String[] args) {
		//System.out.println(solution(2, 10, new int[] {7, 4, 5, 6}));
		System.out.println(solution(100, 100, new int[] {10}));
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
