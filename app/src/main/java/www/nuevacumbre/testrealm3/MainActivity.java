package www.nuevacumbre.testrealm3;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    EditText idlibrofield, ISBNfield, nombrefield, paginasfield, editorialfield;
    Button save,read;
    private Realm myRealm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myRealm = Realm.getDefaultInstance();

        idlibrofield = (EditText)findViewById(R.id.idLibro);
        ISBNfield = (EditText)findViewById(R.id.ISBN);
        nombrefield = (EditText)findViewById(R.id.nombre);
        paginasfield = (EditText)findViewById(R.id.paginas);
        editorialfield = (EditText)findViewById(R.id.editorial);
        save = (Button) findViewById(R.id.save);
        read = (Button) findViewById(R.id.read);
        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                myRealm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        User myUser = myRealm.createObject(User.class);
                        myUser.setIdLibro(Integer.valueOf(idlibrofield.getText().toString()));
                        myUser.setISBN(Integer.valueOf(ISBNfield.getText().toString()));
                        myUser.setNombre(nombrefield.getText().toString());
                        myUser.setPaginas(Integer.valueOf(paginasfield.getText().toString()));
                        myUser.setEditorial(editorialfield.getText().toString());
                    }
                });

            }
        });

        read.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                RealmResults<User> users = myRealm.where(User.class).findAll();            //cespinoza, ejemplo de select en realm
                StringBuilder builder = new StringBuilder();
                for(User user: users) {
                    builder.append(" \n idLibro " + user.getIdLibro());
                    builder.append(" \n ISBN " + user.getISBN());
                    builder.append(" \n Nombre " + user.getNombre());
                    builder.append(" \n Páginas " + user.getPaginas());
                    builder.append(" \n Editorial " + user.getEditorial());
                }

                Log.e("TAG",builder.toString());
            }
        });

    }
}