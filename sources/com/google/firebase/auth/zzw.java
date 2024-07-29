package com.google.firebase.auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzw implements Continuation<GetTokenResult, Task<Void>> {
    final /* synthetic */ FirebaseUser zza;

    zzw(FirebaseUser firebaseUser) {
        this.zza = firebaseUser;
    }

    public final /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
        return FirebaseAuth.getInstance(this.zza.zzd()).zzt((ActionCodeSettings) null, (String) Preconditions.checkNotNull(((GetTokenResult) task.getResult()).getToken()));
    }
}
