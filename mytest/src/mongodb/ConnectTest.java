package mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class ConnectTest {
	public static void main(String[] args) {
		try {
			// MongoClient client = new MongoClient("192.168.1.70", 27017);
			// MongoDatabase db = client.getDatabase("sanguo");
			MongoClient client = new MongoClient("127.0.0.1", 27017);
			MongoIterable<String> it = client.listDatabaseNames();
			MongoCursor<String> it2 = it.iterator();
			while (it2.hasNext()) {
				System.out.println(it2.next());
			}
			MongoDatabase db = client.getDatabase("xchao");
			MongoCursor<String> itTables = db.listCollectionNames().iterator();
			while (itTables.hasNext()) {
				System.out.println(itTables.next());
			}
			// MongoDatabase db = client.getDatabase("xchao");
			// db.createCollection("mytest2");
			System.out.println("Connect to database successfully");
			client.close();

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
