package cophieu;

import com.google.gson.annotations.SerializedName;

/**
 * 
 * @author Do Kien
 * 
 * thông tin về các thuộc tính: https://www.liberatedstocktrader.com/stock-price/
 *
 */

public class Stock extends News {

	@SerializedName("name")
	private String code; // mã cổ phiếu

	@SerializedName("lp")
	private String lastPrice; // last price: giá cuối cùng

	@SerializedName("ch")
	private String change; // lượng thay đổi của last price so với giá tham chiếu

	@SerializedName("high_price")
	private String highPrice; // giá cao nhất(giá trần)

	@SerializedName("description")
	private String name; // tên cổ phiếu

	private String chp; // % thay đổi của ch

	private String volume; // tổng số cổ phiếu đã giao dịch

	private String ask; 

	private String bid; 

	private String spread; // chênh lệch giữa ask và bid, spread càng thấp, thanh khoản càng cao

	@SerializedName("short_name")
	private String shortName;  // tên ngắn

	private String exchange;  // nơi giao dịch

	@SerializedName("open_price")
	private String openPrice; // giá mở cửa

	@SerializedName("low_price")
	private String lowPrice; // giá thấp nhất(giá sàn)

	@SerializedName("prev_close_price")
	private String prevClosePrice; // giá tham chiếu(giá đóng cửa của phiên giao dịch cuối cùng)


	// constructors
	public Stock(){
		super();
	}

	public Stock(String code, String lastPrice, String change, String highPrice, String name, String chp, String volume,
			String ask, String bid, String spread, String shortName, String exchange, String openPrice, String lowPrice,
			String prevClosePrice) {
		super();
		this.code = code;
		this.lastPrice = lastPrice;
		this.change = change;
		this.highPrice = highPrice;
		this.name = name;
		this.chp = chp;
		this.volume = volume;
		this.ask = ask;
		this.bid = bid;
		this.spread = spread;
		this.shortName = shortName;
		this.exchange = exchange;
		this.openPrice = openPrice;
		this.lowPrice = lowPrice;
		this.prevClosePrice = prevClosePrice;
	}


	// getters and setters
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLastPrice() {
		return lastPrice;
	}

	public void setLastPrice(String lastPrice) {
		this.lastPrice = lastPrice;
	}

	public String getChange() {
		return change;
	}

	public void setChange(String change) {
		this.change = change;
	}

	public String getHighPrice() {
		return highPrice;
	}

	public void setHighPrice(String highPrice) {
		this.highPrice = highPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getChp() {
		return chp;
	}

	public void setChp(String chp) {
		this.chp = chp;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getAsk() {
		return ask;
	}

	public void setAsk(String ask) {
		this.ask = ask;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getSpread() {
		return spread;
	}

	public void setSpread(String spread) {
		this.spread = spread;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	public String getOpenPrice() {
		return openPrice;
	}

	public void setOpenPrice(String openPrice) {
		this.openPrice = openPrice;
	}

	public String getLowPrice() {
		return lowPrice;
	}

	public void setLowPrice(String lowPrice) {
		this.lowPrice = lowPrice;
	}

	public String getPrevClosePrice() {
		return prevClosePrice;
	}

	public void setPrevClosePrice(String prevClosePrice) {
		this.prevClosePrice = prevClosePrice;
	}

	// so sánh giá cuối cùng, với giá tham chiếu của chính cổ phiếu ấy
	public double compareToYesterday() {
		return Double.parseDouble(this.getChange());
	}

	// so sánh giá cuối cùng của 2 loại cổ phiếu 
	public double compareTwoStock(Stock st) {
		double lastPrice1 = Double.parseDouble(this.getLastPrice());
		double lastPrice2 = Double.parseDouble(st.getLastPrice());
		return lastPrice1 - lastPrice2;
	}

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("Thời gian:\t"+getDate()+"\nMã cổ phiếu:\t"+code+"\nTên cổ phiếu:\t"+name);
		if(!name.equalsIgnoreCase(shortName))
			result.append("("+shortName+")");
		result.append("\nGiá mở cửa:\t" + openPrice+"\nGiá trần:\t"+highPrice+"\nGiá sàn:\t"+lowPrice+
				"\nGiá tham chiếu:\t"+prevClosePrice+"\nGiá bán:\t"+lastPrice);
		if(Double.parseDouble(chp) < 0) {
			result.append("\nGiảm:\t" +change+"(tương ứng "+chp+"%)");
		}
		else if(Double.parseDouble(chp) < 0) {
			result.append("\nTăng:\t" +change+"(tương ứng "+chp+"%)");
		}
		else
			result.append( "\nHiện tại, giá không thay đổi!");
		return result.toString();
	}
}
