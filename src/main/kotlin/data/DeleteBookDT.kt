package com.example.data

import com.example.databases.BookTable
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.transactions.transaction

class DeleteBookDT {
    suspend fun invokeDT(iD : Int){
        transaction {
            BookTable.deleteWhere { BookTable.id.eq(iD) }
        }
    }
}