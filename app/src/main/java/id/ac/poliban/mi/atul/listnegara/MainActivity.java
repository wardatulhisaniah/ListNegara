package id.ac.poliban.mi.atul.listnegara;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Country> countries = new ArrayList<>();
    private ListView lvCountry;
    private BaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //koneksikan object dengan view
        lvCountry = findViewById(R.id.lvnegara);
//ambil data dari CountryData dan berikan ke object countries
        countries.addAll(CountryData.getAllCountries());
//buat object adapter dan kirim data countries sebagai
//parameter di konstruktor CountryAdapter()
        adapter = new CountryAdapter(countries);
//pasang object adapter sebagai adapter lvCountry
        lvCountry.setAdapter(adapter);
//menambahkan kejadian ketika user mengklik salah satu item
        lvCountry.setOnItemClickListener((parent, view, position, id) -> {
            new AlertDialog.Builder(this)
                    .setTitle("Negara yang Anda Pilih")
                    .setMessage("anda memilih: " +
                            countries.get(position).getCountryName())
                    .setPositiveButton("OK", null).show();
        });
    }
    }

