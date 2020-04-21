package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;

import cophieu.Stock;

public class TestCoPhieu {

	public static void main(String[] args) throws IOException {
		// địa chỉ file json lấy đc từ web
		String path ="C:\\Users\\Do Kien\\Desktop\\tmp.txt";
		
		ArrayList<Stock> cp = convertJsonFileToObjectJava(path);
		
		// in thông tin các cổ phiếu 
		for(int i = 0; i<cp.size();i++) {
			System.out.print(i+1+".");
			System.out.println(cp.get(i));
			System.out.println("-----------------");
		}
	}
	
	/**
	 * 
	 * @author Do Kien
	 * @param path - đường dẫn đến file
	 * @return danh sách các cổ phiếu
	 * 
	 */
	
	public static ArrayList<Stock> convertJsonFileToObjectJava(String path) throws IOException{
		
		// đọc file json đã được lấy từ internet
		FileInputStream fis = new FileInputStream(path);
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		BufferedReader br = new BufferedReader(isr);

		// lấy dữ liệu từ file json rồi gán thành chuỗi 
		StringBuffer sb = new StringBuffer();
		String line;
		while((line = br.readLine()) != null) {
			sb.append(line);
		}

		// xử lý chuỗi json đã lấy

		// kq là JSONArray sau khi đã được lọc
		// mỗi phần tử của kq là những thuộc tính của 1 cổ phiếu
		// source từ vn.invasting.. thì có 32 loại cổ phiếu
		JSONArray kq = new JSONArray();

		// chuyển chuỗi sb -> JSONObject
		JSONObject json = new JSONObject(sb.toString());

		// lấy value của key "d". nó chứa các thuộc tính của cổ phiếu
		JSONArray jsonArray = json.getJSONArray("d");
		for(int i = 0; i < jsonArray.length(); i++) {
			// lấy tên cổ phiếu
			String nameStock = jsonArray.getJSONObject(i).getString("n");

			// lấy thuộc tính còn lại, và thêm tên cổ phiếu vào các thuộc tính
			JSONObject tt2 = jsonArray.getJSONObject(i).getJSONObject("v").put("name", nameStock);

			// thêm tt2 vào kq
			kq.put(tt2);
		}
		// danh sách liên kết các cổ phiếu (32 cổ phiếu)
		ArrayList<Stock> ds = new ArrayList<Stock>();

		// chuyển từ JSONObject --> Object java
		// rồi thêm vào danh sách liên kết ds
		Gson gson = new Gson();
		for(int i = 0; i< kq.length();i++) {
			Stock cp = gson.fromJson(kq.get(i).toString(), Stock.class);
			ds.add(cp);
		}
		
		return ds;
	}
}
