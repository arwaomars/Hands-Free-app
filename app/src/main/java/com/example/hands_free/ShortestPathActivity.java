package com.example.hands_free;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.ui.AppBarConfiguration;
import com.example.hands_free.databinding.ActivityShortestPathBinding;
import java.util.ArrayList;
import java.util.List;
import android.view.MenuItem;

public class ShortestPathActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityShortestPathBinding binding;

    TextView textView;
    List<String> store = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shortest_path);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Collector ID
        String CollectorID = "Collector ID: ";
        ////In next version the ID should get from database.
        CollectorID += "1256";
        textView = findViewById(R.id.textView_collectorID);
        textView.setText(CollectorID);


        //stores that assigned to collector
        StringBuilder CollectorStores = new StringBuilder();
        ////In the next version the store should get from database.
        store.add("Store10");
        store.add(", ");
        store.add("Store11");
        store.add(", ");
        store.add("Store28");
        store.add(", ");
        store.add("Store23");
        store.add(", ");
        store.add("Store30");
        for(int i = 0; i<store.size(); i++){
            CollectorStores.append(store.get(i));
        }
        textView = findViewById(R.id.textView_storesAssigned);
        textView.setText(CollectorStores.toString());
    }


    public void onClickShortestPath(View view){
        ShortestPath calculateShortestPath = new ShortestPath();
        List<Point> shortestPathList = calculateShortestPath.displayShortestPath();

        //Print the shortest path
        StringBuilder shortestPath = new StringBuilder();
        for (Point point : shortestPathList) {
            if(point.getStore().equalsIgnoreCase("office")){
                continue;
            }
            shortestPath.append(point.getStore());
            shortestPath.append(", ");
        }

        textView = findViewById(R.id.textView_shortestPathTitle);
        textView.setVisibility(View.VISIBLE);
        textView = findViewById(R.id.textView_shortestPath);
        textView.setText(shortestPath);
        textView.setVisibility(View.VISIBLE);
    }

}