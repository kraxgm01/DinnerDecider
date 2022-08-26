package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\u001a!\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0002\b\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0002¢\u0006\u0002\b\u0007\u001a\u0014\u0010\b\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001aJ\u0010\t\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\b¢\u0006\u0002\b\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u001a\u001e\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u001a\n\u0010\u0013\u001a\u00020\u0002*\u00020\u0002\u001a\u0014\u0010\u0014\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002¨\u0006\u0015"}, d2 = {"getIndentFunction", "Lkotlin/Function1;", "", "indent", "getIndentFunction$StringsKt__IndentKt", "indentWidth", "", "indentWidth$StringsKt__IndentKt", "prependIndent", "reindent", "", "resultSizeEstimate", "indentAddFunction", "indentCutFunction", "reindent$StringsKt__IndentKt", "replaceIndent", "newIndent", "replaceIndentByMargin", "marginPrefix", "trimIndent", "trimMargin", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/text/StringsKt")
/* compiled from: Indent.kt */
class StringsKt__IndentKt extends StringsKt__AppendableKt {
    public static /* synthetic */ String trimMargin$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "|";
        }
        return StringsKt.trimMargin(str, str2);
    }

    public static final String trimMargin(String $this$trimMargin, String marginPrefix) {
        Intrinsics.checkNotNullParameter($this$trimMargin, "<this>");
        Intrinsics.checkNotNullParameter(marginPrefix, "marginPrefix");
        return StringsKt.replaceIndentByMargin($this$trimMargin, "", marginPrefix);
    }

    public static /* synthetic */ String replaceIndentByMargin$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "";
        }
        if ((i & 2) != 0) {
            str3 = "|";
        }
        return StringsKt.replaceIndentByMargin(str, str2, str3);
    }

    public static final String replaceIndentByMargin(String $this$replaceIndentByMargin, String newIndent, String marginPrefix) {
        Collection destination$iv$iv$iv;
        int i;
        String str;
        String str2 = $this$replaceIndentByMargin;
        String str3 = marginPrefix;
        Intrinsics.checkNotNullParameter(str2, "<this>");
        Intrinsics.checkNotNullParameter(newIndent, "newIndent");
        Intrinsics.checkNotNullParameter(str3, "marginPrefix");
        if (!StringsKt.isBlank(str3)) {
            List lines = StringsKt.lines(str2);
            int resultSizeEstimate$iv = $this$replaceIndentByMargin.length() + (newIndent.length() * lines.size());
            Function1 indentAddFunction$iv = getIndentFunction$StringsKt__IndentKt(newIndent);
            List $this$reindent$iv = lines;
            int lastIndex$iv = CollectionsKt.getLastIndex($this$reindent$iv);
            Collection destination$iv$iv$iv2 = new ArrayList();
            int index$iv$iv$iv$iv = 0;
            for (Object item$iv$iv$iv$iv : $this$reindent$iv) {
                int index$iv$iv$iv$iv2 = index$iv$iv$iv$iv + 1;
                if (index$iv$iv$iv$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String value$iv = (String) item$iv$iv$iv$iv;
                int index$iv = index$iv$iv$iv$iv;
                String it$iv$iv$iv = null;
                if ((index$iv == 0 || index$iv == lastIndex$iv) && StringsKt.isBlank(value$iv)) {
                    int i2 = index$iv;
                    destination$iv$iv$iv = destination$iv$iv$iv2;
                } else {
                    String line = value$iv;
                    CharSequence $this$indexOfFirst$iv = line;
                    int index$iv2 = 0;
                    int length = $this$indexOfFirst$iv.length();
                    int i3 = 0;
                    while (true) {
                        int $i$f$indexOfFirst = index$iv2;
                        if (i3 >= length) {
                            i = -1;
                            break;
                        }
                        int index$iv3 = i3;
                        i3++;
                        int index$iv4 = index$iv3;
                        if ((CharsKt.isWhitespace($this$indexOfFirst$iv.charAt(index$iv4)) ^ 1) != 0) {
                            i = index$iv4;
                            break;
                        }
                        index$iv2 = $i$f$indexOfFirst;
                    }
                    int firstNonWhitespaceIndex = i;
                    if (firstNonWhitespaceIndex == -1) {
                        String str4 = line;
                        int i4 = index$iv;
                        destination$iv$iv$iv = destination$iv$iv$iv2;
                        str = null;
                    } else {
                        String line2 = line;
                        int i5 = index$iv;
                        destination$iv$iv$iv = destination$iv$iv$iv2;
                        if (StringsKt.startsWith$default(line, marginPrefix, firstNonWhitespaceIndex, false, 4, (Object) null)) {
                            str = line2.substring(marginPrefix.length() + firstNonWhitespaceIndex);
                            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).substring(startIndex)");
                        } else {
                            str = null;
                        }
                    }
                    it$iv$iv$iv = str == null ? value$iv : (String) indentAddFunction$iv.invoke(str);
                }
                if (it$iv$iv$iv != null) {
                    destination$iv$iv$iv.add(it$iv$iv$iv);
                }
                Object it$iv$iv$iv2 = $this$replaceIndentByMargin;
                destination$iv$iv$iv2 = destination$iv$iv$iv;
                index$iv$iv$iv$iv = index$iv$iv$iv$iv2;
                String str5 = marginPrefix;
            }
            String sb = ((StringBuilder) CollectionsKt.joinTo$default((List) destination$iv$iv$iv2, new StringBuilder(resultSizeEstimate$iv), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 124, (Object) null)).toString();
            Intrinsics.checkNotNullExpressionValue(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
            return sb;
        }
        throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
    }

    public static final String trimIndent(String $this$trimIndent) {
        Intrinsics.checkNotNullParameter($this$trimIndent, "<this>");
        return StringsKt.replaceIndent($this$trimIndent, "");
    }

    public static /* synthetic */ String replaceIndent$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "";
        }
        return StringsKt.replaceIndent(str, str2);
    }

    public static final String replaceIndent(String $this$replaceIndent, String newIndent) {
        int minCommonIndent;
        String it$iv$iv$iv;
        String str = $this$replaceIndent;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(newIndent, "newIndent");
        List $this$filter$iv = StringsKt.lines(str);
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            if (!StringsKt.isBlank((String) element$iv$iv)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable<String> $this$map$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (String p0 : $this$map$iv) {
            destination$iv$iv2.add(Integer.valueOf(indentWidth$StringsKt__IndentKt(p0)));
        }
        Integer num = (Integer) CollectionsKt.minOrNull((List) destination$iv$iv2);
        if (num == null) {
            minCommonIndent = 0;
        } else {
            minCommonIndent = num.intValue();
        }
        int resultSizeEstimate$iv = $this$replaceIndent.length() + (newIndent.length() * $this$filter$iv.size());
        Function1 indentAddFunction$iv = getIndentFunction$StringsKt__IndentKt(newIndent);
        List $this$reindent$iv = $this$filter$iv;
        int lastIndex$iv = CollectionsKt.getLastIndex($this$reindent$iv);
        Collection destination$iv$iv$iv = new ArrayList();
        int index$iv$iv$iv = 0;
        for (Object item$iv$iv$iv$iv : $this$reindent$iv) {
            int index$iv$iv$iv$iv = index$iv$iv$iv + 1;
            if (index$iv$iv$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String value$iv = (String) item$iv$iv$iv$iv;
            int index$iv = index$iv$iv$iv;
            if ((index$iv == 0 || index$iv == lastIndex$iv) && StringsKt.isBlank(value$iv)) {
                it$iv$iv$iv = null;
                int i = index$iv;
            } else {
                int i2 = index$iv;
                String line = StringsKt.drop(value$iv, minCommonIndent);
                it$iv$iv$iv = line == null ? value$iv : (String) indentAddFunction$iv.invoke(line);
            }
            if (it$iv$iv$iv != null) {
                destination$iv$iv$iv.add(it$iv$iv$iv);
            }
            Object it$iv$iv$iv2 = $this$replaceIndent;
            index$iv$iv$iv = index$iv$iv$iv$iv;
        }
        String sb = ((StringBuilder) CollectionsKt.joinTo$default((List) destination$iv$iv$iv, new StringBuilder(resultSizeEstimate$iv), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 124, (Object) null)).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb;
    }

    public static /* synthetic */ String prependIndent$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "    ";
        }
        return StringsKt.prependIndent(str, str2);
    }

    public static final String prependIndent(String $this$prependIndent, String indent) {
        Intrinsics.checkNotNullParameter($this$prependIndent, "<this>");
        Intrinsics.checkNotNullParameter(indent, "indent");
        return SequencesKt.joinToString$default(SequencesKt.map(StringsKt.lineSequence($this$prependIndent), new StringsKt__IndentKt$prependIndent$1(indent)), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    private static final int indentWidth$StringsKt__IndentKt(String $this$indentWidth) {
        int index$iv;
        CharSequence $this$indexOfFirst$iv = $this$indentWidth;
        int length = $this$indexOfFirst$iv.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                index$iv = -1;
                break;
            }
            index$iv = i;
            i++;
            if ((CharsKt.isWhitespace($this$indexOfFirst$iv.charAt(index$iv)) ^ 1) != 0) {
                break;
            }
        }
        int it = index$iv;
        return it == -1 ? $this$indentWidth.length() : it;
    }

    private static final Function1<String, String> getIndentFunction$StringsKt__IndentKt(String indent) {
        if (indent.length() == 0) {
            return StringsKt__IndentKt$getIndentFunction$1.INSTANCE;
        }
        return new StringsKt__IndentKt$getIndentFunction$2(indent);
    }

    private static final String reindent$StringsKt__IndentKt(List<String> $this$reindent, int resultSizeEstimate, Function1<? super String, String> indentAddFunction, Function1<? super String, String> indentCutFunction) {
        int lastIndex;
        Object it$iv$iv;
        int $i$f$reindent = 0;
        int lastIndex2 = CollectionsKt.getLastIndex($this$reindent);
        Collection destination$iv$iv = new ArrayList();
        int index$iv$iv = 0;
        for (Object item$iv$iv$iv : $this$reindent) {
            int index$iv$iv$iv = index$iv$iv + 1;
            if (index$iv$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Object value = (String) item$iv$iv$iv;
            int $i$f$reindent2 = $i$f$reindent;
            int index = index$iv$iv;
            if ((index == 0 || index == lastIndex2) && StringsKt.isBlank((CharSequence) value)) {
                lastIndex = lastIndex2;
                Function1<? super String, String> function1 = indentAddFunction;
                int i = index;
                it$iv$iv = null;
            } else {
                int i2 = index;
                String invoke = indentCutFunction.invoke(value);
                lastIndex = lastIndex2;
                if (invoke == null) {
                    it$iv$iv = value;
                    Function1<? super String, String> function12 = indentAddFunction;
                } else {
                    it$iv$iv = (String) indentAddFunction.invoke(invoke);
                }
            }
            if (it$iv$iv != null) {
                destination$iv$iv.add(it$iv$iv);
            }
            index$iv$iv = index$iv$iv$iv;
            $i$f$reindent = $i$f$reindent2;
            lastIndex2 = lastIndex;
        }
        String sb = ((StringBuilder) CollectionsKt.joinTo$default((List) destination$iv$iv, new StringBuilder(resultSizeEstimate), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 124, (Object) null)).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb;
    }
}
