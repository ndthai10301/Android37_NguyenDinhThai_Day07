package com.example.btvnday07;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    List<User> userList;
    ImageView imgAdd;
    int mPosition = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Messenger");
        List<User> lst = getListData();
        final ListView listView = (ListView) findViewById(R.id.lvuser_list);
        imgAdd=(ImageView)findViewById(R.id.imgAdd);
        listView.setAdapter(new CustomListAdapter(this, lst));
        // Khi người dùng click vào các ListItem
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Object ob = listView.getItemAtPosition(position);
                User user = (User) ob;
                Toast.makeText(MainActivity.this, "Họ và tên :" + " " + user.getName(), Toast.LENGTH_LONG).show();
            }
        });
        //click add
        imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), AddInformation.class);
                intent.putExtra("name", "");
                // bắt sự kiện khi startActivityForResult
                // để hứng giá trị result trả về là 115 ở hàm onActivityResult
                startActivityForResult(intent, 2907);
            }
        });
    }
    private  List<User> getListData() {
        List<User> list = new ArrayList<User>();
        User user1 = new User("Nguyễn Văn Kiên", "Chưa xác định");
        User user2 = new User("Trần Văn Nam", "Độc thân");
        User user3 = new User("Hồ Ngọc Hà", "Ly hôn");
        list.add(user1);
        list.add(user2);
        list.add(user3);

        return list;
    }
    //create menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        //respond to menu item selection
        switch (item.getItemId()) {
            case R.id.mnFriends:
                Toast.makeText(getBaseContext(),"Friends",Toast.LENGTH_LONG).show();
                //startActivity(new Intent(this, About.class));
                //Toast.makeText(getBaseContext(),"Save",Toast.LENGTH_LONG).show();
                //Put preference
                //editor.putBoolean("full_mode",true);
               // editor.commit();
                //

               // Toast.makeText(getBaseContext(), "Menu Full", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mnMessenger:
                //startActivity(new Intent(this, MainActivity.class));
                Toast.makeText(getBaseContext(),"Messenger",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case RESULT_OK:
                String name = data.getStringExtra("nameAdd");

                if (requestCode == 113) {
                    userList.set(mPosition, new User(name, "Non"));
                    CustomListAdapter.notifyDataSetChanged();

                } else if (requestCode == 2907) {
                    userList.add(new User(name, "Non"));
                    CustomListAdapter.notifyDataSetChanged();
                }

        }
    }
}
