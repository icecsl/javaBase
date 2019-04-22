package thinkingInJava.generics;

/**
 * @Description:
 * @author: huangbingjing
 * @date: 19/1/14
 */
public class LinkedStackIceTest<T> {

	static class NodeIce<U>{
		U item;
		NodeIce<U> next;
		public NodeIce() {
			this.item = null;
			this.next = null;
		}
		public NodeIce(U item, NodeIce<U> next) {
			this.item = item;
			this.next = next;
		}
		public boolean isEnd(){
			return next == null && item==null;
		}

		@Override
		public String toString() {
			final StringBuffer sb = new StringBuffer("NodeIce{");
			sb.append("item=").append(item);
			sb.append(", next=").append(next);
			sb.append('}');
			return sb.toString();
		}
	}

	private NodeIce<T> top = new NodeIce<>();

	public T pop(){
		T popResult = top.item;
		if (!top.isEnd()){
			top=top.next;
		}
		return popResult;
	}

	public void push(T item) {
		NodeIce<T> newTop = new NodeIce<>(item, this.top );
		this.top = newTop;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("LinkedStackIceTest{");
		sb.append("top=").append(top);
		sb.append('}');
		return sb.toString();
	}

	public static void main(String[] args) {
		LinkedStackIceTest<String> linkedStackIceTest = new LinkedStackIceTest<String>();
		String s = "Phasers on stun!";
		String[] s1 = s.split(" ");
		for (String a : s1){
			linkedStackIceTest.push(a);
		}

//		System.out.println(linkedStackIceTest);

		while ((s = linkedStackIceTest.pop()) != null){
			System.out.println(s);
		}
	}
}
