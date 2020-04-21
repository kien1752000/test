package cophieu;

import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author Do Kien
 *
 */

public class News { 
	protected Date date; // ngày giờ lấy dữ liệu(ngày giờ hiện tại)
	protected String source; // nguồn lấy dữ liệu
	
	// default constructor
	public News() {
		Calendar cal = Calendar.getInstance();
		this.date = cal.getTime();
		this.source = "https://vn.investing.com/charts/indices-charts";
	}
	
	// getters and setters
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	
	
}
