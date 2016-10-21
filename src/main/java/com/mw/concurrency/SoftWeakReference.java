package com.mw.concurrency;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Created by mwang on 21/10/2016.
 */
public class SoftWeakReference
{
    public static void main(String[] args)
    {
        SoftReference<Integer> soft = new SoftReference<>(1);
        WeakReference<Integer> weak = new WeakReference<>(1);
    }
}
