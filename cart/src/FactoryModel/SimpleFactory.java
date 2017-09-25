package FactoryModel;

/**
 * 伪代码，并不能进行调试
 * 
 * 简单工厂模式，工厂通过产品号进行生产
 * 
 * 产品继承了产品大类的接口，最后需要返回的是产品大类
 * @author Administrator
 *
 */
public class SimpleFactory {
	public static IProduct crateProduct(String productNo){
		switch (productNo) {
		case "1":
			return new Product1();
			break;
		case "2":
			return new Product2();
			break;
		case "3":
			return new Product3();
			break;
		default:
			break;
		}
	}
}
