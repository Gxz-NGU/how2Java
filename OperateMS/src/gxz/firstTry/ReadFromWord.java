package gxz.firstTry;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.model.PicturesTable;
import org.apache.poi.hwpf.model.StyleDescription;
import org.apache.poi.hwpf.model.StyleSheet;
import org.apache.poi.hwpf.usermodel.CharacterRun;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Picture;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;


public class ReadFromWord {

	 //2003  
    public static List<String> getWordTitles2003(String path) throws IOException{  
        File file = new File(path);  
        String filename = file.getName();  
        filename = filename.substring(0, filename.lastIndexOf("."));  
        InputStream is = new FileInputStream(path);  
        HWPFDocument doc = new HWPFDocument(is);   
        Range r = doc.getRange();  
          
        List<String> list = new ArrayList<String>();  
        for (int i = 0; i < r.numParagraphs(); i++) {  
            Paragraph p = r.getParagraph(i);  
            // check if style index is greater than total number of styles  
            int numStyles =doc.getStyleSheet().numStyles();  
            int styleIndex = p.getStyleIndex();  
            if (numStyles > styleIndex) {  
                StyleSheet style_sheet = doc.getStyleSheet();  
                StyleDescription style = style_sheet.getStyleDescription(styleIndex);  
                String styleName = style.getName();  
                if (styleName!=null&&styleName.contains("Ŀ¼")) {  
                    // write style name and associated text  
                    //System.err.println(styleName + " -> " + p.text());  
                    //System.err.println(p.text());  
                    String text = p.text();  
                  //Ŀǰdoc����Ķ�����ȫ�����֣��ȶ�ת��Ϊdocx���н�����ˡ�
                    list.add(text);  
                }  
            }  
        }  
        return list;  
    }  
      
    public static List<String> getWordTitles2007(String path) throws IOException{  
  
        InputStream is = new FileInputStream(path);  
          
        //2007  
//      OPCPackage p = POIXMLDocument.openPackage(path);  
//      XWPFWordExtractor e = new XWPFWordExtractor(p);  
//      POIXMLDocument doc = e.getDocument();  
        List<String> list = new ArrayList<String>();  
        XWPFDocument doc = new XWPFDocument(is);  
        List<XWPFParagraph>paras = doc.getParagraphs();  
        for (XWPFParagraph graph : paras) {  
            String text = graph.getParagraphText();  
            String style = graph.getStyle();  
            String regex = "^\\d{1}$";//�����Ƿ�Ϊ��λ�������ֵ�������ʽ
            if (style!=null&&style.matches(regex)) {  
              
            }else{  
                continue;  
            }  
            list.add(text);  
        }  
        return list;  
          
    }  
    public static void main(String[] args) throws IOException {  
  
        String path = "E://����//ϵͳ//�й��ƶ�ҵ��֧������Ӫ����ϵͳBOMC//BOMC6.0�淶��ȫ��//BOMC6.0�淶��ȫ��//1���й��ƶ�ҵ��֧������Ӫ����ϵͳBOMC��V6 0�������淶.docx";  
        List<String> list = new ArrayList<String>();  
        if (path.endsWith(".doc")) {  
            list = getWordTitles2003(path);  
        }else if (path.endsWith(".docx")) {  
            list = getWordTitles2007(path);  
        }  
        for (String title : list) {  
            System.out.println(title);  
        }  
    }  

}
