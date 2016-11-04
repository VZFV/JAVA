package first;

public class Ref {
	public static void main(String args[]){
		String str=" hello word ";
		
		char mychar=str.charAt(6);
		System.out.println("字符串str中索引位置是6的字符为:" +mychar);
		
		String substr1=str.substring(3);
		System.out.println("从3下标之后的字符为:" +substr1);
		
		String substr2=str.substring(0, 3);
		System.out.println(substr2);
		
		System.out.println("字符串原来的长度:" +str.length());
		System.out.println("去空格的长度是:" +str.trim().length());
		
		String newstr=str.replace("o","O");
		System.out.println(newstr);
		
		String num1="2234254512";
		String num2="2244545478";
		boolean b=num1.startsWith("22");
		boolean b2=num1.endsWith("78");
		boolean b3=num2.startsWith("22");
		boolean b4=num2.startsWith("78");
		System.out.println(b);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(b4);
		
		
	}

}

