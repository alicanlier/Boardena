package reflecttest;

public class ReflectMethod {
	//field
	   public String field;
	 
	   //constructor
	   public ReflectMethod() {}

	   public ReflectMethod(String field) {
	      this.field = field;
	   }
	 
	   //method
	   public String getField() {
	      System.out.println("call field : " + this.field);
	      return this.field;
	   }
	   public void methodA() {
	      System.out.println("call method A");
	   }
	   public void methodB(String str) {
	      System.out.println("call method B : " + str);
	   }
	   public String methodC() {
	      System.out.println("call method C");
	      return "method C";
	   }
}
