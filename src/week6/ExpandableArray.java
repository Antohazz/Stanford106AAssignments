package week6;

import acm.program.ConsoleProgram;

public class ExpandableArray extends ConsoleProgram {
	
	public void run() {

		EArray a = new EArray();
		a.set(5, "555");
		println(a.get(5));
		println(a.get(6));
	
}
	
	public class EArray {

		private Object[] arr;

		public EArray() {
			arr = new Object[0];
		}

		public void set(int index, Object value) {
			if (index >= arr.length) {
				Object[] temp = new Object[index+1];
				
				for (int i = 0; i < arr.length; i++) {
					temp[i] = arr[i];
				}
				
				arr = temp;
			}
			
			arr[index] = value;
		}


		public Object get(int index) {
			if (index >= arr.length) {
				return null;
			}
			return arr[index];
		}
		
	}
	
}