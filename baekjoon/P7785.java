package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class P7785 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Map<String, Boolean> log = new TreeMap<>(Collections.reverseOrder());
		//List<String> names = new ArrayList<String>();
		while (n-- > 0) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			String name = st.nextToken();
			String inout = st.nextToken();
			if (inout.equals("enter")) {
				log.put(name, true);
			}
			else {
				log.put(name, false);
			}
		}
		
		Iterator<String> iterator = log.keySet().iterator();
		while (iterator.hasNext()) {
			String name = iterator.next();
			boolean inout = log.get(name);
			if (inout) System.out.println(name);
		}
		
		br.close();
	}
}
