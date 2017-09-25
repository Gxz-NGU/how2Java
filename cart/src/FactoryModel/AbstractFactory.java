package FactoryModel;

import bean.Product;

/**
 * 同样的道理，createProduct()返回的也是产品大类
 * 
 * 按照实际生活来说，产品很多，工厂也就相应变多，如果还想只是通过简单的用一句createProduct()来生成产品的话，就需要稍强的
 * 内部逻辑。通过编码，可以明白，抽象工厂模式就是在简单工厂模式的基础上多进行了一步工厂的选择，选择好工厂之后再生产产品，
 * 而内部产品工厂都继承产品工厂接口，其内部createProduct()又是IProduct的，所以，通过一个factory.createProduct()完成了
 * 内部逻辑。在客户端，更简单，就调用了一个方法，但其内部实现，嵌套还是蛮多的。
 * @author Administrator
 *
 */
public class AbstractFactory implements IProductFactory{
	public static IProduct createProduct(String productNo){
		char ch = productNo.charAt(0);
		IProductFactory factory = null;
		if(ch == '1') factory = new ProductFactory1();
		else if(ch == '2') factory = new ProductFactory2();
		else if(ch == '3') factory = new ProductFactory3();
		if(factory!=null) return factory.createProduct(productNo);
		return null;
	}
}

class Client{
	public static void main(String[] args){
		AbstractFactory abstractFactory = new AbstractFactory();
		abstractFactory.createProduct(product1);
	}
	
}