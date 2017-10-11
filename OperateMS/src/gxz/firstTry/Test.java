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
		String path = "D://BOMC6.0�淶��ȫ��//BOMC6.0�淶��ȫ��//1���й��ƶ�ҵ��֧������Ӫ����ϵͳBOMC��V6 0�������淶.docx";
		InputStream is = new FileInputStream(path);
		List<String> list = new ArrayList<String>();  
        XWPFDocument doc = new XWPFDocument(is);  
        List<XWPFParagraph>paras = doc.getParagraphs();  
        
        tree<String> tree = new tree();
        tree.addNode(null, "root");//�������ĸ��ڵ�
        treeNode<String> preNode = tree.getNode("root");
        int preNodeIndex =0;//�����ڵ��ֵ��Ϊ0
        
        for (XWPFParagraph graph : paras) {  
            String text = graph.getParagraphText();  
            String style = graph.getStyle();  
            String regex = "^\\d{1}$";//�����Ƿ�Ϊ��λ�������ֵ�������ʽ
            if (style!=null&&style.matches(regex)) {  
            	if(Integer.parseInt(style)>preNodeIndex){ 
					tree.addNode(preNode,text);
					preNode=tree.getNode(text);
					preNodeIndex=Integer.parseInt(style);
				}else{//�����ǰ�ڵ�ֵ����һ��С�������
					
				}
            }else if(text.contains("�����ܶ��塿")){
				//�Ͱ���һ��graph�е��ַ�����ȡ����������precode��
				int index = paras.indexOf(graph)+1;
            	String content = paras.get(index).getParagraphText();  
				tree.addNode(preNode,content);
				//�����preNode�������ã���Ϊ����ѹ���Ͳ����á����ܶ��塿��������Ϊһ���ڵ���֣���preNode���ɱ�����һ��ֵ������
			}else{  //����������������������Ҫ���������� 
                continue;  
            }  
            list.add(text);  
        }  
	}

}
