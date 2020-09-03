package data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import data.db.entities.CURRENT_USER_ID
import data.db.entities.User


@Dao
interface UserDao {

    //to insert or update the user
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(user: User) : Long

    //to give back the stored user
    @Query("SELECT * FROM user WHERE uid = $CURRENT_USER_ID")
    fun getuser() : LiveData<User>
}