
package dev.sunil.roomandmvvm.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by sunilkumar_cont2 on 06/02/18.
 */

@Entity
public class User {
    @PrimaryKey
    @NonNull
    public String id;

    public String name;

    public String lastName;

    public int age;
}
