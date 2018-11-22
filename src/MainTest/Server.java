package MainTest;

import java.util.LinkedList;

public class Server { // main 규칙을 만들기 위한 파일
	LinkedList<Integer> user1 = new LinkedList<>();
	LinkedList<Integer> user2 = new LinkedList<>();

	public Server() {
		for (int i = 0; i < 28; i++) {
			user1.add(0);
			user2.add(0);
		}
	}
	public static void main(String[] args) {
		Server s = new Server();
		System.out.println(s.user1);
		System.out.println(s.user2);
		
	}
}
