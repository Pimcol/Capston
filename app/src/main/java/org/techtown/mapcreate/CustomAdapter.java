package org.techtown.mapcreate;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    private ArrayList<Database> arrayList;
    private Context context;

    public CustomAdapter(ArrayList<Database> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 실제 리스트뷰가 어뎁터에 연결 후 뷰 홀더를 최로로 만듬
        // 리스트에 찍을 데이터를 넣어줄 때 사용
        
        return null;
    }


    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
        // arryaList가 널이 아니면 (사이즈 리턴 <-> 아니면 0리턴)
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
