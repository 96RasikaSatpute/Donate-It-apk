package com.google.firebase.auth.internal;

import com.google.firebase.internal.InternalTokenResult;

/* compiled from: com.google.firebase:firebase-auth-interop@@19.0.2 */
public interface IdTokenListener {
    void onIdTokenChanged(InternalTokenResult internalTokenResult);
}
