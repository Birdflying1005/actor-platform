package im.actor.push;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.gcm.GcmReceiver;
import com.google.android.gms.gcm.GoogleCloudMessaging;

import im.actor.runtime.Log;
import im.actor.sdk.ActorSDK;

public class PushReceiver extends GcmReceiver {

    private static final String TAG = "ActorPushReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {

        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(context);
        Bundle extras = intent.getExtras();

        if (!extras.isEmpty()) {
                ActorSDK.sharedActor().waitForReady();
                if (extras.containsKey("seq")) {
                    int seq = Integer.parseInt(extras.getString("seq"));

                    int authId = Integer.parseInt(extras.getString("authId", "0"));
                    Log.d(TAG, "Push received #" + seq);
                    ActorSDK.sharedActor().getMessenger().onPushReceived(seq, authId);
                    setResultCode(Activity.RESULT_OK);
                } else if (extras.containsKey("callId")) {
                    long callId = Long.parseLong(extras.getString("callId"));
                    int attempt = 0;
                    if (extras.containsKey("attemptIndex")) {
                        attempt = Integer.parseInt(extras.getString("attemptIndex"));
                    }
                    Log.d(TAG, "Received Call #" + callId + " (" + attempt + ")");
                    ActorSDK.sharedActor().getMessenger().checkCall(callId, attempt);
                    setResultCode(Activity.RESULT_OK);
                }
        }
        super.onReceive(context, intent);
    }
}
