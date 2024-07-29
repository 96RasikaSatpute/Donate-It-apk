package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zar;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
final class zabg extends zar {
    private final /* synthetic */ zabe zahz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zabg(zabe zabe, Looper looper) {
        super(looper);
        this.zahz = zabe;
    }

    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            ((zabd) message.obj).zaa(this.zahz);
        } else if (i != 2) {
            Log.w("GACStateManager", new StringBuilder(31).append("Unknown message id: ").append(message.what).toString());
        } else {
            throw ((RuntimeException) message.obj);
        }
    }
}
