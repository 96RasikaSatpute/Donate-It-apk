package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbu  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
public final class zzbu extends zzat<zzeu> {
    zzbu() {
        super(zzeu.class, new zzbs(zzag.class));
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    public final zzib zzc() {
        return zzib.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ zzabd zzd(zzyy zzyy) throws zzaai {
        return zzeu.zzd(zzyy, zzzn.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzabd zzabd) throws GeneralSecurityException {
        zzeu zzeu = (zzeu) zzabd;
        zzlg.zzb(zzeu.zza(), 0);
        new zzbx();
        zzbx.zzk(zzeu.zzb());
        new zzed();
        zzed.zzk(zzeu.zzc());
    }

    public final zzar<zzex, zzeu> zzi() {
        return new zzbt(this, zzex.class);
    }
}