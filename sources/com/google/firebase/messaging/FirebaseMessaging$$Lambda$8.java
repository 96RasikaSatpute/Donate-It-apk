package com.google.firebase.messaging;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
final /* synthetic */ class FirebaseMessaging$$Lambda$8 implements Continuation {
    private final FirebaseMessaging arg$1;
    private final String arg$2;

    FirebaseMessaging$$Lambda$8(FirebaseMessaging firebaseMessaging, String str) {
        this.arg$1 = firebaseMessaging;
        this.arg$2 = str;
    }

    public Object then(Task task) {
        return this.arg$1.lambda$blockingGetToken$9$FirebaseMessaging(this.arg$2, task);
    }
}
