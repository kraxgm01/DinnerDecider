package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.collections.unsigned.UArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a5\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u00032\u0010\u0010\u0004\u001a\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0003H\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a#\u0010\u0007\u001a\u00020\b\"\u0004\b\u0000\u0010\u0002*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0003H\u0001¢\u0006\u0004\b\t\u0010\n\u001a?\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\n\u0010\r\u001a\u00060\u000ej\u0002`\u000f2\u0010\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a+\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0015\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00030\u0003¢\u0006\u0002\u0010\u0016\u001a;\u0010\u0017\u001a\u0002H\u0018\"\u0010\b\u0000\u0010\u0019*\u0006\u0012\u0002\b\u00030\u0003*\u0002H\u0018\"\u0004\b\u0001\u0010\u0018*\u0002H\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001bH\bø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a)\u0010\u001d\u001a\u00020\u0001*\b\u0012\u0002\b\u0003\u0018\u00010\u0003H\b\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000¢\u0006\u0002\u0010\u001e\u001aG\u0010\u001f\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\u00150 \"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0018*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00180 0\u0003¢\u0006\u0002\u0010!\u0002\u0007\n\u0005\b20\u0001¨\u0006\""}, d2 = {"contentDeepEqualsImpl", "", "T", "", "other", "contentDeepEquals", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", "contentDeepToStringImpl", "", "contentDeepToString", "([Ljava/lang/Object;)Ljava/lang/String;", "contentDeepToStringInternal", "", "result", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "processed", "", "contentDeepToStringInternal$ArraysKt__ArraysKt", "([Ljava/lang/Object;Ljava/lang/StringBuilder;Ljava/util/List;)V", "flatten", "", "([[Ljava/lang/Object;)Ljava/util/List;", "ifEmpty", "R", "C", "defaultValue", "Lkotlin/Function0;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNullOrEmpty", "([Ljava/lang/Object;)Z", "unzip", "Lkotlin/Pair;", "([Lkotlin/Pair;)Lkotlin/Pair;", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/collections/ArraysKt")
/* compiled from: Arrays.kt */
class ArraysKt__ArraysKt extends ArraysKt__ArraysJVMKt {
    public static final <T> List<T> flatten(T[][] $this$flatten) {
        Intrinsics.checkNotNullParameter($this$flatten, "<this>");
        Object[] objArr = (Object[]) $this$flatten;
        int length = objArr.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            Object obj = objArr[i2];
            i2++;
            i3 += ((Object[]) obj).length;
        }
        ArrayList result = new ArrayList(i3);
        int length2 = ((Object[]) $this$flatten).length;
        while (i < length2) {
            Object[] element = $this$flatten[i];
            i++;
            CollectionsKt.addAll(result, (T[]) element);
        }
        return result;
    }

    public static final <T, R> Pair<List<T>, List<R>> unzip(Pair<? extends T, ? extends R>[] $this$unzip) {
        Intrinsics.checkNotNullParameter($this$unzip, "<this>");
        ArrayList listT = new ArrayList($this$unzip.length);
        ArrayList listR = new ArrayList($this$unzip.length);
        int length = $this$unzip.length;
        int i = 0;
        while (i < length) {
            Pair pair = $this$unzip[i];
            i++;
            listT.add(pair.getFirst());
            listR.add(pair.getSecond());
        }
        return TuplesKt.to(listT, listR);
    }

    private static final boolean isNullOrEmpty(Object[] $this$isNullOrEmpty) {
        if ($this$isNullOrEmpty != null) {
            if (!($this$isNullOrEmpty.length == 0)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [C] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <C extends java.lang.Object & R, R> R ifEmpty(C r1, kotlin.jvm.functions.Function0<? extends R> r2) {
        /*
            java.lang.String r0 = "defaultValue"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            int r0 = r1.length
            if (r0 != 0) goto L_0x000a
            r0 = 1
            goto L_0x000b
        L_0x000a:
            r0 = 0
        L_0x000b:
            if (r0 == 0) goto L_0x0012
            java.lang.Object r0 = r2.invoke()
            goto L_0x0013
        L_0x0012:
            r0 = r1
        L_0x0013:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.ArraysKt__ArraysKt.ifEmpty(java.lang.Object[], kotlin.jvm.functions.Function0):java.lang.Object");
    }

    public static final <T> boolean contentDeepEquals(T[] $this$contentDeepEqualsImpl, T[] other) {
        if ($this$contentDeepEqualsImpl == other) {
            return true;
        }
        if ($this$contentDeepEqualsImpl == null || other == null || $this$contentDeepEqualsImpl.length != other.length) {
            return false;
        }
        int length = $this$contentDeepEqualsImpl.length;
        int i = 0;
        while (i < length) {
            int i2 = i;
            i++;
            Object v1 = $this$contentDeepEqualsImpl[i2];
            Object v2 = other[i2];
            if (v1 != v2) {
                if (v1 == null || v2 == null) {
                    return false;
                }
                if (!(v1 instanceof Object[]) || !(v2 instanceof Object[])) {
                    if (!(v1 instanceof byte[]) || !(v2 instanceof byte[])) {
                        if (!(v1 instanceof short[]) || !(v2 instanceof short[])) {
                            if (!(v1 instanceof int[]) || !(v2 instanceof int[])) {
                                if (!(v1 instanceof long[]) || !(v2 instanceof long[])) {
                                    if (!(v1 instanceof float[]) || !(v2 instanceof float[])) {
                                        if (!(v1 instanceof double[]) || !(v2 instanceof double[])) {
                                            if (!(v1 instanceof char[]) || !(v2 instanceof char[])) {
                                                if (!(v1 instanceof boolean[]) || !(v2 instanceof boolean[])) {
                                                    if (!(v1 instanceof UByteArray) || !(v2 instanceof UByteArray)) {
                                                        if (!(v1 instanceof UShortArray) || !(v2 instanceof UShortArray)) {
                                                            if (!(v1 instanceof UIntArray) || !(v2 instanceof UIntArray)) {
                                                                if (!(v1 instanceof ULongArray) || !(v2 instanceof ULongArray)) {
                                                                    if (!Intrinsics.areEqual(v1, v2)) {
                                                                        return false;
                                                                    }
                                                                } else if (!UArraysKt.m573contentEqualslec5QzE(((ULongArray) v1).m269unboximpl(), ((ULongArray) v2).m269unboximpl())) {
                                                                    return false;
                                                                }
                                                            } else if (!UArraysKt.m569contentEqualsKJPZfPQ(((UIntArray) v1).m191unboximpl(), ((UIntArray) v2).m191unboximpl())) {
                                                                return false;
                                                            }
                                                        } else if (!UArraysKt.m568contentEqualsFGO6Aew(((UShortArray) v1).m373unboximpl(), ((UShortArray) v2).m373unboximpl())) {
                                                            return false;
                                                        }
                                                    } else if (!UArraysKt.m571contentEqualskV0jMPg(((UByteArray) v1).m113unboximpl(), ((UByteArray) v2).m113unboximpl())) {
                                                        return false;
                                                    }
                                                } else if (!Arrays.equals((boolean[]) v1, (boolean[]) v2)) {
                                                    return false;
                                                }
                                            } else if (!Arrays.equals((char[]) v1, (char[]) v2)) {
                                                return false;
                                            }
                                        } else if (!Arrays.equals((double[]) v1, (double[]) v2)) {
                                            return false;
                                        }
                                    } else if (!Arrays.equals((float[]) v1, (float[]) v2)) {
                                        return false;
                                    }
                                } else if (!Arrays.equals((long[]) v1, (long[]) v2)) {
                                    return false;
                                }
                            } else if (!Arrays.equals((int[]) v1, (int[]) v2)) {
                                return false;
                            }
                        } else if (!Arrays.equals((short[]) v1, (short[]) v2)) {
                            return false;
                        }
                    } else if (!Arrays.equals((byte[]) v1, (byte[]) v2)) {
                        return false;
                    }
                } else if (!ArraysKt.contentDeepEquals((Object[]) v1, (Object[]) v2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static final <T> String contentDeepToString(T[] $this$contentDeepToStringImpl) {
        if ($this$contentDeepToStringImpl == null) {
            return "null";
        }
        StringBuilder $this$contentDeepToStringImpl_u24lambda_u2d2 = new StringBuilder((RangesKt.coerceAtMost($this$contentDeepToStringImpl.length, 429496729) * 5) + 2);
        contentDeepToStringInternal$ArraysKt__ArraysKt($this$contentDeepToStringImpl, $this$contentDeepToStringImpl_u24lambda_u2d2, new ArrayList());
        String sb = $this$contentDeepToStringImpl_u24lambda_u2d2.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder(capacity).…builderAction).toString()");
        return sb;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: long[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: short[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: byte[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <T> void contentDeepToStringInternal$ArraysKt__ArraysKt(T[] r6, java.lang.StringBuilder r7, java.util.List<java.lang.Object[]> r8) {
        /*
            boolean r0 = r8.contains(r6)
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = "[...]"
            r7.append(r0)
            return
        L_0x000c:
            r8.add(r6)
            r0 = 91
            r7.append(r0)
            r0 = 0
            int r1 = r6.length
        L_0x0016:
            if (r0 >= r1) goto L_0x012f
            r2 = r0
            int r0 = r0 + 1
            if (r2 == 0) goto L_0x0022
            java.lang.String r3 = ", "
            r7.append(r3)
        L_0x0022:
            r3 = r6[r2]
            if (r3 != 0) goto L_0x002d
            java.lang.String r4 = "null"
            r7.append(r4)
            goto L_0x0016
        L_0x002d:
            boolean r4 = r3 instanceof java.lang.Object[]
            if (r4 == 0) goto L_0x0038
            r4 = r3
            java.lang.Object[] r4 = (java.lang.Object[]) r4
            contentDeepToStringInternal$ArraysKt__ArraysKt(r4, r7, r8)
            goto L_0x0016
        L_0x0038:
            boolean r4 = r3 instanceof byte[]
            java.lang.String r5 = "toString(this)"
            if (r4 == 0) goto L_0x004c
            r4 = r3
            byte[] r4 = (byte[]) r4
            java.lang.String r4 = java.util.Arrays.toString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r7.append(r4)
            goto L_0x0016
        L_0x004c:
            boolean r4 = r3 instanceof short[]
            if (r4 == 0) goto L_0x005e
            r4 = r3
            short[] r4 = (short[]) r4
            java.lang.String r4 = java.util.Arrays.toString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r7.append(r4)
            goto L_0x0016
        L_0x005e:
            boolean r4 = r3 instanceof int[]
            if (r4 == 0) goto L_0x0070
            r4 = r3
            int[] r4 = (int[]) r4
            java.lang.String r4 = java.util.Arrays.toString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r7.append(r4)
            goto L_0x0016
        L_0x0070:
            boolean r4 = r3 instanceof long[]
            if (r4 == 0) goto L_0x0082
            r4 = r3
            long[] r4 = (long[]) r4
            java.lang.String r4 = java.util.Arrays.toString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r7.append(r4)
            goto L_0x0016
        L_0x0082:
            boolean r4 = r3 instanceof float[]
            if (r4 == 0) goto L_0x0094
            r4 = r3
            float[] r4 = (float[]) r4
            java.lang.String r4 = java.util.Arrays.toString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r7.append(r4)
            goto L_0x0016
        L_0x0094:
            boolean r4 = r3 instanceof double[]
            if (r4 == 0) goto L_0x00a7
            r4 = r3
            double[] r4 = (double[]) r4
            java.lang.String r4 = java.util.Arrays.toString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r7.append(r4)
            goto L_0x0016
        L_0x00a7:
            boolean r4 = r3 instanceof char[]
            if (r4 == 0) goto L_0x00ba
            r4 = r3
            char[] r4 = (char[]) r4
            java.lang.String r4 = java.util.Arrays.toString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r7.append(r4)
            goto L_0x0016
        L_0x00ba:
            boolean r4 = r3 instanceof boolean[]
            if (r4 == 0) goto L_0x00cd
            r4 = r3
            boolean[] r4 = (boolean[]) r4
            java.lang.String r4 = java.util.Arrays.toString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r7.append(r4)
            goto L_0x0016
        L_0x00cd:
            boolean r4 = r3 instanceof kotlin.UByteArray
            r5 = 0
            if (r4 == 0) goto L_0x00e4
            r4 = r3
            kotlin.UByteArray r4 = (kotlin.UByteArray) r4
            if (r4 == 0) goto L_0x00db
            byte[] r5 = r4.m113unboximpl()
        L_0x00db:
            java.lang.String r4 = kotlin.collections.unsigned.UArraysKt.m585contentToString2csIQuQ(r5)
            r7.append(r4)
            goto L_0x0016
        L_0x00e4:
            boolean r4 = r3 instanceof kotlin.UShortArray
            if (r4 == 0) goto L_0x00fa
            r4 = r3
            kotlin.UShortArray r4 = (kotlin.UShortArray) r4
            if (r4 == 0) goto L_0x00f1
            short[] r5 = r4.m373unboximpl()
        L_0x00f1:
            java.lang.String r4 = kotlin.collections.unsigned.UArraysKt.m589contentToStringd6D3K8(r5)
            r7.append(r4)
            goto L_0x0016
        L_0x00fa:
            boolean r4 = r3 instanceof kotlin.UIntArray
            if (r4 == 0) goto L_0x0110
            r4 = r3
            kotlin.UIntArray r4 = (kotlin.UIntArray) r4
            if (r4 == 0) goto L_0x0107
            int[] r5 = r4.m191unboximpl()
        L_0x0107:
            java.lang.String r4 = kotlin.collections.unsigned.UArraysKt.m588contentToStringXUkPCBk(r5)
            r7.append(r4)
            goto L_0x0016
        L_0x0110:
            boolean r4 = r3 instanceof kotlin.ULongArray
            if (r4 == 0) goto L_0x0126
            r4 = r3
            kotlin.ULongArray r4 = (kotlin.ULongArray) r4
            if (r4 == 0) goto L_0x011d
            long[] r5 = r4.m269unboximpl()
        L_0x011d:
            java.lang.String r4 = kotlin.collections.unsigned.UArraysKt.m591contentToStringuLth9ew(r5)
            r7.append(r4)
            goto L_0x0016
        L_0x0126:
            java.lang.String r4 = r3.toString()
            r7.append(r4)
            goto L_0x0016
        L_0x012f:
            r0 = 93
            r7.append(r0)
            int r0 = kotlin.collections.CollectionsKt.getLastIndex(r8)
            r8.remove(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.ArraysKt__ArraysKt.contentDeepToStringInternal$ArraysKt__ArraysKt(java.lang.Object[], java.lang.StringBuilder, java.util.List):void");
    }
}
