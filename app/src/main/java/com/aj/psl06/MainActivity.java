package com.aj.psl06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView bank1;
    TextView bank2;
    TextView bank3;
    String wordclicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bank1 = findViewById(R.id.Bank1);
        bank2 = findViewById(R.id.Bank2);
        bank3 = findViewById(R.id.Bank3);

        registerForContextMenu(bank1);
        registerForContextMenu(bank2);
        registerForContextMenu(bank3);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");

        if(v == bank1){
            wordclicked = "OCBC";
        }
        else if(v == bank2){
            wordclicked = "DBS";
        }else if(v == bank3){
            wordclicked = "UOB";
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(wordclicked.equalsIgnoreCase("DBS")){
            if(item.getItemId()==0) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.dbs.com.sg/index/default.page"));
                startActivity(intent);
                return true;
            }
            else if(item.getItemId()==1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 63272265));
                startActivity(intentCall);
                return true;
            }
        }else if(wordclicked.equalsIgnoreCase("OCBC")){
            if(item.getItemId()==0) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.ocbc.com/personal-banking/"));
                startActivity(intent);
                return true;
            }
            else if(item.getItemId()==1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 63633333));
                startActivity(intentCall);
                return true;
            }
        }else if(wordclicked.equalsIgnoreCase("UOB")){
            if(item.getItemId()==0) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.uobgroup.com/uobgroup/default.page"));
                startActivity(intent);
                return true;
            }
            else if(item.getItemId()==1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 62598188));
                startActivity(intentCall);
                return true;
            }
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.language_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            bank1.setText("OCBC");
            bank2.setText("DBS");
            bank3.setText("UOB");
            return true;
        } else if (id == R.id.italianSelection) {
            bank1.setText("Società bancaria cinese d'oltremare");
            bank2.setText("La Banca di Sviluppo di Singapore");
            bank3.setText("Banca d'oltremare unita");
            return true;
        } else if (id == R.id.RussianSelection) {
            bank1.setText("Зарубежно-китайская банковская корпорация");
            bank2.setText("Банк развития Сингапура");
            bank3.setText("Объединенный зарубежный банк");
            return true;
        } else if (id == R.id.ChineseSelection) {
            bank1.setText("华侨银行");
            bank2.setText("星展銀行");
            bank3.setText("大华银行");
            return true;
        } else if (id == R.id.BritishSelection) {
            bank2.setText("Oi Guvnor, this That DBS Bloke");
            bank1.setText("Or do ya want these OCBC bruvs");
            bank3.setText("You got'a be Bloody mental with these UOB");
            return true;
        } else {
            bank1.setText("Error translation");
            bank2.setText("Error translation");
            bank3.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }

}