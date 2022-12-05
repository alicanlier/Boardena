package reflecttest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectMain {
	public static void main(String[] arguments)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, SecurityException,
			NoSuchMethodException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {

		/*
		 * 원시형 클래스 타입 char : Character.TYPE byte : Byte.TYPE short : Short.TYPE int :
		 * Integer.TYPE long : Long.TYPE float : Float.TYPE double : Double.TYPE
		 */

		//클래스 가져오기
		Class getClass1 = Class.forName("reflecttest.ReflectMethod");
		Class getClass2 = ReflectMethod.class;
		Class getClass3 = new ReflectMethod().getClass();

		//클래스 객체를 이용한 객체 생성

		//생성자에 인자가 없는 경우
		Object object1 = getClass1.newInstance();
		//생성자에 인자가 있을 경우
		Class[] constructorParamClass = new Class[] { String.class };
		Object[] constructorParamObject = new Object[] { "Reflect Test!!!" };
		Constructor constructor = getClass1.getConstructor(constructorParamClass);
		Object object2 = constructor.newInstance(constructorParamObject);

		//필드 값 가져오기
		Field field = getClass1.getField("field");
		Object fieldObject = field.get(object2);

		System.out.println(fieldObject);

		//메소드 호출

		//메소드에 인자가 없는 경우
		Method method1 = getClass1.getMethod("methodA");
		method1.invoke(object1);
		//메소드에 인자가 있을 경우
		Class[] methodParamClass = new Class[] { String.class };
		Object[] methodParamObject = new Object[] { "1 parameter" };
		Method method2 = getClass1.getMethod("methodB", methodParamClass);
		method2.invoke(object1, methodParamObject);
		//메소드에 리턴값이 있을 경우
		Method method3 = getClass1.getMethod("methodC");
		Object returnObject = method3.invoke(object1);

		System.out.println("methodC return value : " + returnObject);
	}
}
