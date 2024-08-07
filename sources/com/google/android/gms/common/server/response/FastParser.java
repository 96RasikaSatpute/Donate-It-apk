package com.google.android.gms.common.server.response;

import android.util.Log;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.Base64Utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import kotlin.text.Typography;
import okio.internal.BufferKt;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public class FastParser<T extends FastJsonResponse> {
    private static final char[] zaqu = {'u', 'l', 'l'};
    private static final char[] zaqv = {'r', 'u', 'e'};
    private static final char[] zaqw = {'r', 'u', 'e', Typography.quote};
    private static final char[] zaqx = {'a', 'l', 's', 'e'};
    private static final char[] zaqy = {'a', 'l', 's', 'e', Typography.quote};
    private static final char[] zaqz = {10};
    private static final zaa<Integer> zarb = new zab();
    private static final zaa<Long> zarc = new zaa();
    private static final zaa<Float> zard = new zad();
    private static final zaa<Double> zare = new zac();
    private static final zaa<Boolean> zarf = new zaf();
    private static final zaa<String> zarg = new zae();
    private static final zaa<BigInteger> zarh = new zah();
    private static final zaa<BigDecimal> zari = new zag();
    private final char[] zaqp = new char[1];
    private final char[] zaqq = new char[32];
    private final char[] zaqr = new char[1024];
    private final StringBuilder zaqs = new StringBuilder(32);
    private final StringBuilder zaqt = new StringBuilder(1024);
    private final Stack<Integer> zara = new Stack<>();

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    private interface zaa<O> {
        O zah(FastParser fastParser, BufferedReader bufferedReader) throws ParseException, IOException;
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    public static class ParseException extends Exception {
        public ParseException(String str) {
            super(str);
        }

        public ParseException(String str, Throwable th) {
            super(str, th);
        }

        public ParseException(Throwable th) {
            super(th);
        }
    }

    public void parse(InputStream inputStream, T t) throws ParseException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1024);
        try {
            this.zara.push(0);
            char zaj = zaj(bufferedReader);
            if (zaj != 0) {
                if (zaj == '[') {
                    this.zara.push(5);
                    Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = t.getFieldMappings();
                    if (fieldMappings.size() == 1) {
                        FastJsonResponse.Field field = (FastJsonResponse.Field) fieldMappings.entrySet().iterator().next().getValue();
                        t.addConcreteTypeArrayInternal(field, field.zaqj, zaa(bufferedReader, (FastJsonResponse.Field<?, ?>) field));
                    } else {
                        throw new ParseException("Object array response class must have a single Field");
                    }
                } else if (zaj == '{') {
                    this.zara.push(1);
                    zaa(bufferedReader, (FastJsonResponse) t);
                } else {
                    throw new ParseException(new StringBuilder(19).append("Unexpected token: ").append(zaj).toString());
                }
                zak(0);
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    Log.w("FastParser", "Failed to close reader while parsing.");
                }
            } else {
                throw new ParseException("No data to parse");
            }
        } catch (IOException e2) {
            throw new ParseException((Throwable) e2);
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (IOException e3) {
                Log.w("FastParser", "Failed to close reader while parsing.");
            }
            throw th;
        }
    }

    private final boolean zaa(BufferedReader bufferedReader, FastJsonResponse fastJsonResponse) throws ParseException, IOException {
        HashMap hashMap;
        BufferedReader bufferedReader2 = bufferedReader;
        FastJsonResponse fastJsonResponse2 = fastJsonResponse;
        Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = fastJsonResponse.getFieldMappings();
        String zaa2 = zaa(bufferedReader);
        if (zaa2 == null) {
            zak(1);
            return false;
        }
        while (zaa2 != null) {
            FastJsonResponse.Field field = fieldMappings.get(zaa2);
            if (field == null) {
                zaa2 = zab(bufferedReader);
            } else {
                this.zara.push(4);
                switch (field.zaqf) {
                    case 0:
                        if (!field.zaqg) {
                            fastJsonResponse2.zaa(field, zad(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse2.zaa(field, zaa(bufferedReader2, zarb));
                            break;
                        }
                    case 1:
                        if (!field.zaqg) {
                            fastJsonResponse2.zaa(field, zaf(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse2.zab(field, zaa(bufferedReader2, zarh));
                            break;
                        }
                    case 2:
                        if (!field.zaqg) {
                            fastJsonResponse2.zaa(field, zae(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse2.zac(field, zaa(bufferedReader2, zarc));
                            break;
                        }
                    case 3:
                        if (!field.zaqg) {
                            fastJsonResponse2.zaa(field, zag(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse2.zad(field, zaa(bufferedReader2, zard));
                            break;
                        }
                    case 4:
                        if (!field.zaqg) {
                            fastJsonResponse2.zaa(field, zah(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse2.zae(field, zaa(bufferedReader2, zare));
                            break;
                        }
                    case 5:
                        if (!field.zaqg) {
                            fastJsonResponse2.zaa(field, zai(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse2.zaf(field, zaa(bufferedReader2, zari));
                            break;
                        }
                    case 6:
                        if (!field.zaqg) {
                            fastJsonResponse2.zaa(field, zaa(bufferedReader2, false));
                            break;
                        } else {
                            fastJsonResponse2.zag(field, zaa(bufferedReader2, zarf));
                            break;
                        }
                    case 7:
                        if (!field.zaqg) {
                            fastJsonResponse2.zaa(field, zac(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse2.zah(field, zaa(bufferedReader2, zarg));
                            break;
                        }
                    case 8:
                        fastJsonResponse2.zaa(field, Base64Utils.decode(zaa(bufferedReader2, this.zaqr, this.zaqt, zaqz)));
                        break;
                    case 9:
                        fastJsonResponse2.zaa(field, Base64Utils.decodeUrlSafe(zaa(bufferedReader2, this.zaqr, this.zaqt, zaqz)));
                        break;
                    case 10:
                        char zaj = zaj(bufferedReader);
                        if (zaj == 'n') {
                            zab(bufferedReader2, zaqu);
                            hashMap = null;
                        } else if (zaj == '{') {
                            this.zara.push(1);
                            hashMap = new HashMap();
                            while (true) {
                                char zaj2 = zaj(bufferedReader);
                                if (zaj2 == 0) {
                                    throw new ParseException("Unexpected EOF");
                                } else if (zaj2 == '\"') {
                                    String zab = zab(bufferedReader2, this.zaqq, this.zaqs, (char[]) null);
                                    if (zaj(bufferedReader) != ':') {
                                        String valueOf = String.valueOf(zab);
                                        throw new ParseException(valueOf.length() != 0 ? "No map value found for key ".concat(valueOf) : new String("No map value found for key "));
                                    } else if (zaj(bufferedReader) != '\"') {
                                        String valueOf2 = String.valueOf(zab);
                                        throw new ParseException(valueOf2.length() != 0 ? "Expected String value for key ".concat(valueOf2) : new String("Expected String value for key "));
                                    } else {
                                        hashMap.put(zab, zab(bufferedReader2, this.zaqq, this.zaqs, (char[]) null));
                                        char zaj3 = zaj(bufferedReader);
                                        if (zaj3 != ',') {
                                            if (zaj3 == '}') {
                                                zak(1);
                                            } else {
                                                throw new ParseException(new StringBuilder(48).append("Unexpected character while parsing string map: ").append(zaj3).toString());
                                            }
                                        }
                                    }
                                } else if (zaj2 == '}') {
                                    zak(1);
                                }
                            }
                        } else {
                            throw new ParseException("Expected start of a map object");
                        }
                        fastJsonResponse2.zaa(field, (Map<String, String>) hashMap);
                        break;
                    case 11:
                        if (field.zaqg) {
                            char zaj4 = zaj(bufferedReader);
                            if (zaj4 == 'n') {
                                zab(bufferedReader2, zaqu);
                                fastJsonResponse2.addConcreteTypeArrayInternal(field, field.zaqj, (ArrayList) null);
                                break;
                            } else {
                                this.zara.push(5);
                                if (zaj4 == '[') {
                                    fastJsonResponse2.addConcreteTypeArrayInternal(field, field.zaqj, zaa(bufferedReader2, (FastJsonResponse.Field<?, ?>) field));
                                    break;
                                } else {
                                    throw new ParseException("Expected array start");
                                }
                            }
                        } else {
                            char zaj5 = zaj(bufferedReader);
                            if (zaj5 == 'n') {
                                zab(bufferedReader2, zaqu);
                                fastJsonResponse2.addConcreteTypeInternal(field, field.zaqj, null);
                                break;
                            } else {
                                this.zara.push(1);
                                if (zaj5 == '{') {
                                    try {
                                        FastJsonResponse zacn = field.zacn();
                                        zaa(bufferedReader2, zacn);
                                        fastJsonResponse2.addConcreteTypeInternal(field, field.zaqj, zacn);
                                        break;
                                    } catch (InstantiationException e) {
                                        throw new ParseException("Error instantiating inner object", e);
                                    } catch (IllegalAccessException e2) {
                                        throw new ParseException("Error instantiating inner object", e2);
                                    }
                                } else {
                                    throw new ParseException("Expected start of object");
                                }
                            }
                        }
                    default:
                        throw new ParseException(new StringBuilder(30).append("Invalid field type ").append(field.zaqf).toString());
                }
                zak(4);
                zak(2);
                char zaj6 = zaj(bufferedReader);
                if (zaj6 == ',') {
                    zaa2 = zaa(bufferedReader);
                } else if (zaj6 == '}') {
                    zaa2 = null;
                } else {
                    throw new ParseException(new StringBuilder(55).append("Expected end of object or field separator, but found: ").append(zaj6).toString());
                }
            }
        }
        zak(1);
        return true;
    }

    private final String zaa(BufferedReader bufferedReader) throws ParseException, IOException {
        this.zara.push(2);
        char zaj = zaj(bufferedReader);
        if (zaj == '\"') {
            this.zara.push(3);
            String zab = zab(bufferedReader, this.zaqq, this.zaqs, (char[]) null);
            zak(3);
            if (zaj(bufferedReader) == ':') {
                return zab;
            }
            throw new ParseException("Expected key/value separator");
        } else if (zaj == ']') {
            zak(2);
            zak(1);
            zak(5);
            return null;
        } else if (zaj == '}') {
            zak(2);
            return null;
        } else {
            throw new ParseException(new StringBuilder(19).append("Unexpected token: ").append(zaj).toString());
        }
    }

    private final String zab(BufferedReader bufferedReader) throws ParseException, IOException {
        BufferedReader bufferedReader2 = bufferedReader;
        bufferedReader2.mark(1024);
        char zaj = zaj(bufferedReader);
        if (zaj != '\"') {
            if (zaj != ',') {
                int i = 1;
                if (zaj == '[') {
                    this.zara.push(5);
                    bufferedReader2.mark(32);
                    if (zaj(bufferedReader) == ']') {
                        zak(5);
                    } else {
                        bufferedReader.reset();
                        boolean z = false;
                        boolean z2 = false;
                        while (i > 0) {
                            char zaj2 = zaj(bufferedReader);
                            if (zaj2 == 0) {
                                throw new ParseException("Unexpected EOF while parsing array");
                            } else if (!Character.isISOControl(zaj2)) {
                                if (zaj2 == '\"' && !z) {
                                    z2 = !z2;
                                }
                                if (zaj2 == '[' && !z2) {
                                    i++;
                                }
                                if (zaj2 == ']' && !z2) {
                                    i--;
                                }
                                if (zaj2 != '\\' || !z2) {
                                    z = false;
                                } else {
                                    z = !z;
                                }
                            } else {
                                throw new ParseException("Unexpected control character while reading array");
                            }
                        }
                        zak(5);
                    }
                } else if (zaj != '{') {
                    bufferedReader.reset();
                    zaa(bufferedReader2, this.zaqr);
                } else {
                    this.zara.push(1);
                    bufferedReader2.mark(32);
                    char zaj3 = zaj(bufferedReader);
                    if (zaj3 == '}') {
                        zak(1);
                    } else if (zaj3 == '\"') {
                        bufferedReader.reset();
                        zaa(bufferedReader);
                        do {
                        } while (zab(bufferedReader) != null);
                        zak(1);
                    } else {
                        throw new ParseException(new StringBuilder(18).append("Unexpected token ").append(zaj3).toString());
                    }
                }
            } else {
                throw new ParseException("Missing value");
            }
        } else if (bufferedReader2.read(this.zaqp) != -1) {
            char c = this.zaqp[0];
            boolean z3 = false;
            do {
                if (c != '\"' || z3) {
                    if (c == '\\') {
                        z3 = !z3;
                    } else {
                        z3 = false;
                    }
                    if (bufferedReader2.read(this.zaqp) != -1) {
                        c = this.zaqp[0];
                    } else {
                        throw new ParseException("Unexpected EOF while parsing string");
                    }
                }
            } while (!Character.isISOControl(c));
            throw new ParseException("Unexpected control character while reading string");
        } else {
            throw new ParseException("Unexpected EOF while parsing string");
        }
        char zaj4 = zaj(bufferedReader);
        if (zaj4 == ',') {
            zak(2);
            return zaa(bufferedReader);
        } else if (zaj4 == '}') {
            zak(2);
            return null;
        } else {
            throw new ParseException(new StringBuilder(18).append("Unexpected token ").append(zaj4).toString());
        }
    }

    /* access modifiers changed from: private */
    public final String zac(BufferedReader bufferedReader) throws ParseException, IOException {
        return zaa(bufferedReader, this.zaqq, this.zaqs, (char[]) null);
    }

    private final <O> ArrayList<O> zaa(BufferedReader bufferedReader, zaa<O> zaa2) throws ParseException, IOException {
        char zaj = zaj(bufferedReader);
        if (zaj == 'n') {
            zab(bufferedReader, zaqu);
            return null;
        } else if (zaj == '[') {
            this.zara.push(5);
            ArrayList<O> arrayList = new ArrayList<>();
            while (true) {
                bufferedReader.mark(1024);
                char zaj2 = zaj(bufferedReader);
                if (zaj2 == 0) {
                    throw new ParseException("Unexpected EOF");
                } else if (zaj2 != ',') {
                    if (zaj2 != ']') {
                        bufferedReader.reset();
                        arrayList.add(zaa2.zah(this, bufferedReader));
                    } else {
                        zak(5);
                        return arrayList;
                    }
                }
            }
        } else {
            throw new ParseException("Expected start of array");
        }
    }

    private final String zaa(BufferedReader bufferedReader, char[] cArr, StringBuilder sb, char[] cArr2) throws ParseException, IOException {
        char zaj = zaj(bufferedReader);
        if (zaj == '\"') {
            return zab(bufferedReader, cArr, sb, cArr2);
        }
        if (zaj == 'n') {
            zab(bufferedReader, zaqu);
            return null;
        }
        throw new ParseException("Expected string");
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0032 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String zab(java.io.BufferedReader r9, char[] r10, java.lang.StringBuilder r11, char[] r12) throws com.google.android.gms.common.server.response.FastParser.ParseException, java.io.IOException {
        /*
            r0 = 0
            r11.setLength(r0)
            int r1 = r10.length
            r9.mark(r1)
            r1 = r0
            r2 = r1
        L_0x000c:
            int r3 = r9.read(r10)
            r4 = -1
            if (r3 == r4) goto L_0x0070
            r4 = r0
        L_0x0014:
            if (r4 >= r3) goto L_0x0068
            char r5 = r10[r4]
            boolean r6 = java.lang.Character.isISOControl(r5)
            r7 = 1
            if (r6 == 0) goto L_0x003a
            if (r12 == 0) goto L_0x002e
            r6 = r0
        L_0x0022:
            int r8 = r12.length
            if (r6 >= r8) goto L_0x002e
            char r8 = r12[r6]
            if (r8 != r5) goto L_0x002b
            r6 = r7
            goto L_0x002f
        L_0x002b:
            int r6 = r6 + 1
            goto L_0x0022
        L_0x002e:
            r6 = r0
        L_0x002f:
            if (r6 == 0) goto L_0x0032
            goto L_0x003a
        L_0x0032:
            com.google.android.gms.common.server.response.FastParser$ParseException r9 = new com.google.android.gms.common.server.response.FastParser$ParseException
            java.lang.String r10 = "Unexpected control character while reading string"
            r9.<init>((java.lang.String) r10)
            throw r9
        L_0x003a:
            r6 = 34
            if (r5 != r6) goto L_0x005b
            if (r1 != 0) goto L_0x005b
            r11.append(r10, r0, r4)
            r9.reset()
            int r4 = r4 + r7
            long r0 = (long) r4
            r9.skip(r0)
            if (r2 == 0) goto L_0x0056
            java.lang.String r9 = r11.toString()
            java.lang.String r9 = com.google.android.gms.common.util.JsonUtils.unescapeString(r9)
            return r9
        L_0x0056:
            java.lang.String r9 = r11.toString()
            return r9
        L_0x005b:
            r6 = 92
            if (r5 != r6) goto L_0x0064
            r1 = r1 ^ 1
            r2 = r7
            goto L_0x0065
        L_0x0064:
            r1 = r0
        L_0x0065:
            int r4 = r4 + 1
            goto L_0x0014
        L_0x0068:
            r11.append(r10, r0, r3)
            int r3 = r10.length
            r9.mark(r3)
            goto L_0x000c
        L_0x0070:
            com.google.android.gms.common.server.response.FastParser$ParseException r9 = new com.google.android.gms.common.server.response.FastParser$ParseException
            java.lang.String r10 = "Unexpected EOF while parsing string"
            r9.<init>((java.lang.String) r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.FastParser.zab(java.io.BufferedReader, char[], java.lang.StringBuilder, char[]):java.lang.String");
    }

    /* access modifiers changed from: private */
    public final int zad(BufferedReader bufferedReader) throws ParseException, IOException {
        boolean z;
        int i;
        int i2;
        int zaa2 = zaa(bufferedReader, this.zaqr);
        int i3 = 0;
        if (zaa2 == 0) {
            return 0;
        }
        char[] cArr = this.zaqr;
        if (zaa2 > 0) {
            if (cArr[0] == '-') {
                i2 = Integer.MIN_VALUE;
                i = 1;
                z = true;
            } else {
                i2 = -2147483647;
                i = 0;
                z = false;
            }
            if (i < zaa2) {
                int i4 = i + 1;
                int digit = Character.digit(cArr[i], 10);
                if (digit >= 0) {
                    int i5 = -digit;
                    i = i4;
                    i3 = i5;
                } else {
                    throw new ParseException("Unexpected non-digit character");
                }
            }
            while (i < zaa2) {
                int i6 = i + 1;
                int digit2 = Character.digit(cArr[i], 10);
                if (digit2 < 0) {
                    throw new ParseException("Unexpected non-digit character");
                } else if (i3 >= -214748364) {
                    int i7 = i3 * 10;
                    if (i7 >= i2 + digit2) {
                        i3 = i7 - digit2;
                        i = i6;
                    } else {
                        throw new ParseException("Number too large");
                    }
                } else {
                    throw new ParseException("Number too large");
                }
            }
            if (!z) {
                return -i3;
            }
            if (i > 1) {
                return i3;
            }
            throw new ParseException("No digits to parse");
        }
        throw new ParseException("No number to parse");
    }

    /* access modifiers changed from: private */
    public final long zae(BufferedReader bufferedReader) throws ParseException, IOException {
        long j;
        boolean z;
        int zaa2 = zaa(bufferedReader, this.zaqr);
        long j2 = 0;
        if (zaa2 == 0) {
            return 0;
        }
        char[] cArr = this.zaqr;
        if (zaa2 > 0) {
            int i = 0;
            if (cArr[0] == '-') {
                j = Long.MIN_VALUE;
                i = 1;
                z = true;
            } else {
                j = -9223372036854775807L;
                z = false;
            }
            int i2 = 10;
            if (i < zaa2) {
                int i3 = i + 1;
                int digit = Character.digit(cArr[i], 10);
                if (digit >= 0) {
                    i = i3;
                    j2 = (long) (-digit);
                } else {
                    throw new ParseException("Unexpected non-digit character");
                }
            }
            while (i < zaa2) {
                int i4 = i + 1;
                int digit2 = Character.digit(cArr[i], i2);
                if (digit2 < 0) {
                    throw new ParseException("Unexpected non-digit character");
                } else if (j2 >= BufferKt.OVERFLOW_ZONE) {
                    long j3 = j2 * 10;
                    int i5 = i4;
                    long j4 = (long) digit2;
                    if (j3 >= j + j4) {
                        j2 = j3 - j4;
                        i = i5;
                        i2 = 10;
                    } else {
                        throw new ParseException("Number too large");
                    }
                } else {
                    throw new ParseException("Number too large");
                }
            }
            if (!z) {
                return -j2;
            }
            if (i > 1) {
                return j2;
            }
            throw new ParseException("No digits to parse");
        }
        throw new ParseException("No number to parse");
    }

    /* access modifiers changed from: private */
    public final BigInteger zaf(BufferedReader bufferedReader) throws ParseException, IOException {
        int zaa2 = zaa(bufferedReader, this.zaqr);
        if (zaa2 == 0) {
            return null;
        }
        return new BigInteger(new String(this.zaqr, 0, zaa2));
    }

    /* access modifiers changed from: private */
    public final boolean zaa(BufferedReader bufferedReader, boolean z) throws ParseException, IOException {
        while (true) {
            char zaj = zaj(bufferedReader);
            if (zaj != '\"') {
                if (zaj == 'f') {
                    zab(bufferedReader, z ? zaqy : zaqx);
                    return false;
                } else if (zaj == 'n') {
                    zab(bufferedReader, zaqu);
                    return false;
                } else if (zaj == 't') {
                    zab(bufferedReader, z ? zaqw : zaqv);
                    return true;
                } else {
                    throw new ParseException(new StringBuilder(19).append("Unexpected token: ").append(zaj).toString());
                }
            } else if (!z) {
                z = true;
            } else {
                throw new ParseException("No boolean value found in string");
            }
        }
    }

    /* access modifiers changed from: private */
    public final float zag(BufferedReader bufferedReader) throws ParseException, IOException {
        int zaa2 = zaa(bufferedReader, this.zaqr);
        if (zaa2 == 0) {
            return 0.0f;
        }
        return Float.parseFloat(new String(this.zaqr, 0, zaa2));
    }

    /* access modifiers changed from: private */
    public final double zah(BufferedReader bufferedReader) throws ParseException, IOException {
        int zaa2 = zaa(bufferedReader, this.zaqr);
        if (zaa2 == 0) {
            return 0.0d;
        }
        return Double.parseDouble(new String(this.zaqr, 0, zaa2));
    }

    /* access modifiers changed from: private */
    public final BigDecimal zai(BufferedReader bufferedReader) throws ParseException, IOException {
        int zaa2 = zaa(bufferedReader, this.zaqr);
        if (zaa2 == 0) {
            return null;
        }
        return new BigDecimal(new String(this.zaqr, 0, zaa2));
    }

    private final <T extends FastJsonResponse> ArrayList<T> zaa(BufferedReader bufferedReader, FastJsonResponse.Field<?, ?> field) throws ParseException, IOException {
        ArrayList<T> arrayList = new ArrayList<>();
        char zaj = zaj(bufferedReader);
        if (zaj == ']') {
            zak(5);
            return arrayList;
        } else if (zaj == 'n') {
            zab(bufferedReader, zaqu);
            zak(5);
            return null;
        } else if (zaj == '{') {
            this.zara.push(1);
            while (true) {
                try {
                    FastJsonResponse zacn = field.zacn();
                    if (!zaa(bufferedReader, zacn)) {
                        return arrayList;
                    }
                    arrayList.add(zacn);
                    char zaj2 = zaj(bufferedReader);
                    if (zaj2 != ',') {
                        if (zaj2 == ']') {
                            zak(5);
                            return arrayList;
                        }
                        throw new ParseException(new StringBuilder(19).append("Unexpected token: ").append(zaj2).toString());
                    } else if (zaj(bufferedReader) == '{') {
                        this.zara.push(1);
                    } else {
                        throw new ParseException("Expected start of next object in array");
                    }
                } catch (InstantiationException e) {
                    throw new ParseException("Error instantiating inner object", e);
                } catch (IllegalAccessException e2) {
                    throw new ParseException("Error instantiating inner object", e2);
                }
            }
        } else {
            throw new ParseException(new StringBuilder(19).append("Unexpected token: ").append(zaj).toString());
        }
    }

    private final char zaj(BufferedReader bufferedReader) throws ParseException, IOException {
        if (bufferedReader.read(this.zaqp) == -1) {
            return 0;
        }
        while (Character.isWhitespace(this.zaqp[0])) {
            if (bufferedReader.read(this.zaqp) == -1) {
                return 0;
            }
        }
        return this.zaqp[0];
    }

    private final int zaa(BufferedReader bufferedReader, char[] cArr) throws ParseException, IOException {
        int i;
        char zaj = zaj(bufferedReader);
        if (zaj == 0) {
            throw new ParseException("Unexpected EOF");
        } else if (zaj == ',') {
            throw new ParseException("Missing value");
        } else if (zaj == 'n') {
            zab(bufferedReader, zaqu);
            return 0;
        } else {
            bufferedReader.mark(1024);
            if (zaj == '\"') {
                i = 0;
                boolean z = false;
                while (i < cArr.length && bufferedReader.read(cArr, i, 1) != -1) {
                    char c = cArr[i];
                    if (Character.isISOControl(c)) {
                        throw new ParseException("Unexpected control character while reading string");
                    } else if (c != '\"' || z) {
                        if (c == '\\') {
                            z = !z;
                        } else {
                            z = false;
                        }
                        i++;
                    } else {
                        bufferedReader.reset();
                        bufferedReader.skip((long) (i + 1));
                        return i;
                    }
                }
            } else {
                cArr[0] = zaj;
                int i2 = 1;
                while (i < cArr.length && bufferedReader.read(cArr, i, 1) != -1) {
                    if (cArr[i] == '}' || cArr[i] == ',' || Character.isWhitespace(cArr[i]) || cArr[i] == ']') {
                        bufferedReader.reset();
                        bufferedReader.skip((long) (i - 1));
                        cArr[i] = 0;
                        return i;
                    }
                    i2 = i + 1;
                }
            }
            if (i == cArr.length) {
                throw new ParseException("Absurdly long value");
            }
            throw new ParseException("Unexpected EOF");
        }
    }

    private final void zab(BufferedReader bufferedReader, char[] cArr) throws ParseException, IOException {
        int i = 0;
        while (i < cArr.length) {
            int read = bufferedReader.read(this.zaqq, 0, cArr.length - i);
            if (read != -1) {
                int i2 = 0;
                while (i2 < read) {
                    if (cArr[i2 + i] == this.zaqq[i2]) {
                        i2++;
                    } else {
                        throw new ParseException("Unexpected character");
                    }
                }
                i += read;
            } else {
                throw new ParseException("Unexpected EOF");
            }
        }
    }

    private final void zak(int i) throws ParseException {
        if (!this.zara.isEmpty()) {
            int intValue = this.zara.pop().intValue();
            if (intValue != i) {
                throw new ParseException(new StringBuilder(46).append("Expected state ").append(i).append(" but had ").append(intValue).toString());
            }
            return;
        }
        throw new ParseException(new StringBuilder(46).append("Expected state ").append(i).append(" but had empty stack").toString());
    }
}
