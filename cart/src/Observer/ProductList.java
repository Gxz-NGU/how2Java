package Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


public class ProductList extends Observable{
	private List<String> productList = null; // 产品列表
	private static ProductList instance; //创建唯一实例
	private  ProductList() {}
	/**
	 * 单例模式的getInstance()方法
	 * @return 产品唯一实例
	 */
	public static ProductList getInstance(){
		if(null == instance){
			instance = new ProductList();
			instance.productList = new ArrayList<String>();
		}
		return instance;
	}
		
	/**
	 * 增加观察者（电商接口）
	 * @param observer 观察者
	 */
	public void addProductListObserver(Observer observer){
		this.addObserver(observer);
	}
	
	/**
	 * 增加产品
	 * @param product
	 */
	public void addProduct(String newProduct){
		productList.add(newProduct);
		System.out.println("产品新增加了"+newProduct);
	this.setChanged(); //设置被观察对象发生了变化
		this.notifyObservers(newProduct); //通知观察者，并传递新产品。
	}
	
	public static void main(String[] args){
		ProductList observable = ProductList.getInstance();
		TaoBaoObserver taoBaoObserver = new TaoBaoObserver();
		JingDongObserver jingDongObserver = new JingDongObserver();
		observable.addObserver(jingDongObserver);
		observable.addObserver(taoBaoObserver);
		observable.addProduct("巨乳玩具");
	}
}
