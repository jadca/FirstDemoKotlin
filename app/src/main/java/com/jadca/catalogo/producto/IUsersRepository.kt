package com.jadca.catalogo.producto
interface IUsersRepository {
    fun getById(userId : Int) : User
    fun save(user: User)
}
