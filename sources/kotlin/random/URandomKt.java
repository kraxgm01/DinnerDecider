package kotlin.random;

import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.ULongRange;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\"\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\bH\u0000ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001c\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u001e\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u0011\u001a\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a2\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0014\u0010\u0018\u001a\u00020\u0003*\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001a\u001e\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a&\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001c\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007ø\u0001\u0000¢\u0006\u0002\u0010 \u001a\u0014\u0010!\u001a\u00020\b*\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\"\u001a\u001e\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u0004\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a&\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\u001c\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u001e\u001a\u00020'H\u0007ø\u0001\u0000¢\u0006\u0002\u0010(\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"checkUIntRangeBounds", "", "from", "Lkotlin/UInt;", "until", "checkUIntRangeBounds-J1ME1BU", "(II)V", "checkULongRangeBounds", "Lkotlin/ULong;", "checkULongRangeBounds-eb3DHEI", "(JJ)V", "nextUBytes", "Lkotlin/UByteArray;", "Lkotlin/random/Random;", "size", "", "(Lkotlin/random/Random;I)[B", "array", "nextUBytes-EVgfTAA", "(Lkotlin/random/Random;[B)[B", "fromIndex", "toIndex", "nextUBytes-Wvrt4B4", "(Lkotlin/random/Random;[BII)[B", "nextUInt", "(Lkotlin/random/Random;)I", "nextUInt-qCasIEU", "(Lkotlin/random/Random;I)I", "nextUInt-a8DCA5k", "(Lkotlin/random/Random;II)I", "range", "Lkotlin/ranges/UIntRange;", "(Lkotlin/random/Random;Lkotlin/ranges/UIntRange;)I", "nextULong", "(Lkotlin/random/Random;)J", "nextULong-V1Xi4fY", "(Lkotlin/random/Random;J)J", "nextULong-jmpaW-c", "(Lkotlin/random/Random;JJ)J", "Lkotlin/ranges/ULongRange;", "(Lkotlin/random/Random;Lkotlin/ranges/ULongRange;)J", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: URandom.kt */
public final class URandomKt {
    public static final int nextUInt(Random $this$nextUInt) {
        Intrinsics.checkNotNullParameter($this$nextUInt, "<this>");
        return UInt.m123constructorimpl($this$nextUInt.nextInt());
    }

    /* renamed from: nextUInt-qCasIEU  reason: not valid java name */
    public static final int m1231nextUIntqCasIEU(Random $this$nextUInt, int until) {
        Intrinsics.checkNotNullParameter($this$nextUInt, "$this$nextUInt");
        return m1230nextUInta8DCA5k($this$nextUInt, 0, until);
    }

    /* renamed from: nextUInt-a8DCA5k  reason: not valid java name */
    public static final int m1230nextUInta8DCA5k(Random $this$nextUInt, int from, int until) {
        Intrinsics.checkNotNullParameter($this$nextUInt, "$this$nextUInt");
        m1225checkUIntRangeBoundsJ1ME1BU(from, until);
        return UInt.m123constructorimpl(Integer.MIN_VALUE ^ $this$nextUInt.nextInt(from ^ Integer.MIN_VALUE, until ^ Integer.MIN_VALUE));
    }

    public static final int nextUInt(Random $this$nextUInt, UIntRange range) {
        Intrinsics.checkNotNullParameter($this$nextUInt, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (range.isEmpty()) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("Cannot get random in empty range: ", range));
        } else if (UnsignedKt.uintCompare(range.m1235getLastpVg5ArA(), -1) < 0) {
            return m1230nextUInta8DCA5k($this$nextUInt, range.m1234getFirstpVg5ArA(), UInt.m123constructorimpl(range.m1235getLastpVg5ArA() + 1));
        } else {
            if (UnsignedKt.uintCompare(range.m1234getFirstpVg5ArA(), 0) > 0) {
                return UInt.m123constructorimpl(m1230nextUInta8DCA5k($this$nextUInt, UInt.m123constructorimpl(range.m1234getFirstpVg5ArA() - 1), range.m1235getLastpVg5ArA()) + 1);
            }
            return nextUInt($this$nextUInt);
        }
    }

    public static final long nextULong(Random $this$nextULong) {
        Intrinsics.checkNotNullParameter($this$nextULong, "<this>");
        return ULong.m201constructorimpl($this$nextULong.nextLong());
    }

    /* renamed from: nextULong-V1Xi4fY  reason: not valid java name */
    public static final long m1232nextULongV1Xi4fY(Random $this$nextULong, long until) {
        Intrinsics.checkNotNullParameter($this$nextULong, "$this$nextULong");
        return m1233nextULongjmpaWc($this$nextULong, 0, until);
    }

    /* renamed from: nextULong-jmpaW-c  reason: not valid java name */
    public static final long m1233nextULongjmpaWc(Random $this$nextULong, long from, long until) {
        Intrinsics.checkNotNullParameter($this$nextULong, "$this$nextULong");
        m1226checkULongRangeBoundseb3DHEI(from, until);
        return ULong.m201constructorimpl(Long.MIN_VALUE ^ $this$nextULong.nextLong(from ^ Long.MIN_VALUE, until ^ Long.MIN_VALUE));
    }

    public static final long nextULong(Random $this$nextULong, ULongRange range) {
        Intrinsics.checkNotNullParameter($this$nextULong, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (range.isEmpty()) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("Cannot get random in empty range: ", range));
        } else if (UnsignedKt.ulongCompare(range.m1242getLastsVKNKU(), -1) < 0) {
            return m1233nextULongjmpaWc($this$nextULong, range.m1241getFirstsVKNKU(), ULong.m201constructorimpl(range.m1242getLastsVKNKU() + ULong.m201constructorimpl(((long) 1) & 4294967295L)));
        } else {
            if (UnsignedKt.ulongCompare(range.m1241getFirstsVKNKU(), 0) <= 0) {
                return nextULong($this$nextULong);
            }
            long j = ((long) 1) & 4294967295L;
            return ULong.m201constructorimpl(m1233nextULongjmpaWc($this$nextULong, ULong.m201constructorimpl(range.m1241getFirstsVKNKU() - ULong.m201constructorimpl(j)), range.m1242getLastsVKNKU()) + ULong.m201constructorimpl(j));
        }
    }

    /* renamed from: nextUBytes-EVgfTAA  reason: not valid java name */
    public static final byte[] m1227nextUBytesEVgfTAA(Random $this$nextUBytes, byte[] array) {
        Intrinsics.checkNotNullParameter($this$nextUBytes, "$this$nextUBytes");
        Intrinsics.checkNotNullParameter(array, "array");
        $this$nextUBytes.nextBytes(array);
        return array;
    }

    public static final byte[] nextUBytes(Random $this$nextUBytes, int size) {
        Intrinsics.checkNotNullParameter($this$nextUBytes, "<this>");
        return UByteArray.m99constructorimpl($this$nextUBytes.nextBytes(size));
    }

    /* renamed from: nextUBytes-Wvrt4B4$default  reason: not valid java name */
    public static /* synthetic */ byte[] m1229nextUBytesWvrt4B4$default(Random random, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m105getSizeimpl(bArr);
        }
        return m1228nextUBytesWvrt4B4(random, bArr, i, i2);
    }

    /* renamed from: nextUBytes-Wvrt4B4  reason: not valid java name */
    public static final byte[] m1228nextUBytesWvrt4B4(Random $this$nextUBytes, byte[] array, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter($this$nextUBytes, "$this$nextUBytes");
        Intrinsics.checkNotNullParameter(array, "array");
        $this$nextUBytes.nextBytes(array, fromIndex, toIndex);
        return array;
    }

    /* renamed from: checkUIntRangeBounds-J1ME1BU  reason: not valid java name */
    public static final void m1225checkUIntRangeBoundsJ1ME1BU(int from, int until) {
        if (!(UnsignedKt.uintCompare(until, from) > 0)) {
            throw new IllegalArgumentException(RandomKt.boundsErrorMessage(UInt.m117boximpl(from), UInt.m117boximpl(until)).toString());
        }
    }

    /* renamed from: checkULongRangeBounds-eb3DHEI  reason: not valid java name */
    public static final void m1226checkULongRangeBoundseb3DHEI(long from, long until) {
        if (!(UnsignedKt.ulongCompare(until, from) > 0)) {
            throw new IllegalArgumentException(RandomKt.boundsErrorMessage(ULong.m195boximpl(from), ULong.m195boximpl(until)).toString());
        }
    }
}
