#-optimizations !code/simplification/arithmetic,!code/simplification/cast,!field/*,!class/merging/*,!class/unboxing/enum
#-optimizationpasses 1
-allowaccessmodification

-dontwarn com.google.android.gms.**

#Twilio
#-keep class com.twilio.** { *; }
#-keep class org.webrtc.** { *; }
#-keep class com.twilio.video.** { *; }
#-keepattributes InnerClasses

# DB Snappy and Kyro
-dontshrink
    -verbose
    -dontwarn sun.reflect.**
    -dontwarn java.beans.**
    -keep,allowshrinking class com.esotericsoftware.** {
       <fields>;
       <methods>;
    }
    -keep,allowshrinking class java.beans.** { *; }
    -keep,allowshrinking class sun.reflect.** { *; }
    -keep,allowshrinking class com.esotericsoftware.kryo.** { *; }
    -keep,allowshrinking class com.esotericsoftware.kryo.io.** { *; }
    -keep,allowshrinking class sun.nio.ch.** { *; }
    -dontwarn sun.nio.ch.**
    -dontwarn sun.misc.**
    -keep,allowshrinking class com.snappydb.** { *; }
    -dontwarn com.snappydb.**

# OkHTTP and Apache
-dontnote okhttp3.**
-dontwarn rx.internal.util.unsafe.**
-dontwarn javax.annotation.GuardedBy
-dontwarn javax.annotation.**
-dontwarn org.apache.**
-dontwarn org.apache.commons.collections.BeanMap

# For using GSON @Expose annotation
-keepattributes *Annotation*

# Gson specific classes
-keep class sun.* { *; }
-keep class com.google.gson.stream.** { *; }

# Remove Logs
#-assumenosideeffects class android.util.Log {
#    public static *** d(...);
#    public static *** v(...);
#    public static *** e(...);
#}
# Keep retrofit
-dontwarn okio.**
-dontwarn javax.annotation.**
-dontwarn retrofit2.Platform$Java8

