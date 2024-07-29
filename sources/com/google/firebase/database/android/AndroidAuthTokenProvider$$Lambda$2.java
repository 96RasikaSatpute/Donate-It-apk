package com.google.firebase.database.android;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.database.core.AuthTokenProvider;

/* compiled from: AndroidAuthTokenProvider */
final /* synthetic */ class AndroidAuthTokenProvider$$Lambda$2 implements OnSuccessListener {
    private final AuthTokenProvider.GetTokenCompletionListener arg$1;

    private AndroidAuthTokenProvider$$Lambda$2(AuthTokenProvider.GetTokenCompletionListener getTokenCompletionListener) {
        this.arg$1 = getTokenCompletionListener;
    }

    public static OnSuccessListener lambdaFactory$(AuthTokenProvider.GetTokenCompletionListener getTokenCompletionListener) {
        return new AndroidAuthTokenProvider$$Lambda$2(getTokenCompletionListener);
    }

    public void onSuccess(Object obj) {
        this.arg$1.onSuccess(((GetTokenResult) obj).getToken());
    }
}