package com.sky.xposed.ktx

import com.sky.xposed.javax.MethodHook
import com.sky.xposed.javax.XposedPlus
import com.sky.xposed.javax.XposedUtil
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.callbacks.XC_LoadPackage

/**
 * Created by sky on 2018/12/27.
 */

fun findMethod(className: String, methodName: String, vararg parameterTypes: Any): MethodHook {
    return XposedUtil.findMethod(className, methodName, *parameterTypes)
}

fun findMethod(clazz: Class<*>, methodName: String, vararg parameterTypes: Any): MethodHook {
    return XposedUtil.findMethod(clazz, methodName, *parameterTypes)
}

fun findConstructor(clazz: Class<*>, vararg parameterTypes: Any): MethodHook {
    return XposedUtil.findConstructor(clazz, *parameterTypes)
}

fun findConstructor(className: String, vararg parameterTypes: Any): MethodHook {
    return XposedUtil.findConstructor(className, *parameterTypes)
}

fun findClass(className: String): Class<*> {
    return XposedUtil.findClass(className)
}

fun withPackage(packageParam: XC_LoadPackage.LoadPackageParam): XposedPlus {
    return XposedPlus.with(packageParam)
}

fun MethodHook.hook(
        before: (param: XC_MethodHook.MethodHookParam) -> Unit,
        after: (param: XC_MethodHook.MethodHookParam) -> Unit) {

    hook(object : MethodHook.HookCallback{

        override fun onAfter(param: XC_MethodHook.MethodHookParam) {
            before.invoke(param)
        }

        override fun onBefore(param: XC_MethodHook.MethodHookParam) {
            after.invoke(param)
        }
    })
}
