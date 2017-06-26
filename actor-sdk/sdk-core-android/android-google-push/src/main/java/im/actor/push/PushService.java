package im.actor.push;

import android.os.Bundle;

import com.google.android.gms.gcm.GcmListenerService;

import im.actor.runtime.Log;
import im.actor.sdk.ActorSDK;

/**
 * Created by diego on 25/06/17.
 */

public class PushService extends GcmListenerService{

    private static final String TAG = "ActorPushReceiver";

    @Override
    public void onMessageReceived(String s, Bundle extras) {
        Log.d(TAG, "onMessageReceived");

        if (!extras.isEmpty()) {
                ActorSDK.sharedActor().waitForReady();
                if (extras.containsKey("seq")) {
                    int seq = Integer.parseInt(extras.getString("seq"));
                    int authId = Integer.parseInt(extras.getString("authId", "0"));
                    Log.d(TAG, "Push received #" + seq);
                    ActorSDK.sharedActor().getMessenger().onPushReceived(seq, authId);
                } else if (extras.containsKey("callId")) {
                    long callId = Long.parseLong(extras.getString("callId"));
                    int attempt = 0;
                    if (extras.containsKey("attemptIndex")) {
                        attempt = Integer.parseInt(extras.getString("attemptIndex"));
                    }
                    Log.d(TAG, "Received Call #" + callId + " (" + attempt + ")");
                    ActorSDK.sharedActor().getMessenger().checkCall(callId, attempt);
                }
        }
    }
}
