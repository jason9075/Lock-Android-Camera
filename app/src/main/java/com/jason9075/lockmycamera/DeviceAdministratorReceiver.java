package com.jason9075.lockmycamera;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by jason9075 on 2016/4/1.
 */
public class DeviceAdministratorReceiver  extends DeviceAdminReceiver {
    public DeviceAdministratorReceiver() {
    }

    public void onEnabled(Context context, Intent intent) {
        super.onEnabled(context, intent);
    }

    public void onDisabled(Context context, Intent intent) {
        super.onDisabled(context, intent);
    }

    public void onPasswordChanged(Context context, Intent intent) {
        super.onPasswordChanged(context, intent);
    }

    public void onPasswordFailed(Context context, Intent intent) {
        super.onPasswordFailed(context, intent);
    }

    public void onPasswordSucceeded(Context context, Intent intent) {
        super.onPasswordSucceeded(context, intent);
    }
}
