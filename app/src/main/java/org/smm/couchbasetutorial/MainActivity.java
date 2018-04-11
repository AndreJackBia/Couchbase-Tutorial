package org.smm.couchbasetutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.couchbase.lite.CouchbaseLiteException;
import com.couchbase.lite.Database;
import com.couchbase.lite.Document;
import com.couchbase.lite.Manager;
import com.couchbase.lite.Query;
import com.couchbase.lite.QueryEnumerator;
import com.couchbase.lite.QueryOptions;
import com.couchbase.lite.QueryRow;
import com.couchbase.lite.android.AndroidContext;
import com.couchbase.lite.util.ZipUtils;
import com.fasterxml.jackson.databind.util.ObjectIdMap;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Manager manager = null;
        try {
            manager = new Manager(new AndroidContext(getApplicationContext()), Manager.DEFAULT_OPTIONS);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Create or open the database named app
        Database database = null;
        try {
            database = manager.getDatabase("outpumpdb8hgjjkhgk");
        } catch (CouchbaseLiteException e) {
            e.printStackTrace();
        }
        // The properties that will be saved on the document
        Map<String, Object> properties = new HashMap<>();
        Map<String, Object> properties1 = new HashMap<>();
        properties.put("title", "Couchbase Mobile");
        properties1.put("title", "IOS");
        // Create a new document
        Document document1 = database.getDocument("1");
        Document document2 = database.getDocument("2");
        try {
            document1.putProperties(properties);
            document2.putProperties(properties1);
            // Save the document to the database

            Query query = database.createAllDocumentsQuery();
            query.setAllDocsMode(Query.AllDocsMode.ALL_DOCS);
            QueryEnumerator result = query.run();
            Iterator<QueryRow> it = result;

            while (it.hasNext()) {
                QueryRow row = it.next();
                Document doc = database.getDocument((String)row.getKey());

                Log.e("Result",doc.getProperty("title").toString());
            }
            //        for (Iterator<QueryRow> it = result; it.hasNext();) {
//            QueryRow row = it.next();
//
////            if (row.getConflictingRevisions().size() > 0) {
////                Log.w("MYAPP", "Conflict in document: %s", row.getDocumentId());
////                beginConflictResolution(row.getDocument());
////

        } catch (CouchbaseLiteException e) {
            e.printStackTrace();
        }
    }
}
