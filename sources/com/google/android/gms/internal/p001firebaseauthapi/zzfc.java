package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfc  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzfc extends zzzw<zzfd, zzfc> implements zzabe {
    private zzfc() {
        super(zzfd.zzf);
    }

    public final zzfc zza(zzfg zzfg) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        zzfd.zzg((zzfd) this.zza, zzfg);
        return this;
    }

    public final zzfc zzb(int i) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        ((zzfd) this.zza).zze = i;
        return this;
    }

    /* synthetic */ zzfc(zzfb zzfb) {
        super(zzfd.zzf);
    }
}
