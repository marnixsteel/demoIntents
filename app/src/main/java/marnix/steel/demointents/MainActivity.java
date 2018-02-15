package marnix.steel.demointents;

import android.content.Intent;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Button btnCall, btnHomepage, btnMap, btnDetails;
    private Spinner spNamelist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCall = findViewById(R.id.btn_call);
        btnHomepage = findViewById(R.id.btn_homepage);
        btnMap = findViewById(R.id.btn_map);
        btnDetails = findViewById(R.id.btn_details);
        spNamelist = findViewById(R.id.sp_namelist);

        String[] names = {"Jan", "Piet", "Genghis", "Atilla", "Dirk", "Swa", "Evarist", "Freddy", "Drarrie", "Zebi", "El Kazam", "Pol", "Nico"};

        //adapter -> klasse die elementen uit de lijst in de layout stopt per rij voor bv. spanner, listview
        //arrayadapter kan maar 1 lijn tekst weergeven per rij
        ArrayAdapter<String> mArrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, names);
        //adapter toevoegen aan spinner
        spNamelist.setAdapter(mArrayAdapter);
        //welk element als defaultwaarde?
        spNamelist.setSelection(3);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel:+32486285416");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        });

        btnHomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://www.google.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                String adres = "5 pourbusstraat 2000 Antwerpen";
                String encodedAddress = "geo:0,0?q=" + Uri.encode(adres);
                Uri uri = Uri.parse(encodedAddress);
                intent.setData(uri);
                startActivity(intent);
            }
        });

        btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String selectedName = (String) spNamelist.getSelectedItem();

                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("name", selectedName);
                startActivity(intent);
            }
        });
    }
}
