package coupon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

import shop.RepositoryShop;
import shop.ShopEntity;

public class RepositoryCoupon {

	private static List<CouponEntity> coupons;
	
	static {
		try {
			coupons = loadCoupons();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private synchronized static List<CouponEntity> loadCoupons() throws IOException, ParseException, NumberFormatException{
		List<CouponEntity> coupons = new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new FileReader("D:/Program Files (x86)/Java/java-neon/Workspace/ProjekatWebBackend/WebContent/WEB-INF/database/coupons.txt"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		StringTokenizer st;
		
	    String line = br.readLine();

	    CouponEntity coupon;
	    ShopEntity shop;
	    
	    while (line != null)
			try {
				{
					
					st = new StringTokenizer(line, ",");
					while(st.hasMoreTokens()){
						
						coupon = new CouponEntity();
						
						coupon.setId(Long.parseLong(st.nextToken()));
						
						shop = new ShopEntity();
						shop = RepositoryShop.getShopById(st.nextToken());
						
						coupon.setShopId(shop);
						
						coupon.setProductName(st.nextToken());
						
						coupon.setNewPrice(Float.parseFloat(st.nextToken()));
						
						coupon.setOldPrice(Float.parseFloat(st.nextToken()));
						
						coupon.setValidFrom(sdf.parse(st.nextToken()));
						
						String validTo = st.nextToken();
						
						if( validTo.equals("null")){
							coupon.setValidTo(null);
						}else {
							coupon.setValidTo(sdf.parse(validTo));
						}
						
						coupons.add(coupon);
						
					}
					
					line = br.readLine();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    
	    br.close();
	    
	    return coupons;
	}
	
	public synchronized static List<CouponEntity> getCoupons(){
		return coupons;
	}
	
	public synchronized static void addCoupon(CouponEntity couponEntity) throws IOException{
		
		couponEntity.setId(new Random().nextLong());
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("D:/Program Files (x86)/Java/java-neon/Workspace/ProjekatWebBackend/WebContent/WEB-INF/database/coupons.txt",true));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date now = new Date();
		String nowString = sdf.format(now);
		
		String entityForDatabase = "\n" + couponEntity.getId() + "," + couponEntity.getShopId().getId() + 
				"," + couponEntity.getProductName() + "," + couponEntity.getNewPrice() + "," + couponEntity.getOldPrice() + 
				"," + nowString + ",";
		
		if(couponEntity.getValidTo() == null){
			entityForDatabase += "null";
		}else{
			entityForDatabase += sdf.format(couponEntity.getValidTo());
		}
		
		bw.append(entityForDatabase);
	
		bw.close();
		
		coupons.add(couponEntity);
		
	}
	
	public synchronized static void deleteCoupon(Long id) throws IOException{
		for(CouponEntity coupon: coupons){
			if(coupon.getId().equals(id)){
				coupons.remove(coupon);
				break;
			}
		}
		
		File inputFile = new File("D:/Program Files (x86)/Java/java-neon/Workspace/ProjekatWebBackend/WebContent/WEB-INF/database/coupons.txt");
		File tempFile = new File("D:/Program Files (x86)/Java/java-neon/Workspace/ProjekatWebBackend/WebContent/WEB-INF/database/couponsTmp.txt");

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		Long lineToRemove = id;

		String currentLine = null;

		StringTokenizer st;

		boolean firstLine = true;
		
		while ( (currentLine = reader.readLine()) != null) {
			
			st = new StringTokenizer(currentLine, ",");
			
			Long idFromFile = Long.parseLong(st.nextToken());
			
			if (idFromFile.equals(lineToRemove)) {
				continue;
			}
			
			if(!firstLine){
				writer.write("\n");
			}else{
				firstLine = false;
			}
			
			writer.write(currentLine);

		}
		
		
		writer.close();
		reader.close();
		inputFile.delete();
		boolean successful = tempFile.renameTo(inputFile);
		
	}
}
