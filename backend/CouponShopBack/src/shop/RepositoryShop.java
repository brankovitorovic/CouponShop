package shop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import user.UserEntity;

public class RepositoryShop {

	private static List<ShopEntity> shops;
	
	static {
		try {
			shops = loadShops();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private synchronized static List<ShopEntity> loadShops() throws IOException{
		List<ShopEntity> shops = new ArrayList<ShopEntity>();
		
		BufferedReader br = new BufferedReader(new FileReader("D:/Program Files (x86)/Java/java-neon/Workspace/ProjekatWebBackend/WebContent/WEB-INF/database/shops.txt"));
		StringTokenizer st;
		
		ShopEntity shop;
		
		String line = br.readLine();
		
		while(line != null){
			st = new StringTokenizer(line, ",");
			
			while(st.hasMoreTokens()){
				shop = new ShopEntity();
				shop.setId(st.nextToken());
				shop.setName(st.nextToken());
				
				shops.add(shop);			
			}
			line = br.readLine();
		}
		br.close();
		return shops;
	}
	
	public synchronized static List<ShopEntity> getShops(){
		return shops;
	}
	
	public synchronized static void addShop(ShopEntity shopEntity) throws IOException{
		
		shopEntity.setId( Integer.toString( new Random().nextInt(Integer.MAX_VALUE) ) );
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("D:/Program Files (x86)/Java/java-neon/Workspace/ProjekatWebBackend/WebContent/WEB-INF/database/shops.txt",true));
		
		String entityForDataBase = "\n" + shopEntity.getId() + "," + shopEntity.getName();
		
		bw.append(entityForDataBase);
		
		bw.close();
		
	shops.add(shopEntity);
	
	}
	
	public synchronized static ShopEntity getShopById(String id){
		
		for(ShopEntity shop: shops){
			if(shop.getId().equals(id)){
				return shop;
			}
		}
		return null;
	}
	
	public synchronized static void deleteShop(String id) throws IOException{
		for(ShopEntity shop: shops){
			if(shop.getId().equals(id)){
				shops.remove(shop);
				
				break;
			}
		}
		
		File inputFile = new File("D:/Program Files (x86)/Java/java-neon/Workspace/ProjekatWebBackend/WebContent/WEB-INF/database/shops.txt");
		File tempFile = new File("D:/Program Files (x86)/Java/java-neon/Workspace/ProjekatWebBackend/WebContent/WEB-INF/database/shopsTmp.txt");

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		String lineToRemove = id;

		String currentLine = null;

		StringTokenizer st;

		boolean firstLine = true;
		
		while ( (currentLine = reader.readLine()) != null) {
			
			st = new StringTokenizer(currentLine, ",");
			
			String idFromFile = st.nextToken();
			
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
