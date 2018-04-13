package com.own.sqlite1;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.own.sqlite1.adapter.CartoonAdapter;
import com.own.sqlite1.model.Cartoon;
import com.own.sqlite1.sqlite.DBOperations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elena Alvarado on 08/04/2018.
 */

public class CartoonActivity extends AppCompatActivity {

    private EditText edtName;
    private EditText edtType;
    private EditText edtLanguage;
    private EditText edtAuthor;
    private EditText edtCapitulos;
    private EditText edtYear;
    private Button btnSaveCartoon;
    private DBOperations operations;
    private Cartoon cartoon = new Cartoon();
    private RecyclerView rvCartoons;
    private List<Cartoon> cartoons=new ArrayList<Cartoon>();
    private CartoonAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartoon);

        //iniciacion de la isntancia
        operations=DBOperations.getDBOperations(getApplicationContext());
        cartoon.setIdCartoon("");


        initComponents();
    }
    private void initComponents(){
        rvCartoons=(RecyclerView)findViewById(R.id.rv_cartoon_list);
        rvCartoons.setHasFixedSize(true);
        LinearLayoutManager layoutManeger=new LinearLayoutManager(this);
        rvCartoons.setLayoutManager(layoutManeger);
        //
        getCartoons();
        adapter=new CartoonAdapter(cartoons);

        adapter.setListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btn_delete:
                        operations.deleteCartoon(cartoons.get(rvCartoons.getChildPosition((View)v.getParent().getParent())).getIdCartoon());
                        getCartoons();
                        adapter.notifyDataSetChanged();
                        break;
                    case R.id.btn_edit:

                        Toast.makeText(getApplicationContext(),"Editar",Toast.LENGTH_SHORT).show();
                        Cursor c = operations.getCartoonById(cartoons.get(
                                rvCartoons.getChildPosition(
                                        (View)v.getParent().getParent())).getIdCartoon());
                        if (c!=null){
                            if (c.moveToFirst()){
                                cartoon = new Cartoon(c.getString(1),c.getString(2 ), c.getString(3),c.getString(4),c.getString(5),c.getInt(6),c.getInt(7));
                            }
                            edtName.setText(cartoon.getName());
                            edtType.setText(String.valueOf(cartoon.getType()));
                            edtLanguage.setText(String.valueOf(cartoon.getLanguage()));
                            edtAuthor.setText(String.valueOf(cartoon.getAuthor()));
                            edtCapitulos.setText(String.valueOf(cartoon.getCapitulos()));
                            edtYear.setText(String.valueOf(cartoon.getYear()));

                        }else{
                            Toast.makeText(getApplicationContext(),"Registro no encontrado",Toast.LENGTH_SHORT).show();
                        }
                        break;
                }

            }
        });
        rvCartoons.setAdapter(adapter);

        edtName=(EditText)findViewById(R.id.edt_name);
        edtType=(EditText)findViewById(R.id.edt_type);
        edtLanguage=(EditText)findViewById(R.id.edt_language);
        edtAuthor=(EditText)findViewById(R.id.edt_author);
        edtCapitulos=(EditText)findViewById(R.id.edt_capitulos);
        edtYear=(EditText)findViewById(R.id.edt_year);

        btnSaveCartoon=(Button)findViewById(R.id.btn_save_cartoon);

        btnSaveCartoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!cartoon.getIdCartoon().equals("")){
                    cartoon.setName(edtName.getText().toString());
                    cartoon.setType(edtType.getText().toString());
                    cartoon.setLanguage(edtLanguage.getText().toString());
                    cartoon.setAuthor(edtAuthor.getText().toString());
                    cartoon.setCapitulos(Integer.parseInt(edtCapitulos.getText().toString()));
                    cartoon.setYear(Integer.parseInt(edtYear.getText().toString()));
                    operations.updateCartoon(cartoon);

                }else {
                    cartoon = new Cartoon("",edtName.getText().toString(),  edtType.getText().toString(), edtLanguage.getText().toString(),
                            edtAuthor.getText().toString(), Integer.parseInt(edtCapitulos.getText().toString()),Integer.parseInt(edtYear.getText().toString()));
                    operations.insertCartoon(cartoon);
                }
                getCartoons();
                clearData();
                adapter.notifyDataSetChanged();
            }
        });

    }
    private void getCartoons(){
        Cursor c =operations.getCartoons();
        cartoons.clear();
        if(c!=null){
            while (c.moveToNext()){
                cartoons.add(new Cartoon(c.getString(1),c.getString(2 ), c.getString(3),c.getString(4),c.getString(5),c.getInt(6),c.getInt(7)));}
        }

    }

    private void clearData(){
        edtName.setText("");
        edtType.setText("");
        edtLanguage.setText("");
        edtAuthor.setText("");
        edtCapitulos.setText("");
        edtYear.setText("");
        cartoon=null;
        cartoon= new Cartoon();
        cartoon.setIdCartoon("");
    }

}
