package com.jadca.catalogo.producto
import android.util.Log
import java.text.SimpleDateFormat

class FakeInMemoryUsersRepository : IUsersRepository {

    override fun getById(userId: Int): User {
        return User(
            "fbonizzi",
            "Francesco",
            "Bonizzi",
            SimpleDateFormat("dd/MM/yyyy").parse("05/08/1990")!!)
    }

    override fun save(user: User) {
        // Since it's a fake repository, I don't really save the user
        Log.i("FakeInMemoryUsersRepository", "Saved: $user")
    }

}
