package com.yubeigold.web.utils;

import org.testng.Assert;
import org.testng.collections.Lists;
import org.testng.internal.EclipseInterface;

import java.lang.reflect.Array;
import java.util.*;


public class AssertUtil {

    public static void assertTrue(boolean condition, String message) {
        if(!condition) {
            failNotEquals(Boolean.valueOf(condition), Boolean.TRUE, message);
        }

    }

    public static void assertTrue(boolean condition) {
        assertTrue(condition, (String)null);
    }

    public static void assertFalse(boolean condition, String message) {
        if(condition) {
            failNotEquals(Boolean.valueOf(condition), Boolean.FALSE, message);
        }

    }

    public static void assertFalse(boolean condition) {
        assertFalse(condition, (String)null);
    }

    public static void fail(String message, Throwable realCause) {
        AssertionError ae = new AssertionError(message);
        ae.initCause(realCause);
        throw ae;
    }

    public static void fail(String message) {
        ScreenShot.screenShot();
        throw new AssertionError(message);
    }

    public static void fail() {
        fail((String)null);
    }

    public static void assertEquals(Object actual, Object expected, String message) {
        if(expected != null && expected.getClass().isArray()) {
            assertArrayEquals(actual, expected, message);
        } else {
            assertEqualsImpl(actual, expected, message);
        }
    }

    private static void assertEqualsImpl(Object actual, Object expected, String message) {
        if(expected != null || actual != null) {
            if(expected == null ^ actual == null) {
                failNotEquals(actual, expected, message);
            }

            if(!expected.equals(actual) || !actual.equals(expected)) {
                failNotEquals(actual, expected, message);
            }
        }
    }

    private static void assertArrayEquals(Object actual, Object expected, String message) {
        if(expected != actual) {
            if(null == expected) {
                fail("expected a null array, but not null found. " + message);
            }

            if(null == actual) {
                fail("expected not null array, but null found. " + message);
            }

            if(actual.getClass().isArray()) {
                int expectedLength = Array.getLength(expected);
                if(expectedLength == Array.getLength(actual)) {
                    for(int i = 0; i < expectedLength; ++i) {
                        Object _actual = Array.get(actual, i);
                        Object _expected = Array.get(expected, i);

                        try {
                            assertEquals(_actual, _expected);
                        } catch (AssertionError var8) {
                            failNotEquals(actual, expected, message == null?"":message + " (values at index " + i + " are not the same)");
                        }
                    }

                    return;
                }

                failNotEquals(Integer.valueOf(Array.getLength(actual)), Integer.valueOf(expectedLength), message == null?"":message + " (Array lengths are not the same)");
            }

            failNotEquals(actual, expected, message);
        }
    }

    public static void assertEquals(Object actual, Object expected) {
        assertEquals((Object)actual, (Object)expected, (String)null);
    }

    public static void assertEquals(String actual, String expected, String message) {
        assertEquals((Object)actual, (Object)expected, message);
    }

    public static void assertEquals(String actual, String expected) {
        assertEquals((String)actual, (String)expected, (String)null);
    }

    public static void assertEquals(double actual, double expected, double delta, String message) {
        if(Double.isInfinite(expected)) {
            if(expected != actual) {
                failNotEquals(Double.valueOf(actual), Double.valueOf(expected), message);
            }
        } else if(Double.isNaN(expected)) {
            if(!Double.isNaN(actual)) {
                failNotEquals(Double.valueOf(actual), Double.valueOf(expected), message);
            }
        } else if(Math.abs(expected - actual) > delta) {
            failNotEquals(Double.valueOf(actual), Double.valueOf(expected), message);
        }

    }

    public static void assertEquals(double actual, double expected, double delta) {
        assertEquals(actual, expected, delta, (String)null);
    }

    public static void assertEquals(float actual, float expected, float delta, String message) {
        if(Float.isInfinite(expected)) {
            if(expected != actual) {
                failNotEquals(Float.valueOf(actual), Float.valueOf(expected), message);
            }
        } else if(Math.abs(expected - actual) > delta) {
            failNotEquals(Float.valueOf(actual), Float.valueOf(expected), message);
        }

    }

    public static void assertEquals(float actual, float expected, float delta) {
        assertEquals(actual, expected, delta, (String)null);
    }

    public static void assertEquals(long actual, long expected, String message) {
        assertEquals((Object)Long.valueOf(actual), (Object)Long.valueOf(expected), message);
    }

    public static void assertEquals(long actual, long expected) {
        assertEquals(actual, expected, (String)null);
    }

    public static void assertEquals(boolean actual, boolean expected, String message) {
        assertEquals((Object)Boolean.valueOf(actual), (Object)Boolean.valueOf(expected), message);
    }

    public static void assertEquals(boolean actual, boolean expected) {
        assertEquals(actual, expected, (String)null);
    }

    public static void assertEquals(byte actual, byte expected, String message) {
        assertEquals((Object)Byte.valueOf(actual), (Object)Byte.valueOf(expected), message);
    }

    public static void assertEquals(byte actual, byte expected) {
        assertEquals((byte)actual, (byte)expected, (String)null);
    }

    public static void assertEquals(char actual, char expected, String message) {
        assertEquals((Object)Character.valueOf(actual), (Object)Character.valueOf(expected), message);
    }

    public static void assertEquals(char actual, char expected) {
        assertEquals((char)actual, (char)expected, (String)null);
    }

    public static void assertEquals(short actual, short expected, String message) {
        assertEquals((Object)Short.valueOf(actual), (Object)Short.valueOf(expected), message);
    }

    public static void assertEquals(short actual, short expected) {
        assertEquals((short)actual, (short)expected, (String)null);
    }

    public static void assertEquals(int actual, int expected, String message) {
        assertEquals((Object)Integer.valueOf(actual), (Object)Integer.valueOf(expected), message);
    }

    public static void assertEquals(int actual, int expected) {
        assertEquals((int)actual, (int)expected, (String)null);
    }

    public static void assertNotNull(Object object) {
        assertNotNull(object, (String)null);
    }

    public static void assertNotNull(Object object, String message) {
        if(object == null) {
            String formatted = "";
            if(message != null) {
                formatted = message + " ";
            }

            fail(formatted + "expected object to not be null");
        }

        assertTrue(object != null, message);
    }

    public static void assertNull(Object object) {
        assertNull(object, (String)null);
    }

    public static void assertNull(Object object, String message) {
        if(object != null) {
            failNotSame(object, (Object)null, message);
        }

    }

    public static void assertSame(Object actual, Object expected, String message) {
        if(expected != actual) {
            failNotSame(actual, expected, message);
        }
    }

    public static void assertSame(Object actual, Object expected) {
        assertSame(actual, expected, (String)null);
    }

    public static void assertNotSame(Object actual, Object expected, String message) {
        if(expected == actual) {
            failSame(actual, expected, message);
        }

    }

    public static void assertNotSame(Object actual, Object expected) {
        assertNotSame(actual, expected, (String)null);
    }

    private static void failSame(Object actual, Object expected, String message) {
        String formatted = "";
        if(message != null) {
            formatted = message + " ";
        }

        fail(formatted + EclipseInterface.ASSERT_LEFT2 + expected + EclipseInterface.ASSERT_MIDDLE + actual + EclipseInterface.ASSERT_RIGHT);
    }

    private static void failNotSame(Object actual, Object expected, String message) {
        String formatted = "";
        if(message != null) {
            formatted = message + " ";
        }

        fail(formatted + EclipseInterface.ASSERT_LEFT + expected + EclipseInterface.ASSERT_MIDDLE + actual + EclipseInterface.ASSERT_RIGHT);
    }

    private static void failNotEquals(Object actual, Object expected, String message) {
        fail(format(actual, expected, message));
    }

    static String format(Object actual, Object expected, String message) {
        String formatted = "";
        if(null != message) {
            formatted = message + " ";
        }

        return formatted + EclipseInterface.ASSERT_LEFT + expected + EclipseInterface.ASSERT_MIDDLE + actual + EclipseInterface.ASSERT_RIGHT;
    }

    public static void assertEquals(Collection<?> actual, Collection<?> expected) {
        assertEquals((Collection)actual, (Collection)expected, (String)null);
    }

    public static void assertEquals(Collection<?> actual, Collection<?> expected, String message) {
        if(actual != expected) {
            if(actual == null || expected == null) {
                if(message != null) {
                    fail(message);
                } else {
                    fail("Collections not equal: expected: " + expected + " and actual: " + actual);
                }
            }

            assertEquals(actual.size(), expected.size(), (message == null?"":message + ": ") + "lists don't have the same size");
            Iterator<?> actIt = actual.iterator();
            Iterator<?> expIt = expected.iterator();
            int i = -1;

            while(actIt.hasNext() && expIt.hasNext()) {
                ++i;
                Object e = expIt.next();
                Object a = actIt.next();
                String explanation = "Lists differ at element [" + i + "]: " + e + " != " + a;
                String errorMessage = message == null?explanation:message + ": " + explanation;
                assertEqualsImpl(a, e, errorMessage);
            }

        }
    }

    public static void assertEquals(Iterator<?> actual, Iterator<?> expected) {
        assertEquals((Iterator)actual, (Iterator)expected, (String)null);
    }

    public static void assertEquals(Iterator<?> actual, Iterator<?> expected, String message) {
        if(actual != expected) {
            if(actual == null || expected == null) {
                if(message != null) {
                    fail(message);
                } else {
                    fail("Iterators not equal: expected: " + expected + " and actual: " + actual);
                }
            }

            int i = -1;

            while(actual.hasNext() && expected.hasNext()) {
                ++i;
                Object e = expected.next();
                Object a = actual.next();
                String explanation = "Iterators differ at element [" + i + "]: " + e + " != " + a;
                String errorMessage = message == null?explanation:message + ": " + explanation;
                assertEqualsImpl(a, e, errorMessage);
            }

            String explanation;
            String errorMessage;
            if(actual.hasNext()) {
                explanation = "Actual iterator returned more elements than the expected iterator.";
                errorMessage = message == null?explanation:message + ": " + explanation;
                fail(errorMessage);
            } else if(expected.hasNext()) {
                explanation = "Expected iterator returned more elements than the actual iterator.";
                errorMessage = message == null?explanation:message + ": " + explanation;
                fail(errorMessage);
            }

        }
    }

    public static void assertEquals(Iterable<?> actual, Iterable<?> expected) {
        assertEquals((Iterable)actual, (Iterable)expected, (String)null);
    }

    public static void assertEquals(Iterable<?> actual, Iterable<?> expected, String message) {
        if(actual != expected) {
            if(actual == null || expected == null) {
                if(message != null) {
                    fail(message);
                } else {
                    fail("Iterables not equal: expected: " + expected + " and actual: " + actual);
                }
            }

            Iterator<?> actIt = actual.iterator();
            Iterator<?> expIt = expected.iterator();
            assertEquals(actIt, expIt, message);
        }
    }

    public static void assertEquals(Object[] actual, Object[] expected, String message) {
        if(actual != expected) {
            if(actual == null && expected != null || actual != null && expected == null) {
                if(message != null) {
                    fail(message);
                } else {
                    fail("Arrays not equal: " + Arrays.toString(expected) + " and " + Arrays.toString(actual));
                }
            }

            assertEquals((Collection)Arrays.asList(actual), (Collection)Arrays.asList(expected), message);
        }
    }

    public static void assertEqualsNoOrder(Object[] actual, Object[] expected, String message) {
        if(actual != expected) {
            if(actual == null && expected != null || actual != null && expected == null) {
                failAssertNoEqual("Arrays not equal: " + Arrays.toString(expected) + " and " + Arrays.toString(actual), message);
            }

            if(actual.length != expected.length) {
                failAssertNoEqual("Arrays do not have the same size:" + actual.length + " != " + expected.length, message);
            }

            List<Object> actualCollection = Lists.newArrayList();
            Object[] var4 = actual;
            int var5 = actual.length;

            int var6;
            Object o;
            for(var6 = 0; var6 < var5; ++var6) {
                o = var4[var6];
                actualCollection.add(o);
            }

            var4 = expected;
            var5 = expected.length;

            for(var6 = 0; var6 < var5; ++var6) {
                o = var4[var6];
                actualCollection.remove(o);
            }

            if(actualCollection.size() != 0) {
                failAssertNoEqual("Arrays not equal: " + Arrays.toString(expected) + " and " + Arrays.toString(actual), message);
            }

        }
    }

    private static void failAssertNoEqual(String defaultMessage, String message) {
        if(message != null) {
            fail(message);
        } else {
            fail(defaultMessage);
        }

    }

    public static void assertEquals(Object[] actual, Object[] expected) {
        assertEquals((Object[])actual, (Object[])expected, (String)null);
    }

    public static void assertEqualsNoOrder(Object[] actual, Object[] expected) {
        assertEqualsNoOrder(actual, expected, (String)null);
    }

    public static void assertEquals(Set<?> actual, Set<?> expected) {
        assertEquals((Set)actual, (Set)expected, (String)null);
    }

    public static void assertEquals(Set<?> actual, Set<?> expected, String message) {
        if(actual != expected) {
            if(actual == null || expected == null) {
                if(message == null) {
                    fail("Sets not equal: expected: " + expected + " and actual: " + actual);
                } else {
                    failNotEquals(actual, expected, message);
                }
            }

            if(!actual.equals(expected)) {
                if(message == null) {
                    fail("Sets differ: expected " + expected + " but got " + actual);
                } else {
                    failNotEquals(actual, expected, message);
                }
            }

        }
    }

    public static void assertEquals(Map<?, ?> actual, Map<?, ?> expected) {
        if(actual != expected) {
            if(actual == null || expected == null) {
                fail("Maps not equal: expected: " + expected + " and actual: " + actual);
            }

            if(actual.size() != expected.size()) {
                fail("Maps do not have the same size:" + actual.size() + " != " + expected.size());
            }

            Set<?> entrySet = actual.entrySet();
            Iterator var3 = entrySet.iterator();

            while(var3.hasNext()) {
                Object anEntrySet = var3.next();
                Map.Entry<?, ?> entry = (Map.Entry)anEntrySet;
                Object key = entry.getKey();
                Object value = entry.getValue();
                Object expectedValue = expected.get(key);
                assertEqualsImpl(value, expectedValue, "Maps do not match for key:" + key + " actual:" + value + " expected:" + expectedValue);
            }

        }
    }

    public static void assertNotEquals(Object actual1, Object actual2, String message) {
        boolean fail = false;

        try {
            assertEquals(actual1, actual2);
            fail = true;
        } catch (AssertionError var5) {
            ;
        }

        if(fail) {
            fail(message);
        }

    }

    public static void assertNotEquals(Object actual1, Object actual2) {
        assertNotEquals((Object)actual1, (Object)actual2, (String)null);
    }

    static void assertNotEquals(String actual1, String actual2, String message) {
        assertNotEquals((Object)actual1, (Object)actual2, message);
    }

    static void assertNotEquals(String actual1, String actual2) {
        assertNotEquals((String)actual1, (String)actual2, (String)null);
    }

    static void assertNotEquals(long actual1, long actual2, String message) {
        assertNotEquals((Object)Long.valueOf(actual1), (Object)Long.valueOf(actual2), message);
    }

    static void assertNotEquals(long actual1, long actual2) {
        assertNotEquals(actual1, actual2, (String)null);
    }

    static void assertNotEquals(boolean actual1, boolean actual2, String message) {
        assertNotEquals((Object)Boolean.valueOf(actual1), (Object)Boolean.valueOf(actual2), message);
    }

    static void assertNotEquals(boolean actual1, boolean actual2) {
        assertNotEquals(actual1, actual2, (String)null);
    }

    static void assertNotEquals(byte actual1, byte actual2, String message) {
        assertNotEquals((Object)Byte.valueOf(actual1), (Object)Byte.valueOf(actual2), message);
    }

    static void assertNotEquals(byte actual1, byte actual2) {
        assertNotEquals((byte)actual1, (byte)actual2, (String)null);
    }

    static void assertNotEquals(char actual1, char actual2, String message) {
        assertNotEquals((Object)Character.valueOf(actual1), (Object)Character.valueOf(actual2), message);
    }

    static void assertNotEquals(char actual1, char actual2) {
        assertNotEquals((char)actual1, (char)actual2, (String)null);
    }

    static void assertNotEquals(short actual1, short actual2, String message) {
        assertNotEquals((Object)Short.valueOf(actual1), (Object)Short.valueOf(actual2), message);
    }

    static void assertNotEquals(short actual1, short actual2) {
        assertNotEquals((short)actual1, (short)actual2, (String)null);
    }

    static void assertNotEquals(int actual1, int actual2, String message) {
        assertNotEquals((Object)Integer.valueOf(actual1), (Object)Integer.valueOf(actual2), message);
    }

    static void assertNotEquals(int actual1, int actual2) {
        assertNotEquals((int)actual1, (int)actual2, (String)null);
    }

    public static void assertNotEquals(float actual1, float actual2, float delta, String message) {
        boolean fail = false;

        try {
            assertEquals(actual1, actual2, delta, message);
            fail = true;
        } catch (AssertionError var6) {
            ;
        }

        if(fail) {
            fail(message);
        }

    }

    public static void assertNotEquals(float actual1, float actual2, float delta) {
        assertNotEquals(actual1, actual2, delta, (String)null);
    }

    public static void assertNotEquals(double actual1, double actual2, double delta, String message) {
        boolean fail = false;

        try {
            assertEquals(actual1, actual2, delta, message);
            fail = true;
        } catch (AssertionError var9) {
            ;
        }

        if(fail) {
            fail(message);
        }

    }

    public static void assertNotEquals(double actual1, double actual2, double delta) {
        assertNotEquals(actual1, actual2, delta, (String)null);
    }

    public static void assertThrows(Assert.ThrowingRunnable runnable) {
        assertThrows(Throwable.class, runnable);
    }

    public static <T extends Throwable> void assertThrows(Class<T> throwableClass, Assert.ThrowingRunnable runnable) {
        expectThrows(throwableClass, runnable);
    }

    public static <T extends Throwable> T expectThrows(Class<T> throwableClass, Assert.ThrowingRunnable runnable) {
        try {
            runnable.run();
        } catch (Throwable var4) {
            if(throwableClass.isInstance(var4)) {
                return (T) throwableClass.cast(var4);
            }

            String mismatchMessage = String.format("Expected %s to be thrown, but %s was thrown", new Object[]{throwableClass.getSimpleName(), var4.getClass().getSimpleName()});
            throw new AssertionError(mismatchMessage, var4);
        }

        String message = String.format("Expected %s to be thrown, but nothing was thrown", new Object[]{throwableClass.getSimpleName()});
        throw new AssertionError(message);
    }

    public interface ThrowingRunnable {
        void run() throws Throwable;
    }


}
