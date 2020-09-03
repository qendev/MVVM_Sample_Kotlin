package data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import data.db.entities.User

//will create the database here
@Database(
    entities = [User::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    //create all the abstract funs for all the Dao
    abstract fun getUserDao() : UserDao

    //to create the App's Database
    companion object{
        @Volatile //to make the variable available to all other threads annotate it with Volatile
        private var instance : AppDatabase? = null

        //to prevent us from making two instances of the database
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance?: synchronized(LOCK){
            instance?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context)=
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "MyDatabase.db"
            ).build()
    }
}