# Keep ViewBinding methods that are accessed via reflection
-keepclassmembers class * implements androidx.viewbinding.ViewBinding {
   public static *** inflate(...);
   public static *** bind(android.view.View);
}
