package src;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Arrays;

import static com.mongodb.client.model.Updates.combine;

public class Main {

    public static void main(String[] args) {
        MongoClient mongoClient=new MongoClient("localhost",27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("Vehicles");
        MongoCollection mongoCollection = mongoDatabase.getCollection("cars");


     //   save(mongoCollection);
       // read(mongoCollection);
       // readByParam(mongoCollection,"Mark", "Fiat");
        //delete(mongoCollection,"Mark","Fiat");
        update(mongoCollection);
    }

    public static void update(MongoCollection mongoCollection){

        Bson eq = Filters.eq("Mark", "Audi");
        Bson newDocument = combine(set("Model","A2"), set("Color","Black"));



        mongoCollection.updateOne(eq, newDocument);
    }



    public static void delete(MongoCollection mongoCollection,String param, Object value) {
        Document document = new Document();
        document.put(param,value);
        mongoCollection.deleteOne(document);

    }

    private static void readByParam(MongoCollection mongoCollection,String param, Object value){
        Document document = new Document();
        document.put(param,value);
        MongoCursor iterator = mongoCollection.find(document).iterator();
       while(iterator.hasNext()){
          Document next = (Document)iterator.next();
          System.out.println(next);
       }
    }

    private static void read(MongoCollection mongoCollection){
        Document first = (Document)mongoCollection.find().first();
        System.out.println(first.toJson());
    }
    private static void save(MongoCollection mongoCollection) {
        Document document1 = new Document();
        document1.put("Mark","Fiat");
        document1.put("Model","126p");

        Document document2 = new Document();
        document2.put("Mark","Fiat");
        document2.put("Model","One");
        document2.put("Color","Red");

        mongoCollection.insertMany(Arrays.asList(document1,document2));
    }

}
