package okhttp3.internal.io;

import com.google.firebase.messaging.Constants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Okio;
import okio.Sink;
import okio.Source;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0014"}, d2 = {"okhttp3/internal/io/FileSystem$Companion$SYSTEM$1", "Lokhttp3/internal/io/FileSystem;", "appendingSink", "Lokio/Sink;", "file", "Ljava/io/File;", "delete", "", "deleteContents", "directory", "exists", "", "rename", "from", "to", "sink", "size", "", "source", "Lokio/Source;", "okhttp"}, k = 1, mv = {1, 1, 16})
/* compiled from: FileSystem.kt */
public final class FileSystem$Companion$SYSTEM$1 implements FileSystem {
    FileSystem$Companion$SYSTEM$1() {
    }

    public Source source(File file) throws FileNotFoundException {
        Intrinsics.checkParameterIsNotNull(file, "file");
        return Okio.source(file);
    }

    public Sink sink(File file) throws FileNotFoundException {
        Intrinsics.checkParameterIsNotNull(file, "file");
        try {
            return Okio__JvmOkioKt.sink$default(file, false, 1, (Object) null);
        } catch (FileNotFoundException e) {
            file.getParentFile().mkdirs();
            return Okio__JvmOkioKt.sink$default(file, false, 1, (Object) null);
        }
    }

    public Sink appendingSink(File file) throws FileNotFoundException {
        Intrinsics.checkParameterIsNotNull(file, "file");
        try {
            return Okio.appendingSink(file);
        } catch (FileNotFoundException e) {
            file.getParentFile().mkdirs();
            return Okio.appendingSink(file);
        }
    }

    public void delete(File file) throws IOException {
        Intrinsics.checkParameterIsNotNull(file, "file");
        if (!file.delete() && file.exists()) {
            throw new IOException("failed to delete " + file);
        }
    }

    public boolean exists(File file) {
        Intrinsics.checkParameterIsNotNull(file, "file");
        return file.exists();
    }

    public long size(File file) {
        Intrinsics.checkParameterIsNotNull(file, "file");
        return file.length();
    }

    public void rename(File from, File to) throws IOException {
        Intrinsics.checkParameterIsNotNull(from, Constants.MessagePayloadKeys.FROM);
        Intrinsics.checkParameterIsNotNull(to, "to");
        delete(to);
        if (!from.renameTo(to)) {
            throw new IOException("failed to rename " + from + " to " + to);
        }
    }

    public void deleteContents(File directory) throws IOException {
        Intrinsics.checkParameterIsNotNull(directory, "directory");
        File[] files = directory.listFiles();
        if (files != null) {
            int length = files.length;
            int i = 0;
            while (i < length) {
                File file = files[i];
                Intrinsics.checkExpressionValueIsNotNull(file, "file");
                if (file.isDirectory()) {
                    deleteContents(file);
                }
                if (file.delete()) {
                    i++;
                } else {
                    throw new IOException("failed to delete " + file);
                }
            }
            return;
        }
        throw new IOException("not a readable directory: " + directory);
    }
}