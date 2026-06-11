package com.noor.alhidayah.di

import android.content.Context
import androidx.room.Room
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.noor.alhidayah.data.local.NoorDatabase
import com.noor.alhidayah.data.local.TasbihDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides @Singleton
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()
    @Provides @Singleton
    fun provideFirebaseFirestore(): FirebaseFirestore = FirebaseFirestore.getInstance()
    @Provides @Singleton
    fun provideNoorDatabase(@ApplicationContext context: Context): NoorDatabase = Room.databaseBuilder(context, NoorDatabase::class.java, NoorDatabase.DATABASE_NAME).fallbackToDestructiveMigration().build()
    @Provides @Singleton
    fun provideTasbihDao(database: NoorDatabase): TasbihDao = database.tasbihDao()
}
