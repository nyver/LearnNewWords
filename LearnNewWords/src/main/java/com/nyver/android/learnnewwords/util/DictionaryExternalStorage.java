package com.nyver.android.learnnewwords.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.nyver.android.learnnewwords.R;
import com.nyver.android.learnnewwords.exception.DictionaryExternalStorageException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Dictionary External Storage class
 *
 * @author Yuri Novitsky
 */
public class DictionaryExternalStorage
{
    public static final String DIRECTORY_NAME = "dictionaries";
    public static final String SAMPLE_DICTIONARY_NAME = "basic.dic";
    public static final String SAMPLE_DICTIONARY = "dictionaries/" + SAMPLE_DICTIONARY_NAME;

    public static File getPath(Context context)
    {
        return new File(context.getExternalFilesDir(null), DIRECTORY_NAME);
    }

    /**
     * Copy sample of dictionary in dictionaries directory
     */
    public static void copySample(Context context, final File destination) throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream  = null;
        try {
            inputStream = context.getAssets().open(SAMPLE_DICTIONARY);
            File outputFile = new File(destination, SAMPLE_DICTIONARY_NAME);

            outputStream = new FileOutputStream(outputFile);

            byte[] buf = new byte[1024];
            int len;
            while ((len = inputStream.read(buf)) > 0) {
                outputStream.write(buf, 0, len);
            }
        } finally {
            if (null != inputStream) {
                inputStream.close();
            }

            if (null != outputStream) {
                outputStream.close();
            }
        }
    }

    /**
     * Create dictionaries directory if not exists
     *
     * @param context
     * @throws DictionaryExternalStorageException
     */
    public static void createIfNotExists(final Context context) throws DictionaryExternalStorageException
    {
        if (ExternalStorage.isExternalStorageReadable()) {
            File path = getPath(context);
            if (!path.exists()) {
                if (ExternalStorage.isExternalStorageWritable()) {
                    if (!path.mkdir()) {
                        throw new DictionaryExternalStorageException(String.format(context.getString(R.string.error_can_not_create_directory), path.getAbsolutePath()));
                    }

                    try {
                        copySample(context, path);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {
                    throw new DictionaryExternalStorageException(context.getString(R.string.error_external_storage_is_not_writeable));
                }
            }
        } else {
            throw new DictionaryExternalStorageException(context.getString(R.string.error_external_storage_is_not_available));
        }
    }

    /**
     * Get dictionaries files in external storage
     *
     * @param context
     * @return
     */
    public static File[] getDictionaries(Context context)
    {
        return getPath(context).listFiles();
    }
}
