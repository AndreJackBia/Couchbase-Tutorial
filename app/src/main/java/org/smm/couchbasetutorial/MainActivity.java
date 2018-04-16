package org.smm.couchbasetutorial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.couchbase.lite.CouchbaseLiteException;
import com.couchbase.lite.Database;
import com.couchbase.lite.DatabaseConfiguration;
import com.couchbase.lite.Document;
import com.couchbase.lite.MutableDocument;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArticleModel article1 = new ArticleModel();
        article1.setTitle("NASA Hacked");
        article1.setLink("https://www.fakenews.com/NASA Hacked/");
        article1.setCategory("Breaking news");
        article1.setCreator("El barto");
        article1.setDate("27/10/2019");
        article1.setDescription("This is a description");
        article1.setImage("https://www.fakenews.com/wp-content/nasa-pic-hacker.png");
        article1.setContent("This is encoded content");
        try {
            // Get the database (and create it if it doesn’t exist).
            DatabaseConfiguration config = new DatabaseConfiguration(getApplicationContext());
            Database database = new Database("fakenewsdb", config);

            // Create a new document (i.e. a record) in the database.
            MutableDocument mutableDoc = new MutableDocument()
                    .setString("title", article1.getTitle())
                    .setString("link", article1.getLink())
                    .setString("category", article1.getCategory())
                    .setString("creator", article1.getCreator())
                    .setString("description", article1.getDescription())
                    .setString("date", article1.getDate())
                    .setString("content", article1.getContent());

            // Save it to the database.
            database.save(mutableDoc);

            // Update a document.
            mutableDoc = database.getDocument(mutableDoc.getId()).toMutable();
            mutableDoc.setString("image", article1.getImage());
            database.save(mutableDoc);
            Document document = database.getDocument(mutableDoc.getId());

            // Log the document ID (generated by the database) and properties
            Log.i("DATABASE CREATION", "Document ID :: " + document.getId());
            Log.i("DATABASE CREATION", "Learning " + document.getString("language"));

        } catch (CouchbaseLiteException e) {
            Log.e("BEFORE CLASS", e.getMessage());
        }
    }

    //    protected void onCreate_v14(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        Manager manager = null;
//        try {
//            manager = new Manager(new AndroidContext(getApplicationContext()), Manager.DEFAULT_OPTIONS);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        // Create or open the database named app
//        Database database = null;
//        try {
//            database = manager.getDatabase("outpumpdb8hgjjkhgk");
//        } catch (CouchbaseLiteException e) {
//            e.printStackTrace();
//        }
//        // The properties that will be saved on the document
//        Map<String, Object> properties = new HashMap<>();
//        Map<String, Object> properties1 = new HashMap<>();
//        properties.put("title", "Couchbase Mobile");
//        properties1.put("title", "IOS");
//        // Create a new document
//        Document document1 = database.getDocument("1");
//        Document document2 = database.getDocument("2");
//        try {
//            document1.putProperties(properties);
//            document2.putProperties(properties1);
//            // Save the document to the database
//
//            Query query = database.createAllDocumentsQuery();
//            query.setAllDocsMode(Query.AllDocsMode.ALL_DOCS);
//            Iterator<QueryRow> it = query.run();
//
//            while (it.hasNext()) {
//                QueryRow row = it.next();
//                Document doc = database.getDocument((String)row.getKey());
//
//                Log.e("Result",doc.getProperty("title").toString());
//            }
//
//        } catch (CouchbaseLiteException e) {
//            e.printStackTrace();
//        }
//    }
}
