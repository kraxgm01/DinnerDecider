package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

public class WindowInsetsCompat {
    public static final WindowInsetsCompat CONSUMED;
    private static final String TAG = "WindowInsetsCompat";
    private final Impl mImpl;

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            CONSUMED = Impl30.CONSUMED;
        } else {
            CONSUMED = Impl.CONSUMED;
        }
    }

    private WindowInsetsCompat(WindowInsets insets) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.mImpl = new Impl30(this, insets);
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.mImpl = new Impl29(this, insets);
        } else if (Build.VERSION.SDK_INT >= 28) {
            this.mImpl = new Impl28(this, insets);
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.mImpl = new Impl21(this, insets);
        } else if (Build.VERSION.SDK_INT >= 20) {
            this.mImpl = new Impl20(this, insets);
        } else {
            this.mImpl = new Impl(this);
        }
    }

    public WindowInsetsCompat(WindowInsetsCompat src) {
        if (src != null) {
            Impl srcImpl = src.mImpl;
            if (Build.VERSION.SDK_INT >= 30 && (srcImpl instanceof Impl30)) {
                this.mImpl = new Impl30(this, (Impl30) srcImpl);
            } else if (Build.VERSION.SDK_INT >= 29 && (srcImpl instanceof Impl29)) {
                this.mImpl = new Impl29(this, (Impl29) srcImpl);
            } else if (Build.VERSION.SDK_INT >= 28 && (srcImpl instanceof Impl28)) {
                this.mImpl = new Impl28(this, (Impl28) srcImpl);
            } else if (Build.VERSION.SDK_INT >= 21 && (srcImpl instanceof Impl21)) {
                this.mImpl = new Impl21(this, (Impl21) srcImpl);
            } else if (Build.VERSION.SDK_INT < 20 || !(srcImpl instanceof Impl20)) {
                this.mImpl = new Impl(this);
            } else {
                this.mImpl = new Impl20(this, (Impl20) srcImpl);
            }
            srcImpl.copyWindowDataInto(this);
            return;
        }
        this.mImpl = new Impl(this);
    }

    public static WindowInsetsCompat toWindowInsetsCompat(WindowInsets insets) {
        return toWindowInsetsCompat(insets, (View) null);
    }

    public static WindowInsetsCompat toWindowInsetsCompat(WindowInsets insets, View view) {
        WindowInsetsCompat wic = new WindowInsetsCompat((WindowInsets) Preconditions.checkNotNull(insets));
        if (view != null && ViewCompat.isAttachedToWindow(view)) {
            wic.setRootWindowInsets(ViewCompat.getRootWindowInsets(view));
            wic.copyRootViewBounds(view.getRootView());
        }
        return wic;
    }

    @Deprecated
    public int getSystemWindowInsetLeft() {
        return this.mImpl.getSystemWindowInsets().left;
    }

    @Deprecated
    public int getSystemWindowInsetTop() {
        return this.mImpl.getSystemWindowInsets().top;
    }

    @Deprecated
    public int getSystemWindowInsetRight() {
        return this.mImpl.getSystemWindowInsets().right;
    }

    @Deprecated
    public int getSystemWindowInsetBottom() {
        return this.mImpl.getSystemWindowInsets().bottom;
    }

    @Deprecated
    public boolean hasSystemWindowInsets() {
        return !this.mImpl.getSystemWindowInsets().equals(Insets.NONE);
    }

    public boolean hasInsets() {
        return !getInsets(Type.all()).equals(Insets.NONE) || !getInsetsIgnoringVisibility(Type.all() ^ Type.ime()).equals(Insets.NONE) || getDisplayCutout() != null;
    }

    public boolean isConsumed() {
        return this.mImpl.isConsumed();
    }

    public boolean isRound() {
        return this.mImpl.isRound();
    }

    @Deprecated
    public WindowInsetsCompat consumeSystemWindowInsets() {
        return this.mImpl.consumeSystemWindowInsets();
    }

    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(int left, int top, int right, int bottom) {
        return new Builder(this).setSystemWindowInsets(Insets.of(left, top, right, bottom)).build();
    }

    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(Rect systemWindowInsets) {
        return new Builder(this).setSystemWindowInsets(Insets.of(systemWindowInsets)).build();
    }

    @Deprecated
    public int getStableInsetTop() {
        return this.mImpl.getStableInsets().top;
    }

    @Deprecated
    public int getStableInsetLeft() {
        return this.mImpl.getStableInsets().left;
    }

    @Deprecated
    public int getStableInsetRight() {
        return this.mImpl.getStableInsets().right;
    }

    @Deprecated
    public int getStableInsetBottom() {
        return this.mImpl.getStableInsets().bottom;
    }

    @Deprecated
    public boolean hasStableInsets() {
        return !this.mImpl.getStableInsets().equals(Insets.NONE);
    }

    @Deprecated
    public WindowInsetsCompat consumeStableInsets() {
        return this.mImpl.consumeStableInsets();
    }

    public DisplayCutoutCompat getDisplayCutout() {
        return this.mImpl.getDisplayCutout();
    }

    @Deprecated
    public WindowInsetsCompat consumeDisplayCutout() {
        return this.mImpl.consumeDisplayCutout();
    }

    @Deprecated
    public Insets getSystemWindowInsets() {
        return this.mImpl.getSystemWindowInsets();
    }

    @Deprecated
    public Insets getStableInsets() {
        return this.mImpl.getStableInsets();
    }

    @Deprecated
    public Insets getMandatorySystemGestureInsets() {
        return this.mImpl.getMandatorySystemGestureInsets();
    }

    @Deprecated
    public Insets getTappableElementInsets() {
        return this.mImpl.getTappableElementInsets();
    }

    @Deprecated
    public Insets getSystemGestureInsets() {
        return this.mImpl.getSystemGestureInsets();
    }

    public WindowInsetsCompat inset(Insets insets) {
        return inset(insets.left, insets.top, insets.right, insets.bottom);
    }

    public WindowInsetsCompat inset(int left, int top, int right, int bottom) {
        return this.mImpl.inset(left, top, right, bottom);
    }

    public Insets getInsets(int typeMask) {
        return this.mImpl.getInsets(typeMask);
    }

    public Insets getInsetsIgnoringVisibility(int typeMask) {
        return this.mImpl.getInsetsIgnoringVisibility(typeMask);
    }

    public boolean isVisible(int typeMask) {
        return this.mImpl.isVisible(typeMask);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WindowInsetsCompat)) {
            return false;
        }
        return ObjectsCompat.equals(this.mImpl, ((WindowInsetsCompat) o).mImpl);
    }

    public int hashCode() {
        Impl impl = this.mImpl;
        if (impl == null) {
            return 0;
        }
        return impl.hashCode();
    }

    public WindowInsets toWindowInsets() {
        Impl impl = this.mImpl;
        if (impl instanceof Impl20) {
            return ((Impl20) impl).mPlatformInsets;
        }
        return null;
    }

    private static class Impl {
        static final WindowInsetsCompat CONSUMED = new Builder().build().consumeDisplayCutout().consumeStableInsets().consumeSystemWindowInsets();
        final WindowInsetsCompat mHost;

        Impl(WindowInsetsCompat host) {
            this.mHost = host;
        }

        /* access modifiers changed from: package-private */
        public boolean isRound() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean isConsumed() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public WindowInsetsCompat consumeSystemWindowInsets() {
            return this.mHost;
        }

        /* access modifiers changed from: package-private */
        public WindowInsetsCompat consumeStableInsets() {
            return this.mHost;
        }

        /* access modifiers changed from: package-private */
        public DisplayCutoutCompat getDisplayCutout() {
            return null;
        }

        /* access modifiers changed from: package-private */
        public WindowInsetsCompat consumeDisplayCutout() {
            return this.mHost;
        }

        /* access modifiers changed from: package-private */
        public Insets getSystemWindowInsets() {
            return Insets.NONE;
        }

        /* access modifiers changed from: package-private */
        public Insets getStableInsets() {
            return Insets.NONE;
        }

        /* access modifiers changed from: package-private */
        public Insets getSystemGestureInsets() {
            return getSystemWindowInsets();
        }

        /* access modifiers changed from: package-private */
        public Insets getMandatorySystemGestureInsets() {
            return getSystemWindowInsets();
        }

        /* access modifiers changed from: package-private */
        public Insets getTappableElementInsets() {
            return getSystemWindowInsets();
        }

        /* access modifiers changed from: package-private */
        public WindowInsetsCompat inset(int left, int top, int right, int bottom) {
            return CONSUMED;
        }

        /* access modifiers changed from: package-private */
        public Insets getInsets(int typeMask) {
            return Insets.NONE;
        }

        /* access modifiers changed from: package-private */
        public Insets getInsetsIgnoringVisibility(int typeMask) {
            if ((typeMask & 8) == 0) {
                return Insets.NONE;
            }
            throw new IllegalArgumentException("Unable to query the maximum insets for IME");
        }

        /* access modifiers changed from: package-private */
        public boolean isVisible(int typeMask) {
            return true;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Impl)) {
                return false;
            }
            Impl impl = (Impl) o;
            if (isRound() != impl.isRound() || isConsumed() != impl.isConsumed() || !ObjectsCompat.equals(getSystemWindowInsets(), impl.getSystemWindowInsets()) || !ObjectsCompat.equals(getStableInsets(), impl.getStableInsets()) || !ObjectsCompat.equals(getDisplayCutout(), impl.getDisplayCutout())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return ObjectsCompat.hash(Boolean.valueOf(isRound()), Boolean.valueOf(isConsumed()), getSystemWindowInsets(), getStableInsets(), getDisplayCutout());
        }

        /* access modifiers changed from: package-private */
        public void setRootWindowInsets(WindowInsetsCompat rootWindowInsets) {
        }

        /* access modifiers changed from: package-private */
        public void setRootViewData(Insets visibleInsets) {
        }

        /* access modifiers changed from: package-private */
        public void copyRootViewBounds(View rootView) {
        }

        /* access modifiers changed from: package-private */
        public void copyWindowDataInto(WindowInsetsCompat other) {
        }

        public void setOverriddenInsets(Insets[] insetsTypeMask) {
        }

        public void setStableInsets(Insets stableInsets) {
        }
    }

    private static class Impl20 extends Impl {
        private static Class<?> sAttachInfoClass;
        private static Field sAttachInfoField;
        private static Method sGetViewRootImplMethod;
        private static Field sVisibleInsetsField;
        private static boolean sVisibleRectReflectionFetched = false;
        private Insets[] mOverriddenInsets;
        final WindowInsets mPlatformInsets;
        Insets mRootViewVisibleInsets;
        private WindowInsetsCompat mRootWindowInsets;
        private Insets mSystemWindowInsets;

        Impl20(WindowInsetsCompat host, WindowInsets insets) {
            super(host);
            this.mSystemWindowInsets = null;
            this.mPlatformInsets = insets;
        }

        Impl20(WindowInsetsCompat host, Impl20 other) {
            this(host, new WindowInsets(other.mPlatformInsets));
        }

        /* access modifiers changed from: package-private */
        public boolean isRound() {
            return this.mPlatformInsets.isRound();
        }

        public Insets getInsets(int typeMask) {
            return getInsets(typeMask, false);
        }

        public Insets getInsetsIgnoringVisibility(int typeMask) {
            return getInsets(typeMask, true);
        }

        /* access modifiers changed from: package-private */
        public boolean isVisible(int typeMask) {
            for (int i = 1; i <= 256; i <<= 1) {
                if ((typeMask & i) != 0 && !isTypeVisible(i)) {
                    return false;
                }
            }
            return true;
        }

        private Insets getInsets(int typeMask, boolean ignoreVisibility) {
            Insets result = Insets.NONE;
            for (int i = 1; i <= 256; i <<= 1) {
                if ((typeMask & i) != 0) {
                    result = Insets.max(result, getInsetsForType(i, ignoreVisibility));
                }
            }
            return result;
        }

        /* access modifiers changed from: protected */
        public Insets getInsetsForType(int type, boolean ignoreVisibility) {
            DisplayCutoutCompat cutout;
            Insets overriddenInsets = null;
            switch (type) {
                case 1:
                    if (ignoreVisibility) {
                        return Insets.of(0, Math.max(getRootStableInsets().top, getSystemWindowInsets().top), 0, 0);
                    }
                    return Insets.of(0, getSystemWindowInsets().top, 0, 0);
                case 2:
                    if (ignoreVisibility) {
                        Insets rootStable = getRootStableInsets();
                        Insets stable = getStableInsets();
                        return Insets.of(Math.max(rootStable.left, stable.left), 0, Math.max(rootStable.right, stable.right), Math.max(rootStable.bottom, stable.bottom));
                    }
                    Insets systemWindow = getSystemWindowInsets();
                    WindowInsetsCompat windowInsetsCompat = this.mRootWindowInsets;
                    if (windowInsetsCompat != null) {
                        overriddenInsets = windowInsetsCompat.getStableInsets();
                    }
                    int bottom = systemWindow.bottom;
                    if (overriddenInsets != null) {
                        bottom = Math.min(bottom, overriddenInsets.bottom);
                    }
                    return Insets.of(systemWindow.left, 0, systemWindow.right, bottom);
                case 8:
                    Insets[] insetsArr = this.mOverriddenInsets;
                    if (insetsArr != null) {
                        overriddenInsets = insetsArr[Type.indexOf(8)];
                    }
                    if (overriddenInsets != null) {
                        return overriddenInsets;
                    }
                    Insets systemWindow2 = getSystemWindowInsets();
                    Insets rootStable2 = getRootStableInsets();
                    if (systemWindow2.bottom > rootStable2.bottom) {
                        return Insets.of(0, 0, 0, systemWindow2.bottom);
                    }
                    Insets insets = this.mRootViewVisibleInsets;
                    if (insets == null || insets.equals(Insets.NONE) || this.mRootViewVisibleInsets.bottom <= rootStable2.bottom) {
                        return Insets.NONE;
                    }
                    return Insets.of(0, 0, 0, this.mRootViewVisibleInsets.bottom);
                case 16:
                    return getSystemGestureInsets();
                case 32:
                    return getMandatorySystemGestureInsets();
                case 64:
                    return getTappableElementInsets();
                case 128:
                    WindowInsetsCompat windowInsetsCompat2 = this.mRootWindowInsets;
                    if (windowInsetsCompat2 != null) {
                        cutout = windowInsetsCompat2.getDisplayCutout();
                    } else {
                        cutout = getDisplayCutout();
                    }
                    if (cutout != null) {
                        return Insets.of(cutout.getSafeInsetLeft(), cutout.getSafeInsetTop(), cutout.getSafeInsetRight(), cutout.getSafeInsetBottom());
                    }
                    return Insets.NONE;
                default:
                    return Insets.NONE;
            }
        }

        /* access modifiers changed from: protected */
        public boolean isTypeVisible(int type) {
            switch (type) {
                case 1:
                case 2:
                case 8:
                case 128:
                    return true ^ getInsetsForType(type, false).equals(Insets.NONE);
                case 4:
                    return false;
                default:
                    return true;
            }
        }

        /* access modifiers changed from: package-private */
        public final Insets getSystemWindowInsets() {
            if (this.mSystemWindowInsets == null) {
                this.mSystemWindowInsets = Insets.of(this.mPlatformInsets.getSystemWindowInsetLeft(), this.mPlatformInsets.getSystemWindowInsetTop(), this.mPlatformInsets.getSystemWindowInsetRight(), this.mPlatformInsets.getSystemWindowInsetBottom());
            }
            return this.mSystemWindowInsets;
        }

        /* access modifiers changed from: package-private */
        public WindowInsetsCompat inset(int left, int top, int right, int bottom) {
            Builder b = new Builder(WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets));
            b.setSystemWindowInsets(WindowInsetsCompat.insetInsets(getSystemWindowInsets(), left, top, right, bottom));
            b.setStableInsets(WindowInsetsCompat.insetInsets(getStableInsets(), left, top, right, bottom));
            return b.build();
        }

        /* access modifiers changed from: package-private */
        public void copyWindowDataInto(WindowInsetsCompat other) {
            other.setRootWindowInsets(this.mRootWindowInsets);
            other.setRootViewData(this.mRootViewVisibleInsets);
        }

        /* access modifiers changed from: package-private */
        public void setRootWindowInsets(WindowInsetsCompat rootWindowInsets) {
            this.mRootWindowInsets = rootWindowInsets;
        }

        /* access modifiers changed from: package-private */
        public void setRootViewData(Insets visibleInsets) {
            this.mRootViewVisibleInsets = visibleInsets;
        }

        private Insets getRootStableInsets() {
            WindowInsetsCompat windowInsetsCompat = this.mRootWindowInsets;
            if (windowInsetsCompat != null) {
                return windowInsetsCompat.getStableInsets();
            }
            return Insets.NONE;
        }

        /* access modifiers changed from: package-private */
        public void copyRootViewBounds(View rootView) {
            Insets visibleInsets = getVisibleInsets(rootView);
            if (visibleInsets == null) {
                visibleInsets = Insets.NONE;
            }
            setRootViewData(visibleInsets);
        }

        private Insets getVisibleInsets(View rootView) {
            if (Build.VERSION.SDK_INT < 30) {
                if (!sVisibleRectReflectionFetched) {
                    loadReflectionField();
                }
                Method method = sGetViewRootImplMethod;
                if (method == null || sAttachInfoClass == null || sVisibleInsetsField == null) {
                    return null;
                }
                try {
                    Object viewRootImpl = method.invoke(rootView, new Object[0]);
                    if (viewRootImpl == null) {
                        Log.w(WindowInsetsCompat.TAG, "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                        return null;
                    }
                    Rect visibleRect = (Rect) sVisibleInsetsField.get(sAttachInfoField.get(viewRootImpl));
                    if (visibleRect != null) {
                        return Insets.of(visibleRect);
                    }
                    return null;
                } catch (ReflectiveOperationException e) {
                    Log.e(WindowInsetsCompat.TAG, "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
                    return null;
                }
            } else {
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }
        }

        public void setOverriddenInsets(Insets[] insetsTypeMask) {
            this.mOverriddenInsets = insetsTypeMask;
        }

        private static void loadReflectionField() {
            try {
                sGetViewRootImplMethod = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                sAttachInfoClass = cls;
                sVisibleInsetsField = cls.getDeclaredField("mVisibleInsets");
                sAttachInfoField = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                sVisibleInsetsField.setAccessible(true);
                sAttachInfoField.setAccessible(true);
            } catch (ReflectiveOperationException e) {
                Log.e(WindowInsetsCompat.TAG, "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
            }
            sVisibleRectReflectionFetched = true;
        }

        public boolean equals(Object o) {
            if (!super.equals(o)) {
                return false;
            }
            return Objects.equals(this.mRootViewVisibleInsets, ((Impl20) o).mRootViewVisibleInsets);
        }
    }

    private static class Impl21 extends Impl20 {
        private Insets mStableInsets = null;

        Impl21(WindowInsetsCompat host, WindowInsets insets) {
            super(host, insets);
        }

        Impl21(WindowInsetsCompat host, Impl21 other) {
            super(host, (Impl20) other);
            this.mStableInsets = other.mStableInsets;
        }

        /* access modifiers changed from: package-private */
        public boolean isConsumed() {
            return this.mPlatformInsets.isConsumed();
        }

        /* access modifiers changed from: package-private */
        public WindowInsetsCompat consumeStableInsets() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeStableInsets());
        }

        /* access modifiers changed from: package-private */
        public WindowInsetsCompat consumeSystemWindowInsets() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeSystemWindowInsets());
        }

        /* access modifiers changed from: package-private */
        public final Insets getStableInsets() {
            if (this.mStableInsets == null) {
                this.mStableInsets = Insets.of(this.mPlatformInsets.getStableInsetLeft(), this.mPlatformInsets.getStableInsetTop(), this.mPlatformInsets.getStableInsetRight(), this.mPlatformInsets.getStableInsetBottom());
            }
            return this.mStableInsets;
        }

        public void setStableInsets(Insets stableInsets) {
            this.mStableInsets = stableInsets;
        }
    }

    private static class Impl28 extends Impl21 {
        Impl28(WindowInsetsCompat host, WindowInsets insets) {
            super(host, insets);
        }

        Impl28(WindowInsetsCompat host, Impl28 other) {
            super(host, (Impl21) other);
        }

        /* access modifiers changed from: package-private */
        public DisplayCutoutCompat getDisplayCutout() {
            return DisplayCutoutCompat.wrap(this.mPlatformInsets.getDisplayCutout());
        }

        /* access modifiers changed from: package-private */
        public WindowInsetsCompat consumeDisplayCutout() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeDisplayCutout());
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Impl28)) {
                return false;
            }
            Impl28 otherImpl28 = (Impl28) o;
            if (!Objects.equals(this.mPlatformInsets, otherImpl28.mPlatformInsets) || !Objects.equals(this.mRootViewVisibleInsets, otherImpl28.mRootViewVisibleInsets)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.mPlatformInsets.hashCode();
        }
    }

    private static class Impl29 extends Impl28 {
        private Insets mMandatorySystemGestureInsets = null;
        private Insets mSystemGestureInsets = null;
        private Insets mTappableElementInsets = null;

        Impl29(WindowInsetsCompat host, WindowInsets insets) {
            super(host, insets);
        }

        Impl29(WindowInsetsCompat host, Impl29 other) {
            super(host, (Impl28) other);
        }

        /* access modifiers changed from: package-private */
        public Insets getSystemGestureInsets() {
            if (this.mSystemGestureInsets == null) {
                this.mSystemGestureInsets = Insets.toCompatInsets(this.mPlatformInsets.getSystemGestureInsets());
            }
            return this.mSystemGestureInsets;
        }

        /* access modifiers changed from: package-private */
        public Insets getMandatorySystemGestureInsets() {
            if (this.mMandatorySystemGestureInsets == null) {
                this.mMandatorySystemGestureInsets = Insets.toCompatInsets(this.mPlatformInsets.getMandatorySystemGestureInsets());
            }
            return this.mMandatorySystemGestureInsets;
        }

        /* access modifiers changed from: package-private */
        public Insets getTappableElementInsets() {
            if (this.mTappableElementInsets == null) {
                this.mTappableElementInsets = Insets.toCompatInsets(this.mPlatformInsets.getTappableElementInsets());
            }
            return this.mTappableElementInsets;
        }

        /* access modifiers changed from: package-private */
        public WindowInsetsCompat inset(int left, int top, int right, int bottom) {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.inset(left, top, right, bottom));
        }

        public void setStableInsets(Insets stableInsets) {
        }
    }

    static Insets insetInsets(Insets insets, int left, int top, int right, int bottom) {
        int newLeft = Math.max(0, insets.left - left);
        int newTop = Math.max(0, insets.top - top);
        int newRight = Math.max(0, insets.right - right);
        int newBottom = Math.max(0, insets.bottom - bottom);
        if (newLeft == left && newTop == top && newRight == right && newBottom == bottom) {
            return insets;
        }
        return Insets.of(newLeft, newTop, newRight, newBottom);
    }

    private static class Impl30 extends Impl29 {
        static final WindowInsetsCompat CONSUMED = WindowInsetsCompat.toWindowInsetsCompat(WindowInsets.CONSUMED);

        Impl30(WindowInsetsCompat host, WindowInsets insets) {
            super(host, insets);
        }

        Impl30(WindowInsetsCompat host, Impl30 other) {
            super(host, (Impl29) other);
        }

        public Insets getInsets(int typeMask) {
            return Insets.toCompatInsets(this.mPlatformInsets.getInsets(TypeImpl30.toPlatformType(typeMask)));
        }

        public Insets getInsetsIgnoringVisibility(int typeMask) {
            return Insets.toCompatInsets(this.mPlatformInsets.getInsetsIgnoringVisibility(TypeImpl30.toPlatformType(typeMask)));
        }

        public boolean isVisible(int typeMask) {
            return this.mPlatformInsets.isVisible(TypeImpl30.toPlatformType(typeMask));
        }

        /* access modifiers changed from: package-private */
        public final void copyRootViewBounds(View rootView) {
        }
    }

    public static final class Builder {
        private final BuilderImpl mImpl;

        public Builder() {
            if (Build.VERSION.SDK_INT >= 30) {
                this.mImpl = new BuilderImpl30();
            } else if (Build.VERSION.SDK_INT >= 29) {
                this.mImpl = new BuilderImpl29();
            } else if (Build.VERSION.SDK_INT >= 20) {
                this.mImpl = new BuilderImpl20();
            } else {
                this.mImpl = new BuilderImpl();
            }
        }

        public Builder(WindowInsetsCompat insets) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.mImpl = new BuilderImpl30(insets);
            } else if (Build.VERSION.SDK_INT >= 29) {
                this.mImpl = new BuilderImpl29(insets);
            } else if (Build.VERSION.SDK_INT >= 20) {
                this.mImpl = new BuilderImpl20(insets);
            } else {
                this.mImpl = new BuilderImpl(insets);
            }
        }

        @Deprecated
        public Builder setSystemWindowInsets(Insets insets) {
            this.mImpl.setSystemWindowInsets(insets);
            return this;
        }

        @Deprecated
        public Builder setSystemGestureInsets(Insets insets) {
            this.mImpl.setSystemGestureInsets(insets);
            return this;
        }

        @Deprecated
        public Builder setMandatorySystemGestureInsets(Insets insets) {
            this.mImpl.setMandatorySystemGestureInsets(insets);
            return this;
        }

        @Deprecated
        public Builder setTappableElementInsets(Insets insets) {
            this.mImpl.setTappableElementInsets(insets);
            return this;
        }

        public Builder setInsets(int typeMask, Insets insets) {
            this.mImpl.setInsets(typeMask, insets);
            return this;
        }

        public Builder setInsetsIgnoringVisibility(int typeMask, Insets insets) {
            this.mImpl.setInsetsIgnoringVisibility(typeMask, insets);
            return this;
        }

        public Builder setVisible(int typeMask, boolean visible) {
            this.mImpl.setVisible(typeMask, visible);
            return this;
        }

        @Deprecated
        public Builder setStableInsets(Insets insets) {
            this.mImpl.setStableInsets(insets);
            return this;
        }

        public Builder setDisplayCutout(DisplayCutoutCompat displayCutout) {
            this.mImpl.setDisplayCutout(displayCutout);
            return this;
        }

        public WindowInsetsCompat build() {
            return this.mImpl.build();
        }
    }

    private static class BuilderImpl {
        private final WindowInsetsCompat mInsets;
        Insets[] mInsetsTypeMask;

        BuilderImpl() {
            this(new WindowInsetsCompat((WindowInsetsCompat) null));
        }

        BuilderImpl(WindowInsetsCompat insets) {
            this.mInsets = insets;
        }

        /* access modifiers changed from: package-private */
        public void setSystemWindowInsets(Insets insets) {
        }

        /* access modifiers changed from: package-private */
        public void setSystemGestureInsets(Insets insets) {
        }

        /* access modifiers changed from: package-private */
        public void setMandatorySystemGestureInsets(Insets insets) {
        }

        /* access modifiers changed from: package-private */
        public void setTappableElementInsets(Insets insets) {
        }

        /* access modifiers changed from: package-private */
        public void setStableInsets(Insets insets) {
        }

        /* access modifiers changed from: package-private */
        public void setDisplayCutout(DisplayCutoutCompat displayCutout) {
        }

        /* access modifiers changed from: package-private */
        public void setInsets(int typeMask, Insets insets) {
            if (this.mInsetsTypeMask == null) {
                this.mInsetsTypeMask = new Insets[9];
            }
            for (int i = 1; i <= 256; i <<= 1) {
                if ((typeMask & i) != 0) {
                    this.mInsetsTypeMask[Type.indexOf(i)] = insets;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void setInsetsIgnoringVisibility(int typeMask, Insets insets) {
            if (typeMask == 8) {
                throw new IllegalArgumentException("Ignoring visibility inset not available for IME");
            }
        }

        /* access modifiers changed from: package-private */
        public void setVisible(int typeMask, boolean visible) {
        }

        /* access modifiers changed from: protected */
        public final void applyInsetTypes() {
            Insets[] insetsArr = this.mInsetsTypeMask;
            if (insetsArr != null) {
                Insets statusBars = insetsArr[Type.indexOf(1)];
                Insets navigationBars = this.mInsetsTypeMask[Type.indexOf(2)];
                if (navigationBars == null) {
                    navigationBars = this.mInsets.getInsets(2);
                }
                if (statusBars == null) {
                    statusBars = this.mInsets.getInsets(1);
                }
                setSystemWindowInsets(Insets.max(statusBars, navigationBars));
                Insets i = this.mInsetsTypeMask[Type.indexOf(16)];
                if (i != null) {
                    setSystemGestureInsets(i);
                }
                Insets i2 = this.mInsetsTypeMask[Type.indexOf(32)];
                if (i2 != null) {
                    setMandatorySystemGestureInsets(i2);
                }
                Insets i3 = this.mInsetsTypeMask[Type.indexOf(64)];
                if (i3 != null) {
                    setTappableElementInsets(i3);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public WindowInsetsCompat build() {
            applyInsetTypes();
            return this.mInsets;
        }
    }

    /* access modifiers changed from: package-private */
    public void setOverriddenInsets(Insets[] insetsTypeMask) {
        this.mImpl.setOverriddenInsets(insetsTypeMask);
    }

    private static class BuilderImpl20 extends BuilderImpl {
        private static Constructor<WindowInsets> sConstructor;
        private static boolean sConstructorFetched = false;
        private static Field sConsumedField;
        private static boolean sConsumedFieldFetched = false;
        private WindowInsets mPlatformInsets;
        private Insets mStableInsets;

        BuilderImpl20() {
            this.mPlatformInsets = createWindowInsetsInstance();
        }

        BuilderImpl20(WindowInsetsCompat insets) {
            super(insets);
            this.mPlatformInsets = insets.toWindowInsets();
        }

        /* access modifiers changed from: package-private */
        public void setSystemWindowInsets(Insets insets) {
            WindowInsets windowInsets = this.mPlatformInsets;
            if (windowInsets != null) {
                this.mPlatformInsets = windowInsets.replaceSystemWindowInsets(insets.left, insets.top, insets.right, insets.bottom);
            }
        }

        /* access modifiers changed from: package-private */
        public void setStableInsets(Insets insets) {
            this.mStableInsets = insets;
        }

        /* access modifiers changed from: package-private */
        public WindowInsetsCompat build() {
            applyInsetTypes();
            WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets);
            windowInsetsCompat.setOverriddenInsets(this.mInsetsTypeMask);
            windowInsetsCompat.setStableInsets(this.mStableInsets);
            return windowInsetsCompat;
        }

        private static WindowInsets createWindowInsetsInstance() {
            if (!sConsumedFieldFetched) {
                try {
                    sConsumedField = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e) {
                    Log.i(WindowInsetsCompat.TAG, "Could not retrieve WindowInsets.CONSUMED field", e);
                }
                sConsumedFieldFetched = true;
            }
            Field field = sConsumedField;
            if (field != null) {
                try {
                    WindowInsets consumed = (WindowInsets) field.get((Object) null);
                    if (consumed != null) {
                        return new WindowInsets(consumed);
                    }
                } catch (ReflectiveOperationException e2) {
                    Log.i(WindowInsetsCompat.TAG, "Could not get value from WindowInsets.CONSUMED field", e2);
                }
            }
            if (!sConstructorFetched) {
                try {
                    sConstructor = WindowInsets.class.getConstructor(new Class[]{Rect.class});
                } catch (ReflectiveOperationException e3) {
                    Log.i(WindowInsetsCompat.TAG, "Could not retrieve WindowInsets(Rect) constructor", e3);
                }
                sConstructorFetched = true;
            }
            Constructor<WindowInsets> constructor = sConstructor;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Object[]{new Rect()});
                } catch (ReflectiveOperationException e4) {
                    Log.i(WindowInsetsCompat.TAG, "Could not invoke WindowInsets(Rect) constructor", e4);
                }
            }
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void setStableInsets(Insets stableInsets) {
        this.mImpl.setStableInsets(stableInsets);
    }

    private static class BuilderImpl29 extends BuilderImpl {
        final WindowInsets.Builder mPlatBuilder;

        BuilderImpl29() {
            this.mPlatBuilder = new WindowInsets.Builder();
        }

        BuilderImpl29(WindowInsetsCompat insets) {
            super(insets);
            WindowInsets.Builder builder;
            WindowInsets platInsets = insets.toWindowInsets();
            if (platInsets != null) {
                builder = new WindowInsets.Builder(platInsets);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.mPlatBuilder = builder;
        }

        /* access modifiers changed from: package-private */
        public void setSystemWindowInsets(Insets insets) {
            this.mPlatBuilder.setSystemWindowInsets(insets.toPlatformInsets());
        }

        /* access modifiers changed from: package-private */
        public void setSystemGestureInsets(Insets insets) {
            this.mPlatBuilder.setSystemGestureInsets(insets.toPlatformInsets());
        }

        /* access modifiers changed from: package-private */
        public void setMandatorySystemGestureInsets(Insets insets) {
            this.mPlatBuilder.setMandatorySystemGestureInsets(insets.toPlatformInsets());
        }

        /* access modifiers changed from: package-private */
        public void setTappableElementInsets(Insets insets) {
            this.mPlatBuilder.setTappableElementInsets(insets.toPlatformInsets());
        }

        /* access modifiers changed from: package-private */
        public void setStableInsets(Insets insets) {
            this.mPlatBuilder.setStableInsets(insets.toPlatformInsets());
        }

        /* access modifiers changed from: package-private */
        public void setDisplayCutout(DisplayCutoutCompat displayCutout) {
            this.mPlatBuilder.setDisplayCutout(displayCutout != null ? displayCutout.unwrap() : null);
        }

        /* access modifiers changed from: package-private */
        public WindowInsetsCompat build() {
            applyInsetTypes();
            WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(this.mPlatBuilder.build());
            windowInsetsCompat.setOverriddenInsets(this.mInsetsTypeMask);
            return windowInsetsCompat;
        }
    }

    private static class BuilderImpl30 extends BuilderImpl29 {
        BuilderImpl30() {
        }

        BuilderImpl30(WindowInsetsCompat insets) {
            super(insets);
        }

        /* access modifiers changed from: package-private */
        public void setInsets(int typeMask, Insets insets) {
            this.mPlatBuilder.setInsets(TypeImpl30.toPlatformType(typeMask), insets.toPlatformInsets());
        }

        /* access modifiers changed from: package-private */
        public void setInsetsIgnoringVisibility(int typeMask, Insets insets) {
            this.mPlatBuilder.setInsetsIgnoringVisibility(TypeImpl30.toPlatformType(typeMask), insets.toPlatformInsets());
        }

        /* access modifiers changed from: package-private */
        public void setVisible(int typeMask, boolean visible) {
            this.mPlatBuilder.setVisible(TypeImpl30.toPlatformType(typeMask), visible);
        }
    }

    public static final class Type {
        static final int CAPTION_BAR = 4;
        static final int DISPLAY_CUTOUT = 128;
        static final int FIRST = 1;
        static final int IME = 8;
        static final int LAST = 256;
        static final int MANDATORY_SYSTEM_GESTURES = 32;
        static final int NAVIGATION_BARS = 2;
        static final int SIZE = 9;
        static final int STATUS_BARS = 1;
        static final int SYSTEM_GESTURES = 16;
        static final int TAPPABLE_ELEMENT = 64;
        static final int WINDOW_DECOR = 256;

        @Retention(RetentionPolicy.SOURCE)
        public @interface InsetsType {
        }

        private Type() {
        }

        public static int statusBars() {
            return 1;
        }

        public static int navigationBars() {
            return 2;
        }

        public static int captionBar() {
            return 4;
        }

        public static int ime() {
            return 8;
        }

        public static int systemGestures() {
            return 16;
        }

        public static int mandatorySystemGestures() {
            return 32;
        }

        public static int tappableElement() {
            return 64;
        }

        public static int displayCutout() {
            return 128;
        }

        public static int systemBars() {
            return 7;
        }

        static int all() {
            return -1;
        }

        static int indexOf(int type) {
            switch (type) {
                case 1:
                    return 0;
                case 2:
                    return 1;
                case 4:
                    return 2;
                case 8:
                    return 3;
                case 16:
                    return 4;
                case 32:
                    return 5;
                case 64:
                    return 6;
                case 128:
                    return 7;
                case 256:
                    return 8;
                default:
                    throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + type);
            }
        }
    }

    private static final class TypeImpl30 {
        private TypeImpl30() {
        }

        static int toPlatformType(int typeMask) {
            int result = 0;
            for (int i = 1; i <= 256; i <<= 1) {
                if ((typeMask & i) != 0) {
                    switch (i) {
                        case 1:
                            result |= WindowInsets.Type.statusBars();
                            break;
                        case 2:
                            result |= WindowInsets.Type.navigationBars();
                            break;
                        case 4:
                            result |= WindowInsets.Type.captionBar();
                            break;
                        case 8:
                            result |= WindowInsets.Type.ime();
                            break;
                        case 16:
                            result |= WindowInsets.Type.systemGestures();
                            break;
                        case 32:
                            result |= WindowInsets.Type.mandatorySystemGestures();
                            break;
                        case 64:
                            result |= WindowInsets.Type.tappableElement();
                            break;
                        case 128:
                            result |= WindowInsets.Type.displayCutout();
                            break;
                    }
                }
            }
            return result;
        }
    }

    /* access modifiers changed from: package-private */
    public void setRootWindowInsets(WindowInsetsCompat rootWindowInsets) {
        this.mImpl.setRootWindowInsets(rootWindowInsets);
    }

    /* access modifiers changed from: package-private */
    public void setRootViewData(Insets visibleInsets) {
        this.mImpl.setRootViewData(visibleInsets);
    }

    /* access modifiers changed from: package-private */
    public void copyRootViewBounds(View rootView) {
        this.mImpl.copyRootViewBounds(rootView);
    }

    static class Api21ReflectionHolder {
        private static Field sContentInsets;
        private static boolean sReflectionSucceeded = true;
        private static Field sStableInsets;
        private static Field sViewAttachInfoField;

        private Api21ReflectionHolder() {
        }

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                sViewAttachInfoField = declaredField;
                declaredField.setAccessible(true);
                Class<?> sAttachInfoClass = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = sAttachInfoClass.getDeclaredField("mStableInsets");
                sStableInsets = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = sAttachInfoClass.getDeclaredField("mContentInsets");
                sContentInsets = declaredField3;
                declaredField3.setAccessible(true);
            } catch (ReflectiveOperationException e) {
                Log.w(WindowInsetsCompat.TAG, "Failed to get visible insets from AttachInfo " + e.getMessage(), e);
            }
        }

        public static WindowInsetsCompat getRootWindowInsets(View v) {
            if (!sReflectionSucceeded || !v.isAttachedToWindow()) {
                return null;
            }
            try {
                Object attachInfo = sViewAttachInfoField.get(v.getRootView());
                if (attachInfo != null) {
                    Rect stableInsets = (Rect) sStableInsets.get(attachInfo);
                    Rect visibleInsets = (Rect) sContentInsets.get(attachInfo);
                    if (!(stableInsets == null || visibleInsets == null)) {
                        WindowInsetsCompat insets = new Builder().setStableInsets(Insets.of(stableInsets)).setSystemWindowInsets(Insets.of(visibleInsets)).build();
                        insets.setRootWindowInsets(insets);
                        insets.copyRootViewBounds(v.getRootView());
                        return insets;
                    }
                }
            } catch (IllegalAccessException e) {
                Log.w(WindowInsetsCompat.TAG, "Failed to get insets from AttachInfo. " + e.getMessage(), e);
            }
            return null;
        }
    }
}
