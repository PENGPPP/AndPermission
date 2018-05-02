/*
 * Copyright 2018 Yan Zhenjie
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yanzhenjie.permission;

import android.os.Build;

import com.yanzhenjie.permission.install.InstallRequest;
import com.yanzhenjie.permission.install.NRequestFactory;
import com.yanzhenjie.permission.install.ORequestFactory;
import com.yanzhenjie.permission.runtime.PermissionRequest;
import com.yanzhenjie.permission.runtime.Runtime;
import com.yanzhenjie.permission.source.Source;

/**
 * Created by YanZhenjie on 2018/4/28.
 */
public class Options {

    private static final InstallRequestFactory FACTORY;

    static {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            FACTORY = new ORequestFactory();
        } else {
            FACTORY = new NRequestFactory();
        }
    }

    public interface InstallRequestFactory {
        /**
         * Create apk installer request.
         */
        InstallRequest create(Source source);
    }

    private Source mSource;

    Options(Source source) {
        this.mSource = source;
    }

    /**
     * One or more permissions.
     *
     * @deprecated use {@link Options#runtime()} instead.
     */
    @Deprecated
    public PermissionRequest permission(String... permissions) {
        return runtime().permission(permissions);
    }

    /**
     * One or more permission groups.
     *
     * @deprecated use {@link Options#runtime()} instead.
     */
    @Deprecated
    public PermissionRequest permission(String[]... groups) {
        return runtime().permission(groups);
    }

    /**
     * Handle runtime permissions.
     */
    public Runtime runtime() {
        return new Runtime(mSource);
    }

    /**
     * Handle request package install permission.
     */
    public InstallRequest install() {
        return FACTORY.create(mSource);
    }
}