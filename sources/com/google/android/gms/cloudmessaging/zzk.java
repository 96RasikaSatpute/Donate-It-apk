package com.google.android.gms.cloudmessaging;

import android.os.IBinder;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
final /* synthetic */ class zzk implements Runnable {
    private final zzf zza;
    private final IBinder zzb;

    zzk(zzf zzf, IBinder iBinder) {
        this.zza = zzf;
        this.zzb = iBinder;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0021, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0022, code lost:
        r0.zza(0, r1.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002c, code lost:
        throw r1;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:5:0x000a, B:9:0x000f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r4 = this;
            com.google.android.gms.cloudmessaging.zzf r0 = r4.zza
            android.os.IBinder r1 = r4.zzb
            monitor-enter(r0)
            r2 = 0
            if (r1 != 0) goto L_0x000f
            java.lang.String r1 = "Null service connection"
            r0.zza(r2, r1)     // Catch:{ all -> 0x001f }
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x000f:
            com.google.android.gms.cloudmessaging.zzo r3 = new com.google.android.gms.cloudmessaging.zzo     // Catch:{ RemoteException -> 0x0021 }
            r3.<init>(r1)     // Catch:{ RemoteException -> 0x0021 }
            r0.zzc = r3     // Catch:{ RemoteException -> 0x0021 }
            r1 = 2
            r0.zza = r1     // Catch:{ all -> 0x001f }
            r0.zza()     // Catch:{ all -> 0x001f }
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x001f:
            r1 = move-exception
            goto L_0x002b
        L_0x0021:
            r1 = move-exception
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x001f }
            r0.zza(r2, r1)     // Catch:{ all -> 0x001f }
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x002b:
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cloudmessaging.zzk.run():void");
    }
}
