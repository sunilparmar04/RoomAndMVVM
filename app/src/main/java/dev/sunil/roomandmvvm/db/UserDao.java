package dev.sunil.roomandmvvm.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;
/**
 * Created by sunilkumar_cont2 on 06/02/18.
 */
@Dao
public interface UserDao {

    @Insert(onConflict = IGNORE)
    void insertUser(User user);

    @Delete
    void deleteUser(User user);

    @Query("SELECT * FROM User WHERE :id == :id")
    List<User> findUserById(int id);

    @Query("SELECT * FROM User WHERE :id == :id")
    User getUserById(int id);

    @Query("DELETE FROM User")
    void deleteAll();
}