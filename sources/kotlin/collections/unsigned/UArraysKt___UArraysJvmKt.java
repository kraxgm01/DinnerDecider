package kotlin.collections.unsigned;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.UnsignedKt;
import kotlin.collections.AbstractList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\n0\u0001*\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001*\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001f\u0010\u001f\u001a\u00020\u0002*\u00020\u00032\u0006\u0010 \u001a\u00020\u0013H\bø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a\u001f\u0010\u001f\u001a\u00020\u0006*\u00020\u00072\u0006\u0010 \u001a\u00020\u0013H\bø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u001f\u0010\u001f\u001a\u00020\n*\u00020\u000b2\u0006\u0010 \u001a\u00020\u0013H\bø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\u001f\u0010\u001f\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010 \u001a\u00020\u0013H\bø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a.\u0010)\u001a\u00020**\u00020\u00032\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020*0,H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010.\u001a.\u0010)\u001a\u00020/*\u00020\u00032\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020/0,H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101\u001a.\u0010)\u001a\u00020**\u00020\u00072\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020*0,H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u00102\u001a.\u0010)\u001a\u00020/*\u00020\u00072\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020/0,H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00103\u001a.\u0010)\u001a\u00020**\u00020\u000b2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020*0,H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u00104\u001a.\u0010)\u001a\u00020/*\u00020\u000b2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020/0,H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00105\u001a.\u0010)\u001a\u00020**\u00020\u000f2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020*0,H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u00106\u001a.\u0010)\u001a\u00020/*\u00020\u000f2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020/0,H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00107\u0002\u000b\n\u0002\b\u0019\n\u0005\b20\u0001¨\u00068"}, d2 = {"asList", "", "Lkotlin/UByte;", "Lkotlin/UByteArray;", "asList-GBYM_sE", "([B)Ljava/util/List;", "Lkotlin/UInt;", "Lkotlin/UIntArray;", "asList--ajY-9A", "([I)Ljava/util/List;", "Lkotlin/ULong;", "Lkotlin/ULongArray;", "asList-QwZRm1k", "([J)Ljava/util/List;", "Lkotlin/UShort;", "Lkotlin/UShortArray;", "asList-rL5Bavg", "([S)Ljava/util/List;", "binarySearch", "", "element", "fromIndex", "toIndex", "binarySearch-WpHrYlw", "([BBII)I", "binarySearch-2fe2U9s", "([IIII)I", "binarySearch-K6DWlUc", "([JJII)I", "binarySearch-EtDCXyQ", "([SSII)I", "elementAt", "index", "elementAt-PpDY95g", "([BI)B", "elementAt-qFRl0hI", "([II)I", "elementAt-r7IrZao", "([JI)J", "elementAt-nggk6HY", "([SI)S", "sumOf", "Ljava/math/BigDecimal;", "selector", "Lkotlin/Function1;", "sumOfBigDecimal", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "sumOfBigInteger", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, pn = "kotlin.collections", xi = 49, xs = "kotlin/collections/unsigned/UArraysKt")
/* compiled from: _UArraysJvm.kt */
class UArraysKt___UArraysJvmKt {
    /* renamed from: elementAt-qFRl0hI  reason: not valid java name */
    private static final int m506elementAtqFRl0hI(int[] $this$elementAt, int index) {
        Intrinsics.checkNotNullParameter($this$elementAt, "$this$elementAt");
        return UIntArray.m182getpVg5ArA($this$elementAt, index);
    }

    /* renamed from: elementAt-r7IrZao  reason: not valid java name */
    private static final long m507elementAtr7IrZao(long[] $this$elementAt, int index) {
        Intrinsics.checkNotNullParameter($this$elementAt, "$this$elementAt");
        return ULongArray.m260getsVKNKU($this$elementAt, index);
    }

    /* renamed from: elementAt-PpDY95g  reason: not valid java name */
    private static final byte m504elementAtPpDY95g(byte[] $this$elementAt, int index) {
        Intrinsics.checkNotNullParameter($this$elementAt, "$this$elementAt");
        return UByteArray.m104getw2LRezQ($this$elementAt, index);
    }

    /* renamed from: elementAt-nggk6HY  reason: not valid java name */
    private static final short m505elementAtnggk6HY(short[] $this$elementAt, int index) {
        Intrinsics.checkNotNullParameter($this$elementAt, "$this$elementAt");
        return UShortArray.m364getMh2AYeg($this$elementAt, index);
    }

    /* renamed from: asList--ajY-9A  reason: not valid java name */
    public static final List<UInt> m492asListajY9A(int[] $this$asList) {
        Intrinsics.checkNotNullParameter($this$asList, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$1($this$asList);
    }

    /* renamed from: asList-QwZRm1k  reason: not valid java name */
    public static final List<ULong> m494asListQwZRm1k(long[] $this$asList) {
        Intrinsics.checkNotNullParameter($this$asList, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$2($this$asList);
    }

    /* renamed from: asList-GBYM_sE  reason: not valid java name */
    public static final List<UByte> m493asListGBYM_sE(byte[] $this$asList) {
        Intrinsics.checkNotNullParameter($this$asList, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$3($this$asList);
    }

    /* renamed from: asList-rL5Bavg  reason: not valid java name */
    public static final List<UShort> m495asListrL5Bavg(short[] $this$asList) {
        Intrinsics.checkNotNullParameter($this$asList, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$4($this$asList);
    }

    /* renamed from: binarySearch-2fe2U9s$default  reason: not valid java name */
    public static /* synthetic */ int m497binarySearch2fe2U9s$default(int[] iArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = UIntArray.m183getSizeimpl(iArr);
        }
        return UArraysKt.m496binarySearch2fe2U9s(iArr, i, i2, i3);
    }

    /* renamed from: binarySearch-2fe2U9s  reason: not valid java name */
    public static final int m496binarySearch2fe2U9s(int[] $this$binarySearch, int element, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter($this$binarySearch, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, UIntArray.m183getSizeimpl($this$binarySearch));
        int signedElement = element;
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int cmp = UnsignedKt.uintCompare($this$binarySearch[mid], signedElement);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp <= 0) {
                return mid;
            } else {
                high = mid - 1;
            }
        }
        return -(low + 1);
    }

    /* renamed from: binarySearch-K6DWlUc$default  reason: not valid java name */
    public static /* synthetic */ int m501binarySearchK6DWlUc$default(long[] jArr, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m261getSizeimpl(jArr);
        }
        return UArraysKt.m500binarySearchK6DWlUc(jArr, j, i, i2);
    }

    /* renamed from: binarySearch-K6DWlUc  reason: not valid java name */
    public static final int m500binarySearchK6DWlUc(long[] $this$binarySearch, long element, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter($this$binarySearch, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, ULongArray.m261getSizeimpl($this$binarySearch));
        long signedElement = element;
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int cmp = UnsignedKt.ulongCompare($this$binarySearch[mid], signedElement);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp <= 0) {
                return mid;
            } else {
                high = mid - 1;
            }
        }
        return -(low + 1);
    }

    /* renamed from: binarySearch-WpHrYlw$default  reason: not valid java name */
    public static /* synthetic */ int m503binarySearchWpHrYlw$default(byte[] bArr, byte b, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m105getSizeimpl(bArr);
        }
        return UArraysKt.m502binarySearchWpHrYlw(bArr, b, i, i2);
    }

    /* renamed from: binarySearch-WpHrYlw  reason: not valid java name */
    public static final int m502binarySearchWpHrYlw(byte[] $this$binarySearch, byte element, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter($this$binarySearch, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, UByteArray.m105getSizeimpl($this$binarySearch));
        int signedElement = element & 255;
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int cmp = UnsignedKt.uintCompare($this$binarySearch[mid], signedElement);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp <= 0) {
                return mid;
            } else {
                high = mid - 1;
            }
        }
        return -(low + 1);
    }

    /* renamed from: binarySearch-EtDCXyQ$default  reason: not valid java name */
    public static /* synthetic */ int m499binarySearchEtDCXyQ$default(short[] sArr, short s, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m365getSizeimpl(sArr);
        }
        return UArraysKt.m498binarySearchEtDCXyQ(sArr, s, i, i2);
    }

    /* renamed from: binarySearch-EtDCXyQ  reason: not valid java name */
    public static final int m498binarySearchEtDCXyQ(short[] $this$binarySearch, short element, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter($this$binarySearch, "$this$binarySearch");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, UShortArray.m365getSizeimpl($this$binarySearch));
        int signedElement = 65535 & element;
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int cmp = UnsignedKt.uintCompare($this$binarySearch[mid], signedElement);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp <= 0) {
                return mid;
            } else {
                high = mid - 1;
            }
        }
        return -(low + 1);
    }

    private static final BigDecimal sumOfBigDecimal(int[] $this$sumOf, Function1<? super UInt, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter($this$sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigDecimal sum = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(sum, "valueOf(this.toLong())");
        Iterator<UInt> r1 = UIntArray.m186iteratorimpl($this$sumOf);
        while (r1.hasNext()) {
            BigDecimal add = sum.add((BigDecimal) selector.invoke(UInt.m117boximpl(r1.next().m174unboximpl())));
            Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
            sum = add;
        }
        return sum;
    }

    private static final BigDecimal sumOfBigDecimal(long[] $this$sumOf, Function1<? super ULong, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter($this$sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigDecimal sum = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(sum, "valueOf(this.toLong())");
        Iterator<ULong> r1 = ULongArray.m264iteratorimpl($this$sumOf);
        while (r1.hasNext()) {
            BigDecimal add = sum.add((BigDecimal) selector.invoke(ULong.m195boximpl(r1.next().m252unboximpl())));
            Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
            sum = add;
        }
        return sum;
    }

    private static final BigDecimal sumOfBigDecimal(byte[] $this$sumOf, Function1<? super UByte, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter($this$sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigDecimal sum = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(sum, "valueOf(this.toLong())");
        Iterator<UByte> r1 = UByteArray.m108iteratorimpl($this$sumOf);
        while (r1.hasNext()) {
            BigDecimal add = sum.add((BigDecimal) selector.invoke(UByte.m41boximpl(r1.next().m96unboximpl())));
            Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
            sum = add;
        }
        return sum;
    }

    private static final BigDecimal sumOfBigDecimal(short[] $this$sumOf, Function1<? super UShort, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter($this$sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigDecimal sum = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(sum, "valueOf(this.toLong())");
        Iterator<UShort> r1 = UShortArray.m368iteratorimpl($this$sumOf);
        while (r1.hasNext()) {
            BigDecimal add = sum.add((BigDecimal) selector.invoke(UShort.m301boximpl(r1.next().m356unboximpl())));
            Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
            sum = add;
        }
        return sum;
    }

    private static final BigInteger sumOfBigInteger(int[] $this$sumOf, Function1<? super UInt, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter($this$sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigInteger sum = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(sum, "valueOf(this.toLong())");
        Iterator<UInt> r1 = UIntArray.m186iteratorimpl($this$sumOf);
        while (r1.hasNext()) {
            BigInteger add = sum.add((BigInteger) selector.invoke(UInt.m117boximpl(r1.next().m174unboximpl())));
            Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
            sum = add;
        }
        return sum;
    }

    private static final BigInteger sumOfBigInteger(long[] $this$sumOf, Function1<? super ULong, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter($this$sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigInteger sum = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(sum, "valueOf(this.toLong())");
        Iterator<ULong> r1 = ULongArray.m264iteratorimpl($this$sumOf);
        while (r1.hasNext()) {
            BigInteger add = sum.add((BigInteger) selector.invoke(ULong.m195boximpl(r1.next().m252unboximpl())));
            Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
            sum = add;
        }
        return sum;
    }

    private static final BigInteger sumOfBigInteger(byte[] $this$sumOf, Function1<? super UByte, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter($this$sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigInteger sum = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(sum, "valueOf(this.toLong())");
        Iterator<UByte> r1 = UByteArray.m108iteratorimpl($this$sumOf);
        while (r1.hasNext()) {
            BigInteger add = sum.add((BigInteger) selector.invoke(UByte.m41boximpl(r1.next().m96unboximpl())));
            Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
            sum = add;
        }
        return sum;
    }

    private static final BigInteger sumOfBigInteger(short[] $this$sumOf, Function1<? super UShort, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter($this$sumOf, "$this$sumOf");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigInteger sum = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(sum, "valueOf(this.toLong())");
        Iterator<UShort> r1 = UShortArray.m368iteratorimpl($this$sumOf);
        while (r1.hasNext()) {
            BigInteger add = sum.add((BigInteger) selector.invoke(UShort.m301boximpl(r1.next().m356unboximpl())));
            Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
            sum = add;
        }
        return sum;
    }
}
