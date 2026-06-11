# ProGuard Rules for Noor Al-Hidayah

# Keep Firebase
-keep class com.google.firebase.** { *; }
-dontwarn com.google.firebase.**

# Keep Room
-keep class androidx.room.** { *; }
-keep class * extends androidx.room.RoomDatabase
-dontwarn androidx.room.paging.**

# Keep Hilt
-keep class dagger.hilt.** { *; }
-keep class javax.inject.** { *; }

# Keep data models for Firebase serialization
-keep class com.noor.alhidayah.data.model.** { *; }

# Keep Coil
-keep class coil.** { *; }

# Remove logging in release
-assumenosideeffects class android.util.Log {
    public static *** d(...);
    public static *** v(...);
    public static *** i(...);
}
