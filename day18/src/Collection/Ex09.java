package Collection;

import java.util.ArrayList;

class MyQueue{
	ArrayList<String> list = new ArrayList<>();
	
	public void enqueue(String value) {
		list.add(value);	// list에 value를 넣고
	}
	
	public String dequeue() {
		if(list.size() == 0) { // 사이즈가 0이면 값이 없으므로
			return null;	   // null반환
		}
		return list.remove(0);	// 있으면 하나씩 꺼낸다
	}
	
	
	
}
public class Ex09 {
	// Queue : First In First Out, 먼저 들어간 데이터가 먼저 나오는 구조
	// 순서대로 데이터를 처리하기 위해 사용하는 형식
	// queue는 먼저 들어온 값이 먼저 나간다
	// dequeue 나가는 곳(앞)
	// enqueue 들어가는 곳(뒤)
	// 앞을 막아버리면 스택이 된다(마지막에 들어온 값 순으로 나간다)
	
	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.enqueue("짜장");
		queue.enqueue("짬뽕");
		System.out.println(queue.list);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println();
		
	}
}
