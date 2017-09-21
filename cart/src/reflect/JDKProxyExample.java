package reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class JDKProxyExample implements InvocationHandler{
	//真实对象
	private Object target = null;
	
	/**
	 * 建立代理对象和真实对象的关系，并返回代理对象
	 * @param target真实对象
	 * @return 代理对象
	 */
	public Object bind(Object target){
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	
	/**
	 * 代理方法逻辑
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("进入代理逻辑方法");
		System.out.println("在调度真实对象之前的服务0");
		Object obj = method.invoke(target, args);
		System.out.println("在调度真实对象之后的服务");
		return obj;
	}

	public void test(){
		JDKProxyExample jdk = new JDKProxyExample();
		HelloWorld proxy1 = (HelloWorld)jdk.bind(new HelloWorldImpl());
		proxy1.sayHelloWorld();
	}
	
	public static void main(String[] args) {
		JDKProxyExample jdkProxyExample = new JDKProxyExample();
		jdkProxyExample.test();
	}
}
