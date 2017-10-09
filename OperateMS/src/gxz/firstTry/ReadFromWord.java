package gxz.firstTry;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

public class ReadFromWord {

	
	public static void main(String[] args) throws IOException {
		try {
			InputStream is = new FileInputStream(new File("E://����//֪ʶ���ĵ�//�Լ���д//9��Ԥ��������.doc"));
			HWPFDocument hDocument = new HWPFDocument(is);
			WordExtractor ex = new WordExtractor(hDocument);
			String str = ex.getText();
			System.out.println(str);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
