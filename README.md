# Android Snackbar 提示演示

## 简介

本 Demo 演示 Snackbar 的基本用法，展示如何在 Android 中显示轻量级反馈消息。

## 基本原理

Snackbar 是 Material Design 组件，类似于 Toast，但提供更好的交互体验。主要特点：
- 可以显示在屏幕底部
- 支持滑动删除
- 可以添加操作按钮（如撤销）
- 可以与 CoordinatorLayout 配合避免与 FAB 冲突

## 启动和使用

### 环境要求
- Android Studio
- JDK 17
- Gradle 8.x
- Material Components 库

### 安装和运行

1. 用 Android Studio 打开项目
2. 连接 Android 设备或模拟器
3. 点击 Run 运行

### 使用方法
- 点击"显示 Snackbar"按钮查看效果
- Snackbar 会显示在屏幕底部
- 可以点击"撤销"按钮执行操作

## 教程

### 什么是 Snackbar？

Snackbar 是 Material Design 提供的轻量级反馈组件，用于显示简短的消息。它与 Toast 类似，但有以下优势：

- 可以滑动删除
- 支持添加操作按钮
- 显示位置更自然（屏幕底部）
- 可以与 FAB（悬浮操作按钮）配合

### 基本用法

```kotlin
Snackbar.make(view, "消息内容", Snackbar.LENGTH_LONG)
    .show()
```

### 添加操作按钮

```kotlin
Snackbar.make(view, "消息已删除", Snackbar.LENGTH_LONG)
    .setAction("撤销") {
        // 执行撤销操作
    }
    .show()
```

### 显示时长

Snackbar 支持三种显示时长：
- `Snackbar.LENGTH_SHORT`：短时间（约 1500ms）
- `Snackbar.LENGTH_LONG`：长时间（约 2750ms）
- `Snackbar.LENGTH_INDEFINITE`：不自动消失

### 注意事项

1. **View 参数**：make 方法的第一个参数是 CoordinatorLayout 或任意 View
2. **CoordinatorLayout**：使用 CoordinatorLayout 可以避免与 FAB 重叠
3. **显示位置**：默认显示在屏幕底部

## 关键代码详解

### MainActivity.kt

```kotlin
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 设置按钮点击事件
        findViewById<Button>(R.id.showSnackbar).setOnClickListener { view ->
            // 1. 创建 Snackbar
            // 参数1: 视图（会添加到该视图的 CoordinatorLayout）
            // 参数2: 显示的消息内容
            // 参数3: 显示时长
            Snackbar.make(view, "这是一个 Snackbar", Snackbar.LENGTH_LONG)
                // 2. 设置操作按钮（可选）
                .setAction("撤销") {
                    // 用户点击撤销按钮时的处理
                    // 这里可以恢复之前删除的数据等
                }
                // 3. 显示 Snackbar
                .show()
        }
    }
}
```

### activity_main.xml

```xml
<!-- 根布局：垂直线性布局 -->
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <!-- 标题 -->
    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Snackbar 提示演示"
        android:textSize="20sp"
        android:textStyle="bold"
        android:gravity="center" />

    <!-- 显示 Snackbar 按钮 -->
    <Button
        android:id="@+id/showSnackbar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="显示 Snackbar"
        android:layout_marginTop="16dp" />
</LinearLayout>
```

### Snackbar vs Toast

| 特性 | Snackbar | Toast |
|------|----------|-------|
| 显示位置 | 屏幕底部 | 屏幕中部 |
| 滑动删除 | 支持 | 不支持 |
| 操作按钮 | 支持 | 不支持 |
| 显示时长 | 可自定义 | 固定 |
