# AndPermission
Simplify the process of requesting run-time permissions. Simplify the process of installing applications on Android 7.0 and Android 8.0.

```java
AndPermission.with(this)
  .runtime()
  .permission(Permission.Group.STORAGE)
  .onGranted(new Action<List<String>>() {
    @Override
    public void onAction(List<String> data) {
      // TODO write file.
    }
  })
  .onDenied(new Action<List<String>>() {
    @Override
    public void onAction(List<String> data) {
      // TODO something.
    }
  })
  .start();
```

```java
File apkFile = ...;

AndPermission.with(this)
  .install()
  .file(apkFile)
  .onGranted(new Action<File>() {
    @Override
    public void onAction(File data) {
      // The user agrees to install.
    }
  })
  .onDenied(new Action<File>() {
      @Override
      public void onAction(File data) {
        // The user refused to install.
      }
  })
  .start();
```

For more information please see document: [English](http://yanzhenjie.github.io/AndPermission) | [中文](http://yanzhenjie.github.io/AndPermission/cn).

## Download

* Gradle
```
implementation 'com.yanzhenjie:permission:2.0.0-rc5'
```

* [Download source code](https://github.com/yanzhenjie/AndPermission/releases/latest)

AndPermission requires at minimum Java 7 or Android 4.0(Api level 14) .

## ProGuard
If you are using ProGuard you might need to add the following options:
```
-dontwarn com.yanzhenjie.permission.**
```

## Contributing
Before submitting pull requests, contributors must abide by the [agreement](CONTRIBUTING.md) .

## License
```text
Copyright 2016 Yan Zhenjie

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```