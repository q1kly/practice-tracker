package com.example.practice;

import android.app.Activity;
import android.content.Intent;

public class RoleUtils {

    public static String getRole(Activity activity) {
        return activity.getSharedPreferences("app", Activity.MODE_PRIVATE)
                .getString("role", "INTERN");
    }

    public static void setRole(Activity activity, String role) {
        activity.getSharedPreferences("app", Activity.MODE_PRIVATE)
                .edit()
                .putString("role", role)
                .apply();
    }

    public static void requireRole(Activity activity, String neededRole) {
        String role = getRole(activity);
        if (!neededRole.equals(role)) {
            activity.startActivity(new Intent(activity, MainActivity.class));
            activity.finish();
        }
    }
}
