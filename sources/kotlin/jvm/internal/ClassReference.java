package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 K2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001KB\u0011\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010B\u001a\u00020\u00122\b\u0010C\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010D\u001a\u00020EH\u0002J\b\u0010F\u001a\u00020GH\u0016J\u0012\u0010H\u001a\u00020\u00122\b\u0010I\u001a\u0004\u0018\u00010\u0002H\u0017J\b\u0010J\u001a\u00020-H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR \u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000e0\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00128VX\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00128VX\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0016\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u00128VX\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0018\u0010\u0015R\u001a\u0010\u001a\u001a\u00020\u00128VX\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001a\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u00128VX\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001c\u0010\u0015R\u001a\u0010\u001e\u001a\u00020\u00128VX\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0014\u001a\u0004\b\u001e\u0010\u0015R\u001a\u0010 \u001a\u00020\u00128VX\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0014\u001a\u0004\b \u0010\u0015R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001e\u0010$\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030%0\r8VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0010R\u001e\u0010'\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\r8VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0010R\u0016\u0010)\u001a\u0004\u0018\u00010\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0016\u0010,\u001a\u0004\u0018\u00010-8VX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R(\u00100\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00010\b8VX\u0004¢\u0006\f\u0012\u0004\b1\u0010\u0014\u001a\u0004\b2\u0010\u000bR\u0016\u00103\u001a\u0004\u0018\u00010-8VX\u0004¢\u0006\u0006\u001a\u0004\b4\u0010/R \u00105\u001a\b\u0012\u0004\u0012\u0002060\b8VX\u0004¢\u0006\f\u0012\u0004\b7\u0010\u0014\u001a\u0004\b8\u0010\u000bR \u00109\u001a\b\u0012\u0004\u0012\u00020:0\b8VX\u0004¢\u0006\f\u0012\u0004\b;\u0010\u0014\u001a\u0004\b<\u0010\u000bR\u001c\u0010=\u001a\u0004\u0018\u00010>8VX\u0004¢\u0006\f\u0012\u0004\b?\u0010\u0014\u001a\u0004\b@\u0010A¨\u0006L"}, d2 = {"Lkotlin/jvm/internal/ClassReference;", "Lkotlin/reflect/KClass;", "", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "constructors", "", "Lkotlin/reflect/KFunction;", "getConstructors", "()Ljava/util/Collection;", "isAbstract", "", "isAbstract$annotations", "()V", "()Z", "isCompanion", "isCompanion$annotations", "isData", "isData$annotations", "isFinal", "isFinal$annotations", "isInner", "isInner$annotations", "isOpen", "isOpen$annotations", "isSealed", "isSealed$annotations", "getJClass", "()Ljava/lang/Class;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "sealedSubclasses$annotations", "getSealedSubclasses", "simpleName", "getSimpleName", "supertypes", "Lkotlin/reflect/KType;", "supertypes$annotations", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "typeParameters$annotations", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "visibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", "error", "", "hashCode", "", "isInstance", "value", "toString", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* compiled from: ClassReference.kt */
public final class ClassReference implements KClass<Object>, ClassBasedDeclarationContainer {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Map<Class<? extends Function<?>>, Integer> FUNCTION_CLASSES;
    /* access modifiers changed from: private */
    public static final HashMap<String, String> classFqNames;
    private static final HashMap<String, String> primitiveFqNames;
    private static final HashMap<String, String> primitiveWrapperFqNames;
    /* access modifiers changed from: private */
    public static final Map<String, String> simpleNames;
    private final Class<?> jClass;

    public static /* synthetic */ void isAbstract$annotations() {
    }

    public static /* synthetic */ void isCompanion$annotations() {
    }

    public static /* synthetic */ void isData$annotations() {
    }

    public static /* synthetic */ void isFinal$annotations() {
    }

    public static /* synthetic */ void isInner$annotations() {
    }

    public static /* synthetic */ void isOpen$annotations() {
    }

    public static /* synthetic */ void isSealed$annotations() {
    }

    public static /* synthetic */ void sealedSubclasses$annotations() {
    }

    public static /* synthetic */ void supertypes$annotations() {
    }

    public static /* synthetic */ void typeParameters$annotations() {
    }

    public static /* synthetic */ void visibility$annotations() {
    }

    public ClassReference(Class<?> jClass2) {
        Intrinsics.checkParameterIsNotNull(jClass2, "jClass");
        this.jClass = jClass2;
    }

    public Class<?> getJClass() {
        return this.jClass;
    }

    public String getSimpleName() {
        return Companion.getClassSimpleName(getJClass());
    }

    public String getQualifiedName() {
        return Companion.getClassQualifiedName(getJClass());
    }

    public Collection<KCallable<?>> getMembers() {
        error();
        throw null;
    }

    public Collection<KFunction<Object>> getConstructors() {
        error();
        throw null;
    }

    public Collection<KClass<?>> getNestedClasses() {
        error();
        throw null;
    }

    public List<Annotation> getAnnotations() {
        error();
        throw null;
    }

    public Object getObjectInstance() {
        error();
        throw null;
    }

    public boolean isInstance(Object value) {
        return Companion.isInstance(value, getJClass());
    }

    public List<KTypeParameter> getTypeParameters() {
        error();
        throw null;
    }

    public List<KType> getSupertypes() {
        error();
        throw null;
    }

    public List<KClass<? extends Object>> getSealedSubclasses() {
        error();
        throw null;
    }

    public KVisibility getVisibility() {
        error();
        throw null;
    }

    public boolean isFinal() {
        error();
        throw null;
    }

    public boolean isOpen() {
        error();
        throw null;
    }

    public boolean isAbstract() {
        error();
        throw null;
    }

    public boolean isSealed() {
        error();
        throw null;
    }

    public boolean isData() {
        error();
        throw null;
    }

    public boolean isInner() {
        error();
        throw null;
    }

    public boolean isCompanion() {
        error();
        throw null;
    }

    private final Void error() {
        throw new KotlinReflectionNotSupportedError();
    }

    public boolean equals(Object other) {
        return (other instanceof ClassReference) && Intrinsics.areEqual((Object) JvmClassMappingKt.getJavaObjectType(this), (Object) JvmClassMappingKt.getJavaObjectType((KClass) other));
    }

    public int hashCode() {
        return JvmClassMappingKt.getJavaObjectType(this).hashCode();
    }

    public String toString() {
        return getJClass().toString() + " (Kotlin reflection is not available)";
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0005J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0005J\u001c\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00012\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0005R&\u0010\u0003\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bX\u0004¢\u0006\u0002\n\u0000R*\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bX\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkotlin/jvm/internal/ClassReference$Companion;", "", "()V", "FUNCTION_CLASSES", "", "Ljava/lang/Class;", "Lkotlin/Function;", "", "classFqNames", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "primitiveFqNames", "primitiveWrapperFqNames", "simpleNames", "getClassQualifiedName", "jClass", "getClassSimpleName", "isInstance", "", "value", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
    /* compiled from: ClassReference.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0044, code lost:
            if (r1 != null) goto L_0x006c;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String getClassSimpleName(java.lang.Class<?> r10) {
            /*
                r9 = this;
                java.lang.String r0 = "jClass"
                kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r10, r0)
                boolean r0 = r10.isAnonymousClass()
                java.lang.String r1 = "Array"
                r2 = 0
                if (r0 == 0) goto L_0x0012
                r1 = r2
                goto L_0x00ce
            L_0x0012:
                boolean r0 = r10.isLocalClass()
                if (r0 == 0) goto L_0x0079
                java.lang.String r0 = r10.getSimpleName()
                java.lang.reflect.Method r1 = r10.getEnclosingMethod()
                java.lang.String r3 = "$"
                r4 = 2
                java.lang.String r5 = "name"
                if (r1 == 0) goto L_0x0047
                r6 = 0
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r5)
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r8 = r1.getName()
                java.lang.StringBuilder r7 = r7.append(r8)
                java.lang.StringBuilder r7 = r7.append(r3)
                java.lang.String r7 = r7.toString()
                java.lang.String r1 = kotlin.text.StringsKt.substringAfter$default((java.lang.String) r0, (java.lang.String) r7, (java.lang.String) r2, (int) r4, (java.lang.Object) r2)
                if (r1 == 0) goto L_0x0047
                goto L_0x006c
            L_0x0047:
                java.lang.reflect.Constructor r1 = r10.getEnclosingConstructor()
                if (r1 == 0) goto L_0x006b
                r6 = 0
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r5)
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r8 = r1.getName()
                java.lang.StringBuilder r7 = r7.append(r8)
                java.lang.StringBuilder r3 = r7.append(r3)
                java.lang.String r3 = r3.toString()
                java.lang.String r1 = kotlin.text.StringsKt.substringAfter$default((java.lang.String) r0, (java.lang.String) r3, (java.lang.String) r2, (int) r4, (java.lang.Object) r2)
                goto L_0x006c
            L_0x006b:
                r1 = r2
            L_0x006c:
                if (r1 == 0) goto L_0x006f
                goto L_0x00ce
            L_0x006f:
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r5)
                r1 = 36
                java.lang.String r1 = kotlin.text.StringsKt.substringAfter$default((java.lang.String) r0, (char) r1, (java.lang.String) r2, (int) r4, (java.lang.Object) r2)
                goto L_0x00ce
            L_0x0079:
                boolean r0 = r10.isArray()
                if (r0 == 0) goto L_0x00b8
                java.lang.Class r0 = r10.getComponentType()
                java.lang.String r3 = "componentType"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
                boolean r3 = r0.isPrimitive()
                if (r3 == 0) goto L_0x00b1
                java.util.Map r3 = kotlin.jvm.internal.ClassReference.simpleNames
                java.lang.String r4 = r0.getName()
                java.lang.Object r3 = r3.get(r4)
                java.lang.String r3 = (java.lang.String) r3
                if (r3 == 0) goto L_0x00b2
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.StringBuilder r2 = r2.append(r3)
                java.lang.StringBuilder r2 = r2.append(r1)
                java.lang.String r2 = r2.toString()
                goto L_0x00b2
            L_0x00b1:
            L_0x00b2:
                if (r2 == 0) goto L_0x00b6
                r1 = r2
                goto L_0x00ce
            L_0x00b6:
                goto L_0x00ce
            L_0x00b8:
                java.util.Map r0 = kotlin.jvm.internal.ClassReference.simpleNames
                java.lang.String r1 = r10.getName()
                java.lang.Object r0 = r0.get(r1)
                r1 = r0
                java.lang.String r1 = (java.lang.String) r1
                if (r1 == 0) goto L_0x00ca
                goto L_0x00ce
            L_0x00ca:
                java.lang.String r1 = r10.getSimpleName()
            L_0x00ce:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.ClassReference.Companion.getClassSimpleName(java.lang.Class):java.lang.String");
        }

        public final String getClassQualifiedName(Class<?> jClass) {
            String str;
            Intrinsics.checkParameterIsNotNull(jClass, "jClass");
            String str2 = null;
            if (jClass.isAnonymousClass() || jClass.isLocalClass()) {
                return null;
            }
            if (jClass.isArray()) {
                Class componentType = jClass.getComponentType();
                Intrinsics.checkExpressionValueIsNotNull(componentType, "componentType");
                if (componentType.isPrimitive() && (str = (String) ClassReference.classFqNames.get(componentType.getName())) != null) {
                    str2 = str + "Array";
                }
                if (str2 != null) {
                    return str2;
                }
                return "kotlin.Array";
            }
            String str3 = (String) ClassReference.classFqNames.get(jClass.getName());
            if (str3 != null) {
                return str3;
            }
            return jClass.getCanonicalName();
        }

        public final boolean isInstance(Object value, Class<?> jClass) {
            Intrinsics.checkParameterIsNotNull(jClass, "jClass");
            Map access$getFUNCTION_CLASSES$cp = ClassReference.FUNCTION_CLASSES;
            if (access$getFUNCTION_CLASSES$cp != null) {
                Integer num = (Integer) access$getFUNCTION_CLASSES$cp.get(jClass);
                if (num != null) {
                    return TypeIntrinsics.isFunctionOfArity(value, num.intValue());
                }
                return (jClass.isPrimitive() != 0 ? JvmClassMappingKt.getJavaObjectType(JvmClassMappingKt.getKotlinClass(jClass)) : jClass).isInstance(value);
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
        }
    }

    static {
        Iterable $this$mapIndexed$iv = CollectionsKt.listOf(Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
        int index$iv$iv = 0;
        for (Object item$iv$iv : $this$mapIndexed$iv) {
            int index$iv$iv2 = index$iv$iv + 1;
            if (index$iv$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            destination$iv$iv.add(TuplesKt.to((Class) item$iv$iv, Integer.valueOf(index$iv$iv)));
            index$iv$iv = index$iv$iv2;
        }
        FUNCTION_CLASSES = MapsKt.toMap((List) destination$iv$iv);
        HashMap hashMap = new HashMap();
        HashMap $this$apply = hashMap;
        $this$apply.put("boolean", "kotlin.Boolean");
        $this$apply.put("char", "kotlin.Char");
        $this$apply.put("byte", "kotlin.Byte");
        $this$apply.put("short", "kotlin.Short");
        $this$apply.put("int", "kotlin.Int");
        $this$apply.put("float", "kotlin.Float");
        $this$apply.put("long", "kotlin.Long");
        $this$apply.put("double", "kotlin.Double");
        primitiveFqNames = hashMap;
        HashMap hashMap2 = new HashMap();
        HashMap $this$apply2 = hashMap2;
        $this$apply2.put("java.lang.Boolean", "kotlin.Boolean");
        $this$apply2.put("java.lang.Character", "kotlin.Char");
        $this$apply2.put("java.lang.Byte", "kotlin.Byte");
        $this$apply2.put("java.lang.Short", "kotlin.Short");
        $this$apply2.put("java.lang.Integer", "kotlin.Int");
        $this$apply2.put("java.lang.Float", "kotlin.Float");
        $this$apply2.put("java.lang.Long", "kotlin.Long");
        $this$apply2.put("java.lang.Double", "kotlin.Double");
        primitiveWrapperFqNames = hashMap2;
        HashMap hashMap3 = new HashMap();
        HashMap $this$apply3 = hashMap3;
        $this$apply3.put("java.lang.Object", "kotlin.Any");
        $this$apply3.put("java.lang.String", "kotlin.String");
        $this$apply3.put("java.lang.CharSequence", "kotlin.CharSequence");
        $this$apply3.put("java.lang.Throwable", "kotlin.Throwable");
        $this$apply3.put("java.lang.Cloneable", "kotlin.Cloneable");
        $this$apply3.put("java.lang.Number", "kotlin.Number");
        $this$apply3.put("java.lang.Comparable", "kotlin.Comparable");
        $this$apply3.put("java.lang.Enum", "kotlin.Enum");
        $this$apply3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        $this$apply3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        $this$apply3.put("java.util.Iterator", "kotlin.collections.Iterator");
        $this$apply3.put("java.util.Collection", "kotlin.collections.Collection");
        $this$apply3.put("java.util.List", "kotlin.collections.List");
        $this$apply3.put("java.util.Set", "kotlin.collections.Set");
        $this$apply3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        $this$apply3.put("java.util.Map", "kotlin.collections.Map");
        $this$apply3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        $this$apply3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        $this$apply3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        $this$apply3.putAll(hashMap);
        $this$apply3.putAll(hashMap2);
        Collection<String> $this$associateTo$iv = hashMap.values();
        Intrinsics.checkExpressionValueIsNotNull($this$associateTo$iv, "primitiveFqNames.values");
        for (String kotlinName : $this$associateTo$iv) {
            StringBuilder append = new StringBuilder().append("kotlin.jvm.internal.");
            Intrinsics.checkExpressionValueIsNotNull(kotlinName, "kotlinName");
            Pair pair = TuplesKt.to(append.append(StringsKt.substringAfterLast$default(kotlinName, '.', (String) null, 2, (Object) null)).append("CompanionObject").toString(), kotlinName + ".Companion");
            $this$apply3.put(pair.getFirst(), pair.getSecond());
        }
        Map map = $this$apply3;
        for (Map.Entry next : FUNCTION_CLASSES.entrySet()) {
            $this$apply3.put(((Class) next.getKey()).getName(), "kotlin.Function" + ((Number) next.getValue()).intValue());
        }
        classFqNames = hashMap3;
        Map $this$mapValues$iv = hashMap3;
        Map destination$iv$iv2 = new LinkedHashMap(MapsKt.mapCapacity($this$mapValues$iv.size()));
        for (Object element$iv$iv$iv : $this$mapValues$iv.entrySet()) {
            destination$iv$iv2.put(((Map.Entry) element$iv$iv$iv).getKey(), StringsKt.substringAfterLast$default((String) ((Map.Entry) element$iv$iv$iv).getValue(), '.', (String) null, 2, (Object) null));
        }
        simpleNames = destination$iv$iv2;
    }
}
