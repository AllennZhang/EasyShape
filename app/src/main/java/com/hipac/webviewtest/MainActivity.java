package com.hipac.webviewtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hipac.webviewtest.view.BorderTextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private BorderTextView borderTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editext);
       Button btnJump =  findViewById(R.id.btnJump);
       Button btnBaidu =  findViewById(R.id.btnBaidu);
       Button btnWeixin =   findViewById(R.id.btnWeixin);
       Button btnVideo = findViewById(R.id.video);
       Button btnDialog = findViewById(R.id.dialogShow);
        borderTextView = findViewById(R.id.tv_button);
       btnJump.setOnClickListener(this);
       btnBaidu.setOnClickListener(this);
       btnWeixin.setOnClickListener(this);
       btnVideo.setOnClickListener(this);
       btnDialog.setOnClickListener(this);


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnJump:
                if (TextUtils.isEmpty(editText.getText())){
                    Toast.makeText(this,"输入地址不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                String url = editText.getText().toString().trim();
                WebViewActivity.startActivity(this,url);
                break;
            case R.id.btnBaidu:
                WebViewActivity.startActivity(this,"https://www.baidu.com/");
                break;
            case R.id.btnWeixin:
                 WebViewActivity.startActivity(this,"https://mp.weixin.qq.com/s/R4xmQvlGENAf8VOKwPFGkg");
                break;
            case R.id.video:
//                startActivity(new Intent(MainActivity.this,VideoActivity.class));
                break;
            case R.id.dialogShow:
                    startActivity(new Intent(MainActivity.this,ShapeTestActivity.class));
//                  borderTextView.update(new BorderTextView.Builder(borderTextView).gradientColor(Color.YELLOW,Color.GREEN).gradientOrientation(BorderTextView.Orientation.LEFT_RIGHT));

//                SelectePhotoDialog dialog = new SelectePhotoDialog(this);
//                dialog.show();
                break;
        }
    }
}
