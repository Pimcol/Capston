package org.techtown.mapcreate;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap gMap;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Database> arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    private String Path = "167F3aug8WK60nbfNcxbllNtRGs-F_UjAYMmGQiKIfkA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        
        database = FirebaseDatabase.getInstance(); // 변수 안에 FirebaseDatabase 연동
        databaseReference = database.getReference("Path");
        
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // FirebaseDatabase의 데이터를 받아오는 곳
                arrayList.clear();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()) { // 반복문으로 데이터 List를 추출
                    Database gasInfo = snapshot.getValue(Database.class); // GasInfo 클래스에 데이터를 저장해줄 변수 선언
                    arrayList.add(gasInfo); // 데이터를 배열리스트(Arraylist)에 넣음
                }
                // 위의 작업으로 수정 했음으로 새로고침 실행

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // 디버그 가져오다 에러 발생 시
                Log.e("MainActivity", String.valueOf(databaseError.toException()));

            }
        });
        adapter = new CustomAdapter(arrayList, this);
        recyclerView.setAdapter(adapter); // 리사이클러뷰에 어뎁터 연결


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.id_map);
        mapFragment.getMapAsync(this);  // 지도 콜백에 등록
    }



    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        for (int i=0; i<arrayList.size(); i++) {
            LatLng location = new LatLng(arrayList.get(i).getLat(), arrayList.get(i).getLng());
            googleMap.addMarker(new MarkerOptions().position(location).title(arrayList.get(i).getGasStation()));
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 12));
            // CameraUpdate를 사용해 카메라 이동할 위치 지정 (즉, 카메라 위치 변경)
            // CameraUpdateFactory를 사용해, 여러 유형의 CameraUpdate 만들 수 있다.
        }
    }
}