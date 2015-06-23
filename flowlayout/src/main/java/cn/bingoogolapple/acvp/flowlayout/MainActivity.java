package cn.bingoogolapple.acvp.flowlayout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
    private String[] mVals = new String[]{"Hello", "AndroidAndroidAndroid", "AndroidWelcome", "Welcome", "Button", "HelloWelcome", "Button"};
    private FlowLayout mFlowLayout;
    private EditText mTagEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTagEt = (EditText) findViewById(R.id.et_main_tag);
        mFlowLayout = (FlowLayout) findViewById(R.id.flowlayout);
        initData();
    }

    public void initData() {
        for (int i = 0; i < mVals.length; i++) {
            mFlowLayout.addView(getLabel(mVals[i]), new ViewGroup.MarginLayoutParams(ViewGroup.MarginLayoutParams.WRAP_CONTENT, ViewGroup.MarginLayoutParams.WRAP_CONTENT));
        }
    }

    private TextView getLabel(String text) {
        TextView label = new TextView(this);
        label.setTextColor(Color.WHITE);
        label.setBackgroundResource(R.drawable.selector_tag);
        label.setGravity(Gravity.CENTER);
        label.setSingleLine(true);
        label.setEllipsize(TextUtils.TruncateAt.END);
        int padding = FlowLayout.dp2px(this, 5);
        label.setPadding(padding, padding, padding, padding);
        label.setText(text);
        return label;
    }

    public void onClick(View view) {
        String tag = mTagEt.getText().toString().trim();
        if (!TextUtils.isEmpty(tag)) {
            mFlowLayout.addView(getLabel(tag), new ViewGroup.MarginLayoutParams(ViewGroup.MarginLayoutParams.WRAP_CONTENT, ViewGroup.MarginLayoutParams.WRAP_CONTENT));
        }
        mTagEt.setText("");
    }
}