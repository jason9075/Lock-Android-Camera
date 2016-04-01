package com.jason9075.lockmycamera;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private DevicePolicyManager devicePolicyManager;
    private ComponentName cameraAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton activeButton = (ImageButton) findViewById(R.id.active_button);

        devicePolicyManager = (DevicePolicyManager) getApplicationContext().getSystemService(Context.DEVICE_POLICY_SERVICE);
        cameraAdmin = new ComponentName(this, DeviceAdministratorReceiver.class);

        if (devicePolicyManager != null) {
            Intent intent = new Intent("android.app.action.ADD_DEVICE_ADMIN");
            intent.putExtra("android.app.extra.DEVICE_ADMIN", cameraAdmin);
            intent.putExtra("android.app.extra.ADD_EXPLANATION", "我要鎖死相機的權限");

            startActivityForResult(intent, 3333);
        }

        activeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                devicePolicyManager.setCameraDisabled(cameraAdmin, !devicePolicyManager.getCameraDisabled(cameraAdmin));
                Toast.makeText(getApplicationContext(), "setCameraDisable = " + devicePolicyManager.getCameraDisabled(cameraAdmin), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 3333:
                devicePolicyManager = (DevicePolicyManager) getApplicationContext().getSystemService(Context.DEVICE_POLICY_SERVICE);
                break;
        }
    }


}
