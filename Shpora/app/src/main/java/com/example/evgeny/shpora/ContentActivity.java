package com.example.evgeny.shpora;

        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.text.Html;
        import android.widget.TextView;

public class ContentActivity extends AppCompatActivity {
    TextView contentView;
    private String[] nameFiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_activity);

        contentView = (TextView)findViewById(R.id.txt_content);
        nameFiles = getResources().getStringArray(R.array.names_files);
        int position = getIntent().getIntExtra(MainActivity.KEY_ID, 0);
        InputFile file = new InputFile(getApplicationContext(), nameFiles[position]);
        contentView.setText(Html.fromHtml(file.readFile()));
    }
}

