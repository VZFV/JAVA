package first;

public class driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericStack<String> driver = new GenericStack<String>();
		
		driver.push("Name");
		driver.push("ID");
		driver.push("Photo");	// puts parameter at the end of the ArrayList	
		
		while(!driver.isEmpty()){
			System.out.println(driver.toString());
			driver.pop();		// removes the last item in the ArrayList	
		}
	}

}
