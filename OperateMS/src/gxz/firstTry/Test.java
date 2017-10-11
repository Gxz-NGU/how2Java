package gxz.firstTry;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import Tree.tree;
import Tree.treeNode;

public class Test {

	public static void main(String[] args) throws IOException {
		String path = "D://BOMC6.0规范（全）//BOMC6.0规范（全）//1、中国移动业务支撑网运营管理系统BOMC（V6 0）技术规范.docx";
		InputStream is = new FileInputStream(path);
		List<String> list = new ArrayList<String>();  
        XWPFDocument doc = new XWPFDocument(is);  
        List<XWPFParagraph>paras = doc.getParagraphs();  
        
        tree<String> tree = new tree();
        tree.addNode(null, "root");//整棵树的根节点
        treeNode<String> preNode = tree.getNode("root");
        int preNodeIndex =0;//将根节点的值设为0
        
        for (XWPFParagraph graph : paras) {  
            String text = graph.getParagraphText();  
            String style = graph.getStyle();  
            String regex = "^\\d{1}$";//检验是否为个位数的数字的正则表达式
            if (style!=null&&style.matches(regex)) {  
            	if(Integer.parseInt(style)>preNodeIndex){ 
					tree.addNode(preNode,text);
					preNode=tree.getNode(text);
					preNodeIndex=Integer.parseInt(style);
				}else{//如果当前节点值比上一个小或者相等
					
				}
            }else if(text.contains("【功能定义】")){
				//就把下一个graph中的字符串提取出来，放入precode中
				int index = paras.indexOf(graph)+1;
            	String content = paras.get(index).getParagraphText();  
				tree.addNode(preNode,content);
				//无需对preNode进行设置，因为我们压根就不想让【功能定义】的内容作为一个节点出现，让preNode依旧保持上一个值的内容
			}else{  //解析出的其他内容暂无需要，不做操作 
                continue;  
            }  
            list.add(text);  
        }  
	}

}
