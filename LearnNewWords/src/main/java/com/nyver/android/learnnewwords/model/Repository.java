package com.nyver.android.learnnewwords.model;

import android.content.Context;

/**
 * Repository interface
 *
 * @author Yuri Novitsky
 */
public interface Repository<T>
{
    public T[] get(Context context);

}
