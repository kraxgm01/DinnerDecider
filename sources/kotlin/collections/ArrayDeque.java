package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0007\u0018\u0000 P*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001PB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0007\b\u0016¢\u0006\u0002\u0010\u0006B\u0015\b\u0016\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010\tJ\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u001d\u0010\u0013\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u0016\u0010\u001a\u001a\u00020\u00142\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u0013\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ\b\u0010\u001e\u001a\u00020\u0017H\u0016J\u0016\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0016J\u001e\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0002J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0004H\u0002J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0004H\u0002J\u001d\u0010'\u001a\u00020\u00142\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00140)H\bJ\u000b\u0010*\u001a\u00028\u0000¢\u0006\u0002\u0010+J\r\u0010,\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u0016\u0010-\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0015\u00100\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00101J\u0016\u00102\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u0004H\b¢\u0006\u0002\u0010.J\u0011\u0010!\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\bJM\u00103\u001a\u00020\u00172>\u00104\u001a:\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(\u000e\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u001705H\u0000¢\u0006\u0002\b8J\b\u00109\u001a\u00020\u0014H\u0016J\u000b\u0010:\u001a\u00028\u0000¢\u0006\u0002\u0010+J\u0015\u0010;\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00101J\r\u0010<\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u0010\u0010=\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010>\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0015\u0010?\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u0016\u0010@\u001a\u00020\u00142\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u0015\u0010A\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010.J\u000b\u0010B\u001a\u00028\u0000¢\u0006\u0002\u0010+J\r\u0010C\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u000b\u0010D\u001a\u00028\u0000¢\u0006\u0002\u0010+J\r\u0010E\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u0016\u0010F\u001a\u00020\u00142\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u001e\u0010G\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010HJ\u0017\u0010I\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0000¢\u0006\u0004\bJ\u0010KJ)\u0010I\u001a\b\u0012\u0004\u0012\u0002HL0\u000b\"\u0004\b\u0001\u0010L2\f\u0010M\u001a\b\u0012\u0004\u0012\u0002HL0\u000bH\u0000¢\u0006\u0004\bJ\u0010NJ\u0015\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0016¢\u0006\u0002\u0010KJ'\u0010O\u001a\b\u0012\u0004\u0012\u0002HL0\u000b\"\u0004\b\u0001\u0010L2\f\u0010M\u001a\b\u0012\u0004\u0012\u0002HL0\u000bH\u0016¢\u0006\u0002\u0010NR\u0018\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006Q"}, d2 = {"Lkotlin/collections/ArrayDeque;", "E", "Lkotlin/collections/AbstractMutableList;", "initialCapacity", "", "(I)V", "()V", "elements", "", "(Ljava/util/Collection;)V", "elementData", "", "", "[Ljava/lang/Object;", "head", "<set-?>", "size", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "addFirst", "(Ljava/lang/Object;)V", "addLast", "clear", "contains", "copyCollectionElements", "internalIndex", "copyElements", "newCapacity", "decremented", "ensureCapacity", "minCapacity", "filterInPlace", "predicate", "Lkotlin/Function1;", "first", "()Ljava/lang/Object;", "firstOrNull", "get", "(I)Ljava/lang/Object;", "incremented", "indexOf", "(Ljava/lang/Object;)I", "internalGet", "internalStructure", "structure", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "internalStructure$kotlin_stdlib", "isEmpty", "last", "lastIndexOf", "lastOrNull", "negativeMod", "positiveMod", "remove", "removeAll", "removeAt", "removeFirst", "removeFirstOrNull", "removeLast", "removeLastOrNull", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "testToArray", "testToArray$kotlin_stdlib", "()[Ljava/lang/Object;", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toArray", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ArrayDeque.kt */
public final class ArrayDeque<E> extends AbstractMutableList<E> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int defaultMinCapacity = 10;
    private static final Object[] emptyElementData = new Object[0];
    private static final int maxArraySize = 2147483639;
    /* access modifiers changed from: private */
    public Object[] elementData;
    /* access modifiers changed from: private */
    public int head;
    /* access modifiers changed from: private */
    public int size;

    public int getSize() {
        return this.size;
    }

    public ArrayDeque(int initialCapacity) {
        Object[] objArr;
        if (initialCapacity == 0) {
            objArr = emptyElementData;
        } else if (initialCapacity > 0) {
            objArr = new Object[initialCapacity];
        } else {
            throw new IllegalArgumentException(Intrinsics.stringPlus("Illegal Capacity: ", Integer.valueOf(initialCapacity)));
        }
        this.elementData = objArr;
    }

    public ArrayDeque() {
        this.elementData = emptyElementData;
    }

    public ArrayDeque(Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        boolean z = false;
        Object[] array = elements.toArray(new Object[0]);
        if (array != null) {
            this.elementData = array;
            this.size = array.length;
            if (array.length == 0 ? true : z) {
                this.elementData = emptyElementData;
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    private final void ensureCapacity(int minCapacity) {
        if (minCapacity >= 0) {
            Object[] objArr = this.elementData;
            if (minCapacity > objArr.length) {
                if (objArr == emptyElementData) {
                    this.elementData = new Object[RangesKt.coerceAtLeast(minCapacity, 10)];
                } else {
                    copyElements(Companion.newCapacity$kotlin_stdlib(objArr.length, minCapacity));
                }
            }
        } else {
            throw new IllegalStateException("Deque is too big.");
        }
    }

    private final void copyElements(int newCapacity) {
        Object[] newElements = new Object[newCapacity];
        Object[] objArr = this.elementData;
        ArraysKt.copyInto((T[]) objArr, (T[]) newElements, 0, this.head, objArr.length);
        Object[] objArr2 = this.elementData;
        int length = objArr2.length;
        int i = this.head;
        ArraysKt.copyInto((T[]) objArr2, (T[]) newElements, length - i, 0, i);
        this.head = 0;
        this.elementData = newElements;
    }

    private final E internalGet(int internalIndex) {
        return this.elementData[internalIndex];
    }

    /* access modifiers changed from: private */
    public final int positiveMod(int index) {
        Object[] objArr = this.elementData;
        return index >= objArr.length ? index - objArr.length : index;
    }

    /* access modifiers changed from: private */
    public final int negativeMod(int index) {
        return index < 0 ? this.elementData.length + index : index;
    }

    private final int internalIndex(int index) {
        return positiveMod(this.head + index);
    }

    /* access modifiers changed from: private */
    public final int incremented(int index) {
        if (index == ArraysKt.getLastIndex((T[]) this.elementData)) {
            return 0;
        }
        return index + 1;
    }

    private final int decremented(int index) {
        return index == 0 ? ArraysKt.getLastIndex((T[]) this.elementData) : index - 1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public final E first() {
        if (!isEmpty()) {
            return this.elementData[this.head];
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E firstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return this.elementData[this.head];
    }

    public final E last() {
        if (!isEmpty()) {
            return this.elementData[positiveMod(this.head + CollectionsKt.getLastIndex(this))];
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E lastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return this.elementData[positiveMod(this.head + CollectionsKt.getLastIndex(this))];
    }

    public final void addFirst(E element) {
        ensureCapacity(size() + 1);
        int decremented = decremented(this.head);
        this.head = decremented;
        this.elementData[decremented] = element;
        this.size = size() + 1;
    }

    public final void addLast(E element) {
        ensureCapacity(size() + 1);
        this.elementData[positiveMod(this.head + size())] = element;
        this.size = size() + 1;
    }

    public final E removeFirst() {
        if (!isEmpty()) {
            Object element = this.elementData[this.head];
            Object[] objArr = this.elementData;
            int i = this.head;
            objArr[i] = null;
            this.head = incremented(i);
            this.size = size() - 1;
            return element;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E removeFirstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    public final E removeLast() {
        if (!isEmpty()) {
            int internalLastIndex = positiveMod(this.head + CollectionsKt.getLastIndex(this));
            Object element = this.elementData[internalLastIndex];
            this.elementData[internalLastIndex] = null;
            this.size = size() - 1;
            return element;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E removeLastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    public boolean add(E element) {
        addLast(element);
        return true;
    }

    public void add(int index, E element) {
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(index, size());
        if (index == size()) {
            addLast(element);
        } else if (index == 0) {
            addFirst(element);
        } else {
            ensureCapacity(size() + 1);
            int internalIndex = positiveMod(this.head + index);
            if (index < ((size() + 1) >> 1)) {
                int decrementedInternalIndex = decremented(internalIndex);
                int decrementedHead = decremented(this.head);
                int i = this.head;
                if (decrementedInternalIndex >= i) {
                    Object[] objArr = this.elementData;
                    objArr[decrementedHead] = objArr[i];
                    ArraysKt.copyInto((T[]) objArr, (T[]) objArr, i, i + 1, decrementedInternalIndex + 1);
                } else {
                    Object[] objArr2 = this.elementData;
                    ArraysKt.copyInto((T[]) objArr2, (T[]) objArr2, i - 1, i, objArr2.length);
                    Object[] objArr3 = this.elementData;
                    objArr3[objArr3.length - 1] = objArr3[0];
                    ArraysKt.copyInto((T[]) objArr3, (T[]) objArr3, 0, 1, decrementedInternalIndex + 1);
                }
                this.elementData[decrementedInternalIndex] = element;
                this.head = decrementedHead;
            } else {
                int tail = positiveMod(this.head + size());
                if (internalIndex < tail) {
                    Object[] objArr4 = this.elementData;
                    ArraysKt.copyInto((T[]) objArr4, (T[]) objArr4, internalIndex + 1, internalIndex, tail);
                } else {
                    Object[] objArr5 = this.elementData;
                    ArraysKt.copyInto((T[]) objArr5, (T[]) objArr5, 1, 0, tail);
                    Object[] objArr6 = this.elementData;
                    objArr6[0] = objArr6[objArr6.length - 1];
                    ArraysKt.copyInto((T[]) objArr6, (T[]) objArr6, internalIndex + 1, internalIndex, objArr6.length - 1);
                }
                this.elementData[internalIndex] = element;
            }
            this.size = size() + 1;
        }
    }

    private final void copyCollectionElements(int internalIndex, Collection<? extends E> elements) {
        Iterator iterator = elements.iterator();
        int length = this.elementData.length;
        int i = internalIndex;
        while (i < length) {
            int index = i;
            i++;
            if (!iterator.hasNext()) {
                break;
            }
            this.elementData[index] = iterator.next();
        }
        int i2 = 0;
        int i3 = this.head;
        while (i2 < i3) {
            int index2 = i2;
            i2++;
            if (!iterator.hasNext()) {
                break;
            }
            this.elementData[index2] = iterator.next();
        }
        this.size = size() + elements.size();
    }

    public boolean addAll(Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        ensureCapacity(size() + elements.size());
        copyCollectionElements(positiveMod(this.head + size()), elements);
        return true;
    }

    public boolean addAll(int index, Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(index, size());
        if (elements.isEmpty()) {
            return false;
        }
        if (index == size()) {
            return addAll(elements);
        }
        ensureCapacity(size() + elements.size());
        int tail = positiveMod(this.head + size());
        int internalIndex = positiveMod(this.head + index);
        int elementsSize = elements.size();
        if (index < ((size() + 1) >> 1)) {
            int i = this.head;
            int shiftedHead = i - elementsSize;
            if (internalIndex < i) {
                Object[] objArr = this.elementData;
                ArraysKt.copyInto((T[]) objArr, (T[]) objArr, shiftedHead, i, objArr.length);
                if (elementsSize >= internalIndex) {
                    Object[] objArr2 = this.elementData;
                    ArraysKt.copyInto((T[]) objArr2, (T[]) objArr2, objArr2.length - elementsSize, 0, internalIndex);
                } else {
                    Object[] objArr3 = this.elementData;
                    ArraysKt.copyInto((T[]) objArr3, (T[]) objArr3, objArr3.length - elementsSize, 0, elementsSize);
                    Object[] objArr4 = this.elementData;
                    ArraysKt.copyInto((T[]) objArr4, (T[]) objArr4, 0, elementsSize, internalIndex);
                }
            } else if (shiftedHead >= 0) {
                Object[] objArr5 = this.elementData;
                ArraysKt.copyInto((T[]) objArr5, (T[]) objArr5, shiftedHead, i, internalIndex);
            } else {
                Object[] objArr6 = this.elementData;
                shiftedHead += objArr6.length;
                int elementsToShift = internalIndex - i;
                int shiftToBack = objArr6.length - shiftedHead;
                if (shiftToBack >= elementsToShift) {
                    ArraysKt.copyInto((T[]) objArr6, (T[]) objArr6, shiftedHead, i, internalIndex);
                } else {
                    ArraysKt.copyInto((T[]) objArr6, (T[]) objArr6, shiftedHead, i, i + shiftToBack);
                    Object[] objArr7 = this.elementData;
                    ArraysKt.copyInto((T[]) objArr7, (T[]) objArr7, 0, this.head + shiftToBack, internalIndex);
                }
            }
            this.head = shiftedHead;
            copyCollectionElements(negativeMod(internalIndex - elementsSize), elements);
        } else {
            int shiftedInternalIndex = internalIndex + elementsSize;
            if (internalIndex < tail) {
                int i2 = tail + elementsSize;
                Object[] objArr8 = this.elementData;
                if (i2 <= objArr8.length) {
                    ArraysKt.copyInto((T[]) objArr8, (T[]) objArr8, shiftedInternalIndex, internalIndex, tail);
                } else if (shiftedInternalIndex >= objArr8.length) {
                    ArraysKt.copyInto((T[]) objArr8, (T[]) objArr8, shiftedInternalIndex - objArr8.length, internalIndex, tail);
                } else {
                    int shiftToFront = (tail + elementsSize) - objArr8.length;
                    ArraysKt.copyInto((T[]) objArr8, (T[]) objArr8, 0, tail - shiftToFront, tail);
                    Object[] objArr9 = this.elementData;
                    ArraysKt.copyInto((T[]) objArr9, (T[]) objArr9, shiftedInternalIndex, internalIndex, tail - shiftToFront);
                }
            } else {
                Object[] objArr10 = this.elementData;
                ArraysKt.copyInto((T[]) objArr10, (T[]) objArr10, elementsSize, 0, tail);
                Object[] objArr11 = this.elementData;
                if (shiftedInternalIndex >= objArr11.length) {
                    ArraysKt.copyInto((T[]) objArr11, (T[]) objArr11, shiftedInternalIndex - objArr11.length, internalIndex, objArr11.length);
                } else {
                    ArraysKt.copyInto((T[]) objArr11, (T[]) objArr11, 0, objArr11.length - elementsSize, objArr11.length);
                    Object[] objArr12 = this.elementData;
                    ArraysKt.copyInto((T[]) objArr12, (T[]) objArr12, shiftedInternalIndex, internalIndex, objArr12.length - elementsSize);
                }
            }
            copyCollectionElements(internalIndex, elements);
        }
        return true;
    }

    public E get(int index) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, size());
        return this.elementData[positiveMod(this.head + index)];
    }

    public E set(int index, E element) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, size());
        int internalIndex = positiveMod(this.head + index);
        Object oldElement = this.elementData[internalIndex];
        this.elementData[internalIndex] = element;
        return oldElement;
    }

    public boolean contains(Object element) {
        return indexOf(element) != -1;
    }

    public int indexOf(Object element) {
        int tail = positiveMod(this.head + size());
        int i = this.head;
        if (i < tail) {
            while (i < tail) {
                int index = i;
                i++;
                if (Intrinsics.areEqual(element, this.elementData[index])) {
                    return index - this.head;
                }
            }
            return -1;
        } else if (i < tail) {
            return -1;
        } else {
            int length = this.elementData.length;
            while (i < length) {
                int index2 = i;
                i++;
                if (Intrinsics.areEqual(element, this.elementData[index2])) {
                    return index2 - this.head;
                }
            }
            int i2 = 0;
            while (i2 < tail) {
                int index3 = i2;
                i2++;
                if (Intrinsics.areEqual(element, this.elementData[index3])) {
                    return (this.elementData.length + index3) - this.head;
                }
            }
            return -1;
        }
    }

    public int lastIndexOf(Object element) {
        int index;
        int index2;
        int tail = positiveMod(this.head + size());
        int i = this.head;
        if (i < tail) {
            int i2 = tail - 1;
            if (i <= i2) {
                do {
                    index2 = i2;
                    i2--;
                    if (Intrinsics.areEqual(element, this.elementData[index2])) {
                        return index2 - this.head;
                    }
                } while (index2 != i);
            }
        } else if (i > tail) {
            int i3 = tail - 1;
            if (i3 >= 0) {
                do {
                    int index3 = i3;
                    i3--;
                    if (Intrinsics.areEqual(element, this.elementData[index3])) {
                        return (this.elementData.length + index3) - this.head;
                    }
                } while (i3 >= 0);
            }
            int lastIndex = ArraysKt.getLastIndex((T[]) this.elementData);
            int i4 = this.head;
            if (i4 <= lastIndex) {
                do {
                    index = lastIndex;
                    lastIndex--;
                    if (Intrinsics.areEqual(element, this.elementData[index])) {
                        return index - this.head;
                    }
                } while (index != i4);
            }
        }
        return -1;
    }

    public boolean remove(Object element) {
        int index = indexOf(element);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    public E removeAt(int index) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, size());
        if (index == CollectionsKt.getLastIndex(this)) {
            return removeLast();
        }
        if (index == 0) {
            return removeFirst();
        }
        int internalIndex = positiveMod(this.head + index);
        Object element = this.elementData[internalIndex];
        if (index < (size() >> 1)) {
            int i = this.head;
            if (internalIndex >= i) {
                Object[] objArr = this.elementData;
                ArraysKt.copyInto((T[]) objArr, (T[]) objArr, i + 1, i, internalIndex);
            } else {
                Object[] objArr2 = this.elementData;
                ArraysKt.copyInto((T[]) objArr2, (T[]) objArr2, 1, 0, internalIndex);
                Object[] objArr3 = this.elementData;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i2 = this.head;
                ArraysKt.copyInto((T[]) objArr3, (T[]) objArr3, i2 + 1, i2, objArr3.length - 1);
            }
            Object[] objArr4 = this.elementData;
            int i3 = this.head;
            objArr4[i3] = null;
            this.head = incremented(i3);
        } else {
            int internalLastIndex = positiveMod(this.head + CollectionsKt.getLastIndex(this));
            if (internalIndex <= internalLastIndex) {
                Object[] objArr5 = this.elementData;
                ArraysKt.copyInto((T[]) objArr5, (T[]) objArr5, internalIndex, internalIndex + 1, internalLastIndex + 1);
            } else {
                Object[] objArr6 = this.elementData;
                ArraysKt.copyInto((T[]) objArr6, (T[]) objArr6, internalIndex, internalIndex + 1, objArr6.length);
                Object[] objArr7 = this.elementData;
                objArr7[objArr7.length - 1] = objArr7[0];
                ArraysKt.copyInto((T[]) objArr7, (T[]) objArr7, 0, 1, internalLastIndex + 1);
            }
            this.elementData[internalLastIndex] = null;
        }
        this.size = size() - 1;
        return element;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: type inference failed for: r4v3, types: [int] */
    /* JADX WARNING: type inference failed for: r4v4 */
    /* JADX WARNING: type inference failed for: r4v9 */
    /* JADX WARNING: type inference failed for: r4v11 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean removeAll(java.util.Collection<? extends java.lang.Object> r17) {
        /*
            r16 = this;
            r0 = r17
            java.lang.String r1 = "elements"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r1 = r16
            r2 = 0
            boolean r3 = r1.isEmpty()
            r4 = 0
            if (r3 != 0) goto L_0x00d5
            java.lang.Object[] r3 = r1.elementData
            int r3 = r3.length
            r5 = 1
            if (r3 != 0) goto L_0x001b
            r3 = r5
            goto L_0x001c
        L_0x001b:
            r3 = r4
        L_0x001c:
            if (r3 == 0) goto L_0x0020
            goto L_0x00d5
        L_0x0020:
            int r3 = r1.size()
            int r6 = r1.head
            int r6 = r6 + r3
            int r3 = r1.positiveMod(r6)
            int r6 = r1.head
            r7 = 0
            int r8 = r1.head
            r9 = 0
            if (r8 >= r3) goto L_0x0067
            int r4 = r1.head
        L_0x003d:
            if (r4 >= r3) goto L_0x005e
            r8 = r4
            int r4 = r4 + 1
            java.lang.Object[] r10 = r1.elementData
            r10 = r10[r8]
            r11 = r10
            r12 = 0
            boolean r13 = r0.contains(r11)
            r11 = r13 ^ 1
            if (r11 == 0) goto L_0x005c
            java.lang.Object[] r11 = r1.elementData
            int r12 = r6 + 1
            r11[r6] = r10
            r6 = r12
            goto L_0x003d
        L_0x005c:
            r7 = 1
            goto L_0x003d
        L_0x005e:
            java.lang.Object[] r4 = r1.elementData
            kotlin.collections.ArraysKt.fill((T[]) r4, r9, (int) r6, (int) r3)
            r4 = r7
            goto L_0x00c5
        L_0x0067:
            int r8 = r1.head
            java.lang.Object[] r10 = r1.elementData
            int r10 = r10.length
        L_0x0070:
            if (r8 >= r10) goto L_0x0097
            r11 = r8
            int r8 = r8 + 1
            java.lang.Object[] r12 = r1.elementData
            r12 = r12[r11]
            java.lang.Object[] r13 = r1.elementData
            r13[r11] = r9
            r13 = r12
            r14 = 0
            boolean r15 = r0.contains(r13)
            r13 = r15 ^ 1
            if (r13 == 0) goto L_0x0095
            java.lang.Object[] r13 = r1.elementData
            int r14 = r6 + 1
            r13[r6] = r12
            r6 = r14
            goto L_0x0070
        L_0x0095:
            r7 = 1
            goto L_0x0070
        L_0x0097:
            int r6 = r1.positiveMod(r6)
        L_0x009c:
            if (r4 >= r3) goto L_0x00c4
            r8 = r4
            int r4 = r4 + 1
            java.lang.Object[] r10 = r1.elementData
            r10 = r10[r8]
            java.lang.Object[] r11 = r1.elementData
            r11[r8] = r9
            r11 = r10
            r12 = 0
            boolean r13 = r0.contains(r11)
            r11 = r13 ^ 1
            if (r11 == 0) goto L_0x00c2
            java.lang.Object[] r11 = r1.elementData
            r11[r6] = r10
            int r6 = r1.incremented(r6)
            goto L_0x009c
        L_0x00c2:
            r7 = 1
            goto L_0x009c
        L_0x00c4:
            r4 = r7
        L_0x00c5:
            if (r4 == 0) goto L_0x00d4
            int r5 = r1.head
            int r5 = r6 - r5
            int r5 = r1.negativeMod(r5)
            r1.size = r5
        L_0x00d4:
            goto L_0x00d6
        L_0x00d5:
        L_0x00d6:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.ArrayDeque.removeAll(java.util.Collection):boolean");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r3v3, types: [int] */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: type inference failed for: r3v11 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean retainAll(java.util.Collection<? extends java.lang.Object> r14) {
        /*
            r13 = this;
            java.lang.String r0 = "elements"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = r13
            r1 = 0
            boolean r2 = r0.isEmpty()
            r3 = 0
            if (r2 != 0) goto L_0x00cb
            java.lang.Object[] r2 = r0.elementData
            int r2 = r2.length
            if (r2 != 0) goto L_0x0017
            r2 = 1
            goto L_0x0018
        L_0x0017:
            r2 = r3
        L_0x0018:
            if (r2 == 0) goto L_0x001c
            goto L_0x00cb
        L_0x001c:
            int r2 = r0.size()
            int r4 = r0.head
            int r4 = r4 + r2
            int r2 = r0.positiveMod(r4)
            int r4 = r0.head
            r5 = 0
            int r6 = r0.head
            r7 = 0
            if (r6 >= r2) goto L_0x0061
            int r3 = r0.head
        L_0x0039:
            if (r3 >= r2) goto L_0x0058
            r6 = r3
            int r3 = r3 + 1
            java.lang.Object[] r8 = r0.elementData
            r8 = r8[r6]
            r9 = r8
            r10 = 0
            boolean r9 = r14.contains(r9)
            if (r9 == 0) goto L_0x0056
            java.lang.Object[] r9 = r0.elementData
            int r10 = r4 + 1
            r9[r4] = r8
            r4 = r10
            goto L_0x0039
        L_0x0056:
            r5 = 1
            goto L_0x0039
        L_0x0058:
            java.lang.Object[] r3 = r0.elementData
            kotlin.collections.ArraysKt.fill((T[]) r3, r7, (int) r4, (int) r2)
            r3 = r5
            goto L_0x00bb
        L_0x0061:
            int r6 = r0.head
            java.lang.Object[] r8 = r0.elementData
            int r8 = r8.length
        L_0x006a:
            if (r6 >= r8) goto L_0x008f
            r9 = r6
            int r6 = r6 + 1
            java.lang.Object[] r10 = r0.elementData
            r10 = r10[r9]
            java.lang.Object[] r11 = r0.elementData
            r11[r9] = r7
            r11 = r10
            r12 = 0
            boolean r11 = r14.contains(r11)
            if (r11 == 0) goto L_0x008d
            java.lang.Object[] r11 = r0.elementData
            int r12 = r4 + 1
            r11[r4] = r10
            r4 = r12
            goto L_0x006a
        L_0x008d:
            r5 = 1
            goto L_0x006a
        L_0x008f:
            int r4 = r0.positiveMod(r4)
        L_0x0094:
            if (r3 >= r2) goto L_0x00ba
            r6 = r3
            int r3 = r3 + 1
            java.lang.Object[] r8 = r0.elementData
            r8 = r8[r6]
            java.lang.Object[] r9 = r0.elementData
            r9[r6] = r7
            r9 = r8
            r10 = 0
            boolean r9 = r14.contains(r9)
            if (r9 == 0) goto L_0x00b8
            java.lang.Object[] r9 = r0.elementData
            r9[r4] = r8
            int r4 = r0.incremented(r4)
            goto L_0x0094
        L_0x00b8:
            r5 = 1
            goto L_0x0094
        L_0x00ba:
            r3 = r5
        L_0x00bb:
            if (r3 == 0) goto L_0x00ca
            int r5 = r0.head
            int r5 = r4 - r5
            int r5 = r0.negativeMod(r5)
            r0.size = r5
        L_0x00ca:
            goto L_0x00cc
        L_0x00cb:
        L_0x00cc:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.ArrayDeque.retainAll(java.util.Collection):boolean");
    }

    private final boolean filterInPlace(Function1<? super E, Boolean> predicate) {
        int i = 0;
        if (!isEmpty()) {
            if (!(this.elementData.length == 0)) {
                int tail = positiveMod(this.head + size());
                int newTail = this.head;
                boolean modified = false;
                if (this.head < tail) {
                    int access$getHead$p = this.head;
                    while (access$getHead$p < tail) {
                        int index = access$getHead$p;
                        access$getHead$p++;
                        Object element = this.elementData[index];
                        if (predicate.invoke(element).booleanValue()) {
                            this.elementData[newTail] = element;
                            newTail++;
                        } else {
                            modified = true;
                        }
                    }
                    ArraysKt.fill((T[]) this.elementData, null, newTail, tail);
                } else {
                    int access$getHead$p2 = this.head;
                    int length = this.elementData.length;
                    while (access$getHead$p2 < length) {
                        int index2 = access$getHead$p2;
                        access$getHead$p2++;
                        Object element2 = this.elementData[index2];
                        this.elementData[index2] = null;
                        if (predicate.invoke(element2).booleanValue()) {
                            this.elementData[newTail] = element2;
                            newTail++;
                        } else {
                            modified = true;
                        }
                    }
                    newTail = positiveMod(newTail);
                    while (i < tail) {
                        int index3 = i;
                        i++;
                        Object element3 = this.elementData[index3];
                        this.elementData[index3] = null;
                        if (predicate.invoke(element3).booleanValue()) {
                            this.elementData[newTail] = element3;
                            newTail = incremented(newTail);
                        } else {
                            modified = true;
                        }
                    }
                }
                if (modified) {
                    this.size = negativeMod(newTail - this.head);
                }
                return modified;
            }
        }
        return false;
    }

    public void clear() {
        int tail = positiveMod(this.head + size());
        int i = this.head;
        if (i < tail) {
            ArraysKt.fill((T[]) this.elementData, null, i, tail);
        } else if (!isEmpty()) {
            Object[] objArr = this.elementData;
            ArraysKt.fill((T[]) objArr, null, this.head, objArr.length);
            ArraysKt.fill((T[]) this.elementData, null, 0, tail);
        }
        this.head = 0;
        this.size = 0;
    }

    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        T[] arrayOfNulls = array.length >= size() ? array : ArraysKt.arrayOfNulls(array, size());
        int tail = positiveMod(this.head + size());
        int i = this.head;
        if (i < tail) {
            ArraysKt.copyInto$default(this.elementData, (Object[]) arrayOfNulls, 0, i, tail, 2, (Object) null);
        } else if (!isEmpty()) {
            Object[] objArr = this.elementData;
            ArraysKt.copyInto((T[]) objArr, arrayOfNulls, 0, this.head, objArr.length);
            Object[] objArr2 = this.elementData;
            ArraysKt.copyInto((T[]) objArr2, arrayOfNulls, objArr2.length - this.head, 0, tail);
        }
        if (arrayOfNulls.length > size()) {
            arrayOfNulls[size()] = null;
        }
        return arrayOfNulls;
    }

    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    public final <T> T[] testToArray$kotlin_stdlib(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return toArray(array);
    }

    public final Object[] testToArray$kotlin_stdlib() {
        return toArray();
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlin/collections/ArrayDeque$Companion;", "", "()V", "defaultMinCapacity", "", "emptyElementData", "", "[Ljava/lang/Object;", "maxArraySize", "newCapacity", "oldCapacity", "minCapacity", "newCapacity$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ArrayDeque.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int newCapacity$kotlin_stdlib(int oldCapacity, int minCapacity) {
            int newCapacity = (oldCapacity >> 1) + oldCapacity;
            if (newCapacity - minCapacity < 0) {
                newCapacity = minCapacity;
            }
            int newCapacity2 = ArrayDeque.maxArraySize;
            if (newCapacity - ArrayDeque.maxArraySize <= 0) {
                return newCapacity;
            }
            if (minCapacity > ArrayDeque.maxArraySize) {
                newCapacity2 = Integer.MAX_VALUE;
            }
            return newCapacity2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0018, code lost:
        r1 = r4.head;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void internalStructure$kotlin_stdlib(kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Object[], kotlin.Unit> r5) {
        /*
            r4 = this;
            java.lang.String r0 = "structure"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            int r0 = r4.size()
            int r1 = r4.head
            int r1 = r1 + r0
            int r0 = r4.positiveMod(r1)
            boolean r1 = r4.isEmpty()
            if (r1 != 0) goto L_0x0022
            int r1 = r4.head
            if (r1 >= r0) goto L_0x001d
            goto L_0x0022
        L_0x001d:
            java.lang.Object[] r2 = r4.elementData
            int r2 = r2.length
            int r1 = r1 - r2
            goto L_0x0024
        L_0x0022:
            int r1 = r4.head
        L_0x0024:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            java.lang.Object[] r3 = r4.toArray()
            r5.invoke(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.ArrayDeque.internalStructure$kotlin_stdlib(kotlin.jvm.functions.Function2):void");
    }
}
