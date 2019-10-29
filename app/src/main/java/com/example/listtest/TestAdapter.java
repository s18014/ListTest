package com.example.listtest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {
    private String[] arrayString; // 使うデータ
    private Listener listener; // Itemが押された時に呼ばれるリスナー

    public TestAdapter(String[] arrayString) {
        // データを受け取って内部に保存
        this.arrayString = arrayString;
    }

    // 渡されたリスナーを登録
    public void setOnItemClickListener(Listener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public TestAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // simple_list_item_1は一つのTextViewを持っているレイアウトファイル、ディフォルトで用意されている
        View view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TestAdapter.ViewHolder holder, final int position) {
        holder.textView.setText(arrayString[position]);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.run(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayString.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // simple_list_item_1が持っているTextViewの参照を取っている
            textView = itemView.findViewById(android.R.id.text1);
        }
    }

    // Itemが押された時に呼ばれるリスナーのインターフェース
    public interface Listener {
        public void run(int index);
    }
}
