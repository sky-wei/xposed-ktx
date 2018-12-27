# xposed-ktx

这个一个Kotlin写的Xposed的扩展项目

### 正常使用
```kotlin
XposedHelpers.findAndHookMethod(
            "com.app.Application",
            lparam.classLoader,
            "onCreate",
            object : XC_MethodHook() {

                override fun beforeHookedMethod(param: MethodHookParam?) {
                    super.beforeHookedMethod(param)
                }

                override fun afterHookedMethod(param: MethodHookParam) {
                    super.afterHookedMethod(param)
                }
            }
    )
```

### 扩展使用
```kotlin
// 最先需要初始化
XposedPlus.setDefaultInstance(XposedPlus.Builder(param))
                
findMethod("com.app.Application", "onCreate")
        .hook({
            // ...
        }, {
            // ...
        })                

或者只处理AfterHook方法：

findMethod("com.app.Application", "onCreate")
        .after {
            // afterHook ...
        }
```

### Gradle引入
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}

dependencies {
    implementation 'com.github.sky-wei:xposed-javax:1.0.8'
    implementation 'com.github.jingcai-wei:xposed-ktx:1.1'
}
```

## License

    Copyright 2018 The sky Authors

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

