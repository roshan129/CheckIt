package com.roshanadke.checkit.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.roshanadke.checkit.common.Constants.TODO_DATABASE_NAME
import com.roshanadke.checkit.data.local.ToDoDatabase
import com.roshanadke.checkit.data.local.TodoListDao
import com.roshanadke.checkit.data.repository.ToDoItemsRepositoryImpl
import com.roshanadke.checkit.domain.repository.ToDoItemsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ToDoAppModule {

    @Provides
    @Singleton
    fun getDatabase(
        @ApplicationContext context: Context
    ): ToDoDatabase {
        return Room.databaseBuilder(
            context,
            ToDoDatabase::class.java,
            TODO_DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun getToDoListDao(
        db: ToDoDatabase
    ): TodoListDao {
        return db.getToDoListDao()
    }

    @Provides
    @Singleton
    fun provideToDoRepository(
        dao: TodoListDao
    ): ToDoItemsRepository {
        return ToDoItemsRepositoryImpl(dao)
    }


}