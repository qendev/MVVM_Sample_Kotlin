package data.db.entities

import androidx.room.Entity


@Entity
data class User(
    var id :Int? = null,
    var email:String? = null,
    var password :String? = null,
    var email_verified_at :String? = null,
    var created_at :String? = null,
    var updated_at :String? = null
)
