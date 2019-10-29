package com.example.listtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView list = findViewById(R.id.list);

        // viewにレイアウトを設定
        list.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));

        // 使うデータ、ここでは文字列の配列
        final String[] arrayList = {"hoge", "fuga", "baka", "nana", "chinko"};

        // 使うアダプター
        TestAdapter adapter = new TestAdapter(arrayList);

        // アイテムが押されたときの処理
        adapter.setOnItemClickListener(new TestAdapter.Listener() {
            @Override
            public void run(int index) {
                Toast.makeText(MainActivity.this, arrayList[index] + "が押されました", Toast.LENGTH_SHORT).show();
            }
        });

        // viewにアダプターを設定
        list.setAdapter(adapter);
    }
}
