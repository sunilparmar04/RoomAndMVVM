package dev.sunil.roomandmvvm.db;

import android.content.Context;

import java.util.List;

/**
 * Created by sunilkumar_cont2 on 06/02/18.
 */

public class DBHelper {
    Context context;
    AppDatabase db;

    public DBHelper(Context context) {
        this.context = context;
        db = AppDatabase.getInMemoryDatabase(this.context);
    }

    public User addUser(final String id, final String name,
                        final String lastName, final int age) {
        //to delete all users data
        db.userModel().deleteAll();
        User user = new User();
        user.id = id;
        user.age = age;
        user.name = name;
        user.lastName = lastName;
        db.userModel().insertUser(user);
        return user;
    }


    public User getUserInfo(int id) {

        User user = db.userModel().getUserById(id);
        return user;
    }

    public List<User> getUser(int id) {

        List<User> user = db.userModel().findUserById(id);

        return user;
    }


}
