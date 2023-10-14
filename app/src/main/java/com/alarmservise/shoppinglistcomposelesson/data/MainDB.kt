package com.alarmservise.shoppinglistcomposelesson.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ShoppingListItem::class, AddItem::class, NoteItem::class],
    version = 1
)
abstract class MainDB: RoomDatabase() {
    abstract val shoppingListDao: ShoppingListDao

}