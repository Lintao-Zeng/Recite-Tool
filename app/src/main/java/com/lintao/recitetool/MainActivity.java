package com.lintao.recitetool;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static com.lintao.recitetool.spare.count;
import static com.lintao.recitetool.spare.getTemp;
import static com.lintao.recitetool.spare.index;
import static com.lintao.recitetool.spare.line;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        问题显示框
        final TextView question = findViewById(R.id.question);
        question.setMovementMethod(ScrollingMovementMethod.getInstance());
        question.setTextIsSelectable(true);

//        答案显示框
        final TextView answer = findViewById(R.id.answer);
        answer.setMovementMethod(ScrollingMovementMethod.getInstance());
        answer.setTextIsSelectable(true);
        answer.setVisibility(View.INVISIBLE);

//        取得题库
        final String[] temp = getTemp();

//        显示框初始化
        final EditText number = findViewById(R.id.number);
        number.setText(String.valueOf(count));
        question.setText(temp[index].replace("\\n", "\n"));
        answer.setText(temp[index+1].replace("\\n", "\n"));

        final Button control = findViewById(R.id.control);


//        上一个按钮初始化
        final Button previous = findViewById(R.id.previous);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index==0){
                    answer.setVisibility(View.INVISIBLE);
                    control.setText("显示");
                    index = line - 2;
                    question.setText(temp[index].replace("\\n", "\n"));
                    answer.setText(temp[index+1].replace("\\n", "\n"));
                    count = line / 2;
                    number.setText(String.valueOf(count));
                    Toast.makeText(MainActivity.this, "已跳转到最后一个", Toast.LENGTH_SHORT).show();
                }else {
                    answer.setVisibility(View.INVISIBLE);
                    control.setText("显示");
                    index = index-2;
                    question.setText(temp[index].replace("\\n", "\n"));
                    answer.setText(temp[index+1].replace("\\n", "\n"));
                    count--;
                    number.setText(String.valueOf(count));
                }
            }
        });

//        控制按钮功能初始化
        control.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(control.getText().equals("显示")){
                    answer.setVisibility(View.VISIBLE);
                    control.setText("隐藏");
                }else {
                    answer.setVisibility(View.INVISIBLE);
                    control.setText("显示");
                }
            }
        });

//        下一个按钮初始化
        final Button next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index==(temp.length - 2)){
                    answer.setVisibility(View.INVISIBLE);
                    control.setText("显示");
                    index = 0;
                    question.setText(temp[index].replace("\\n", "\n"));
                    answer.setText(temp[index+1].replace("\\n", "\n"));
                    count = 1;
                    number.setText(String.valueOf(count));
                    Toast.makeText(MainActivity.this, "已跳转到第一个", Toast.LENGTH_SHORT).show();
                }else {
                    answer.setVisibility(View.INVISIBLE);
                    control.setText("显示");
                    index = index+2;
                    question.setText(temp[index].replace("\\n", "\n"));
                    answer.setText(temp[index+1].replace("\\n", "\n"));
                    count++;
                    number.setText(String.valueOf(count));
                }
            }
        });

//        跳转按钮功能初始化
        Button jump = findViewById(R.id.jump);
        jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.setVisibility(View.INVISIBLE);
                control.setText("显示");
                int inpuNo = Integer.valueOf(number.getText().toString());
                index = inpuNo * 2 - 2;
                question.setText(temp[index].replace("\\n", "\n"));
                answer.setText(temp[index+1].replace("\\n", "\n"));
                count = inpuNo;
            }
        });

    }

}