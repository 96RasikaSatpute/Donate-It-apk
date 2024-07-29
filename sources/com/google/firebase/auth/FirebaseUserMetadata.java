package com.google.firebase.auth;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public interface FirebaseUserMetadata extends SafeParcelable {
    long getCreationTimestamp();

    long getLastSignInTimestamp();
}