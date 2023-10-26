package com.alarmservise.shoppinglistcomposelesson.di

import android.app.Application
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.room.Room
import com.alarmservise.shoppinglistcomposelesson.data.AddItemRepoImpl
import com.alarmservise.shoppinglistcomposelesson.data.AddItemRepository
import com.alarmservise.shoppinglistcomposelesson.data.MainDB
import com.alarmservise.shoppinglistcomposelesson.data.NoteRepoImpl
import com.alarmservise.shoppinglistcomposelesson.data.NoteRepository
import com.alarmservise.shoppinglistcomposelesson.data.ShoppingListRepoImpl
import com.alarmservise.shoppinglistcomposelesson.data.ShoppingListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMainDb(app: Application): MainDB {
        return Room.databaseBuilder(
            app,
            MainDB::class.java,
            "shop_list_db"
        ).build()
    }
    @Provides
    @Singleton
    fun provideShopRepo(db: MainDB): ShoppingListRepository{
        return ShoppingListRepoImpl(db.shoppingListDao)
    }

    @Provides
    @Singleton
    fun provideAddItemRepo(db: MainDB): AddItemRepository{
        return AddItemRepoImpl(db.addItemDao)
    }

    @Provides
    @Singleton
    fun provideNoteRepo(db: MainDB): NoteRepository{
        return NoteRepoImpl(db.noteItemDao)
    }
}