# Android Snackbar 提示演示

## 简介

Snackbar 是 Material Design 组件，提供轻量级反馈。

## 教程

```kotlin
Snackbar.make(view, "消息", Snackbar.LENGTH_LONG)
    .setAction("撤销") { }
    .show()
```
