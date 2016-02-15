package ly.generalassemb.drewmahrt.shoppinglistwithdetailview;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ShoppingSQLiteOpenHelper helper = new ShoppingSQLiteOpenHelper(DetailActivity.this);
        if (getIntent().getExtras() != null) {
            int position = -1;
            position = getIntent().getExtras().getInt("position");
            if (position != -1) {
                Cursor cursor = helper.getItem(position);
                cursor.moveToFirst();
                if (!cursor.isAfterLast()) {
                    do {
                        TextView textView = (TextView) findViewById(R.id.textView);
                        TextView textView1 = (TextView) findViewById(R.id.textView2);
                        TextView textView2 = (TextView) findViewById(R.id.textView3);
                        TextView textView3 = (TextView) findViewById(R.id.textView4);
                        textView.setText(cursor.getString(cursor.getColumnIndex(ShoppingSQLiteOpenHelper.COL_ITEM_NAME)));
                        textView1.setText(cursor.getString(cursor.getColumnIndex(ShoppingSQLiteOpenHelper.COL_ITEM_DESCRIPTION)));
                        textView2.setText(cursor.getString(cursor.getColumnIndex(ShoppingSQLiteOpenHelper.COL_ITEM_PRICE)));
                        textView3.setText(cursor.getString(cursor.getColumnIndex(ShoppingSQLiteOpenHelper.COL_ITEM_TYPE)));
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
        }
    }
}